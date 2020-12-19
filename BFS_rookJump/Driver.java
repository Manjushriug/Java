import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Driver {
	static int startrow,startcol;
	static int goalrow,goalcol;
	static int rowMax;
	static int 	colMax;
	static int[][] maze;
	
	public int[][] getnumberArray(){
		int maze[][] = {{3,4,1,3,1},{3,3,3,0,2},{3,1,2,2,3},{4,2,3,3,3},{4,1,4,3,2}};
		return maze;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String FILE_NAME = "C:\\Users\\manju\\java\\AI\\Hello\\file.txt.txt";
		String line = "";
		
		Driver driver1 = new Driver();
		try {

            FileInputStream fin = new FileInputStream(FILE_NAME);
            InputStreamReader in = new InputStreamReader(fin);
            BufferedReader br1 = new BufferedReader(in);
            Scanner scn = new Scanner(br1);
            line = scn.nextLine();
            
            while(!line.equals("0")){
            	
            String[] matrix_spec = line.split(" ");
            rowMax = Integer.valueOf(matrix_spec[0]);
            
            colMax = Integer.valueOf(matrix_spec[1]);
            startrow = Integer.valueOf(matrix_spec[2]);
            startcol = Integer.valueOf(matrix_spec[3]);
            goalrow = Integer.valueOf(matrix_spec[4]);
            goalcol = Integer.valueOf(matrix_spec[5]);
            maze = new int[rowMax][colMax];
            for (int i = 0; i < rowMax; i++) {
                line = scn.nextLine();
                String[] numbers = line.split(" ");
                for (int j = 0; j < colMax; j++) {
                    int value = Integer.valueOf(numbers[j]);
                    maze[i][j] = value;
                }
            }
            
            Node startnode = new Node(maze[startrow][startcol], startrow,startcol,null,"");
    		Node goalnode = new Node(maze[goalrow][goalcol], goalrow,goalcol,null,"");
    		
    		BFS bfs = new BFS(startnode, goalnode);
    		
    		if(bfs.compute()){
                System.out.println("Path Found!");
    		}else{
    			System.out.println("Path not Found!");	
    		}
    		line = scn.nextLine();
            }
            fin.close();
            
        }catch (Exception e) {

			e.printStackTrace();

		}
		
	}
		
	}


