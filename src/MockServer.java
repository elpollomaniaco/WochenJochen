import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import calendar.*;

public class MockServer {
    private Controller controller;

    public MockServer(Controller c){
        System.out.println("MockServer started");
        controller = c;

        try {
            inputLoop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Input loop - Waiting for input and firing ADD/SHOW

    private void inputLoop () throws IOException{
        System.out.println("MockServer is listening to Input");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("a")){
                addEvent();
            }
            if (input.equals("s")){
                showWeek();
            }
        }
    }
    //ADD - Adds random Event to the Week
    private void addEvent() {
        System.out.println("Adding a random Event to the Week...");

    }
    //SHOW - Gets the Week from the controller and starts a print
    private void showWeek() {
        System.out.println("Showing the Week in the Console...");
        Week week = controller.getWeek();
        week.printWeek();
    }

}
