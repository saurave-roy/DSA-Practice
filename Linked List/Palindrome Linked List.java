Brute force:

  class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        while(temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;

        while(temp!=null){
            if(temp.val != st.peek())return false;
            st.pop();
            temp = temp.next;
        }
        return true;
    }
}

Optimal:

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second!=null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {

            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}
