package Model;

import java.util.Arrays;

public class RadixSort {
    /**
     * Algoritmo extraido de: https://www.geeksforgeeks.org/Radix-sort/
     * @param arr
     * @param n
     * @return
     */
    public static int getMax(Integer arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    /**
     *  contar
     * @param arr array a ordenar
     * @param n largo
     * @param exp a
     */
    public static void countSort(Integer arr[], int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    /**
     * aa
     * @param arr array a ordenar
     * @param n a
     * @return array ordenado
     */

    public static Integer[] radixsort(Integer arr[], int n)
    {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        return arr;
    }

}
