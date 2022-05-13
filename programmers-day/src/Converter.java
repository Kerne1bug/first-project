public class Converter {
    double metersAmountInStep = 0.00075;
    double caloriesInStep = 0.05;

    double getDistance (int steps) {
        return steps * metersAmountInStep;
    }

    double getCalories (int steps) {
        return steps * caloriesInStep;
    }
}
