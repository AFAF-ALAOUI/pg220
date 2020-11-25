public class Test {
    public static void main(String[] args)
    {

        int MAX=9;
        String number1;
        Human human = new Human();
        human.choose("joueur 1");
        human.choose("joueur 2");
        ArtificialIntel ai = new ArtificialIntel();
        while(true) {
            number1 = human.play_human();
            ArtificialIntel.play_ai(MAX);

            if(number1.equals("sortir")){
              break;}
            Integer.parseInt(number1);
            System.out.println(number1);

        }
    }
}

