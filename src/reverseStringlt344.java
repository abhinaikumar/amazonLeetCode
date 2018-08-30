public class reverseStringlt344 {

    /*
    344. Reverse String

    Input: "hello"
    Output: "olleh"

    Input: "A man, a plan, a canal: Panama"
    Output: "amanaP :lanac a ,nalp a ,nam A"

     */

    /*
    first approach: StringBuffer
     */
    public String reverseString(String s) {
        if(s==null || s.length()==0){
            return new String();
        }
        StringBuffer sb=new StringBuffer();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    /*
    second approach: CharArray, use swap method
     */
    public String reverseString1(String s){

        char[] res=s.toCharArray();
        int i=0;
        int j=s.length()-1;

        while(i<j){
            char tmp=res[i];
            res[i]=res[j];
            res[j]=tmp;
            i++;
            j--;
        }
        return new String(res);
    }
}
