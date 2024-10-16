class ThreadNum extends Thread {
    int num;

    public ThreadNum(int n) {
        num = n;
    }

    public void run() {
        for (int k = 0; k < 20; k++) {
            System.out.print(num);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class suspend_resume {
    @SuppressWarnings("removal")
    public static void main(String args[]) {
        ThreadNum t1 = new ThreadNum(1);
        ThreadNum t2 = new ThreadNum(2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(200);
            t1.suspend();
            Thread.sleep(1000);
            t1.resume();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}