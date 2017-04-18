package parallel;

import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 18-Apr-17.
 */
public class runner extends Thread{
    int Threadnumber;

    public runner(int threadnumber){
        super();
        this.Threadnumber = threadnumber;
    }


    @Override
    public void run() {

//        android_performance.threadnumber.set(Threadnumber);
        JUnitCore.runClasses(android_performance.class);
    }
}
