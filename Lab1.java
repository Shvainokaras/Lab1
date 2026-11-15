import java.util.Arrays;
import java.util.Scanner;

public class Lab1 {

    private Scanner scanner = new Scanner(System.in);

    // Проверка ввода целого числа
    private int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    // Проверка ввода числа типа long
    private long readLong(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    // Проверка ввода вещественного числа
    private double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(
                    scanner.nextLine().trim().replace(',', '.')
                );

                if (Double.isFinite(value)) {
                    return value;
                }
                System.out.println("Введите конечное число.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите вещественное число.");
            }
        }
    }

    // Проверка ввода символа-цифры
    private char readDigit(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            if (input.length() == 1 &&
                input.charAt(0) >= '0' &&
                input.charAt(0) <= '9') {
                return input.charAt(0);
            }

            System.out.println("Ошибка! Введите одну цифру от 0 до 9.");
        }
    }

    // Ввод массива
    private int[] readArray(String message) {
        int length;

        do {
            length = readInt("Введите количество элементов массива " + message + ": ");
            if (length <= 0) {
                System.out.println("Размер массива должен быть положительным.");
            }
        } while (length <= 0);

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = readInt("Введите элемент [" + i + "]: ");
        }

        return arr;
    }

    // ЗАДАНИЕ 1. МЕТОДЫ

    // 1. Дробная часть
    public double fraction(double x) {
        return x - (int) x;
    }

    // 3. Букву в число
    public int charToNum(char x) {
        return x - '0';
    }

    // 5. Двузначное
    public boolean is2Digits(int x) {
        return x >= 10 && x <= 99 || x <= -10 && x >= -99;
    }

    // 7. Диапазон
    public boolean isInRange(int a, int b, int num) {
        return num >= Math.min(a, b) && num <= Math.max(a, b);
    }

    // 9. Равенство
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // ЗАДАНИЕ 2. УСЛОВИЯ

    // 1. Модуль числа
    public int abs(int x) {
        return Math.abs(x);
    }

    // 3. Тридцать пять
    public boolean is35(int x) {
        return (x % 3 == 0) != (x % 5 == 0);
    }

    // 5. Тройной максимум
    public int max3(int x, int y, int z) {
        int max = x;

        if (y > max) {
            max = y;
        }

        if (z > max) {
            max = z;
        }

        return max;
    }

    // 7. Двойная сумма
    public int sum2(int x, int y) {
        int sum = x + y;

        if (sum >= 10 && sum <= 19) {
            return 20;
        }

        return sum;
    }

    // 9. День недели
    public String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    // ЗАДАНИЕ 3. ЦИКЛЫ 

    // 1. Числа подряд
    public String listNums(int x) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= x; i++) {
            result.append(i).append(" ");
        }

        return result.toString().trim();
    }

    // 3. Четные числа
    public String chet(int x) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= x; i += 2) {
            result.append(i).append(" ");
        }

        return result.toString().trim();
    }

    // 5. Длина числа
    public int numLen(long x) {
        int length = 0;

        do {
            length++;
            x /= 10;
        } while (x != 0);

        return length;
    }

    // 7. Квадрат
    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 9. Правый треугольник
    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // ЗАДАНИЕ 4. МАССИВЫ 

    // 1. Поиск первого значения
    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }

        return -1;
    }

    // 3. Поиск максимального по модулю
    public int maxAbs(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (Math.abs((long) arr[i]) > Math.abs((long) max)) {
                max = arr[i];
            }
        }

        return max;
    }

    // 5. Добавление массива в массив
    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }

        return result;
    }

    // 7. Возвратный реверс
    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }

    // 9. Все вхождения
    public int[] findAll(int[] arr, int x) {
        int count = 0;

        for (int value : arr) {
            if (value == x) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

    // ==================== ГЛАВНЫЙ МЕТОД ====================

    public static void main(String[] args) {
        Lab1 lab = new Lab1();

        
        System.out.println("\n       ЛАБОРАТОРНАЯ РАБОТА №1");
        System.out.println("          ВАРИАНТ №3\n");
        

        // Задание 1
        System.out.println("\nЗАДАНИЕ 1. МЕТОДЫ \n");

        double fractionNumber = lab.readDouble("Введите вещественное число: ");
        System.out.println("Дробная часть: " + lab.fraction(fractionNumber));

        char digit = lab.readDigit("Введите цифру: ");
        System.out.println("Числовое значение: " + lab.charToNum(digit));

        int number = lab.readInt("Введите число для проверки на двузначность: ");
        System.out.println("Результат: " + lab.is2Digits(number));

        int a = lab.readInt("Введите первую границу диапазона: ");
        int b = lab.readInt("Введите вторую границу диапазона: ");
        int num = lab.readInt("Введите проверяемое число: ");
        System.out.println("Входит в диапазон: " + lab.isInRange(a, b, num));

        int x = lab.readInt("Введите первое число для проверки равенства: ");
        int y = lab.readInt("Введите второе число: ");
        int z = lab.readInt("Введите третье число: ");
        System.out.println("Все числа равны: " + lab.isEqual(x, y, z));

        // Задание 2
        System.out.println("\n ЗАДАНИЕ 2. УСЛОВИЯ \n");

        number = lab.readInt("Введите число для нахождения модуля: ");
        System.out.println("Модуль числа: " + lab.abs(number));

        number = lab.readInt("Введите число для проверки делимости на 3 или 5: ");
        System.out.println("Результат: " + lab.is35(number));

        x = lab.readInt("Введите первое число: ");
        y = lab.readInt("Введите второе число: ");
        z = lab.readInt("Введите третье число: ");
        System.out.println("Максимальное число: " + lab.max3(x, y, z));

        x = lab.readInt("Введите первое слагаемое: ");
        y = lab.readInt("Введите второе слагаемое: ");
        System.out.println("Результат сложения: " + lab.sum2(x, y));

        number = lab.readInt("Введите номер дня недели (1-7): ");
        System.out.println("День недели: " + lab.day(number));

        // Задание 3
        System.out.println("\n ЗАДАНИЕ 3. ЦИКЛЫ \n");

        number = lab.readInt("Введите число для вывода последовательности от 0: ");
        System.out.println("Последовательность: " + lab.listNums(number));

        number = lab.readInt("Введите число для вывода четных чисел: ");
        System.out.println("Четные числа: " + lab.chet(number));

        long longNumber = lab.readLong("Введите целое число для определения длины: ");
        System.out.println("Количество цифр: " + lab.numLen(longNumber));

        number = lab.readInt("Введите размер квадрата: ");
        if (number < 0) {
            System.out.println("Размер не может быть отрицательным.");
        } else {
            System.out.println("Квадрат:");
            lab.square(number);
        }

        number = lab.readInt("Введите высоту правого треугольника: ");
        if (number < 0) {
            System.out.println("Высота не может быть отрицательной.");
        } else {
            System.out.println("Правый треугольник:");
            lab.rightTriangle(number);
        }

        // Задание 4
        System.out.println("\n ЗАДАНИЕ 4. МАССИВЫ \n");

        int[] arr = lab.readArray("A");
        number = lab.readInt("Введите число для поиска: ");
        System.out.println("Индекс первого вхождения: " +
            lab.findFirst(arr, number));

        arr = lab.readArray("B");
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Максимальный по модулю элемент: " +
            lab.maxAbs(arr));

        int[] arr1 = lab.readArray("C");
        int[] ins = lab.readArray("D");

        int pos;
        do {
            pos = lab.readInt("Введите позицию вставки (от 0 до " +
                arr1.length + "): ");

            if (pos < 0 || pos > arr1.length) {
                System.out.println("Некорректная позиция вставки.");
            }
        } while (pos < 0 || pos > arr1.length);

        System.out.println("Исходный массив: " + Arrays.toString(arr1));
        System.out.println("Вставляемый массив: " + Arrays.toString(ins));
        System.out.println("Результат: " +
            Arrays.toString(lab.add(arr1, ins, pos)));

        arr = lab.readArray("E");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Массив в обратном порядке: " +
            Arrays.toString(lab.reverseBack(arr)));

        arr = lab.readArray("F");
        number = lab.readInt("Введите число для поиска всех вхождений: ");
        System.out.println("Индексы всех вхождений: " +
            Arrays.toString(lab.findAll(arr, number)));
    }
}
