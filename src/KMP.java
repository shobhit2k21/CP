
public class KMP {

    // Build LPS (Longest Prefix Suffix) array
    static int[] buildLPS(String pattern) {

        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } 
            else {
                if (len != 0) {
                    len = lps[len - 1];
                } 
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // KMP Pattern Searching
    static void KMPSearch(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m == 0) {
            System.out.println("Empty pattern");
            return;
        }

        int[] lps = buildLPS(pattern);

        int i = 0; // Text pointer
        int j = 0; // Pattern pointer

        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));

                j = lps[j - 1];
            }
            else if (i < n && text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {

        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int[] lps = buildLPS(pattern);

        System.out.print("LPS Array: ");
        for (int x : lps) {
            System.out.print(x + " ");
        }

        System.out.println("\n");

        KMPSearch(text, pattern);
    }
}
