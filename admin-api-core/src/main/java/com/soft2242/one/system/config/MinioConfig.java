package com.soft2242.one.system.config;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年06月01日 16:46
 * @Description:
 * @since: 1.0
 */
@Configuration
public class MinioConfig {

    private String endPoint = "http://47.115.224.170:9000";

    private String accessKey="om1ga";

    private String secretKey="12345678";

    private MinioClient instance;


    @PostConstruct
    public void init() {
        instance = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     * 判断 bucket 是否存在
     *
     * @param bucketName
     * @return
     */
    private boolean bucketExists(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    public void makeBucket(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        boolean flag = bucketExists(bucketName);

        if (!flag) {
            instance.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    public ObjectWriteResponse uploadObject(String bucketName, String objectName, String filePath) throws Exception {
        return instance.uploadObject(UploadObjectArgs.builder().bucket(bucketName).object(objectName).filename(filePath).build());
    }


    public void removeObject(String bucketName, String objectName) throws Exception {
        instance.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 文件上传
     *
     * @param bucketName 存储桶名称
     * @param objectName 文件名
     * @param filePath   存储目录
     * @return 响应结果
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, String filePath, InputStream inputStream) throws Exception {
        String returnFileName = objectName.substring(objectName.lastIndexOf("."));
        String type = typeCheck(returnFileName);
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream, -1, 10485760)
                .contentType(type)
                .build();
        return instance.putObject(putObjectArgs);
    }

    private String typeCheck(String returnFileName){
        if(returnFileName != null){
            if(returnFileName.equals(".jpeg") || returnFileName.equals(".png") || returnFileName.equals(".jpg")){
                return "image/jpeg";
            }else if(returnFileName.equals(".mp4")){
                return "video/mp4";
            }else if(returnFileName.equals(".html")){
                return "text/html";
            }else if(returnFileName.equals(".css")){
                return "text/css";
            }else if(returnFileName.equals(".js")){
                return "application/javascript";
            }else if(returnFileName.equals(".pdf")){
                return "application/pdf";
            }else{
                return "application/octet-stream";
            }
        }
        return null;
    }

    public void removeBucket(String bucketName) throws Exception {
        if (bucketExists(bucketName)) {
            instance.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 根据文件路径得到预览文件绝对地址
     *
     * @param bucketName
     * @param fileName
     * @return
     */
    public String getPreviewFileUrl(String bucketName, String fileName) {
        try {
            return instance.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).expiry(7, TimeUnit.DAYS).bucket(bucketName).object(fileName).build());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
