class Solution {
    public String reverseStr(String s, int k) {
        char[] sArray = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            reverseStrInRange(sArray, i, Math.min(i + k - 1, s.length() - 1));
            i += 2 * k;
        }
        return String.valueOf(sArray);
    }

    // Reverse string between [i, j]
    private void reverseStrInRange(char[] s, int i, int j) {
        while (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++; j--;
        }
    }
}
