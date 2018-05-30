import java.util.HashMap;
// Two Sum
public class Problem1 {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i = 0; i < nums.length; i++) {
      int compliment = target - nums[i];
      if(map.containsKey(compliment)) {
        return new int[] {map.get(compliment), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("Something when wrong");
  }

  public static void main(String[] args) {
    Problem1 p1 = new Problem1();
    int[] nums = new int[] {2, 7, 11, 15};
    int target = 9;
    int[] answer = p1.twoSum(nums, target);
    System.out.print("[");
    for(int i = 0; i < answer.length - 1; i++) {
      System.out.print(answer[i] + ", ");
    }
    System.out.print(answer[answer.length - 1] + "]");
    System.out.println();
  }
}
