public class Player {
    
    private String name;
    private char symbol;

    public Player(String name, char symbol)
    {
        // this.name=name;
        // this.symbol=symbol;
        setname(name);
        setsymbol(symbol);
    }

    public Player()
    {
        name=null;
        symbol='\0';
    }

    public void setname(String name)
    {
        this.name=name;
    }

    public String getname()
    {
        return this.name;
    }

    public void setsymbol(char symbol)
    {
        this.symbol=symbol;
    }

    public char getsymbol()
    {
        return this.symbol;
    }
}

