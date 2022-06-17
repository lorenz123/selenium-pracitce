package com.bibvip.login;

import org.openqa.selenium.WebDriver;

import static com.bibvip.configs.DriverConfig.getChromeConfig;

public class ExecuteLoginTest {

    public static void performLogin(){
        //start chrome driver
        WebDriver driverChrome = getChromeConfig();

        //activate - login auto
        LoginAutoTest.doLoginAuto(driverChrome);

        //Done (Close browsers)
        driverChrome.close();
    }


}
