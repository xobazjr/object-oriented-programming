import java.util.Scanner;

public class recurrence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please input n,  a0 and a1: ");
        int n = sc.nextInt();
        int a0 = sc.nextInt();
        int a1 = sc.nextInt();

        System.out.print("Output is: ");
        System.out.print(a0+" "+a1+" ");

        for(int k=2;k<=n;k++){
            int a = (int) (Math.pow(k, 2) * a1 - a0 + Math.pow(3, k));
    
            a0 = a1;
            a1 = a;

            System.out.print(a+" ");
        }
    }
}
