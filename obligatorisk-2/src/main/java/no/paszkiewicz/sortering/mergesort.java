package no.paszkiewicz.sortering;
import java.util.Random;

public class mergesort {

    static void mergeSort(int[] a,int[] temptab, int forste, int siste) {
        if (forste < siste) {
            int midt = (forste + siste) / 2;
            temptab = new int[a.length];
            mergeSort(a,temptab, forste, midt);
            mergeSort(a,temptab, midt + 1, siste);
            merge(a, temptab, forste, midt, siste);
        }
    }

    static void merge(int[] a, int[] temptab, int forste, int midt, int siste) {
        int forstehalv1 = forste;
        int sistehalv1 = midt;
        int andrehalv = midt + 1;
        int sistehalv2 = siste;
        int i = 0;
        while (forstehalv1 <= sistehalv1 && andrehalv <= sistehalv2) {
            if (a[forstehalv1] <= a[andrehalv]) {
                temptab[i] = a[forstehalv1];
                forstehalv1++;
            } else {
                temptab[i] = a[andrehalv];
                andrehalv++;
            }
            i++;
        }
        for (; forstehalv1 <= sistehalv1; forstehalv1++, i++) {
            temptab[i] = a[forstehalv1];
        }
        for (; andrehalv <= sistehalv2; andrehalv++, i++) {
            temptab[i] = a[andrehalv];
        }
        for (i = forste; i <= siste; i++) {
            a[i] = temptab[i];
        }
    }

    public static void main(String[] args) {
        Random tilfeldig = new Random();
        int n = 32000;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = tilfeldig.nextInt(99);
        }
        long start = System.currentTimeMillis();

        mergeSort(array,array, 0, n-1);

        long slutt = System.currentTimeMillis();

        System.out.println("Tid brukt: " + (slutt - start) + " ms");
        System.out.println("Tid i sekund: " + ((slutt - start) / 1000.0) + "s");
    }
}
