package com.blogspot.abitmanipulator.multithreading.basics;

/*
Basics of Threads
- Thread lifecycle (New, Runnable, Running, Waiting, Terminated)
- Ways to create threads (Thread class, Runnable, Callable)
*/

public class CreateThread {
    public static void main(String[] args) {
        // 1. extending Thread class
        ThreadOne threadOne = new ThreadOne(60);
        threadOne.start();

        // 2. Implementing Runnable interface
        Thread threadTwo = new Thread (new ThreadTwoRunnable(50));
        threadTwo.start();

        // 2a. pass an anonymous inner class
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from inner class!");
            }
        });
        t.start();;

        // 2b. lambda expression: Runnable = a functional interface (only one method run()) ==> replace the anonymous inner class
        Thread worker = new Thread(()->{
            for(int i = 0; i < 100; i++) {
                System.out.println("lambda expression : " + i);
            }
        });
        worker.start();
    }
}

class ThreadOne extends Thread {
    private int count = 0;
    ThreadOne(){
        this.count = 10; // default
    }

    ThreadOne(int count){
        this.count = count;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("over ride \'public void run()\' of Thread class");
        for (int i=0; i<count; i++) {
            System.out.println("counting thread : " + i);
        }
    }
}

class ThreadTwoRunnable implements Runnable {
    private int count = 0;
    ThreadTwoRunnable( ){
        this.count = 30; // default
    }

    ThreadTwoRunnable(int count){
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("over ride \'public abstract void run()\' of Runnable interface");
        for (int i=0; i<count; i++) {
            System.out.println("counting runnable : " + i);
        }
    }
}
