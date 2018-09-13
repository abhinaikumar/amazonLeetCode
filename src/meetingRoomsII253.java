import java.util.Arrays;

public class meetingRoomsII {
    /*
    253. Meeting Rooms II
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    find the minimum number of conference rooms required.

    Example 1:

    Input: [[0, 30],[5, 10],[15, 20]]
    Output: 2
    Example 2:

    Input: [[7,10],[2,4]]
    Output: 1
     */

    private class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e) { start = s; end = e; }
    }

    public int minMeetingRooms(Interval[] intervals) {

        int room=1;
        int[] starts=new int[intervals.length];
        int[] ends=new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starts[i]=intervals[i].start;
            ends[i]=intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int end=0;
        for(int i=0; i<intervals.length; i++){
            if(starts[i]<ends[end]){
                room++;
            }
            else{
                end++;
            }
        }
        return room;
    }

}
