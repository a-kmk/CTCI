package Ch15ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockedATM {
    private Lock lock;
    private int balance = 100;

    public lockedATM(){
        lock = new ReentrantLock();
    }

    public int withdraw(int value){
        lock.lock();
        int temp = balance;
        try{
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
        }catch (InterruptedException e){
            System.out.println("Interrupted exception");
        }
        lock.unlock();
        return temp;
    }

    public int deposit(int value){
        lock.lock();
        int temp = balance;
        try{
            Thread.sleep(100);
            temp = temp+value;
            Thread.sleep(300);
            balance = temp;
        }catch(InterruptedException exc){
            System.out.println("Interrupted exception");
        }
        lock.unlock();
        return temp;
    }
}
