package hackerrank.bfs;

import java.util.*;

public class ShortestReach {
    public static class Graph {
        List<List<Integer>> adjList;
        int size;
        public Graph(int size) {
            adjList = new ArrayList<>();
            this.size = size;
            while (size-- > 0) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }

        public int[] shortestReach(int startId) {
            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            distances[startId] = 0;
            Set<Integer> seen = new HashSet<>();
            seen.add(startId);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startId);
            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                for (int i : adjList.get(curr)) {
                    if (!seen.contains(i)) {
                        queue.add(i);
                        seen.add(i);
                        distances[i] = distances[curr] + 6;
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
