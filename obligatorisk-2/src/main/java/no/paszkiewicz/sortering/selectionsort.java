package no.paszkiewicz.sortering;
import java.util.Random;

public class selectionsort {

    static void bytt(int[] a, int b, int c) {
        int midlertidig = a[b];
        a[b] = a[c];
        a[c] = midlertidig;
    }

    static void selectionSort(int[] a, int n) {

        for (int i = 0; i < n -1; i++) {
            int min = a[i];
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    mini = j;
                    min = a[j];
                }
            }
            bytt(a, i, mini);
        }
    }
    public static void main(String[] args) {
        Random tilfeldig = new Random();

        int n = 32000;
        int[] array = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = tilfeldig.nextInt(99);
        }

        long start = System.currentTimeMillis();

        selectionSort(array, n);

        long slutt = System.currentTimeMillis();

        System.out.println("Tid brukt: " + (slutt - start) + " ms");
        System.out.println("Tid i sekund: " + ((slutt - start) / 1000.0) + "s" );

        // for (int num : array) {
        //    System.out.print(num + " ");
        // }
    }
}
