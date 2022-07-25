public class Board {
    
    private char board[][];
    private final int size=3;
    private int count;
    private char p1symbol,p2symbol;
    public static final int player1win=1;
    public static final int player2win=2;
    public static final int draw=3;
    public static final int incomplete=4;
    public static final int invalid=5;

    public Board(char p1symbol, char p2symbol)
    {
        board= new char[size][size];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                board[i][j]=' ';
            }
        }

        this.p1symbol=p1symbol;
        this.p2symbol=p2symbol;

    }

    public int move(char psymbol, int x, int y)
    {
        if(x<0 || x>=size || y<0 || y>=size || board[x][y] !=' ')
        {
            return invalid;
        }
        board[x][y]=psymbol;   // Insert symbol in the board
        count++;

        if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
            return psymbol==p1symbol?player1win:player2win;

        if(board[0][y]==board[1][y] && board[0][y]==board[2][y])
            return psymbol==p2symbol?player2win:player1win;

        if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2])
            return psymbol==p1symbol?player1win:player2win;

        if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[0][2]==board[2][0])
            return psymbol==p1symbol?player1win:player2win;

        if(count==size*size)
            return draw;

        return incomplete;
    }

    public void print()
    {
        System.out.println("---------------");
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print("|" +board[i][j] + "|");
            }
            System.out.println();
        }

        System.out.println("---------------");
    }


}
