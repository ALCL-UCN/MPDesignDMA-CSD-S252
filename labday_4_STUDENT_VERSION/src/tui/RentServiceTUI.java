package tui;
import controller.*;
import model.*;
import java.util.*;

public class RentServiceTUI {
    private TextInput textInput;
    private RentServiceController rentServiceController;
    
    public static void start() {
        new RentServiceTUI().go();
    }

    public RentServiceTUI() {
        textInput = new TextInput();
        rentServiceController = new RentServiceController();
    }

    public void go() {
        greetings();
        boolean goon = true;
        TextOptions options = new TextOptions("Pick an option");
        options.addOption("Find by name...");
        options.addOption("Find by number...");
        options.addOption("Show all");
        options.addOption("Create new...");
        options.addOption("Update by number...");
        options.addOption("Delete by number...");
        options.addOption("Exit");

        while(goon) {
            String choice = options.display();
            switch(choice) {
                case "Find by name...":
                    findByName();
                    break;
                case "Find by number...":
                    findByNumber();
                    break;
                case "Show all":
                    showAll();
                    break;
                case "Create new...":
                    createNew();
                    break;
                case "Update by number...":
                    update();
                    break;
                case "Delete by number...":
                    deleteByNumber();
                    break;
                case "Exit":
                    goon = false;
            }
        }
        solong();
    }
    
    private void update() {
        // Hey student, delete the below lines and start coding
        System.out.println("Implment me!");
        new Scanner(System.in).nextLine();
        System.out.println("Please please please!");
        new Scanner(System.in).nextLine();
    }
    
    private void findByName() {
        System.out.println("Search for Rent Service by name");
        String name = textInput.inputString("Specify the Rent Service name to look for (exact match)");
        RentService res = rentServiceController.findByName(name);
        display("Your search for \"" + name + "\" gave this result:", res);
    }
    
    private void findByNumber() {
        System.out.println("Search for Rent Service by number");
        int no = textInput.inputInt("Specify the Rent Service number to look for");
        RentService res = rentServiceController.findByNo(no);
        display("Your search for " + no + " gave this result:", res);
    }
    
    private void showAll() {
        System.out.println("Displaying all Rent Services");
        ArrayList<RentService> res = rentServiceController.getAll();
        for(RentService rs : res) {
            display(null, rs);
        }
    }
    
    private void createNew() {
        System.out.println("Creating new Rent Service");
        String name = textInput.inputString("name");
        double price = textInput.inputDouble("price");
        RentService res = rentServiceController.create(name, price);
        display("You have created", res);//TODO more intelligent info about unsuccessful creation
    }

    private void deleteByNumber() {
        System.out.println("Deleting by number");
        int no = textInput.inputInt("Specify Rent Service number");
        RentService res = rentServiceController.delete(no);
        display("You have deleted", res);
    }

    private void display(String title, RentService rs) {
        if(title != null) {
            System.out.println(title);
        }
        if(rs != null) {
            System.out.println("Rent Service");
            System.out.println("  number: " + rs.getNo());
            System.out.println("  name: " + rs.getName());
            System.out.println("  price: " + rs.getPrice());
            System.out.println("  this service is " + (rs.isAvailable() ? "" : "not ") + "available\n");
        } else {
            System.out.println("No Rent Service to display\n");
        }
    }

    private void greetings() {
        System.out.println("Welcome to the Rent Service Registering system.");
    }

    private void solong() {
        System.out.println("That was all then. 'Till the next time we meet.");
    }
}