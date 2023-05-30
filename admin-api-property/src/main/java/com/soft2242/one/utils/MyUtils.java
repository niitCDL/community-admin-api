package com.soft2242.one.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/5/29 21:05
 */
public class MyUtils {
    // map 转 java 对象
    public static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) throws Exception {
        if (map == null) return null;
        T t = clazz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) setter.invoke(t, map.get(property.getName()));
        }
        return t;
    }

    // java 对象转 map
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) return null;
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo
                .getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) continue;
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            map.put(key, value);
        }
        return map;
    }

    public static String convertToString(String[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        return String.join(",", input);
    }

    public static String[] convertToArray(String input) {
        if (input == null || "".equals(input)) {
            return null;
        }
        return input.split(",");
    }
}
