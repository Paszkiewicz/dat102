import java.util.Random;

public class quicksort {
    /**
     * this function needs the length of "a" to be longer than 3
     */
    static void quickSort(int[] a, int forste, int siste) {

        if (forste < siste) {
            int pivot = del(a, forste, siste);
            quickSort(a, forste, pivot - 1);
            quickSort(a, pivot + 1, siste);
        }
    }

    static void bytt(int[] a, int b, int c) {
        int midlertidig = a[b];
        a[b] = a[c];
        a[c] = midlertidig;
    }
    static int del(int[] a, int forste, int siste) {
        int midt = (forste + siste) / 2;
        sorter(a, forste, midt, siste);

        bytt(a, midt, siste -1);
        int pivot2 = siste -1;
        int pivotverdi = a[pivot2];

        int fravenstre = forste + 1;
        int frahogre = siste - 2;

        boolean ferdig = false;
        while (!ferdig) {
            while (a[fravenstre] < pivotverdi) {
                fravenstre++;
            }
            while (a[frahogre] > pivotverdi) {
                frahogre--;
            }
            if (fravenstre < frahogre) {
                bytt(a, fravenstre, frahogre);
                fravenstre++;
                frahogre--;
            } else {
                ferdig = true;
            }
        }
        bytt(a, pivot2, fravenstre);
        pivot2 = fravenstre;

        return pivot2;
    }
    static void sorter(int[] a, int forste, int midt, int siste) {
        bytt2(a, forste, midt);
        bytt2(a, midt, siste);
        bytt2(a, forste, midt);
    }
    static void bytt2(int[] a, int b, int c) {
        if (a[b] > a[c]) {
            bytt(a, b, c);
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

        quickSort(array, 0, n-1);

        long slutt = System.currentTimeMillis();

        System.out.println("Tid brukt: " + (slutt - start) + " ms");
        System.out.println("Tid i sekund: " + ((slutt - start) / 1000.0) + "s" );

        // for (int num : array) {
        //    System.out.print(num + " ");
        // }
    }
}
