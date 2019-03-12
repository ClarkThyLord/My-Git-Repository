import java.util.Scanner;

public class Main {
    static private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello World, long time no see!");

        back_again();
        ask_me();
    }

    private static void back_again(){
        System.out.println("BACK AT IT AGAIN!");
    }

    private static void ask_me(){
        System.out.print("What's your name? ");
        String name = input.nextLine();
        System.out.print(String.format("%s, how are you, on a scale from 1-10? ", name));
        int feeling = input.nextInt();
        if (feeling >= 1 && feeling <= 10) {
            switch (feeling) {
                case 1:
                    System.out.println(";///;that sucks :(");
                    break;
                case 5:
                    System.out.println("OWO, that's something!");
                    break;
                case 10:
                    System.out.println("UWU, THAT'S AMAZING!!!");
                    break;
                default:
                    System.out.println("Meh, duck you too!");
            }
        }
    }
}
