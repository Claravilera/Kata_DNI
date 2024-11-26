package DNIView;

import java.util.Scanner;

public class DNIView {
    private Scanner scanner;

    public DNIView() {
        this.scanner = new Scanner(System.in);
    }
    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        System.out.print("Introduce el número del DNI (0 - 99999999): ");
        return scanner.nextLine();
    }
}