import java.util.*;
public class ProductSort {
    static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; int i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) {
                i++; double t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            }
        double t = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = t;
        return i + 1;
    }
    public static void main(String[] args) {
        double[] prices = {999.99, 499.49, 1299.00, 250.75, 750.10};
        quickSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(prices));
    }
}
