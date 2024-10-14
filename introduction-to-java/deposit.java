import java.util.Scanner;

public class deposit {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the monthly saving amount: ");
        double money = input.nextDouble();
        
        double interest=0;

        for(int i=0;i<6;i++){
            if(i == 0){
                interest = money * (1 + 0.00417);
            }else{
                interest = (money + interest) * (1 + 0.00417);
            }
        }System.out.println("After the sixth month, the account value is $"+String.format("%.2f",interest));
    }
}
