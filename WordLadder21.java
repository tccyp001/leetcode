import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		
		int ret = ladderLength("hot","dog", dict);
		System.out.println(ret);

	}
	public static int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> que = new LinkedList<String>();
        
        que.offer(start);
        int step = 0;
        StringBuilder sb = new StringBuilder();
        HashSet<String> visited = new HashSet<String>();
        while(!que.isEmpty())
        {
            String cur = que.remove();
            visited.add(cur);
            step++;
 
            for(int i = 0;i<cur.length();i++)
            {
                sb.setLength(0);
                sb.append(cur);
                for(int j = 0;j<26;j++)
                {
                    sb.setCharAt(i,(char) (j + 'a'));
                    String tmp = sb.toString();
                    if(visited.contains(tmp))continue;
                    if(tmp.equals(end))return step;
                    if(dict.contains(tmp))
                       que.offer(tmp);
                }
            }
            
        }
        return -1;
    }
}
