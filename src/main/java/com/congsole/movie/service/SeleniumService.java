package com.congsole.movie.service;

import com.congsole.movie.dto.JustWatchPopular;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
public class SeleniumService {
    private WebDriver webDriver;
    private static final String justWatchUrl = "https://www.justwatch.com/kr";
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Chrome Driver/chromedriver.exe";


    public List<JustWatchPopular> justWatchList() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // webDriver 옵셜 설정.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--lang=ko");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
//        options.setCapability("ignoreProtectedModeSettings",true);

        // webDriver 생성
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        webDriver.get(justWatchUrl);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // 페이지를 불러오는 여유시간
        List<WebElement> elementList = webDriver.findElements(By.className("title-list-grid__item--link"));

        List<JustWatchPopular> justWatchList = new ArrayList<>();

        for(WebElement element: elementList) {
            JustWatchPopular justWatch = JustWatchPopular.builder()
                    .name(element.findElement(new By.ByCssSelector("picture img.picture-comp__img")).getAttribute("alt"))
                    .url(element.getAttribute("href"))
                    .imgUrl(element.findElement(new By.ByCssSelector("picture img.picture-comp__img")).getAttribute("src"))
                    .build();
            justWatchList.add(justWatch);

        }
        return justWatchList;
    }

}
