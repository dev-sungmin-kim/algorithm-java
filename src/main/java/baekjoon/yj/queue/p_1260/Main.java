package baekjoon.yj.queue.p_1260;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNode = scanner.nextInt();
        int numberOfEdge = scanner.nextInt();
        int startNode = scanner.nextInt();

        int[][] graph = new int[numberOfNode + 1][numberOfNode + 1];
        while (numberOfEdge-- > 0) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();

            graph[node1][node2] = graph[node2][node1] = 1;
        }

        System.out.println(getDFSResult(graph, startNode));
        System.out.println(getBFSResult(graph, startNode));
    }

    private static String getDFSResult(int[][] graph, int startNode) {
        boolean[] visited = new boolean[graph.length];
        List<String> result = new ArrayList<>();

        depthFirstSearch(graph, startNode, visited, result);

        return String.join(" ", result);
    }

    private static void depthFirstSearch(int[][] graph, int node, boolean[] visited, List<String> result) {
        visited[node] = true;
        result.add(String.valueOf(node));

        for (int i = 1; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                depthFirstSearch(graph, i, visited, result);
            }
        }
    }

    private static String getBFSResult(int[][] graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        queue.offer(startNode);
        visited[startNode] = true;

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(String.valueOf(node));

            for (int i = 1; i < graph.length; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        return String.join(" ", result);
    }
}
