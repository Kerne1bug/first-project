public class Converter {
    private double Meters_Amount_I_nStep = 0.00075;
    private double Calories_In_Step = 0.05;

    double getDistance (int stepsKm) {
        return stepsKm * Meters_Amount_I_nStep;
    }

    double getCalories (int stepsCal) {
        return stepsCal * Calories_In_Step;
    }
}
