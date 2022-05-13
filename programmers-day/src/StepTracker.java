public class StepTracker { // 3 метода: 1) статистика 2) запись и хранение информации о шагах 3) новая цель в шагах
    int[][] monthData;
    Converter converter = new Converter();
    int targetSteps = 10000;
    StepTracker() {
        monthData = new int[12][30]; // двумерный массив 12 месяцев 30 дней в месяце
    }

    String[] getMonthStat(int monthNumber) { // статистика за месяц по дню
        String stepsPerDayStat = "";
        int totalStepsCount = 0;
        int maxNum = maxStepMonth(monthNumber);
        double meanSteps = meanStepsMonth (monthNumber);
        int bestSeries = getBestSeries(monthNumber);

        for (int j = 0; j < monthData[monthNumber].length; j++) {
            int stepsPerDay = monthData[monthNumber][j] > 0 ? monthData[monthNumber][j] : 0; //функция булинов фактически иф елс
            totalStepsCount += stepsPerDay; // прибавилиб как в обычном цикле
            stepsPerDayStat =  stepsPerDayStat + j + " день: " + stepsPerDay + " шагов, ";// вывод статистики по дням
        }
        double distance = converter.getDistance(totalStepsCount);
        double calories = converter.getCalories(totalStepsCount);

        String totalStepsCountOutput = "Общее количество шагов за месяц: " + totalStepsCount + "\n";// вывод общего числа шагов за месяц
        String maxNumOutput = "Максимальное количество шагов за месяц: " + maxNum + "\n";// вывод макс шагов за месяц
        String meanStepsOutput = "Среднее количество шагов за месяц: " + meanSteps + "\n";// вывод средние шаги за месяц
        String distanceOutput = "Пройденая дистанция в км: " + distance + "\n";// вывод километров за месяц
        String caloriesOutput = "Количество сожжённых килокалорий: " + calories + "\n";// вывод калорий за месяц
        String bestSeriesOutput = "Лучшая серия: " + bestSeries + " дня" + "\n";// вывод лучшая серия за месяц
        String[] stats = {stepsPerDayStat, totalStepsCountOutput, maxNumOutput,
                meanStepsOutput, distanceOutput, caloriesOutput, bestSeriesOutput}; // гугл помог
        return stats;
    }

    void addData(int month, int day, int step) {
        monthData[month][day] = step;
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

    double meanStepsMonth (int monthNumber) { //средние шаги за месяц
        double meanSteps = 0;
        for (int i = 0; i < monthData[monthNumber].length; i++) {
            meanSteps += monthData[monthNumber][i];
        }
        if (meanSteps == 0) { //если 0 возвращаем 0 что бы ошибки не было
            return 0;
        }
        return meanSteps / 30; //разделили на 30 так как месяц фиксированный но можно и массив сюда воткнуть
    }

    int getBestSeries (int monthNumber) { // лучшая серия подряд идущих дней
        int bestSeries = 0;
        int currentSeries = 0;
        for (int i = 0; i < monthData[monthNumber].length; i++) {
            if (monthData[monthNumber][i] >= targetSteps) {
                currentSeries += 1;// увеличиваем курент на 1
            } else if (currentSeries > bestSeries) {
                bestSeries = currentSeries; // смотри больше ли куррент бест и если да то обоновляем
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