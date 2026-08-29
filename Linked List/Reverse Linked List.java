Bruteforce:
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer>st = new Stack<>();
        ListNode temp = head;

        while(temp!=null){
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;

        while(temp != null){
            temp.val = st.pop();
            temp = temp.next;
        }
        return head;
    }
}

Optimal:
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
