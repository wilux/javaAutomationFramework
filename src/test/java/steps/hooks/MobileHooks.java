package steps.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileHooks {

    public static AndroidDriver driver;

    @Before("@mobile")
    public void setUpMobile() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
//                .setDeviceName("emulator-5554") // o tu dispositivo real
                .setAppPackage("py.com.elcomercio.retailbanking")
                .setAppActivity("com.itti.ueno_app.MainActivity")
                .amend("noReset", true); // mantiene la sesión iniciada

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), // en Appium 2 ya no se usa /wd/hub
                options
        );
    }

    @After("@mobile")
    public void tearDownMobile() {
        if (driver != null) {
            driver.quit();
        }
    }
}