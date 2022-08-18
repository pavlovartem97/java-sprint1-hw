import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int curentComand = -1;
        StepTracker stepTracker = new StepTracker();

        while (curentComand != 0) {
            printMenu();
            curentComand = scanner.nextInt();

            if (1 == curentComand) {
                System.out.println("Введите месяц (значение от 1 до 12):");
                int month = scanner.nextInt();

                System.out.println("Введите день (значение от 1 до 30):");
                int day = scanner.nextInt();

                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();

                boolean isError = false;
                if (1 > month || 12 < month) {
                    System.out.println("Некорректное задание месяца");
                    isError = true;
                }

                if (1 > day || 30 < day) {
                    System.out.println("Некорректное задание дня");
                    isError = true;
                }

                if (steps < 0) {
                    System.out.println("Некорректное задание количества шагов");
                    isError = true;
                }

                if (isError) {
                    System.out.println("Были введены некорректные данные, попробуйте еще раз");
                }
                else {
                    stepTracker.saveStepsPerDay(month - 1, day - 1, steps);
                    System.out.println("Количество шагов успешно сохранено");
                }
            }
            else if (2 == curentComand) {
                System.out.println("Введите месяц (значение от 1 до 12):");
                int month = scanner.nextInt();
                if (1 > month || 12 < month) {
                    System.out.println("Некорректное задание месяца, попробуйте еще раз");
                }
                else {
                    stepTracker.printStatistics(month - 1);
                }
            }
            else if (3 == curentComand) {
                System.out.println("Введите новое целевое количество шагов:");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Некорректное задание количества шагов");
                }
                else{
                    stepTracker.setTargetSteps(steps);
                }
            }
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu(){
        System.out.println("Введите команду");
        System.out.println("1: Ввести количество шагов за определённый день;");
        System.out.println("2: Напечатать статистику за определённый месяц;");
        System.out.println("3: Изменить цель по количеству шагов в день;");
        System.out.println("0: Выйти из приложения.");
    }
}

