package game;

public class HumanPlayStrException extends RuntimeException{

    private String str;
    private boolean value;

    public String getString(){
        return this.str;
    }

    public boolean getValue(){
      return this.value;
    }




    public HumanPlayStrException(String str){
        super("Your input is not an integer :"+ str + " is not allowed");
        this.str = str;
    }
    public String serialization(){
      return String.format("Erreur saisie colonne %s", this.str);
    }

}
