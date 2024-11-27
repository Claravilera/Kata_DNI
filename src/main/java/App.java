import DNIModel.DNICalculator;
import DNIView.DNIView;
import dev.clara.DNIController.DNIController;

public class App {
 public static void main(String[] args) {
        DNICalculator calculator = new DNICalculator();
        DNIView view = new DNIView();
        DNIController controller = new DNIController(calculator, view);

        controller.execute();
    }

}
