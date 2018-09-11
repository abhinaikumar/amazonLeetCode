import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    /*
        146. LRU Cache
        Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

        Follow up:
        Could you do both operations in O(1) time complexity?

        Example:

        LRUCache cache = new LRUCache( 2 );//capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

     */
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    public void remove(Node n){
        // n is not head
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
        //n is not tail
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
    }
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
        //linkedlist is not empty
        if(head!=null)
            head.pre = n;
        head = n;
        //first element insert into linkedlist
        if(end ==null)
            end = head;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node tmp = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(tmp);
            }else{
                setHead(tmp);
            }
            map.put(key, tmp);
        }
    }
}
