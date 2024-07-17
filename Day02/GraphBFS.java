package Day02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            ArrayList<Integer> bfs = new ArrayList<>();
            boolean[] vis = new boolean[V + 1];
            Queue<Integer> queue = new LinkedList<>();
            vis[0] = true;
            queue.add(0);

            while (!queue.isEmpty()) {
                // Remove it from the queue
                Integer node = queue.poll();
                // Add it to the bfs
                bfs.add(node);

                for (Integer it : adj.get(node)) {
                    if (vis[it] == false) {
                        vis[it] = true;
                        queue.add(it);
                    }
                }
            }
            return bfs;
        }
    }
}
