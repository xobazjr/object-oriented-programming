import java.util.Scanner;

public class fahrenheit_degree {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double fahrenheit = input.nextDouble();

        double celsius =  (5 / 9) * (fahrenheit - 32); 
        
        System.out.println(celsius);
    }
}
