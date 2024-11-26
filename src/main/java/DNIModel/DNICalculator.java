package DNIModel;

public class DNICalculator {

    private static final char[] DNI_LETTERS = 
    
    {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
    'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    public char calculateLetter(int dniNumber) {
        if (dniNumber < 0 || dniNumber > 99999999) {
            throw new IllegalArgumentException("El número debe estar entre 0 y 99999999.");
        }
        return DNI_LETTERS[dniNumber % 23];
                                            
    }
}