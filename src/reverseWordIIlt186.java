import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class reverseWordIIlt186 {
    /*
    186. Reverse Words in a String II

    Given an input string , reverse the string word by word.
    Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
    Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

     */

    /*
    first approach: use list to save words O(n) space
    slow, beat 6%
     */

    public void reverseWords(char[] str) {
        List<String> words = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        //save all words into list
        for(int i=0; i<str.length; i++){

            if(str[i]!=' '){
                sb.append(str[i]);
                if(i==str.length-1){
                    words.add(sb.toString());
                }
            }else{
                words.add(sb.toString());
                sb.setLength(0);
            }
        }
        //reverse
        int offset=0;
        for(int i=words.size()-1; i>=0; i--){
            String word=words.get(i);
            for(int j=0; j<word.length(); j++){
                str[j+offset]=word.charAt(j);
                if(j==word.length()-1&&i!=0){
                    str[j+offset+1]=' ';
                }
            }
            offset+=word.length()+1;
        }
    }

    /*
    second approach: inplace O(1)space
    disscussion: reverse twice, first, whole char[], then each word
     */
    public void reverseWords2(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {      // no need to worry about space
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] str, int start, int end){
        while(start<end){
            char tmp=str[start];
            str[start]=str[end];
            str[end]=tmp;
            start++;
            end--;
        }
    }



}
