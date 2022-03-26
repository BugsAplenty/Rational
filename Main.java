import java.util.Scanner;

public class Main {
    private static final Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.println("Please input 1st rational: ");
            Rational rational1 = inputRational();
            System.out.println("Please input 2nd rational: ");
            Rational rational2 = inputRational();
            System.out.println("Rationals selected. Here are the results: ");
            calculate(rational1, rational2);
        }
    }

    private static void calculate(Rational rational1, Rational rational2) {
        Rational sum = rational1.plus(rational2);
        Rational difference = rational1.minus(rational2);
        Rational product = rational1.multiply(rational2);
        Rational quotient = rational1.divide(rational2);
        boolean isEqual = rational1.equals(rational2);
        boolean isGreaterThan = rational1.greaterThan(rational2);
        Rational productReduced = product.reduce();
        printResults(rational1, rational2, sum, difference, product, quotient, isEqual, isGreaterThan, productReduced);
    }

    private static void printResults(
            Rational rational1,
            Rational rational2,
            Rational sum,
            Rational difference,
            Rational product,
            Rational quotient,
            boolean isEqual,
            boolean isGreaterThan,
            Rational productReduced
    ) {
        System.out.println(
                String.join(
                        "\n",
                        "1st rational - " + rational1.toString(),
                        "2nd rational - " + rational2.toString(),
                        "Sum - " + sum,
                        "Difference - " + difference,
                        "Product - " + product,
                        "Quotient - " + quotient,
                        "Are the rationals equal? - " + isEqual,
                        "Is the first rational greater than the second? - " + isGreaterThan,
                        "The reduction of the product - " + productReduced,
                        "-----"
                )
        );
    }

    static Rational inputRational() {
        int numerator = inputNumerator();
        int denominator = inputDenominator();
        return new Rational(numerator, denominator);
    }
    static int inputNumerator() {
        System.out.println("Please input numerator: ");
        int numerator;
        while (true) {
            try {
                numerator = Integer.parseInt(userInput.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Numerator must be an integer. Choose a different numerator: ");
            }
        }
        return numerator;
    }
    static int inputDenominator() {
        System.out.println("Please input denominator: ");
        int denominator;
            while(true) {
                try {
                    denominator = Integer.parseInt(userInput.nextLine());
                    if (denominator == 0) {
                        System.out.println("Cannot divide by zero. Choose a different denominator: ");
                    } else if (denominator < 0) {
                        System.out.println("Denominator must be positive.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Denominator must be an integer. Choose a different denominator: ");
            }
        }
            return denominator;
    }
}
