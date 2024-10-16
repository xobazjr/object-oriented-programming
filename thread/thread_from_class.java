public class thread_from_class{
    public static void main(String[] args){
        numberthread number1,number2,number3,number4,number5;

        number1 = new numberthread(1); number1.start();
        number2 = new numberthread(2); number2.start();
        number3 = new numberthread(3); number3.start();
        number4 = new numberthread(4); number4.start();
        number5 = new numberthread(5); number5.start();
    }
}

class numberthread extends Thread{
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