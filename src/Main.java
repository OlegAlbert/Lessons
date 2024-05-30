import java.util.Arrays;

public class Main {

    //1
    static void  printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //2
    static void checkSumSign() {
        int a = 3;
        int b = 2;
        System.out.println((a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    //3
    static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4
    static void compareNumbers() {
        int a = 4;
        int b = 4;
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    //5
    static boolean isSumInRange(int firstNumber, int secondNumber) {
        return ((firstNumber + secondNumber >= 10) && (firstNumber + secondNumber <= 20));
    }

    //6
    static void printNumberSign(int number) {
        System.out.println((number < 0) ? "Число отрицательное" : "Число положительное");
    }

    //7
    static boolean isNumberPositive(int number) {
        return number < 0;
    }


    //8
    static void printStringNTimes(String message, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(message);
        }
    }


    //9
    static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }


    //14
    static int[] returnArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
    public static void main(String[] args) {
        //1
        printThreeWords();

        //2
        checkSumSign();

        //3
        printColor();

        //4
        compareNumbers();

        //5
        System.out.println(isSumInRange(1, 8));

        //6
        printNumberSign(-5);

        //7
        System.out.println(isNumberPositive(0));

        //8
        printStringNTimes("Hello", 1);

        //9
        System.out.println(isLeapYear(1999));

        //10
        int[] firstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = (firstArray[i] == 0 ? 1 : 0);
            //System.out.print(firstArray[i] + " ");
        }

        //11
        int[] secondArray = new int[100];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = i + 1;
            //System.out.print(secondArray[i] + " ");
        }

        //12
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < thirdArray.length; i++) {
            thirdArray[i] = (thirdArray[i] < 6) ? thirdArray[i] * 2 : thirdArray[i];
            //System.out.print(thirdArray[i] + " ");
        }

        //13
        int[][] fourthArray = new int[9][9];
        /*for (int i = 0; i < fourthArray.length; i++) {
            for (int j = 0; j < fourthArray[0].length; j++) {
                if ((i == j) || (i + j == fourthArray.length - 1)) {
                    fourthArray[i][j] = 1;
                }
                else {
                    fourthArray[i][j] = 0;
                }
            }
        }*/

        for (int i = 0; i <fourthArray.length; i++) {
            fourthArray[i][i] = 1;
            fourthArray[i][fourthArray.length - 1 - i] = 1;
        }

        /*for (int i = 0; i < fourthArray.length; i++) {
            for (int j = 0; j < fourthArray[0].length; j++) {
                System.out.print(fourthArray[i][j]);
                if (j == fourthArray.length - 1) {
                    System.out.println();
                }
            }
        }*/

        //14
        int len = 5;
        int initialValue = 6;
        int[] fifthArray = new int[len];
        fifthArray = returnArray(len, initialValue);
        /*for (int i = 0; i < fifthArray.length; i++) {
            System.out.print(fifthArray[i] + " ");
        }*/
    }
}