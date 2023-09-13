package FirstChallenge;
/**
 * The object this first challenge is find a method that returns the integer part
 * and separated the decimal part of a float type 
 */
public class FirstChallengeFloatTypeBasualdoArcati {

    public static void main(String[] args) {
        System.out.println("In this challenge we will find the integer part and the decimal part of a float type");
        float number = 3.14159265f;
        float integerPart = (int) number;
        float decimalPart = number - integerPart;
        System.out.println("The float number is: " + number);
        System.out.println("The integer part is: " + integerPart);
        System.out.println("The decimal part is: " + decimalPart);
        System.out.println("Do you want to enter a number and see the floating part and the integer part? ");
        System.out.println("If you want to enter a number, please enter 1, if not, please enter 0");
        int userInput = Integer.parseInt(System.console().readLine());
        if (userInput == 1){
            System.out.println("Please enter a number: ");
            float userNumber = Float.parseFloat(System.console().readLine());
            float userIntegerPart = (int) userNumber;
            float decimalPartUser = userNumber - userIntegerPart;
            System.out.println("The float number is: " + userNumber);
            System.out.println("The integer part is: " + userIntegerPart);
            System.out.println("The decimal part is: " + decimalPartUser);
        }else{
            System.out.println("Thank you for your time");
        }
    }
}