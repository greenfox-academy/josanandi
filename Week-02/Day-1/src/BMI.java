public class BMI {
    public static void main(String[] args) {
        double massInKg = 81.2;
        double heightInM = 1.78;

        double BMI=massInKg/Math.pow(heightInM,2);

        // Print the Body mass index (BMI) based on these values
        System.out.println("The BMI index is: " + BMI);

    }
}
