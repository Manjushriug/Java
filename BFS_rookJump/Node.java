import java.util.ArrayList;

/** Custom class for specifying the Node */
public class Node {

	
	public int JumpNumber,Row,Column;
	public int rowMax = Driver.rowMax;
	public int colMax = Driver.colMax;
	public String action;
	public Node parent;
	private Driver driver1 = new Driver();
	
	
	//private int[][] board = new int[rowMax][colMax];
	public Node(int jumpnumber, int row, int column, Node parent,String action){
        this.JumpNumber = jumpnumber ;
        this.Row = row;
        this.Column= column;
        this.parent = parent;
        this.action = action;
        
    }
	
	/** Get the children of the node in the tree */
	public ArrayList<Node> getChildren(){
		ArrayList<Node> childNodes = new ArrayList<>();
		childNodes = computeChildren();
		return childNodes;
	}
	
	public void setMatrixSize(int maxRow, int maxCol){
		this.rowMax = maxRow;
		this.colMax = maxCol;
	}
	
	public ArrayList<Node> computeChildren(){
		ArrayList<Node> childNodes = new ArrayList<>();
		Node child;
		int row_changed,column_changed;
		
		
		int [][]board = Driver.maze;
		if((this.Row + this.JumpNumber)<=this.rowMax-1){
			row_changed = this.Row + this.JumpNumber;
			child = new Node(board[row_changed][Column],row_changed,Column,this,"D");
			
			childNodes.add(child);
		}
		
		if((this.Column + this.JumpNumber)<=this.colMax-1){
			column_changed = this.Column+ this.JumpNumber;
			child = new Node(board[this.Row][column_changed],this.Row,column_changed,this,"R");
			
			childNodes.add(child);
		}
		if((this.Row - this.JumpNumber)>=0){
			row_changed = this.Row - this.JumpNumber;
			child = new Node(board[row_changed][Column],row_changed,Column,this,"U");
			childNodes.add(child);
		}
		if((this.Column - this.JumpNumber)>=0){
			column_changed = this.Column- this.JumpNumber;
			child = new Node(board[this.Row][column_changed],this.Row,column_changed,this,"L");
			childNodes.add(child);
		}
		
		return childNodes;
	}

}
