package com.magda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int[] results = new int[10];
        readTable(results);
        ChartDrawer chartDrawer = new ChartDrawer(results);
        chartDrawer.drawChart();
    }

    private static void readTable(int[] results){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] items = input.split("");
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            try {
                results[j] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                results[j] = -1 * Integer.parseInt(items[++i]);
            }
            j++;
        }
    }
}