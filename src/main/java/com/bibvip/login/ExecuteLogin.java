package com.bibvip.login;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static com.bibvip.login.LoginAuto.doLoginAuto;
import static com.bibvip.utility.ThinkingTimeUtil.getWebDriverWait;

@Slf4j
public class ExecuteLogin {

    public static void performLogin() throws MalformedURLException {
        //start chrome driver
        WebDriver driverChrome = getChromeConfig();

        WebDriverWait wait = getWebDriverWait(driverChrome);

        //activate - login auto
        doLoginAuto(wait);

        //Done (Close browsers)
        driverChrome.close();
    }


}
