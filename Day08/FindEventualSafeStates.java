package Day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int m = graph.length;
            int n = graph[0].length;
            List<List<Integer>> adjRev = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                adjRev.add(new ArrayList<>());
            }

            int[] indegree = new int[m];
            // Reverse the edges
            for (int i = 0; i < m; i++) {
                for (int it : graph[i]) {
                    // it -> i
                    // i -> it
                    adjRev.get(it).add(i);
                    indegree[i]++;
                }
            }
            Queue<Integer> q = new LinkedList<>();
            List<Integer> safeNodes = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                safeNodes.add(node);
                for (int it : adjRev.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        q.add(it);
                    }
                }
            }
            Collections.sort(safeNodes);
            return safeNodes;

        }
    }
}
