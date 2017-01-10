package Android; /**
 * Created by erez.akri on 05-Jan-17.
 */
//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class regularSeeTestAndroid {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;
    String DeviceName;

    void regularSeeTestAndroid(String DeviceName){
        this.DeviceName=DeviceName;
    }


    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
    }

    @Test
    public void test_1() {
//        client.waitForDevice("@os='android'", 10000);
        client.setDevice(DeviceName);
        long startTime = System.currentTimeMillis();
        int i;
        for (i = 0; i < 1; i++) {
            client.launch("com.experitest.ExperiBank/.LoginActivity", true, true);
            client.elementSendText("NATIVE", "hint=Username", 0, "company");
            client.elementSendText("NATIVE", "hint=Password", 0, "company");
            client.click("NATIVE", "text=Login", 0, 1);
            client.click("NATIVE", "text=Make Payment", 0, 1);
            client.click("NATIVE", "text=Select", 0, 1);
            client.elementListSelect("", "text=Mexico", 0, false);
            client.click("NATIVE", "text=Mexico", 0, 1);
            client.click("NATIVE", "text=Cancel", 0, 1);
            client.click("NATIVE", "text=Logout", 0, 1);
        }
        long tottalTime = (System.currentTimeMillis()-startTime)/1000;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(this.getClass().getName());
        System.out.println(i +" itarations took "+ tottalTime + " seconds");
        System.out.println("avarage time per iteration was: " + (tottalTime/i));
        System.out.println("----------------------------------------------------------------------------------");
    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }
}

