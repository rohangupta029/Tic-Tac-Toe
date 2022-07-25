import java.util.Scanner;

public class Tic_Tac_Toe {
    private Player p1,p2;
    private Board board;


     public static void main(String[] args) {
        Tic_Tac_Toe t = new Tic_Tac_Toe();
        t.startgame();
        
    }

    public void startgame()
    {
        Scanner s= new Scanner(System.in);
        // Player input

        p1=takeplayerinput(1);
        p2=takeplayerinput(2);

        while(p1.getsymbol()==p2.getsymbol())     // loop for checking same symbol or not
        {
            System.out.println("Symbol is already taken, please enter another symbol");
            char symbol=s.nextLine().charAt(0);
            p2.setsymbol(symbol);
        }

        // Create board
        board= new Board(p1.getsymbol(), p2.getsymbol());
        boolean p1chance=true;
        int status=Board.incomplete;
        board.print();

        while(status==Board.incomplete || status==Board.invalid)
        {
            if(p1chance)
            {
                System.out.println("Player 1-"+ p1.getname() +" 's turn ");
                System.out.println("Enter x");
                int x=s.nextInt();
                System.out.println("Enter y");
                int y=s.nextInt();
                status=board.move(p1.getsymbol(),x,y);
                if(status!=Board.invalid)
                {
                    p1chance=false;
                    board.print();
                }
                else
                {
                    System.out.println("Invalid Move! Please try again");
                    continue;
                }
            }
            else
            {
                System.out.println("Player 2-"+ p2.getname() +" 's turn ");
                System.out.println("Enter x");
                int x=s.nextInt();
                System.out.println("Enter y");
                int y=s.nextInt();
                status=board.move(p2.getsymbol(),x,y);
                if(status!=Board.invalid)
                {
                    p1chance=true;
                    board.print();
                }
                else
                {
                    System.out.println("Invalid Move! Please try again");
                    continue;
                }
            }

            if(status==Board.player1win)
            {
                System.out.println("Player 1-" + p1.getname()+" Wins!" );
            }
            else if(status==Board.player2win)
            {
                System.out.println("Player 2-" + p2.getname()+" Wins!" );
            }
            else if(status==Board.draw)
            {
                System.out.println(" Draw!!!!! Want to try again" );
            }
        }

    s.close();
    }


    public Player takeplayerinput(int num)
    {                                                           // Function to take the details of the players
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the name of Player" +num);
        String name=s.nextLine();
        System.out.println("Enter the symbol of Player" +num);
        char symbol=s.next().charAt(0);
        Player p = new Player(name,symbol);

        
        return p;
        

    }


}
