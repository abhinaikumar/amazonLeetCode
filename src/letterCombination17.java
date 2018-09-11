import java.util.LinkedList;
import java.util.List;

public class letterCombination17 {
    /*
    17. Letter Combinations of a Phone Number
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    private String[] numbers={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res=new LinkedList<>();
        if(digits==null || digits.length()==0)
            return res;
        combination(new String(), digits, 0, res);
        return res;
    }

    private void combination(String str, String digits, int offset, List<String> res){
        if(offset>=digits.length()){
            res.add(str);
            return;
        }
        String letters=numbers[digits.charAt(offset)-'0'];
        for(int i=0; i<=letters.length()-1; i++){
            combination(str+letters.charAt(i), digits, offset+1, res);
        }
    }

}
