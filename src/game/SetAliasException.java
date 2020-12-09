package game;

public class SetAliasException extends RuntimeException{
    private String str;

    public String getString(){
        return this.str;
    }

    public SetAliasException(String str) {
        super("Alias : "+ str +" is invalid");
        this.str = str;
    }
}
