import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<String> text = new ArrayList<>();
        List<String> pattern = new ArrayList<>();

        getSerial(root, text); getSerial(subRoot, pattern);

        int[] next = getNext(pattern);

        // i：文本串 j:模式串
        int i = 0; int j = 0;
        while (i < text.size() && j < pattern.size()) {

            if (stringEqual(text.get(i), pattern.get(j))) {
                i++; j++;
            } else if (next[j] >= 0){
                j = next[j];
            } else {
                i++; j = 0;
            }
        }
        return j == pattern.size();
    }

    private boolean stringEqual(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        return s1.equals(s2);
    }

    private int[] getNext(List<String> pattern) {
        if (pattern.size() == 1) return new int[]{-1};
        int[] next = new int[pattern.size()];
        next[0] = -1;  next[1] = 0;
        for (int i = 2; i < pattern.size(); i++) {
            String tailOfSuffix = pattern.get(i - 1);
            int possibleNextIndexOfPrefix = next[i - 1];
            // 解释下这里的边界情况：possibleNextIndexOfPrefix = 0时，0前面没有字符串了，不存在前后缀，我们用next[0]=-1标记这种情况。
            // 此时长度也就是0.
            while (possibleNextIndexOfPrefix >= 0 && !stringEqual(pattern.get(possibleNextIndexOfPrefix), tailOfSuffix)) possibleNextIndexOfPrefix = next[possibleNextIndexOfPrefix];
            if (possibleNextIndexOfPrefix < 0) {
                next[i] = 0;
            } else {
                next[i] = possibleNextIndexOfPrefix + 1;
            }
        }
        return next;
    }

    private void getSerial(TreeNode head, List<String> path) {
        if (head == null) {
            path.add(null);
        } else {
            path.add(String.valueOf(head.val));
            getSerial(head.left, path);
            getSerial(head.right, path);
        }
    }
}
