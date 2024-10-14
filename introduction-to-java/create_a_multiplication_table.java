import java.util.Scanner;

public class create_a_multiplication_table {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Please input number of columns and rows: ");
        int m = input.nextInt();
        int n = input.nextInt();

        for(int i=0;i<m+1;i++){
            if(m <= 0 || n <= 0){
                break;
            }
            
            for(int j=0;j<n+1;j++){
                if((i*j) == 1){
                    System.out.print(" "+" "+"\t"); 
                }else if((i*j) >= 2){
                    System.out.print(i*j+" "+"\t"); 
                }
            }System.out.println();
        }
    }
}
