import java.util.Scanner;

public class Praktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Привет я программа StepTracker"); //приветствие для красоты
//        int stepsPerDay = scanner.nextInt(); //переменная для класса StepTracker

        StepTracker tracker = new StepTracker();
        Converter converter = new Converter();


        while (true) { // обработка разных случаев
            printMenu();
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    // вводим месяц, день, шаги и заполняем массив
                    System.out.println("Введите месяц: 0 - Январь, 11 - Декабрь");
                    int month = scanner.nextInt();
                    if (month < 0 || month > 11) { // проверка на меньше и тогда ошибка
                        System.out.println("Неверный ввод, должно быть от 0 до 11");
                        break;
                    }
                        System.out.println("Введите день: ");
                    int day = scanner.nextInt();
                    if (day < 1 || day > 30) { // проверка на меньше и тогда ошибка
                        System.out.println("Неверный ввод, должно быть от 1 до 30");
                        break;
                    }
                    System.out.println("Введите количество шагов: ");
                    int step = scanner.nextInt();
                    if (step < 0) { // проверка на меньше и тогда ошибка
                        System.out.println("Неверный ввод, не должно быть минусового значения");
                        break;
                    }
                        tracker.addData(month, day, step);
                    break;
                case 2:
                    System.out.println("За какой месяц Вы хотите увидеть статистику? 0 - Январь, 11 - Декабрь");
                    int monthNumber = scanner.nextInt();
                    if (monthNumber < 0 || monthNumber > 11) { // проверка на меньше и тогда ошибка
                        System.out.println("Неверный ввод, должно быть от 0 до 11");
                        break;
                    }

                    int totalStepsCount = tracker.getTotalSteps(monthNumber);
                    int maxNum = tracker.maxStepMonth(monthNumber);
                    double meanSteps = tracker.meanStepsMonth(monthNumber);
                    double bestSeries = tracker.getBestSeries(monthNumber);
                    double stepsKm = converter.getDistance(totalStepsCount);
                    double stepsCal = converter.getCalories(totalStepsCount);

                    String stepsPerDayStat = tracker.getStepsInMonth(monthNumber);
                    System.out.println("Ваша статистика: " + "\n"
                            + "Количество шагов по дням: " + stepsPerDayStat);
                    System.out.println("Общее количество шагов за месяц : " + totalStepsCount);
                    System.out.println("Максимальное пройденное количество шагов в месяце : " + maxNum);
                    System.out.println("Среднее количество шагов: " + meanSteps);
                    System.out.println("Пройденная дистанция (в км): " + stepsKm);
                    System.out.println("Количество сожжённых килокалорий: " + stepsCal);
                    System.out.println("Лучшая серия: " + bestSeries);

//                    tracker.getMonthStat(monthNumber);
//                            System.out.println("Ваша статистика: " + "\n" + "Количество шагов по дням: "
//                            + stepsPerDayStat[0] + stepsPerDayStat[1] + stepsPerDayStat[2]
//                            + stepsPerDayStat[3] + stepsPerDayStat[4] + stepsPerDayStat[5]
//                            + stepsPerDayStat[6]);
                    break;
                case 3:
                    System.out.println("Введине новое целевое значение шагов в день:");
                    int targetSteps = scanner.nextInt(); //
                    if (targetSteps < 0) { // проверка на меньше и тогда ошибка
                        System.out.println("Неверный ввод");
                        continue;
                    } else {
                        tracker.setTargetSteps(targetSteps);
                        System.out.println(targetSteps); //для проверки
                    }
                    break;
                case 0:
                    System.out.println("Выход");
                    scanner.close();
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

        private static void printMenu() {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Ввести количество шагов за определённый день");
            System.out.println("2 - Напечатать статистику за определённый месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выйти из приложения");
        }
    }
