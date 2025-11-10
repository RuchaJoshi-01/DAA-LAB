import java.util.*;
public class FileMergeOptimizer {
    public static void main(String[] args) {
        int[] fileSizes = {10, 20, 30, 5};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : fileSizes) pq.add(s);
        int totalCost = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            int merge = a + b;
            totalCost += merge;
            pq.add(merge);
        }
        System.out.println("Minimum File Merge Cost: " + totalCost);
    }
}
