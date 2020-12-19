import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* Find the shortest path using Breadth first search algorithm */
public class BFS {
	
	 Node startNode;
	    Node goalNode;

	    public BFS(Node start, Node goalNode){
	        this.startNode = start;
	        this.goalNode = goalNode;
	        
	    }
	    
		/* Get the explored path */
	    public int path(Node current){
	    	int count = 0;
	    	Node currentNode = current;
	    	ArrayList<Node> pathExplored = new ArrayList<>();
	    	
	    	while(currentNode.parent != null){
	    		pathExplored.add(currentNode);
	    		currentNode = currentNode.parent;
	    	}
	    	count = pathExplored.size();
	    	return count;
	    }
	    
		/**
		 Get the Shortest path, if the goal node is present
		 */
	    public String pathString(Node current){
	    	String pathstring = "";
	    	Node currentNode = current;
	    	ArrayList<Node> pathExplored = new ArrayList<>();
	    	pathExplored.add(current);
	    	while(currentNode.parent != null){
	    		pathExplored.add(currentNode);
	    		currentNode = currentNode.parent;
	    	}
	    	//count = pathExplored.size();
	    	for (int i = pathExplored.size()-1; i >0 ; i--) {
	    		Node explorednode = pathExplored.get(i);
	    		pathstring = pathstring + explorednode.action;
	    	}
	    	return pathstring;
	    }
	    
	    public boolean inexplored(ArrayList<Node> explored, Node current){
	    	boolean found = false;
	    	Node currentNode = current;
	    	for (int i = 0; i < explored.size(); i++) {
	    		Node explorednode = explored.get(i);
	    		
	    		if(explorednode.Column == currentNode.Column && explorednode.Row == currentNode.Row)
	    			found = true;
        		
        	}
	    	
	    	return found;
	    }

		/** Compute the shortest distance from the start node to the specified goal node */
	    public boolean compute(){
	    	//int numMoves = 0;
	    	if(startNode.Row == goalNode.Row && startNode.Column
	    			== goalNode.Column ){
	            System.out.println("Goal Node Found!");
	            
	        }
	    	
	    	Queue<Node> queue = new LinkedList<>();
	        ArrayList<Node> explored = new ArrayList<>();
	        queue.add(this.startNode);
	         
	        
	        while(!queue.isEmpty()){
	            Node current = queue.remove();
	            
	            if(current.Row == goalNode.Row && current.Column
		    			== goalNode.Column ){
		            System.out.println("Goal Node Found!");
		            System.out.printf("Count %d", path(current));
		            System.out.println(pathString(current));
		            return true;
		            
		        }else{
	                if(current.getChildren().isEmpty())
	                    return false;
	                else{
	                	if(!inexplored(explored,current))
	                	
	                	queue.addAll(current.getChildren());
	                }
	                
	            }
	            explored.add(current);
	        }

	        return false;
	        }

}
