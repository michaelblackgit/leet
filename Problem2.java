// Add two numbers

public class Problem2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l3 = new ListNode(-1);
    ListNode l3start = l3;
    int addend1, addend2, sum;
    int carry = 0;

    while(true) {
      if(l1 == null && l2 == null) break;

      if(l1 == null) addend1 = 0;
      else addend1 = l1.val;

      if(l2 == null) addend2 = 0;
      else addend2 = l2.val;

      if(carry != 0) sum = addend1 + addend2 + carry;
      else sum = addend1 + addend2;

      if(sum > 9) {
        carry = sum / 10;
        sum = sum % 10;
      } else carry = 0;

      if(l3.val != -1) {
        l3.next = new ListNode(sum);
        l3 = l3.next;
      }
      else l3.val = sum;

      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
    }
    if(carry != 0) l3.next = new ListNode(carry);
    return l3start;
  }

  public static void main(String[] args) {
    Problem2 p2 = new Problem2();

    ListNode l1n1 = new ListNode(5);
    //ListNode l1n2 = new ListNode(4);
    //ListNode l1n3 = new ListNode(3);
    //l1n1.next = l1n2;
    //l1n2.next = l1n3;

    ListNode l2n1 = new ListNode(5);
    //ListNode l2n2 = new ListNode(6);
    //ListNode l2n3 = new ListNode(4);
    //l2n1.next= l2n2;
    //l2n2.next = l2n3;

    p2.printList(l1n1);
    p2.printList(l2n1);
    p2.printList(p2.addTwoNumbers(l1n1, l2n1));
  }

  private void printList(ListNode ln) {
    while(ln != null) {
      System.out.print(ln.val + " ");
      ln = ln.next;
    }
    System.out.println();
  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
