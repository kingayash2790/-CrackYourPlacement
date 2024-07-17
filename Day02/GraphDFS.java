package Day02;

import java.util.ArrayList;

public class GraphDFS {

    class Solution {
        public void dfs(int nodeVal, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList) {
            vis[nodeVal] = true;
            dfsList.add(nodeVal);

            for (Integer it : adj.get(nodeVal)) {
                if (vis[it] == false) {
                    // If the neighbouring node is not visited, then call the dfs function,
                    // where it will mark the node as visited and then it will add that node to
                    // dfsList
                    dfs(it, vis, adj, dfsList);
                }
            }
        }

        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] vis = new boolean[V + 1];
            ArrayList<Integer> dfsList = new ArrayList<>();

            // Initially marking the strating node as visited
            vis[0] = true;
            dfs(0, vis, adj, dfsList);
            return dfsList;
        }
    }
}
