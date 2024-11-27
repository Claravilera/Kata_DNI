package dev.clara.DNIController;

import DNIModel.DNICalculator;
import DNIView.DNIView;

public final class DNIController {
    private DNICalculator calculator;
    private DNIView view;

    public DNIController(DNICalculator calculator, DNIView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void execute() {
        boolean validInput = false;
        int dniNumber = 0;

        while (!validInput) {
            try {
                String input = view.getInput();

                dniNumber = Integer.parseInt(input);

                if (dniNumber < 0 || dniNumber > 99999999) {
                    view.showMessage("El número debe estar entre 0 y 99999999. Inténtalo de nuevo.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                view.showMessage("El dato introducido es incorrecto. Inténtalo de nuevo.");
            }
        }

        // Calcular la letra del DNI
        char dniLetter = calculator.calculateLetter(dniNumber);

        // Mostrar el resultado
        view.showMessage("El DNI completo es: " + dniNumber + dniLetter);
    }
}
