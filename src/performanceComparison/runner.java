package performanceComparison;

import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 05-Jan-17.
 */
public class runner {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        do {
            JUnitCore.runClasses(regularSeeTestAndroid.class);
            JUnitCore.runClasses(AndroidCrome.class);

        }while (((((System.currentTimeMillis()-startTime)/1000)/60)/60)<6);
    }
}
