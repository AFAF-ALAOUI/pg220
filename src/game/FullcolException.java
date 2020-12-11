package game;

public class FullcolException extends RuntimeException {
        private int value;

        public FullcolException(int value) {
            super("the column "+value+"  is full");
            this.value = value;
        }

        public String serialization(){
          return String.format("Erreur colonne pleine %d",this.value);
        }

}
