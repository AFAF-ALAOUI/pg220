package game;

public class HumanPlayIntException extends RuntimeException {
    private int value;

    public int getInt(){
        return this.value;
    }

    public HumanPlayIntException(int value){
        super("Your input is out of range :"+ value +" is not allowed");
        this.value = value;
    }

    public String serialization(){
      return String.format("Colonne non valide %d",this.value);
    }

}
