import java.util.Stack;

class Solution {
    public int celebrity(int mat[][]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int v1 = st.pop();
            int v2 = st.pop();
            if (mat[v1][v2] == 0) {
                st.push(v1);
            } else if (mat[v2][v1] == 0) {
                st.push(v2);
            }
        }
        if (st.size() == 0) {
            return -1;
        }
        int potentialCeleb = st.pop();
        for (int i = 0; i < mat.length; i++) {
            if (mat[potentialCeleb][i] == 1) {
                return -1;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == potentialCeleb) {
                continue;
            }
            if (mat[i][potentialCeleb] == 1) {
                return -1;
            }
        }
        return potentialCeleb;
    }
}