public class isMonotonicArray896 {

    /*
    896. Monotonic Array
    An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

    Return true if and only if the given array A is monotonic.

    Example 1:
    Input: [1,2,2,3]
    Output: true
    Example 2:

    Input: [6,5,4,4]
    Output: true
    Example 3:

    Input: [1,3,2]
    Output: false
    Example 4:

    Input: [1,2,4,5]
    Output: true
    Example 5:

    Input: [1,1,1]
    Output: true

     */

    /*
    ugly approach when I wrote in the 100th conest

     */
    public boolean isMonotonic(int[] A) {
        if(A.length==1)
            return true;
        int index=1;
        while(index<A.length&&A[index-1]==A[index]){
            index++;
        }
        if(index==A.length)
            return true;
        int flag=A[index-1]>A[index]?-1:1;
        if(flag==-1){
            while(index<A.length){
                if(A[index]>A[index-1]){
                    return false;
                }
                index++;
            }
        }else{
            while(index<A.length){
                if(A[index]<A[index-1]){
                    return false;
                }
                index++;
            }
        }
        return true;
    }


    /*
    super clean and cool approach from discussion
     */

    public boolean isMonotonicCool(int[] A) {
        if(A.length==1)
            return true;
        boolean inc=true;
        boolean dec=true;

        for(int i=1; i<A.length; i++){
            inc &= A[i-1]<=A[i];
            dec &= A[i-1]>=A[i];
        }
        return inc||dec;
    }



}
