import java.util.Random;
import java.util.Scanner;

class TicTocToe
 {
	static char[][] board;
	 public TicTocToe()
	 {
		 board =new char[3][3];
		 initBoard();
	 }
	 void initBoard()
	 {
		 for(int i=0;i<board.length;i++)
		 {
			 for(int j=0;j<board[i].length;j++)
			 { 
				 board[i][j]=' ';
			 }
		 }
	 }

	static void dispBoard()
 {
		 System.out.println("-------------");
		 for(int i=0;i<board.length;i++)
		 {
			 System.out.print("| ");
			 for(int j=0;j<board[i].length;j++)
			 {
				 System.out.print(board[i][j]+" | "); 
			 }
			 System.out.println();
			 System.out.println("-------------");
		 }
}
 static void placeMark(int row,int col,char mark)
 {
	if(row>=0 && row<=2 && col>=0 && col<=2)
	{ 
		board[row][col]=mark;
	}
	else
	{
		System.out.println("invalid solution"); 
	}
 }
 static boolean checkColWin()
  {
	  for(int j=0;j<=2;j++)
	  {
		  if( board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
		  {
			  return true;
		  }
	  }
	  return false;
  }
  static boolean checkRowWin()
  {
	  for(int i=0;i<=2;i++)
	  {
		  if(board[i][0]!=' ' &&  board[i][0]==board[i][1] && board[i][1]==board[i][2])
		  {
			  return true;
		  }
	  }
	  return false;
  }
 static  boolean checkDiagWin()
  {
		  if(board[0][0]!=' ' &&  board[0][0]==board[1][1] && board[1][1]==board[2][2] ||board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
		  {
			  return true;
		  }
	  
	  return false;
  }      
 
static boolean chechDraw()
{
	for(int i=0;i<=2;i++)
	{
		for(int j=0;j<=2;j++)
		{
			if(board[i][j]==' ')
			{
				return false;
			}
		}
	}
	return true;
}
 }
abstract class Player
{
	String name;
	char mark;
	abstract void MakeMove();
	boolean isValidMove(int row,int col)
    {
   	 if(row>=0 && row<=2 && col>=0 && col<=2)
   	 {
   		 if(TicTocToe.board[row][col]== ' ')
   		 {
   			 return true;
   		 }
   	 }
   	 return false;
    }
	
}
 class HumanPlayer extends Player
 {
     public HumanPlayer(String name,char mark)
     {
    	 this.name=name;
    	 this.mark=mark;
     }
    void MakeMove()
     {
    	 Scanner sc=new Scanner(System.in);
    	 int row,col;
    	 do {
    		 System.out.println("Enter the row and coloumn");
        	  row=sc.nextInt();
        	  col=sc.nextInt();
    	  }while(!isValidMove(row,col));
    	 
    	 TicTocToe.placeMark(row,col,mark);
     }
    
 }
 class AiPlayer extends Player
 {
     public AiPlayer(String name,char mark)
     {
    	 this.name=name;
    	 this.mark=mark;
     }
    void MakeMove()
     {
    	 int row,col;
    	 do {
    		 Random r=new Random();
    		row= r.nextInt(3);
    		col=r.nextInt(3);
    	 }while(!isValidMove(row,col));
    	 
    	 TicTocToe.placeMark(row,col,mark);
     }
     
 }
public class Lanch_Game {

	public static void main(String[] args) {
		TicTocToe  t=new TicTocToe();
		HumanPlayer p1=new HumanPlayer("Archana",'x');
		AiPlayer p2=new AiPlayer("Sana ",'o');
		
		Player cp;
		cp=p1;
		while(true) {
		System.out.println(cp.name +" turn");
		cp.MakeMove();
		TicTocToe.dispBoard();
		if(TicTocToe.checkColWin() || TicTocToe.checkRowWin() || TicTocToe.checkDiagWin())
		{
			System.out.println(cp.name+ "Has won");
			break;
		}
		else if(TicTocToe.chechDraw())
		{
			System.out.println("game is draw");
			break;
		}
		else
		{
		if(cp==p1)
		{
			cp=p2;
		}
		else
		{
			cp=p1;
		}
		}
}	
		}

}

