package no.paszkiewicz.insertionsort;

import java.util.Random;

public class InsertionSort {

    public static void insertionSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            }
        }
        
        for (int i = 2; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Random tilfeldig = new Random();
        
        int n = 200000;
        int[] array = new int[n];
        
        for (int i= 0; i < n; i++){
            array[i] = tilfeldig.nextInt(99);
        }
        
        long start = System.currentTimeMillis();
        
        insertionSort(array);
        
        long slutt = System.currentTimeMillis();
        
        System.out.println("Tid brukt: " + (slutt - start) + " ms");
        System.out.println("Tid i sekund: " + ((slutt - start) / 1000.0) + "s" );
        
        // for (int num : array) {
        //    System.out.print(num + " ");
        // }
    }
}
