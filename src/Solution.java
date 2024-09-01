import java.util.*;

public class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        List<Integer> results = new ArrayList<>();
        LinkedList<Integer> distances = new LinkedList<>();
        HashMap<Integer, Integer> distanceMap = new HashMap<>();

        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];
            int dist = Math.abs(x) + Math.abs(y);
            if (distanceMap.containsKey(dist)) {
                distanceMap.put(dist, distanceMap.get(dist) + 1);
            } else {
                distanceMap.put(dist, 1);
            }
            insertSorted(distances, dist);
            if (distances.size() > k) {
                int removedDist = distances.removeLast();
                distanceMap.put(removedDist, distanceMap.get(removedDist) - 1);
                if (distanceMap.get(removedDist) == 0) {
                    distanceMap.remove(removedDist);
                }
            }
            if (distances.size() < k) {
                results.add(-1);
            } else {
                results.add(distances.get(k - 1));
            }
        }
        return results.stream().mapToInt(i -> i).toArray();
    }

    private void insertSorted(LinkedList<Integer> list, int dist) {
        int index = 0;
        while (index < list.size() && list.get(index) < dist) {
            index++;
        }
        list.add(index, dist);
    }
}