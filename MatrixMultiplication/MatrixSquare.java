
//Author : Rashid Riaz - FA19_BSE_081
import java.security.*;

public class MatrixSquare {

    private static SecureRandom randomNumber = new SecureRandom();

    public static void main(String[] args) {
        if (args.length < 1) {
            printHorizontalLineOfEquals();
            System.out.println("Command Line Arguments not found!!");
            printHorizontalLineOfEquals();
        } else {
            int rows = 0, columns = 0;
            boolean validCommandLineArgument = true;
            try {
                rows = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                printHorizontalLineOfEquals();
                System.out.println(e);
                printHorizontalLineOfEquals();
                validCommandLineArgument = false;
            }

            if (validCommandLineArgument) {
                columns = rows;
                int[][] matrix = new int[rows][columns];
                int[][] result = new int[rows][columns];
                getValues(matrix);
                result = squareMatrix(matrix);

                printStatement("Original Matrix");
                showResults(matrix);
                printStatement("Square Matrix");
                showResults(result);

            }
        }
    }

    private static void getValues(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (5 + randomNumber.nextInt(11));
            }
        }
    }

    private static int[][] squareMatrix(int[][] array) {
        int rows = array.length, columns = array[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                for (int k = 0; k < array[0].length; k++) {
                    result[i][j] += array[i][k] * array[k][j];
                }
            }
        }

        return result;
    }

    private static void showResults(int[][] array) {
        printHorizontalLineOfEquals();
        addTwoLineBreaks();
        for (int[] row : array) {

            if (array.length <= 7) {
                System.out.printf("%45s", "  ");
            }

            for (int element : row) {
                System.out.printf("%3d\t", element);
            }

            addTwoLineBreaks();
        }
        printHorizontalLineOfEquals();
    }

    private static void printStatement(String statement) {
        printHorizontalLineOfEquals();
        addTwoLineBreaks();
        System.out.printf("%65s", statement);
        printHorizontalLineOfEquals();
    }

    private static void printHorizontalLineOfEquals() {
        System.out.print(
                "\n\n====================================================================================================================\n");
    }

    private static void addTwoLineBreaks() {
        System.out.print("\n\n");
    }
}