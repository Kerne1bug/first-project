public class StepTracker { // 3 метода: 1) статистика 2) запись и хранение информации о шагах 3) новая цель в шагах
    private int[][] monthData;
    private int targetSteps = 10000;

    StepTracker() {
        monthData = new int[12][30]; // двумерный массив 12 месяцев 30 дней в месяце
    }

    String getStepsInMonth(int monthNumber) {
        String stepsPerDayStat = "";
        for (int j = 0; j < monthData[monthNumber].length; j++) {
            int dayNumber = j + 1;
            int stepsPerDay = monthData[monthNumber][j]; // прибавили как в обычном цикле
            stepsPerDayStat = stepsPerDayStat + dayNumber + " день: " + stepsPerDay + " шагов, ";
        }
        return stepsPerDayStat;
    }

    int getTotalSteps(int monthNumber) {
        int totalStepsCount = 0;
        for (int j = 0; j < monthData[monthNumber].length; j++) {
            int stepsPerDay = monthData[monthNumber][j] > 0 ? monthData[monthNumber][j] : 0; //функция булинов фактически иф елс
            totalStepsCount += stepsPerDay; // прибавили как в обычном цикле
        }
        return totalStepsCount;
    }

    void addData(int month, int day, int step) {
        monthData[month][day - 1] = step; // dai - 1 - массив не правильно заполнял ЗАПОМНИТЬ!
    }

    int maxStepMonth(int monthNumber) {
        int maxNum = monthData[monthNumber][0];
        for (int i = 0; i < monthData[monthNumber].length; i++) {
            if (maxNum < monthData[monthNumber][i]) {
                maxNum = monthData[monthNumber][i];
            }
        }
        return maxNum;
    }

    double meanStepsMonth(int monthNumber) { //средние шаги за месяц
        return getTotalSteps(monthNumber) / 30;
    }

    int getBestSeries(int monthNumber) { // лучшая серия подряд идущих дней
        int bestSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < monthData[monthNumber].length; i++) {
            if (monthData[monthNumber][i] >= targetSteps) {
                currentSeries += 1; // увеличиваем курент на 1
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
            } else { // для обнуления счетчика
                currentSeries = 0;
            }
        }
        return bestSeries;
    }

    void setTargetSteps(int newTargetSteps) {
        targetSteps = newTargetSteps;
        if (targetSteps != 0 && targetSteps > 0) { //проверка если 0 или больше то ничего не делаем
            targetSteps = newTargetSteps;
        }
    }
}

//    String[] getMonthStat(int monthNumber) { // статистика за месяц по дню
//        String stepsPerDayStat = "";
//        int totalStepsCount = 0;
//        int maxNum = maxStepMonth(monthNumber);
//        double meanSteps = meanStepsMonth (monthNumber);
//        int bestSeries = getBestSeries(monthNumber);
//
//        for (int j = 0; j < monthData[monthNumber].length; j++) {
//            int stepsPerDay = monthData[monthNumber][j] > 0 ? monthData[monthNumber][j] : 0; //функция булинов фактически иф елс
//            int dayNumber = j + 1;
//            totalStepsCount += stepsPerDay; // прибавили как в обычном цикле
//            stepsPerDayStat = stepsPerDayStat + dayNumber + " день: " + stepsPerDay + " шагов, ";// вывод статистики по дням
//        }

//          double distance = converter.getDistance(totalStepsCount);
//          double calories = converter.getCalories(totalStepsCount);

//        String totalStepsCountOutput = "Общее количество шагов за месяц: " + totalStepsCount + "\n";// вывод общего числа шагов за месяц
//        String maxNumOutput = "Максимальное количество шагов за месяц: " + maxNum + "\n";// вывод макс шагов за месяц
//        String meanStepsOutput = "Среднее количество шагов за месяц: " + meanSteps + "\n";// вывод средние шаги за месяц
//        String distanceOutput = "Пройденая дистанция в км: " + distance + "\n";// вывод километров за месяц
//        String caloriesOutput = "Количество сожжённых килокалорий: " + calories + "\n";// вывод калорий за месяц
//        String bestSeriesOutput = "Лучшая серия: " + bestSeries + " дня" + "\n";// вывод лучшая серия за месяц
//        String[] stats = {stepsPerDayStat, totalStepsCountOutput, maxNumOutput,
//                meanStepsOutput, distanceOutput, caloriesOutput, bestSeriesOutput}; // гугл помог
//        return new String[]{stepsPerDayStat};
//    }
