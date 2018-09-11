public class RLEIterator {

    int[] iterators;

    public RLEIterator(int[] A) {
        int[] sequences = new int[A.length/2];
        int[] nums = new int[A.length/2];
        for(int i=0,j=0,z=0; i<A.length; i++){
            if(i%2==0){
                sequences[j]=A[i];
                j++;
            }
            else{
                nums[z]=A[i];
                z++;
            }
        }
        int sum=0;
        for(int i=0; i<sequences.length; i++){
            sum+=sequences[i];
        }
        iterators=new int[sum];
        int offset=0;
        for(int i=0; i<sequences.length;i++){
            int descrese=sequences[i];
            int val=nums[i];
            while(descrese>0){
                iterators[offset]=val;
                descrese--;
                offset++;
            }
        }
    }
    //iterators => 8 8 8 5 5
    //next = [2],[1],[1],[2]
    // return 8 8 5 -1
    public int next(int n) {
        int[] nums=iterators;
        int lastSequence=0;
        int[] rest=new int[iterators.length-n];
        for(int i:iterators){
            System.out.println(i);
        }
        lastSequence = n>iterators.length ? -1 : iterators[n-1];
        for(int i=n, j=0; i<iterators.length; i++, j++){
            rest[j]=iterators[i];
        }
        return lastSequence;
    }
}
