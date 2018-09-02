public class longestPalindromeSubstringlt5 {
    /*
    5. Longest Palindromic Substring
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Input: "cbbd"
    Output: "bb"
     */

    /*
    substring is same as subarray. its continuous.

    https://www.youtube.com/watch?v=m2Mk9JN5T4A      well explained

    */


    /*
    first approach: dynamic programming
    str="babad"
    i=1 j=4 if charAt(i)==charAt(j) then if str from i+1 to j-1 is palindrome then str from i to j is palindrome
    then dp[i][j]=true if dp[i+1][j-1] is true;
    edge case: i=2, j=3 || i=2, j=2
    when the difference between i,j is less than 3, which means if j-i=2(i.e i=1, j=3), char[i]==char[j] then i+1,j-1 is
    same character, then it is always true; similar idea for j-i=1 and j=i;
    time: O(n^2), space:O(n^2)
     */
    public String longestPalindromicSubStringDP(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int max=0;
        String res=new String();
        //care about i,j,if use i as the starting index, j as the ending index, then loop j first then loop i....
        for(int j=0; j<s.length(); j++){
            for(int i=0; i<=j; i++){
                //consider edge case
                dp[i][j] = s.charAt(i)==s.charAt(j)&&(j-i<=2 || dp[i+1][j-1]);
                if(dp[i][j]){
                    //it's palindromic, care about length when it is related with index.
                    if(max<j-i+1){
                        max=j-i+1;
                        res=s.substring(i,j+1); //substring method,the end character is exclusive
                    }
                }
            }
        }
        return res;
    }

    /*
    Central diffusion method ? or Central expansion method? 中心扩散法
    中心扩散法，loop一遍str，每次把i当中心，向两边扩散，检查左边是不是等于右边，当不是的时候停止，然后检查当前的palindrome是不是
    比之前的 长， 如果是那么替换掉，这里要注意while loop停止时候的left， right值。
     */

    String r=new String();
    public String longestPlaindromicSubStringDiffusion(String s){
        if(s==null||s.length()==0)
            return r;
        for(int i=0; i<s.length(); i++){
            diffusion(s,i,i);   //odd length
            diffusion(s,i,i+1); //even length
        }
        return r;
    }

    private void diffusion(String s, int left, int right){

        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        /*
        why use substring from left+1 to right?
        babad => b => aba => babad stop
        For example: left=2,right=2 => left=1, right=3 =>left=0, right=4 stop
        when the while loop stop, left is 0 and right is 4, but the palindrome string is aba from left=1 to right=3
        hence, substring should be from left+1 to right.
         */
        String cur=s.substring(left+1, right);
        if(cur.length()>r.length()){
            r=cur;
        }
    }

}
