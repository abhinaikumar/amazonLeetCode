public class getIntersectionNodelt160 {
    /*
    160. Intersection of Two Linked Lists

    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3

    Notes:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
    */

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    /*
    first approach: check the length, and move the longer one's start node to the same position
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null||headB==null){
            return null;
        }
        int len1=getLen(headA);
        int len2=getLen(headB);
        ListNode a=headA;
        ListNode b=headB;

        while(len1>len2){
            a=a.next;
            len1--;
        }
        while(len2>len1){
            b=b.next;
            len2--;
        }

        while(a!=null&&b!=null&&a!=b){
            a=a.next;
            b=b.next;
        }
        return a;
    }

    private int getLen(ListNode node){
        int res=0;
        while(node!=null){
            res++;
            node=node.next;
        }
        return res;
    }

    /*
    second approach from discussion: 没明白为什么虽然看了explanation
    We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to
    the head of another linkedlist after it reaches the tail node. In the second iteration, we will move two pointers
    until they points to the same node. Our operations in first iteration will help us counteract the difference.
    So if two linkedlist intersects, the meeting point in second iteration must be the intersection point.
    If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be
    the tail node of both lists, which is null
    */

    public ListNode getIntersectionNodeApproach2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

}
