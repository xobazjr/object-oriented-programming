public class thread_runnable{
    public static void main(String[] args){
       Thread number1,number2,number3,number4,number5;

        number1 = new Thread(new numberthread(1)); number1.start();
        number2 = new Thread(new numberthread(2)); number2.start();
        number3 = new Thread(new numberthread(3)); number3.start();
        number4 = new Thread(new numberthread(4)); number4.start();
        number5 = new Thread(new numberthread(5)); number5.start();
    }
}

class numberthread implements Runnable{
    int num;

    public numberthread(int n){
        num = n;
    }

    public void run(){
        for(int k=0;k<10;k++){
            System.out.print(num);
        }
    }
}