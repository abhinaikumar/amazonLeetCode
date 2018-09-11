import java.util.*;

public class MedianFinder {

    PriorityQueue<Integer> smallerQueue;
    PriorityQueue<Integer> biggerQueue;
    private boolean even = true;
    public MedianFinder() {
        smallerQueue =new PriorityQueue<>(Collections.reverseOrder());//max heap because we need to pop the biggest element
        biggerQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(even){
            biggerQueue.add(num);
            smallerQueue.add(biggerQueue.poll());
        }else{
            smallerQueue.add(num);
            biggerQueue.add(smallerQueue.poll());
        }
        even = !even;
    }

    public double findMedian() {
        double res=0;
        if(even){
            res = (smallerQueue.peek()+biggerQueue.peek())/2.0;
        }else{
            res = smallerQueue.peek();
        }
        return res;
    }

}
