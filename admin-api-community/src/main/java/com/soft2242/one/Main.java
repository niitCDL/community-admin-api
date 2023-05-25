package com.soft2242.one;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

/**
 * @ClassName Main
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/5/25 12:38
 */
public class Main {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
        FastAutoGenerator.create("jdbc:mysql://106.14.246.27:3306/db_community", "root", "kobe24")
                .globalConfig(builder -> {
                    builder.author("Dr.king") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\IDEAProjects\\group-one\\admin\\community-admin-api\\admin-api-community\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.soft2242") // 设置父包名
                            .moduleName("one") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\IDEAProjects\\group-one\\admin\\community-admin-api\\admin-api-community\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_mall") // 设置需要生成的表名
                            .addTablePrefix("t_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
