package SecondChallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*
 * The objetive of this challenge is to create a program that will ask for the name and the surname of 5 people.
 * With these objects, sort them by first or last name or by last name inversely
 * As many times as the user wishes
 */
public class ListOrder {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter the name of the person number " + (i + 1) + ":");
            String name = System.console().readLine();
            System.out.println("Please enter the surname of the person number " + (i + 1) + ":");
            String surname = System.console().readLine();
            
            Person person = new Person();
            person.setName(name);
            person.setSurname(surname);
            people.add(person);
        }

        String select = selectOption();
        selectOption(select, people);
        String answer = "";

        do {
            System.out.println("Do you want to select another option? Yes or No");
            answer = System.console().readLine().toLowerCase();
            
            if (answer.equals("yes")) {
                select = selectOption();
                selectOption(select, people);
            }
        } while (answer.equals("yes"));
        
        System.out.println("Thank you for your time");
        scanner.close();
        
    }

    public static String selectOption(){
        System.out.println("How do you want to order them?");
        System.out.println("1 - By name");
        System.out.println("2 - By surname");
        System.out.println("3 - Inversely by surname");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void selectOption (String select, List<Person> people){
        switch (select) {
            case "1":
            orderByName(people);
            break;
            case "2":
            orderBySurname(people); 
            break;
            case "3":
            orderByInverseSurname(people);
            break;
        
            default:
            System.out.println("Please enter a valid option");
            break;
        }
    }
    public static void orderByName(List<Person> people){
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("People sorted by name");
        for (Person person : people){
            System.out.println(person.getName() + " " + person.getSurname());
        }
    }
    public static void orderBySurname(List<Person> people){
        people.sort(Comparator.comparing(Person::getSurname));
        System.out.println("People sorted by surname");
        for (Person person : people){
            System.out.println(person.getSurname() + " " + person.getName());
        }
    }
    public static void orderByInverseSurname(List<Person> people){
        people.sort(Comparator.comparing(Person::getSurname).reversed());
        System.out.println("People sorted by inverse surname");
        for (Person person : people){
            System.out.println(person.getSurname() + " " + person.getName());
        }
    }
}
