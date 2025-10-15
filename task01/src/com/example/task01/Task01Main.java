package com.example.task01;

import java.io.IOException;
import java.io.InputStream;

public class Task01Main {
    public static void main(String[] args) throws IOException {
        System.out.println(checkSumOfStream(
            new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})
        ));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checksum = 0;
        
        int currentByte;
        while ((currentByte = inputStream.read()) != -1) {
            // Применяем формулу: C[n+1] = rotateLeft(C[n]) xor b[n+1]
            checksum = Integer.rotateLeft(checksum, 1);
            checksum ^= currentByte;
        }
        
        return checksum;
    }
}
