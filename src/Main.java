public class Main {

    public static void arrayMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4");
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4х4");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] массива не число");
                }
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"five", "6", "7", "8"},
                {"9", "ten", "11", "12"},
                {"13", "14", "15", "sixteen"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8", "9"},
                {"10", "11", "12"},
                {"13", "14"}
        };

        try {
            arrayMethod(validArray);
            System.out.println("Массив обработан успешно.");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            arrayMethod(invalidSizeArray);
            System.out.println("Массив обработан успешно.");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            arrayMethod(invalidDataArray);
            System.out.println("Массив обработан успешно.");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}