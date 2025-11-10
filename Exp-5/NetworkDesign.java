import java.util.*;
public class NetworkDesign {
    static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) { min = key[v]; idx = v; }
        return idx;
    }
    public static void main(String[] args) {
        int V = 5;
        int[][] cost = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}};
        int[] key = new int[V], parent = new int[V];
        boolean[] mstSet = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; parent[0] = -1;
        for (int i = 0; i < V - 1; i++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (cost[u][v] != 0 && !mstSet[v] && cost[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = cost[u][v];
                }
        }
        int total = 0;
        for (int i = 1; i < V; i++) total += cost[i][parent[i]];
        System.out.println("Minimum Cable Installation Cost: " + total);
    }
}
