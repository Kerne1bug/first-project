import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет я программа StepTracker"); //приветствие для красоты
//        int stepsPerDay = scanner.nextInt(); //переменная для класса StepTracker
        printMenu();
        int userInput = scanner.nextInt();

        StepTracker tracker = new StepTracker();

        while (userInput != 0) { // обработка разных случаев
            if (userInput == 1) { // вводим количество шагов и заполняем массив
                System.out.println("Введите месяц: 0 - Январь, 11 - Декабрь");
                int month  = scanner.nextInt();
                System.out.println("Введите день: ");
                int day  = scanner.nextInt();
                System.out.println("Введите количество шагов: ");
                int step  = scanner.nextInt();
                tracker.addData(month, day, step);

            } else if (userInput == 2) {
                System.out.println("За какой месяц Вы хотите увидеть статистику? 0 - Январь, 11 - Декабрь");
                int monthNumber  = scanner.nextInt();
                String[] stepsPerDayStat = tracker.getMonthStat(monthNumber);
                System.out.println("Ваша статистика: " + "\n" + "Количество шагов по дням: "
                        + stepsPerDayStat[0] + stepsPerDayStat[1] + stepsPerDayStat[2]
                        + stepsPerDayStat[3] + stepsPerDayStat[4] + stepsPerDayStat[5]
                        + stepsPerDayStat[6]);
            } else if (userInput == 3) {
                System.out.println("Введине новое целевое значение шагов в день:");
                int targetSteps = scanner.nextInt(); //
                if (targetSteps <= 0) { // проверка на меньше и тогда ошибка
                    System.out.println("Неверный ввод");
                }
                tracker.setTargetSteps(targetSteps);
            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

        private static void printMenu() {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Ввести количество шагов за определённый день");
            System.out.println("2 - Напечатать статистику за определённый месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выйти из приложения");
        }
    }
