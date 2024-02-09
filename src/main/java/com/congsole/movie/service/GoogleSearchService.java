package com.congsole.movie.service;

import com.congsole.movie.dto.Ott;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GoogleSearchService {
    private WebDriver webDriver;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Chrome Driver/chromedriver.exe";
    ChromeOptions options = new ChromeOptions();

    public boolean firstSearchedContentWithCoopangPlay(String movieName) {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        String url = "https://www.google.com/search?q=" + movieName + "+-+쿠팡플레이";

        // webDriver 옵셜 설정.
        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");

        // webDriver 생성
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // 페이지를 불러오는 여유시간
        List<WebElement> elementList = webDriver.findElements(By.className("LC20lb"));

        return elementList.get(0).getText().equals(movieName+" - 쿠팡플레이");
    }


    public List<Ott> servicesAt(String movieName) {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        String url = "https://www.google.com/search?q=" + movieName + " 보는 곳";

        // webDriver 옵셜 설정.
        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");

        // webDriver 생성
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // 페이지를 불러오는 여유시간

        List<Ott> ottList = new ArrayList<>();

        List<WebElement> elementList = webDriver.findElements(By.className("phXTff"));
        for(WebElement webElement: elementList) {
            String ottName = webElement.findElement(By.className("bclEt")).getText();
            WebElement costElement = webElement.findElement(By.className("rsj3fb"));
            String cost;
            if(costElement.getText().contains("구독")) {
                cost = costElement.getText();
            } else if(costElement.getText().contains("최저")) {
                cost = "최저 " + costElement.findElement(new By.ByCssSelector("span")).getText();
            } else {
                cost = costElement.findElement(new By.ByCssSelector("span")).getText();
            }
            ottList.add(Ott.builder().ottName(ottName).cost(cost).build());
        }

        return ottList;
    }
}
