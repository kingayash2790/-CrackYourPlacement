package Day04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirGraph {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Solution {
        // Helper function to detect a cycle using BFS
        public boolean detectCycle(int source, ArrayList<ArrayList<Integer>> adj, int[] vis) {
            vis[source] = 1; // Mark the source node as visited
            Queue<Pair> queue = new LinkedList<>();

            // Add the initial node into the queue with its parent as -1
            queue.add(new Pair(source, -1));

            while (!queue.isEmpty()) {
                Pair node = queue.poll();
                int curNode = node.first;
                int parent = node.second;

                // Traverse all neighbors of the current node
                for (int neighbour : adj.get(curNode)) {
                    if (vis[neighbour] == 0) { // If neighbor is not visited
                        vis[neighbour] = 1; // Mark neighbor as visited
                        queue.add(new Pair(neighbour, curNode)); // Add neighbor to queue with current node as parent
                    } else if (neighbour != parent) { // If neighbor is visited and not the parent, cycle detected
                        return true;
                    }
                }
            }
            return false; // No cycle detected
        }

        // Main function to detect cycle in an undirected graph
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            int[] vis = new int[V]; // Array to keep track of visited nodes

            // Initialize all nodes as unvisited
            for (int i = 0; i < V; i++) {
                vis[i] = 0;
            }

            // Check each node; if not visited, run cycle detection
            // This is to check the cycle detection for connected components
            for (int i = 0; i < V; i++) {

                // If the visited[node] = 0, that means it is a node of different component
                if (vis[i] == 0) {
                    if (detectCycle(i, adj, vis)) {
                        return true; // If a cycle is detected
                    }
                }
            }
            return false; // No cycles detected
        }
    }
}
