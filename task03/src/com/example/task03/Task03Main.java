package com.example.task03;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;

public class Task03Main {
    public static void main(String[] args) throws IOException {
        // InputStream с байтами 48, 49, 50, 51
        byte[] testData = {48, 49, 50, 51};
        InputStream testStream = new java.io.ByteArrayInputStream(testData);
        
        // ASCII
        String result = readAsString(testStream, Charset.forName("ASCII"));
        System.out.println(result); 
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // буфер для чтения байтов
        byte[] buffer = new byte[1024];
        int bytesRead;
        
        // для накопления результата
        StringBuilder result = new StringBuilder();
        
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                ByteBuffer byteBuffer = ByteBuffer.wrap(buffer, 0, bytesRead);
                java.nio.charset.Decoder decoder = charset.newDecoder();
                CharBuffer charBuffer = decoder.decode(byteBuffer);
                result.append(charBuffer);
            }
        } catch (CharacterCodingException e) {
            throw new IOException("Ошибка декодирования", e);
        }
        
        return result.toString();
    }
}
