package TicTacToe.Entity.Exception;

public class InvalidMoveException extends Exception{
    public InvalidMoveException(String errmessage ){
        super(errmessage);
    }
    public InvalidMoveException(String errmessage, Throwable cause ){
        super(errmessage,cause);
    }
}
