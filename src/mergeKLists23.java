import java.util.PriorityQueue;

public class mergeKLists23 {
    /*
    23. Merge k Sorted Lists
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6

     */

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    /*
    first try:
    Use PriorityQueue to store the data. O(logN)to insert one element, hence for total lists, the time complexity is
    O(nlogn), Space O(n)
    Build a new Listnodes is O(n) time
    Total time: O(nlogn)+O(n)=O(nlogn)
    Total space: O(n)

     */

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0; i<lists.length;i++){
            ListNode list = lists[i];
            while(list!=null){
                queue.add(list.val);
                list=list.next;
            }
        }
        ListNode guard=new ListNode(0);
        ListNode head=null;
        if(!queue.isEmpty())
            head=new ListNode(queue.poll());
        guard.next=head;
        while(!queue.isEmpty()){
            head.next=new ListNode(queue.poll());
            head=head.next;
        }
        return guard.next;
    }
}
