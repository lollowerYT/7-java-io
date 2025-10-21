package com.example.task02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        OutputStream output = System.out;

        final int CR = 13; // '\r'
        final int LF = 10; // '\n'

        int prev = -1;
        int curr;

        while ((curr = input.read()) != -1) {
            if (prev == CR) {
                if (curr == LF) {
                    // заменяем \r\n -> \n
                    output.write(LF);
                    prev = -1; // сбрасываем, чтобы не писать \r отдельно
                    continue;
                } else {
                    // одиночный \r — выводим
                    output.write(CR);
                }
            }
            prev = curr;
        }

        // если последний байт был \r без \n — нужно вывести его
        if (prev == CR) {
            output.write(CR);
        } else if (prev != -1) {
            output.write(prev);
        }

        output.flush();
    }
}

        
        output.flush();
    }
}

