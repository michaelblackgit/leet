// Longest palindromic substring

public class Problem5 {

  public String longestPalindrome(String s) {
    // use dynamic programming
    boolean[][] table = new boolean[s.length()][s.length()];
    String longestPalindrome = s.substring(0, 1);

    // length 1 and 2
    for(int i = 0; i < s.length() - 1; i++) {
      table[i][i] = true;
      if(s.charAt(i) == s.charAt(i + 1)) {
        table[i][i + 1] = true;
        // add 2 instead of one because of the way
        // substrng works
        longestPalindrome = s.substring(i, i + 2);
      }
    }
    table[s.length() - 1][s.length() - 1] = true;

    // length > 2
    for(int j = 1; j < s.length(); j++) {
      for(int i = 0; i < s.length() - 1; i++) {
        if(i > j) continue; // need this or it's too slow
        if(s.charAt(i) == s.charAt(j) && table[i + 1][j - 1] == true) {
          table[i][j] = true;
          if(s.substring(i, j + 1).length() > longestPalindrome.length())
            longestPalindrome = s.substring(i, j + 1);
        }
      }
    }

    return longestPalindrome;
  }

  private void printTable(boolean[][] t, int size) {
    System.out.print(" ");
    for(int i = 0; i < size; i++) System.out.print(" " + i);
    System.out.println();
    for(int i = 0; i < size; i++) {
      System.out.print(i + " ");
      for(int j = 0; j < size; j++) {
        if(t[i][j]) System.out.print("T ");
        else System.out.print("F ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Problem5 p5 = new Problem5();
    System.out.println(p5.longestPalindrome("bananas"));
  }
}
