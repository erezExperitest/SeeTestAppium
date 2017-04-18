package old;

import old.RESETiOS;
import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 30-Jan-17.
 */
public class reunner {
    public static void main(String args[]){


        Thread t1 = new Thread(()-> JUnitCore.runClasses(RESETiOS.class));
        Thread t2 = new Thread(()-> JUnitCore.runClasses(RESETiOS.class));
        Thread t3 = new Thread(()-> JUnitCore.runClasses(RESETiOS.class));

        t1.start();
        t2.start();
        t3.start();


    }
}
