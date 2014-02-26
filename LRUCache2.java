import java.util.HashMap;
import java.util.LinkedList;


public class LRUCache2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    private int size = 0;
    public LinkedList<Node> list = new LinkedList<Node>();
    public HashMap<Integer, Node> map= new HashMap<Integer, Node>();
    public LRUCache2(int capacity) {
        size = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        
        Node n1 = map.get(key);
        list.remove(n1);
        list.add(n1);
        return n1.value;
    }
    
    public void set(int key, int value) {
        Node n1;
        if(map.containsKey(key))
        {
        	n1 = map.get(key);
            list.remove(n1);
        }
        else
        {
            n1 = new Node(key,value);
            
        }
        list.add(n1);
        map.put(key,n1);
        
        while(list.size()>size)
        {
            n1 = list.remove(0);
            map.remove(n1.key);
        }
    }
   private class Node {
		public int key;
		public int value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
