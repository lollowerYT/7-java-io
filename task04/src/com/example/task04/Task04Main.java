package com.example.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task04Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0;
        
        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                try {
                    double number = Double.parseDouble(token);
                    sum += number;
                } catch (NumberFormatException e) {
                }
            }
        }
        
        System.out.printf("%.6f%n", sum);
    }
}
