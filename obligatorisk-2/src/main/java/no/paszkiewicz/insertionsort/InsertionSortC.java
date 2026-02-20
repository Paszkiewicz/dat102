package no.paszkiewicz.insertionsort;

import java.util.Random;

public class InsertionSortC {

    public static void insertionSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            }
        }
        
        int tall = 1;

        for (int i = tall; i < array.length - 1; i += 2) {
            int v1 = array[i];
            int v2 = array[i + 1];
            
            if (v1 > v2) { 
                int t = v1;
                v1 = v2;
                v2 = t;
            }

            int j = i - 1;
            
            while (array[j] > v2) {
                array[j + 2] = array[j];
                j--;
            }
            
            array[j + 2] = v2;
            
            while (array[j] > v1) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = v1;

            tall = i;
        }

        // if (tall < array.length) {
        //         int key = array[tall];
        //         int j = tall - 1;
                
        //         while (array[j] < key) {
        //             array[j + 1] = array[j];
        //             j--;
        //         }
                
        //         array[j + 1] = key;
        // }
    }


    public static void main(String[] args) {
        Random tilfeldig = new Random();
        
        int n = 10;
        int[] array = new int[n];
        
        for (int i= 0; i < n; i++){
            array[i] = tilfeldig.nextInt(11);
        }
        
        long start = System.currentTimeMillis();
        
        insertionSort(array);
        
        long slutt = System.currentTimeMillis();
        
        System.out.println("Tid brukt: " + (slutt - start) + " ms");
        System.out.println("Tid i sekund: " + ((slutt - start) / 1000.0) + "s" );
        
        for (int num : array) {
           System.out.print(num + " ");
        }
    }
}
