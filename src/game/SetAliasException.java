package game;

public class SetAliasException extends Exception{
    private String str;

    public String getString(){
        return this.str;
    }

    public SetAliasException(String str) {
        super("Alias : "+ str +" is invalid");
        this.str = str;
    }

    public String serialization(int i){
      return String.format("Erreur saisie joueur %d %s",i, this.str);
    }
}
