package com.bibvip.login;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static com.bibvip.login.LoginAuto.doLoginAuto;

@Slf4j
public class ExecuteLogin {

    public static void performLogin(){
        //start chrome driver
        WebDriver driverChrome = getChromeConfig();

        //activate - login auto
        doLoginAuto(driverChrome);

        //Done (Close browsers)
        driverChrome.close();
    }


}
