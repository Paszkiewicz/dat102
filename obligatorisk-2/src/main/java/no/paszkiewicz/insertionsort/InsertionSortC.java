package no.paszkiewicz.insertionsort;

import java.util.Random;

public class InsertionSortC {

    public static void insertionSort(int[] array) {
        int n = array.length;
        if (n < 2) return;
    
        // 1. Flytt minste element fremst (Vaktpost/Sentinel)
        for (int i = n - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            }
        }
    
        // 2. Sorter to og to (Oppgave 1b/c)
        int i = 1; 
        for (; i <= n - 2; i += 2) { // Kjører så lenge vi har et par tilgjengelig
            int v1 = array[i];
            int v2 = array[i + 1];
    
            if (v1 > v2) {
                int t = v1; v1 = v2; v2 = t;
            }
    
            int j = i - 1;
            // Flytt elementer for å gi plass til v2 (den største av paret)
            while (array[j] > v2) {
                array[j + 2] = array[j];
                j--;
            }
            array[j + 2] = v2;
    
            // Flytt elementer for å gi plass til v1 (den minste av paret)
            while (array[j] > v1) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = v1;
        }
    
        // 3. Håndter siste elementet hvis n er oddetall 
        if (i < n) {
            int key = array[i];
            int j = i - 1;
            while (array[j] > key) { // Endret fra < til >
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
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
