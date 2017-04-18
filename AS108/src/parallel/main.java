package parallel;

/**
 * Created by erez.akri on 18-Apr-17.
 */
public class main {
    public static void main(String args[]){
        Thread t1 =new runner(1);
        Thread t2 =new runner(2);
        Thread t3 =new runner(3);
        Thread t4 =new runner(4);
        Thread t5 =new runner(5);
        Thread t6 =new runner(6);
        Thread t7 =new runner(7);
        Thread t8 =new runner(8);
        Thread t9 =new runner(9);
        Thread t10 =new runner(10);
        Thread t11 =new runner(11);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();

    }
}
