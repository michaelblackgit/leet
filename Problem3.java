// Longest substring without repeating characters

import java.util.HashSet;

public class Problem3 {

  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<Character>();
    int count = 0, max = 0;
    int j = 0;

    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(!set.contains(c)) {
        set.add(c);
        count++;
      } else {
        if(max < count) max = count;
        while(s.charAt(j) != c) {
          set.remove(s.charAt(j));
          count--;
          j++;
        }
        j++;
      }
    }
    if(max < count) max = count;
    return max;
  }

  public static void main(String[] args) {
    Problem3 p3 = new Problem3();
    System.out.println(p3.lengthOfLongestSubstring("abcabcabb"));
  }
}
