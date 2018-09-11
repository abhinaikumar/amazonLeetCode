import java.util.*;

public class wordLadder127 {
    /*
    127. Word Ladder
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5

    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: 0

    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

     */

    /*
    BFS

    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    submission TLE
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                String curWord=queue.remove();
                if(curWord.equals(endWord)) {
                    return level + 1;
                }
                for(int j=0; j<curWord.length(); j++){
                    char[] chars=curWord.toCharArray();
                    for(char ch='a'; ch<'z'; ch++){
                        chars[j]=ch;
                        String check=new String(chars);
                        if(!check.equals(curWord)&&wordList.contains(check)){
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;

    }


    /*
    second approach
     */
    public int ladderLengthII(String beginWord, String endWord, List<String> wordList) {

        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordList.add(endWord);
        int dis=1;

        while(!reached.contains(endWord)){
            Set<String> toAdd=new HashSet<>();
            for(String each:reached){
                for(int i=0; i<each.length(); i++){

                    char[] chars=each.toCharArray();
                    for(char ch='a'; ch<='z'; ch++){
                        chars[i]=ch;
                        String tmp = new String(chars);
                        if(wordList.contains(tmp)){
                            toAdd.add(tmp);
                            wordList.remove(tmp);
                        }
                    }
                }
            }
            dis++;
            if(toAdd.size()==0){
                return 0;
            }
            reached=toAdd;
        }
        return dis;
    }
}
























