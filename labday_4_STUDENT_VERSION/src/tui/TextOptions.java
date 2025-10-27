package tui;
import java.util.ArrayList;
public class TextOptions {
    private String title;
    private ArrayList<String> options;
    private TextInput textInput;
    public TextOptions(String title) {
        this.title = title;
        this.options = new ArrayList<>();
        this.textInput = new TextInput();
    }

    public void addOption(String option) {
        options.add(option);
    }

    public String display() {
        String res = null;
        while(res == null) {
            System.out.println(title);
            for(int i = 0; i < options.size(); i++) {
                System.out.println("  " + (i+1) + ": " + options.get(i));
            }
            int choice = textInput.inputInt("Select an option");
            if(choice > 0 && choice <= options.size()) {
                res = options.get(choice - 1);
            }
        }
        return res;
    }
}