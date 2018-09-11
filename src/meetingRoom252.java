import java.util.Arrays;

public class meetingRoom252 {
    /*
    252. Meeting Rooms
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

    Example 1:

    Input: [[0,30],[5,10],[15,20]]
    Output: false
    Example 2:

    Input: [[7,10],[2,4]]
    Output: true
     */

    private class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s, int e) { start = s; end = e; }
    }
    /*
    approach: store all starts and ends in two arrays and sort
    if its invalid, next start time will be less than current end time
     */

    public boolean canAttendMeetings(Interval[] intervals) {

        int[] starts=new int[intervals.length];
        int[] ends=new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starts[i]=intervals[i].start;
            ends[i]=intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for(int i=1; i<intervals.length; i++){
            if(starts[i]<ends[i-1])
                return false;
        }
        return true;
    }
}
