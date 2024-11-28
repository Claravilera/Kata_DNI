package TestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import DNIModel.DNICalculator;
import DNIView.DNIView;
import dev.clara.DNIController.DNIController;

class DNIViewStub extends DNIView {
    private List<String> inputs; 
    private List<String> messages; 

    public DNIViewStub(List<String> inputs) {
        this.inputs = inputs;
        this.messages = new ArrayList<>();
    }

    @Override
    public String getInput() {
         return inputs.remove(0);
    }

    @Override
    public void showMessage(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}

class DNICalculatorStub extends DNICalculator {
    @Override
    public char calculateLetter(int dniNumber) {
        return 'X';
    }
}

public class DNIControllerTest {

    @Test
    public void testExecuteWithValidInput() {
        List<String> inputs = new ArrayList<>();
        inputs.add("12345678"); // Entrada válida

        DNIViewStub viewStub = new DNIViewStub(inputs);
        DNICalculatorStub calculatorStub = new DNICalculatorStub();
        DNIController controller = new DNIController(calculatorStub, viewStub);

        controller.execute();

        List<String> messages = viewStub.getMessages();
        assertEquals(1, messages.size()); 
        assertEquals("The complete DNI is: 12345678X", messages.get(0));
    }

    @Test
    public void testExecuteWithInvalidInput() {
        List<String> inputs = new ArrayList<>();
        inputs.add("abc");
        inputs.add("100000000"); 
        inputs.add("12345678"); 

        DNIViewStub viewStub = new DNIViewStub(inputs);
        DNICalculatorStub calculatorStub = new DNICalculatorStub();
        DNIController controller = new DNIController(calculatorStub, viewStub);

        controller.execute();

        List<String> messages = viewStub.getMessages();
        assertEquals(3, messages.size());
        assertEquals("The information entered is incorrect. Try again.", messages.get(0)); 
        assertEquals("The number must be between 0 and 99999999. Try again.", messages.get(1)); 
        assertEquals("The complete DNI is: 12345678X", messages.get(2)); 
    }
}