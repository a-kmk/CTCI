package Ch15ThreadsAndLocks;

public class ThreadExample extends Thread{
    int count =0;

    public void run(){
        System.out.println("Thread Starting");
        try{
            while(count < 5){
                Thread.sleep(500);
                System.out.println("In Thread, count is " + count);
                count++;
            }
        }catch(InterruptedException exc){
           System.out.println("Thread terminating");
        }
    }


        public static void main(String args[]){
            ThreadExample instance = new ThreadExample();
            instance.start();

            while(instance.count != 5){
                try{
                    Thread.sleep(250);
                }catch (InterruptedException exc){
                    exc.printStackTrace();
                }
            }

    }
}
