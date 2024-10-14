import java.util.Scanner;
import java.util.ArrayList;

public class occurrence_of_max_number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<Integer>();

        while (true) {
            int n = sc.nextInt();

            if(n == 0){
                arr.sort(null);
                int count = 0;
                n = arr.get(arr.size()-1);

                for(int i=0;i<arr.size();i++){
                    if(arr.get(i) == n){
                        ++count;
                    }
                }

                System.out.println(n+" "+count);
                break;
            }else{
                arr.add(n);
            }
        }
    }
}
