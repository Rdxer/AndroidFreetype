package com.xian.freetype.word;

import java.util.ArrayList;
import java.util.List;

public class WordInfoUtils {
    public static void printMash(WordInfo wordInfo) {
        byte[] buffer = wordInfo.getBuffer();
        for (int y = 0; y < wordInfo.rows; y++) {
            for (int x = 0; x < wordInfo.width; x++) {

                int pixel = (buffer[y * wordInfo.pitch + (x >> 3)] >> (7 - (x % 8))) & 0x1;
                System.out.print(pixel != 0  ? "⬛️ " : "⬜️ ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> makeMash(WordInfo wordInfo) {
        List<List<Integer>> mash = new ArrayList<>();

        byte[] buffer = wordInfo.getBuffer();

        int x_max = wordInfo.width;
        int y_max = wordInfo.rows;

//        for (int y = 0; y < wordInfo.rows; y++) {
//            for (int x = 0; x < wordInfo.width; x++) {
//
//                int pixel = (buffer[y * wordInfo.pitch + (x >> 3)] >> (7 - (x % 8))) & 0x1;
//                System.out.print(pixel != 0  ? "⬛️ " : "⬜️ ");
//            }
//            System.out.print("\n");
//        }

        int y = 0;
        for (; y < y_max; y++) {
            List<Integer> row = new ArrayList<>();
            for (int x = 0; x < x_max; x++) {
                int pixel = (buffer[y * wordInfo.pitch + (x >> 3)] >> (7 - (x % 8))) & 0x1;
                if (pixel != 0) {
                    row.add(1);
                }else{
                    row.add(0);
                }
            }
            mash.add(row);
        }


        return mash;
    }

    public static void printMash(List<List<Integer>> mash) {
        System.out.println("public static void printMash(List<List<Integer>> mash) {");
        for (List<Integer> row : mash) {
            for (Integer item : row) {
                System.out.print(item != 0  ? "⬛️ " : "⬜️ ");
            }
            System.out.println("");
        }

    }
}
