public class AllSubstringArePalindromeOrNot {
    public static void main(String[] args) {    // O(N^2) solution instead pf N^3

        String s = "Shobhit";
        int n = s.length();                           // n <= 10^4
        boolean[][] palindromeTable = new boolean[n][n];

// Base Case 1: Substrings of length 1 are always palindromes
        for (int i = 0; i < n; i++) {
            palindromeTable[i][i] = true;
        }

// Base Case 2: Substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromeTable[i][i + 1] = true;
            }
        }

// General Case: Substrings of length 3 to n
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // End index

                // A substring s[i..j] is a palindrome if outer characters match
                // AND the inner substring s[i+1..j-1] is also a palindrome
                if (s.charAt(i) == s.charAt(j) && palindromeTable[i + 1][j - 1]) {
                    palindromeTable[i][j] = true;
                }
            }
        }
    }
}

