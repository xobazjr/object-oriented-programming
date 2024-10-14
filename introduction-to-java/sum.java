import java.util.Scanner;

public class sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double result = 0;

        System.out.print("Please input x, n: ");
        int x = sc.nextInt();
        int n = sc.nextInt();

        for(int i=0;i<n+1;i++){
            result += Math.pow(x,i);
        }System.out.println("Output is: "+String.format("%.0f",result));
    }
}
