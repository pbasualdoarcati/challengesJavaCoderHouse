package SecondChallenge;

import java.util.Arrays;
import java.util.Comparator;

public class ListOrder {
    public static void main(String[] args) {
        Person[] people = new Person[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter the name of the person number " + (i + 1) + ":");
            String name = System.console().readLine();
            System.out.println("Please enter the surname of the person number " + (i + 1) + ":");
            String surname = System.console().readLine();
            
            Person person = new Person();
            person.setName(name);
            person.setSurname(surname);
            people[i] = person;
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
        
    }

    public static String selectOption(){
        System.out.println("How do you want to order them?");
        System.out.println("1 - By name");
        System.out.println("2 - By surname");
        System.out.println("3 - Inversely by surname");
        return System.console().readLine();
    }
    public static void selectOption (String select, Person[] people){
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
    public static void orderByName(Person[] people){
        Arrays.sort(people, Comparator.comparing(Person::getName));
        System.out.println("People sorted by name");
        for (Person person : people){
            System.out.println(person.getName() + " " + person.getSurname());
        }
    }
    public static void orderBySurname(Person[] people){
        Arrays.sort(people, Comparator.comparing(Person::getSurname));
        System.out.println("People sorted by surname");
        for (Person person : people){
            System.out.println(person.getSurname() + " " + person.getName());
        }
    }
    public static void orderByInverseSurname(Person[] people){
        Arrays.sort(people, Comparator.comparing(Person::getSurname).reversed());
        System.out.println("People sorted by inverse surname");
        for (Person person : people){
            System.out.println(person.getSurname() + " " + person.getName());
        }
    }
}
