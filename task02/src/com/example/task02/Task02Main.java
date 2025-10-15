package com.example.task02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        OutputStream output = System.out;
        
        // Байт-коды для перевода строк
        final byte CR = 13; // \r
        final byte LF = 10; // \n
        
        byte currentByte;
        byte nextByte = -1;
        
        while ((currentByte = input.read()) != -1) {
            if (input.available() > 0) {
                nextByte = input.read();
            } else {
                nextByte = -1;
            }
            
            if (currentByte == CR && nextByte == LF) {
                output.write(LF);
            } else {
                output.write(currentByte);
                
                if (nextByte != -1) {
                    input.unread(nextByte);
                }
            }
        }
        
        output.flush();
    }
}
