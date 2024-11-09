class Solution {
    public String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        int len = removeExtraSpaces(sArray);
        reverseString(sArray, 0, len - 1);
        int wordStart = 0; int wordEnd = 0;
        while (wordEnd < len) {
            if (sArray[wordEnd] == ' ') {
                reverseString(sArray, wordStart, wordEnd - 1);
                wordStart = wordEnd + 1;
            }
            if (wordEnd == len - 1) {
                reverseString(sArray, wordStart, wordEnd);
                wordStart = wordEnd + 1;
            }
            wordEnd++;
        }
        return String.valueOf(sArray, 0, len);
    }

    //Reverse string [i, j]
    private void reverseString(char[] s, int i, int j) {
        while (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++;
            j--;
        }
    }

    private int removeExtraSpaces(char[] s) {
        int slow = -1; int fast = 0;
        while (fast < s.length) {
            if (s[fast] != ' ') {
                s[++slow] = s[fast++];
            } else {
                while (fast < s.length && s[fast] == ' ') fast++;
                //头和尾不用加空格
                if (fast < s.length && slow != -1) {
                    s[++slow] = ' ';
                }
            }
        }
        return slow + 1;
    }
}
