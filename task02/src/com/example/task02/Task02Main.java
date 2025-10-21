package com.example.task02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        OutputStream output = System.out;
        
        // Константы для символов перевода строки
        final int CR = 13; // \r
        final int LF = 10; // \n
        
        int currentByte;
        
        while ((currentByte = input.read()) != -1) {
            if (currentByte == CR) {
                // Проверяем следующий байт
                int nextByte = input.read();
                if (nextByte == LF) {
                    // Если встретили \r\n - записываем только \n
                    output.write(LF);
                } else {
                    // Иначе возвращаем прочитанный байт обратно
                    output.write(CR);
                    if (nextByte != -1) {
                        input.unread(nextByte);
                    }
                }
            } else {
                // Для остальных байтов просто записываем их
                output.write(currentByte);
            }
        }
        
        output.flush();
    }
}

