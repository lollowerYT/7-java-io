package com.example.task03;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Task03Main {
    public static void main(String[] args) throws IOException {
        // Пример: байты 48, 49, 50, 51 → "0123"
        byte[] testData = {48, 49, 50, 51};
        InputStream testStream = new java.io.ByteArrayInputStream(testData);

        String result = readAsString(testStream, Charset.forName("ASCII"));
        System.out.println(result); // Выведет: 0123
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // Считываем все байты из потока
        byte[] data = inputStream.readAllBytes();

        // Преобразуем байты в строку с нужной кодировкой
        return new String(data, charset);
    }
}
