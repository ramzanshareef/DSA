import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            graph.get(invocation[0]).add(invocation[1]);
        }
        Set<Integer> suspicious = new HashSet<>();
        dfs(k, graph, suspicious);
        boolean canRemove = true;
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                for (int invokedMethod : graph.get(i)) {
                    if (suspicious.contains(invokedMethod)) {
                        canRemove = false;
                        break;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        if (canRemove) {
            for (int i = 0; i < n; i++) {
                if (!suspicious.contains(i)) {
                    result.add(i);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
        }

        return result;
    }

    private void dfs(int method, List<List<Integer>> graph, Set<Integer> suspicious) {
        if (suspicious.contains(method)) {
            return;
        }
        suspicious.add(method);
        for (int invokedMethod : graph.get(method)) {
            dfs(invokedMethod, graph, suspicious);
        }
    }
}