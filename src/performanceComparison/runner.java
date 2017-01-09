package performanceComparison;

import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 05-Jan-17.
 */
public class runner {

    public static void main(String[] args){
        JUnitCore.runClasses(regularSeeTestAndroid.class);
        JUnitCore.runClasses(PerformanceSTAAppiumAndroid.class);
    }
}
