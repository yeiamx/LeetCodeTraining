class Solution {
    public int strStr(String haystack, String needle) {
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int[] next = getNext(pattern);
        // i：文本串 j:模式串
        int i = 0; int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (text[i] == pattern[j]) {
                i++; j++;
            } else if (next[j] >= 0){
                j = next[j];
            } else {
                i++; j = 0;
            }
        }
        if (j == needle.length()) {
            return i - needle.length();
        }
        return -1;
    }

    private int[] getNext(char[] pattern) {
        if (pattern.length == 1) return new int[]{-1};
        int[] next = new int[pattern.length];
        next[0] = -1;  next[1] = 0;
        for (int i = 2; i < pattern.length; i++) {
            char tailOfSuffix = pattern[i - 1];
            int possibleNextIndexOfPrefix = next[i - 1];
            // 解释下这里的边界情况：possibleNextIndexOfPrefix = 0时，0前面没有字符串了，不存在前后缀，我们用next[0]=-1标记这种情况。
            // 此时长度也就是0.
            while (possibleNextIndexOfPrefix >= 0 && pattern[possibleNextIndexOfPrefix] != tailOfSuffix) possibleNextIndexOfPrefix = next[possibleNextIndexOfPrefix];
            if (possibleNextIndexOfPrefix < 0) {
                next[i] = 0;
            } else {
                next[i] = possibleNextIndexOfPrefix + 1;
            }
        }
        return next;
    }
}
