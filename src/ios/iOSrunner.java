package ios;

import Android.AndroidCrome;
import Android.regularSeeTestAndroid;
import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 05-Jan-17.
 */
public class iOSrunner {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        do {
            JUnitCore.runClasses(eribankAppiumiOS.class);
            JUnitCore.runClasses(SafariSTA.class);
            float testTime = ((((System.currentTimeMillis()-startTime)/1000)/60)/60);
            System.out.println(testTime);
        }while (((((System.currentTimeMillis()-startTime)/1000)/60)/60)<6);
    }
}
