package TestView;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DNIView.DNIView;

public class DNIViewTest {

    private ByteArrayOutputStream outputStream; 
    private PrintStream originalOut;           
    private ByteArrayInputStream inputStream; 
    private final PrintStream originalIn = System.out; 

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream)); 
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut); 
        System.setErr(originalIn);   
    }

    @Test
    public void testShowMessage() {
        DNIView view = new DNIView();
        String message = "this is a test.";
        view.showMessage(message);

        assertEquals(message + System.lineSeparator(), outputStream.toString());
    }

    @Test
    public void testGetInput() {
        String simulatedInput = "12345678";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        DNIView view = new DNIView();
        String input = view.getInput();

        assertEquals(simulatedInput, input);
    }
}
