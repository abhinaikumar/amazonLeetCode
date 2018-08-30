import java.util.List;

public class addTwoNumbersI {
    /*
    2. Add Two Numbers

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    /*
    first approach: reverse two list and add them , reverse sum
    care point: carry left or not? when one listnode is null? keep track head.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode res=new ListNode(0);
        ListNode dummy=res;
        while(l1!=null || l2!=null){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            res.next=new ListNode((val1+val2+carry)%10);
            if(val1+val2+carry>=10){
                carry=1;
            }else{
                carry=0;
            }
            res=res.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1){
            res.next=new ListNode(1);
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode l){
        ListNode prev=null;
        while(l!=null){
            ListNode next=l.next;
            l.next=prev;
            prev=l;
            l=next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(4);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(5);
        ListNode n=addTwoNumbers(l1,l2);
        while(n!=null){
            System.out.print(n.val);
            n=n.next;
        }
        System.out.println();
        System.out.println(342+564);
    }
}
