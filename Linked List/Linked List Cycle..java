Brute force:
  
  public class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;

        while(temp!=null){
            if(map.containsKey(temp))return true;
            map.put(temp, 1);

            temp = temp.next;
        }
        return false;
    }
}

Optimal:

public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){ 
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)return true;
        }
        return false;
    }
}
