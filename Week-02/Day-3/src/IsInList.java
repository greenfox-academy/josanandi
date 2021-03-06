import java.util.*;

public class IsInList {
    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        System.out.println(checkNums(list));
        // Check if list contains all of the following elements: 4,8,12,16
        // Create a method that accepts list as an input
        // it should return "true" if it contains all, otherwise "false"

    }
    public static Boolean checkNums(ArrayList listOfNumbers) {
        ArrayList<Integer> listOfElementsToCheck = new ArrayList<>(Arrays.asList(4, 8,12,16));
        return listOfNumbers.containsAll(listOfElementsToCheck);
    }
}
