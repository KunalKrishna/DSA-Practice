package com.blogspot.abitmanipulator.multithreading.basics;

/*
Basics of Threads
- Thread lifecycle (New, Runnable, Running, Waiting, Terminated)
- Ways to create threads (Thread class, Runnable, Callable)
*/

public class CreateThread {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        Thread threadTwo = new Thread (new ThreadTwoRunnable());
        threadTwo.start();
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
        this.count = 5; // default
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
