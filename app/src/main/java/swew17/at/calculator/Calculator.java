package swew17.at.calculator;

public final class Calculator {

    private Calculator() {}

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) throws ArithmeticException {

        if (b == 0) {
            throw new ArithmeticException();
        }

        return a / b;
    }

}
