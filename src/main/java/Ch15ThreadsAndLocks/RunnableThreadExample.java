package Ch15ThreadsAndLocks;

/*
To create a thread using the runnable interface we:
1. Create a class that implements the runnable interface, an object of this class is said to be a runnable object
2. Create an object of type Thread by passing a Runnable object as an argument to the Thread constructor, the thread
now has a runnable object that implements the run() method
3. The start() method is invoked on the Thread object created in the previous step
 */
public class RunnableThreadExample implements Runnable {
    public int count =0;

    public void run(){
        System.out.println("RunnableThread starting.");

        try{
            while (count < 5){
                Thread.sleep(500);
                count++;
            }
        }catch(InterruptedException exc){
            System.out.println("RunnableThread interrupted");
        }

        System.out.println("RunnableThread terminating");
    }

    public static void main(String[] args){
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        /* waits until the above thread count counts to 5 (slowly)*/
        while(instance.count != 5){
            try{
                Thread.sleep(250);
            } catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }

}
