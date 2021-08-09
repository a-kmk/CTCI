package Ch15ThreadsAndLocks;

/*
 Synchronized methods, this preveents multiple threads from executing the code simultaneously on the same object
 */
public class MyClass extends Thread{
    private String name;
    private MyObject myObj;

    public MyClass(MyObject myObj, String name){
        this.name = name;
        this.myObj = myObj;
    }

    public void run(){
        myObj.foo(name);
    }

    public static void main(String args[]){
        /* Diferent references - both threads can call MyObject.foo() */
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();
        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj2, "2");
        thread1.start();
        thread2.start();

        /* Same reference to obj. Only one will be allowed to call foo and the other
           will be forced to wait
         */
        MyObject obj = new MyObject();
        MyClass thread3 = new MyClass(obj, "3");
        MyClass thread4 = new MyClass(obj, "4");
        thread3.start();
        thread4.start();

    }
}

