import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int val, max, min;
        int currentIndex = 0;
        boolean isCool = false;
        int dataPointsLength = 100;
        int userInteger = SafeInput.getRangedInt(sc, "Enter a integer value", 1, 100);

        int[] dataPoints = new int[dataPointsLength];

        for (int i = 0; i < dataPointsLength; i++) {
            val = random.nextInt(100)+ 1;
            dataPoints[i] = val;
            if(contains(dataPoints, userInteger)) {
                isCool = true;
                System.out.println(dataPoints[i]);
                currentIndex = i;
                break;
            }
            else if (i == (dataPointsLength - 1)){
                System.out.println(dataPoints[i]);

            }else {
                System.out.print(dataPoints[i] + " | ");
            }
        }
        max = getMax(dataPoints);
        min = getMin(dataPoints);

        if (isCool){
            System.out.println("The value "+ userInteger + " was found at the Array index of: " + currentIndex);
        }
        System.out.println("Total Value of the Random Array is: " + sum(dataPoints));
        System.out.println("Average Value of the Random Array is: " + getAverage(dataPoints));
        System.out.println("The number of times the User's value " + userInteger + " was found is: " + occurrenceScan(dataPoints, userInteger));
        System.out.println("The minimum value that was found was: " + min );
        System.out.println("The maximum value that was found was: " + max );
    }
    public static double getAverage(int[] values){
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }
    public static int getMax(int[] array){
        int currentMax = array[0];
        for (int j : array) {
            if (j > currentMax) {
                currentMax = j;
            }
        }
        return currentMax;
    }

    public static int getMin(int[] array){
        int currentMin = array[0];
        for (int j : array) {
            if (j < currentMin) {
                currentMin = j;
            }
        }
        return currentMin;
    }

    public static int occurrenceScan(int[] values, int target){
        int count = 0;
        for (int j : values) {
             if (j == target) {
                count++;
             }
        }
        return count;
    }

    public static int sum(int[] values){
        int sum = 0;
        for (int j : values){
            sum += j;
        }
        return sum;
    }
    public static boolean contains(int[] values, int target){
        boolean found = false;
        for (int j : values) {
            if (j == target) {
                found = true;
                break;
            }
        }
        return found;
    }



}