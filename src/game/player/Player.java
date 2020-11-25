import java.util.Scanner;
package game.player;

public class Player {

    public String choose(String str) {
        System.out.println(str);
        String name1, name2;
        Scanner reader = new Scanner(System.in);
        name1 = reader.nextLine();
        name2 = reader.nextLine();
        System.out.println(str + name1 + name2);

        return name2;
    }


}
