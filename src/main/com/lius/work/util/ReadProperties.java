package com.lius.work.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 读取Properties中的内容
 */
public class ReadProperties {
    /**
     * 默认文件路径
     */
    private static final String filePath = "application.properties";

    /**
     * 获取对应的文件地址(classpath下)
     */
    private static String getFile(String filePath) {
        ClassLoader classLoader = ReadProperties.class.getClassLoader();
        URL resource = filePath.equals("") ? classLoader.getResource(ReadProperties.filePath) : classLoader.getResource(filePath);
        assert resource != null;
        return resource.getFile();
    }

    /**
     * 获取properties 对象
     */
    private static Properties getProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = ReadProperties.class.getClassLoader().getResourceAsStream(filePath);
        properties.load(resourceAsStream);
        return properties;
    }


    /**
     * 获取key
     */
    public static String getKeyValue(String key) throws IOException {
        String filePath = getFile(""); //  判断文件是否存在
        if (new File(filePath).exists()) {
            return getProperties(ReadProperties.filePath).getProperty(key);
        } else {
            throw new IOException("文件不存在");
        }
    }

    /**
     * 获取key
     */
    public static String getKeyValue(String key, String filePath) throws IOException {
        String file = getFile(filePath);
        if (new File(file).exists()) {
            return getProperties(filePath).getProperty(key);
        } else {
            throw new IOException("文件不存在");
        }
    }

}
