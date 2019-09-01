import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/*
	Autor: Eduardo Barbosa de Oliveira RA: 1814559
	Repositório: https://github.com/dacom-utfpr-cm/atividade-2-mais-threads-eboliveira
	Data: 01/09/2019
	Problema: Faça um programa multithreaded em Java que ordene um vetor usando o Merge Sort recursivo.
	Faça com que a thread principal dispare duas threads para classificar cada metade do vetor.
*/
public class Main {


    public static void mergeSort(int[] a, int n) throws InterruptedException {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        //Cria os runnables da chamada recursiva
        Runnable r1 = () -> {
            try {
                mergeSort(l, mid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                mergeSort(r, n - mid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        //cria as threas e executa
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();

        //da merge nos vetores resutantes
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = { 5, 1, 6, 2, 3, 4 };
        System.out.println(Arrays.toString(array));
        mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

}