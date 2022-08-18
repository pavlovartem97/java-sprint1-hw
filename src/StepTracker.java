public class StepTracker {
    int[][] data = new int[12][30];
    int targetSteps = 10000;
    Converter converter = new Converter();
    public void saveStepsPerDay(int month, int day, int steps) {
        data[month][day] = steps;
    }

    public void setTargetSteps(int steps) {
        targetSteps = steps;
    }
    public void printStatistics(int month) {
        System.out.println("Количество пройденных шагов по дням:");
        printStatisticsPerDay(month);

        int allSteps = calcAllSteps(month);
        System.out.println("Общее количество шагов за месяц:");
        System.out.println(allSteps);

        System.out.println("Максимальное пройденное количество шагов в месяце;");
        System.out.println(calcMaxDistance(month));

        System.out.println("Среднее количество шагов;");
        System.out.println(allSteps / 30.);

        System.out.println("Пройденная дистанция (в км);");
        System.out.println(converter.convertStepsToKm(allSteps));

        System.out.println("Количество сожжённых килокалорий;");
        System.out.println(converter.convertStepsToCalories(allSteps));

        System.out.println("Лучшая серия;");
        System.out.println(calcBestSeries(month));
    }

    public void printStatisticsPerDay(int month) {
        for (int day = 0; day < data[month].length; ++day) {
            System.out.print((day + 1) + " день: " + data[month][day]);
            if (day + 1 != data[month].length) {
                System.out.print(", ");
            }
            else {
                System.out.println();
            }
        }
    }

    public int calcAllSteps(int month) {
        int allDistance = 0;
        for (int day = 0; day < data[month].length; ++day) {
            allDistance += data[month][day];
        }
        return allDistance;
    }

    public int calcMaxDistance(int month) {
        int maxDistance = 0;
        for (int day = 0; day < data[month].length; ++day) {
            if (data[month][day] > maxDistance) {
                maxDistance = data[month][day];
            }
        }
        return maxDistance;
    }

    public int calcBestSeries(int month) {
        int bestSeries = 0;
        int curSeries = 0;
        for (int day = 0; day < data[month].length; ++day) {
            if (data[month][day] > targetSteps) {
                curSeries++;
            }
            else {
                if (curSeries > bestSeries){
                    bestSeries = curSeries;
                }
                curSeries = 0;
            }
        }
        // Дополнительная проверка последней серии шагов
        if (curSeries > bestSeries){
            bestSeries = curSeries;
        }

        return bestSeries;
    }
}
