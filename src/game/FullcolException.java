package game;

public class FullcolException extends RuntimeException {
        private int value;

        public FullcolException(int value) {
            super("the colomn : "+value+". is full");
            this.value = value;
        }

}

