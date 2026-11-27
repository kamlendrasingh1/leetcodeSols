class Solution {
    public int strStr(String haystack, String needle) {

        // Step 1: Build LPS
        int[] lps = new int[needle.length()];

        int prevLPS = 0;
        int i = 1;

        while (i < needle.length()) {

            if (needle.charAt(i) == needle.charAt(prevLPS)) {

                lps[i] = prevLPS + 1;

                prevLPS++;
                i++;

            } else {

                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }

        // Step 2: KMP search
        i = 0;
        int j = 0;

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {

                i++;
                j++;

            } else {

                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == needle.length()) {
                return i - needle.length();
            }
        }

        return -1;
    }
}