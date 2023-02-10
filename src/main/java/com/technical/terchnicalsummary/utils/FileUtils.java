package com.technical.terchnicalsummary.utils;

import java.io.*;
import java.util.Arrays;

public class FileUtils {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        // 获取到文件的父目录
        System.out.println(file.getParent());
        // 获取到文件名
        System.out.println(file.getName());
        // 获取到文件路径(构造 File 的时候指定的路径)
        System.out.println(file.getPath());
        // 获取到绝对路径(简单拼接)
        System.out.println(file.getAbsolutePath());
        // 获取到绝对路径
        System.out.println(file.getCanonicalPath());
        // 文件是否存在
        System.out.println(file.exists());
        // 是否是目录
        System.out.println(file.isDirectory());
        // 是否是文件
        System.out.println(file.isFile());
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write("1234");
        writer.flush();
        outputStream.close();
    }

    /**
     * 创建文件
     * @param filePath
     */
    public void createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * 删除文件
     * @param filePath
     */
    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 显示路径下的目录或文件
     * @param filePath
     */
    public void showChildFile(String filePath) {
        File file = new File(filePath);
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file.listFiles()));
    }

    /**
     * 文件重命名
     * @param filePath
     * @param renameFileStr
     */
    public void renameFile(String filePath,String renameFileStr) {
        File file = new File(filePath);
        File renameFile = new File(renameFileStr);
        file.renameTo(renameFile);
    }
}
