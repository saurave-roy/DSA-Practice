Bruteforce:

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(head == null || head.next == null)return head;

        ListNode temp = head;

        while(temp!=null && temp.next!=null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.val);
        }

        temp = head.next;

        while(temp != null &&temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.val);
        }
        int i = 0;
        temp = head;

        while(temp!=null){
            temp.val = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }
}

Optimal:

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
