package game;

public class HumanPlayIntException extends RuntimeException {
    private int value;

    public int getInt(){
        return this.value;
    }

    public HumanPlayIntException(int value){
        super("Your input is out of range :"+ value +"It's not allowed");
        this.value = value;
    }
}
