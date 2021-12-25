package binary.search;

import java.util.*;

public class BottomView {
	
	static Node root;
	
	static class Pair<K, V>{
	    Node node;
	    int index;
	    Pair(Node node, int index){
	        this.node = node;
	        this.index = index;
	    }
	    public Node getNode(){
	        return this.node;
	    }
	    public int getIndex(){
	        return this.index;
	    }
	}

	public static ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = verticleOrder(root);
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int size = entry.getValue().size();
            int val = entry.getValue().get(size - 1);
            result.add(val);
        }
        return result;
    }
    
    static Map<Integer, List<Integer>> verticleOrder(Node root){
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        Map<Integer, List<Integer>> distance = new TreeMap<>();
        
        while(!queue.isEmpty()){
            Map<Integer, List<Integer>> map = new HashMap<>();
            int size = queue.size();
            while(size-- > 0){
                Pair<Node, Integer> temp = queue.remove();
                int index = temp.getIndex();
                List<Integer> list = map.getOrDefault(map.get(index), 
                new ArrayList<>());
                list.add(temp.node.val);
                map.put(index, list);
                if(temp.node.left != null){
                    queue.add(new Pair<>(temp.node.left, index - 1));
                }
                if(temp.node.right != null){
                    queue.add(new Pair<>(temp.node.right, index + 1));
                }
            }
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                List<Integer> list = distance
                .getOrDefault(entry.getKey(), new ArrayList<>());
                list.addAll(entry.getValue());
                distance.put(entry.getKey(), list);
            }
        }
        return distance;
    }
    
	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(0);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		System.out.println(bottomView(root));
	}
}

