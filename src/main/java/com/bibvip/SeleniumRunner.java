package com.bibvip;

import com.bibvip.configs.consts.ElementType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bibvip.configs.consts.BibEnglishLinks.*;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.LinksRetriever.getAllLinksInPage;
import static com.bibvip.utility.LocalizationChecker.chineseCheckWordsInPage;
import static com.bibvip.utility.LocalizationChecker.englishCheckWordsInPage;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibvip.utility.ThinkingTimeUtil.getWebDriverWait;
import static com.bibvip.variables.LoginVars.PASSWORD_TEXTFIELD;

@Slf4j
public class SeleniumRunner {

    public static void main(String[] args) throws Exception {


    }

}
