import java.util.*;

public class wordLadderII126 {

    /*

    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output:
    [
      ["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]
    ]

    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: []
     */
    /*
    bfs+dfs
    The basic idea is:

1). Use BFS to find the shortest distance between start and end, tracing the distance of crossing
nodes from start node to end node, and store node's next level neighbors to HashMap;

2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap:
compare if the distance of the next level node equals the distance of the current node + 1.
     */

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new LinkedList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        HashSet<String> dict = new HashSet<>(wordList);
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }


    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, HashSet<String> dict,
                     HashMap<String, ArrayList<String>> nodeNeightbors, HashMap<String, Integer> distance)
    {

        for(String str:dict){
            nodeNeightbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        distance.put(start, 0);

        while(!queue.isEmpty()){
            int size=queue.size();
            boolean foundEnd=false;
            for(int i=0; i<size; i++){
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors=getNeighbors(cur, dict);
                for(String neighbor: neighbors){
                    nodeNeightbors.get(cur).add(neighbor);
                    if(!distance.containsKey(neighbor)){
                        distance.put(neighbor, curDistance+1);
                        if(neighbor.equals(end)){
                            foundEnd=true;
                        }else{
                            queue.offer(neighbor);
                        }
                    }
                }
                if(foundEnd==true)
                    break;
            }
        }
    }


    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String cur, HashSet<String> dict){
        ArrayList<String> res=new ArrayList<>();
        char[] chars=cur.toCharArray();
        for(char ch='a'; ch<='z'; ch++){
            for(int i=0; i<chars.length; i++){
                if(chars[i]==ch)
                    continue;
                char old_char = chars[i];
                chars[i]=ch;
                String tmp=new String(chars);
                if(dict.contains(tmp)){
                    res.add(tmp);
                }
                chars[i]=old_char;
            }
        }
        return res;
    }


    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, HashSet<String> dict,
                     HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance,
                     ArrayList<String> solution, List<List<String>> res){
        solution.add(cur);
        if(end.equals(cur)){
            res.add(new ArrayList<>(solution));
        }
        else{
            for(String next : nodeNeighbors.get(cur)){
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }


}
