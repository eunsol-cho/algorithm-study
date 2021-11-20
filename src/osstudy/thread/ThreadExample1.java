package osstudy.thread;

public class ThreadExample1{
    public static void main(String[] args) {
        // 1. Thread 클래스 상속
        MyThread1 myThread = new MyThread1();
        myThread.start();
        System.out.println("Hello, My Child!");

        // 2. Runnable 인터페이스 구현
        Thread thread = new Thread(new MyThread2());
        thread.start();
        System.out.println("Hello, My Runnable Child!");

        // 3. Lambda로 Runnable 인터페이스 구현
        Runnable task = () -> {
            try {
                while (true) {
                    System.out.println("Hello, Lambda Runnable!");
                    Thread.sleep(500);
                }
            } catch (InterruptedException ie) {
                System.out.println("I'm interrupted");
            }
        };
        System.out.println("Hello, My Lambda Child!");
    }
}

class MyThread1 extends Thread{
    public void run() {
        try {
            while (true) {
                System.out.println("Hello, Thread!");
                Thread.sleep(500);
            }
        } catch (InterruptedException ie) {
            System.out.println("I'm interrupted");
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Hello, Runnable!");
                Thread.sleep(500);
            }
        } catch (InterruptedException ie) {
            System.out.println("I'm interrupted");
        }
    }
}