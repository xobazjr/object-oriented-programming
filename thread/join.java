public class join {
    public static void main(String args[]) {
        Thread number1, number2;
        number1 = new Thread(new ThreadNum(1));
        number1.start();
        number2 = new Thread(new ThreadNum(2));
        number2.start();
        try {
            number1.join();
            number2.join();
        } catch (Exception e) {
        }
        System.out.print("\nMain stop");
    }
}

class ThreadNum implements Runnable {
    int num;

    public ThreadNum(int n) {
        num = n;
    }

    public void run() {
    for (int k=0; k < 10; k++){
        System.out.print(num);
    }
}

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}