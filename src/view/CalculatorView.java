package view;

import log.Logger;
import model.ComplexNum;
import service.Calculator;
import service.operations.AddOperation;
import service.operations.DivOperation;
import service.operations.MultiplicationOperation;

import java.util.Scanner;

public class CalculatorView {
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.println("Добро пожаловать в калькулятор комплексных чисел!");

        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Умножение");
            System.out.println("3. Деление");
            System.out.println("4. Выйти");
            System.out.print("Введите номер операции: ");

            int choice = getMenuChoice(scanner);

            if (choice == 4) {
                System.out.println("Программа завершена.");
                System.exit(0);
            }

            // Ввод чисел
            ComplexNum num1 = inputComplexNumber(scanner, "первого");
            ComplexNum num2 = inputComplexNumber(scanner, "второго");

            // Выбор операции
            Calculator calculator = null;
            switch (choice) {
                case 1:
                    calculator = new Calculator(new AddOperation());
                    break;
                case 2:
                    calculator = new Calculator(new MultiplicationOperation());
                    break;
                case 3:
                    calculator = new Calculator(new DivOperation());
                    break;
                default:
                    System.out.println("Неверный выбор операции.");
                    continue;
            }

            // Выполнение выбранной операции
            ComplexNum result = calculator.calculate(num1, num2);
            logger.log("Результат: " + result);
            System.out.println("Результат операции: " + result);
        }

    }

    // Метод для получения выбора операции из меню
    private static int getMenuChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 4) {
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка ввода! Введите число от 1 до 4:");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Ошибка! Введите число от 1 до 4.");
            }
        }
        return choice;
    }

    // Метод для ввода комплексного числа
    private static ComplexNum inputComplexNumber(Scanner scanner, String order) {
        System.out.println("Введите действительную часть " + order + " числа:");
        double realPart = getInput(scanner);
        System.out.println("Введите мнимую часть " + order + " числа:");
        double imaginaryPart = getInput(scanner);
        return new ComplexNum(realPart, imaginaryPart);
    }

    // Метод для получения числового ввода от пользователя
    private static double getInput(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка ввода! Пожалуйста, введите число:");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
