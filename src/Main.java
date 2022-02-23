import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println(twoPowN(5));

        printTime(150);

        System.out.println(isPrime(17));

        printPalindromeNums(1600, 2100);

        printLikePascalCase("cAT");

        printCheckerBoard(5);

        printElementInSequence(3.2, 1.5, 5);

        expendIntoPrimeFactors(4578652);

        printMultipleTable(5, 6);

        printMatrixWithDiagonalSequence(5, 10);

        printMatrixLikeSnake(5, 10);

        printRotateMatrix(5, 5);
    }


    /**
     * task3
     * returning power of 2
     *
     * @param pow = power
     * @return
     */
    private static int twoPowN(int pow) {
        if (pow < 1 || pow > 15) {
            System.out.println("Number out of range");
            return -1;
        }
        int result = 1;
        for (int i = 0; i <= pow; i++) {
            result *= 2;
        }
        return result;
    }

    /**
     * task4
     * printing time in digital clock
     *
     * @param minutes = input minutes
     */
    private static void printTime(int minutes) {
        if (minutes < 0) {
            System.out.println("Invalid number of minutes");
            return;
        }
        if (minutes >= 1440) System.out.println(minutes / 1440 + " day");
        else {
            System.out.println(minutes / 60 + " : " + (minutes % 60));
        }
    }


/*    5.How many times will the body of the loop be executed?
 -         for (int i = 2; i <= 15; i ++)
    {...}
    answer - 14
-	         for (int i = 10; i <= 100; i = i+7)
    {...}
    answer - 13
-	        for (float i = 1.5; i <= 10.3; i = i+0.4)
    {...}
    answer - 24
*/

    /**
     * task 5
     * checking is given number prime
     *
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * task6
     * printing all palindrome numbers between given two four-digit numbers
     *
     * @param A
     * @param B
     */
    private static void printPalindromeNums(int A, int B) {
        for (int i = A; i <= B; i++) {
            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * task7
     * printing given word, where the first letter is capitalized, the rest are small.
     *
     * @param str
     */
    private static void printLikePascalCase(String str) {
        System.out.println(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
    }

    /**
     * task8
     * printing checkerboard with given size
     *
     * @param size
     */
    private static void printCheckerBoard(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size + i; j++) {
                if (isEven(j)) {
                    System.out.print("X");
                } else System.out.print("O");
            }
            System.out.println();
        }
    }

    /**
     * task9
     * The first term and the denominator of the geometric progression are given (real numbers b1 and q, q! = 0).
     * An integer n is also given. Print the n-th term of a geometric progression.
     * 't use the pow function, use a for loop.
     * Printing the answer with precision exactly two characters after the period.
     *
     * @param b1
     * @param q
     * @param index
     */
    private static void printElementInSequence(double b1, double q, int index) {
        for (int i = 1; i < index; i++) {
            b1 *= q;
        }
        System.out.printf("%.2f", b1);
    }


    /**
     * task10
     * expanding given number into Prime numbers
     *
     * @param num
     */
    private static void expendIntoPrimeFactors(int num) {
        if (isPrime(num)) {
            System.out.println("Your number is prime");
            return;
        }
        for (int i = 2; i <= num; i++) {
            if (num == i) {
                System.out.print(i);
                return;
            }
            if (isPrime(i) && num % i == 0) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
            }
        }
    }

    /**
     * task11
     * creating matrix with given sizes and fill it with the multiplication table A [i] [j] = i * j
     * printing matrix
     *
     * @param row
     * @param colum
     */
    private static void printMultipleTable(int row, int colum) {
        int[][] matrix = new int[row][colum];
        for (int i = 0, num1 = 0, num2 = 0; i < row * colum; i++) {
            if (num2 == colum) {
                num1++;
                num2 = 0;
            }
            matrix[num1][num2] = num1 * num2;
            num2++;

        }
        printMatrix(matrix);
    }

    /**
     * task12
     * Creating an array A [n] [m] and filling it as shown in the example.
     * 0  1  3  6 10 14 18 22 26 30
     * 2  4  7 11 15 19 23 27 31 34
     * 5  8 12 16 20 24 28 32 35 37
     * 9 13 17 21 25 29 33 36 38 39
     * printing array
     *
     * @param rowSize
     * @param columSize
     */
    private static void printMatrixWithDiagonalSequence(int rowSize, int columSize) {
        int[][] matrix = new int[rowSize][columSize];
        int num = 1;
        int countColum = 0;
        int countRow = 1;
        int row, colum;

        while (num < rowSize * columSize) {
            if (countColum < columSize - 1) {
                countColum++;
                row = 0;
            } else {
                row = countRow;
                countRow++;
            }

            for (colum = countColum; colum >= 0 && row < rowSize; colum--, row++) {
                matrix[row][colum] = num;
                num++;
            }
        }
        printMatrix(matrix);
    }

    /**
     * task13
     * Creating an array A [n] [m] and filling it as snake.
     * 0  1  2  3  4  5  6  7  8  9
     * 19 18 17 16 15 14 13 12 11 10
     * 20 21 22 23 24 25 26 27 28 29
     * 39 38 37 36 35 34 33 32 31 30
     * printing matrix
     *
     * @param rowSize
     * @param columSize
     */
    private static void printMatrixLikeSnake(int rowSize, int columSize) {
        int[][] matrix = new int[rowSize][columSize];
        int num = 0;

        for (int i = 0; i < rowSize; i++) {
            if (isEven(i)) {
                for (int j = 0; j < columSize; j++) {
                    matrix[i][j] = num;
                    num++;
                }
            } else {
                for (int j = columSize - 1; j >= 0; j--) {
                    matrix[i][j] = num;
                    num++;
                }
            }
        }
        printMatrix(matrix);
    }

    /**
     * task14
     * rotating matrix 90 or 180 degrees and printing matrix
     *
     * @param row
     * @param colum
     */
    private static void printRotateMatrix(int row, int colum) {
        int num = 1;
        int count1 = row - 1;
        int matrix[][] = new int[row][colum];

        //filling original matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        System.out.println("Original matrix \n");
        printMatrix(matrix);
        System.out.println();

        System.out.println("Enter number 1 to rotate matrix 90 degrees" +
                "and 2 to rotate 180 degrees");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1": {
                int matrix90[][] = new int[row][colum];

                for (int i = 0; i < row; i++, count1--) {
                    for (int j = 0; j < colum; j++) {
                        matrix90[j][count1] = matrix[i][j];
                    }
                }
                System.out.println("90 degrees rotated matrix \n");
                printMatrix(matrix90);
            }
            break;

            case "2": {
                int temp;
                for (int i = 0; i < row / 2; i++, count1--) {
                    for (int j = 0; j < colum; j++) {
                        temp = matrix[i][j];
                        matrix[i][j] = matrix[count1][row - 1 - j];
                        matrix[count1][row - 1 - j] = temp;
                    }
                }
                if (!isEven(row)) {
                    for (int i = 0; i < colum / 2; i++) {
                        temp = matrix[row / 2][i];
                        matrix[row / 2][i] = matrix[row / 2][row - 1 - i];
                        matrix[row / 2][row - 1 - i] = temp;
                    }
                }
                System.out.println("180 degrees rotated matrix \n");
                printMatrix(matrix);
                break;
            }
            default: {
                System.out.println("Illegal choice");
                break;
            }
        }
    }

    //Helper methods

    /**
     * checking is given number is even
     *
     * @param num
     * @return
     */
    private static boolean isEven(int num) {
        return ((num & 1) == 0);
    }

    /**
     * checking is given number prime
     *
     * @param i
     * @return
     */
    private static boolean isPalindrome(int i) {
        return (i % 10 == i / 1000 && (i / 10 % 10 == i / 100 % 10));
    }

    /**
     * printing matrix
     *
     * @param matrix
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int value : array) {
                System.out.print(value + " \t");
            }
            System.out.println();
        }
    }
}
