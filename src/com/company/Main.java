package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Input the path");
//        Scanner input = new Scanner(System.in);
//        String path = input.nextLine();
        String result="";
        try {
            int max = readFile("numbers.txt");
            result = String.valueOf(max);
        } catch (IOException e) {
            System.out.println("File not found");;
        } catch (Exception e) {
            System.out.println("Context not valid");
        }

        try {
            writeFile("result.text",result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readFile(String path) throws IOException {
        File file = new File (path);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        int max = Integer.parseInt(br.readLine());
        while((line =br.readLine()) != null){
            System.out.println(line);
            if(max < Integer.parseInt(line)){
                max = Integer.parseInt(line);
            }
        }
        br.close();
        System.out.println("Gia tri lon nhat la " + max);
        return max;
    }

    public static void writeFile(String path, String context) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter br = new BufferedWriter(fileWriter);
        br.write(context);
        br.close();
        fileWriter.close();
    }
}
