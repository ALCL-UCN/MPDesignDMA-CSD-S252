package tui;
import java.util.Scanner;
public class TextInput {
    private Scanner scanner;
    
    public TextInput() {
        scanner = new Scanner(System.in);
    }
    
    public String inputString(String prompt) {
        System.out.print(prompt + ": ");
        String res = scanner.nextLine();
        return res;
    }
    
    public int inputInt(String prompt) {
        System.out.println(prompt + ": ");
        int res = scanner.nextInt();
        scanner.nextLine();
        return res;
    }
    
    public double inputDouble(String prompt) {
        System.out.print(prompt + ": ");
        double res = scanner.nextDouble();
        scanner.nextLine();
        return res;
    }
}
