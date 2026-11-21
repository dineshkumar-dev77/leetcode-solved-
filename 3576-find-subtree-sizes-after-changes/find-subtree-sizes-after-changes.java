import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // First DFS: Find new parents
        int[] nodeStack = new int[n];
        int[] indexStack = new int[n];
        int[] oldStack = new int[n];

        int top = 0;
        nodeStack[top] = 0;
        oldStack[top] = -1;

        last[s.charAt(0) - 'a'] = 0;

        while (top >= 0) {

            int node = nodeStack[top];

            if (indexStack[top] < tree[node].size()) {

                int child = tree[node].get(indexStack[top]++);

                int c = s.charAt(child) - 'a';

                int old = last[c];

                if (old != -1) {
                    newParent[child] = old;
                }

                top++;

                nodeStack[top] = child;
                indexStack[top] = 0;
                oldStack[top] = old;

                last[c] = child;

            } else {

                int c = s.charAt(node) - 'a';

                last[c] = oldStack[top];

                top--;
            }
        }

        // Build the modified tree
        List<Integer>[] updated = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            updated[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            updated[newParent[i]].add(i);
        }

        // Second DFS: Calculate subtree sizes
        int[] order = new int[n];
        int[] stack = new int[n];

        int size = 0;
        top = 0;

        stack[top++] = 0;

        while (top > 0) {

            int node = stack[--top];

            order[size++] = node;

            for (int child : updated[node]) {
                stack[top++] = child;
            }
        }

        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = n - 1; i > 0; i--) {

            int node = order[i];

            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}