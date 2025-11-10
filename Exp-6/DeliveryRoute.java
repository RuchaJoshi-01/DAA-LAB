import java.util.*;
public class DeliveryRoute {
    static int minDistance(int[] dist, boolean[] visited, int V) {
        int min = Integer.MAX_VALUE, idx = -1;
        for (int v = 0; v < V; v++)
            if (!visited[v] && dist[v] <= min) { min = dist[v]; idx = v; }
        return idx;
    }
    public static void main(String[] args) {
        int[][] map = {
            {0, 4, 0, 0, 0, 10},
            {4, 0, 3, 0, 0, 0},
            {0, 3, 0, 2, 4, 0},
            {0, 0, 2, 0, 1, 0},
            {0, 0, 4, 1, 0, 2},
            {10, 0, 0, 0, 2, 0}};
        int V = map.length, src = 0;
        int[] dist = new int[V]; boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited, V);
            visited[u] = true;
            for (int v = 0; v < V; v++)
                if (!visited[v] && map[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + map[u][v] < dist[v])
                    dist[v] = dist[u] + map[u][v];
        }
        for (int i = 0; i < V; i++)
            System.out.println("Shortest distance from warehouse to city " + i + " = " + dist[i]);
    }
}
