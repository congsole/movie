package com.congsole.movie.service;

import com.congsole.movie.dto.RateDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class NaverSearchService {
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Chrome Driver/chromedriver.exe";
    ChromeOptions options = new ChromeOptions();

    public RateDto getRateFromNaver(String movieName) {
        String url = "https://search.naver.com/search.naver?query=영화 " + movieName + " 평점";

        WebDriver webDriver = getWebDriver();
        webDriver.get(url);

        List<WebElement> divList = webDriver.findElements(By.className("lego_rating_box_see"));

         if (divList.size() == 1) {
             webDriver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[2]/div[2]/div/div/div[1]/div/div/ul/li[2]/a")).click();
             WebElement div_netizen = webDriver.findElements(By.className("lego_rating_box_see")).get(0);
             System.out.println(div_netizen.getText());
             String[] netizen = div_netizen.getText().split("\n");
             System.out.println(netizen.toString());

             return RateDto.builder()
                     .siteName("Naver")
                     .netizen_rate(Double.parseDouble(netizen[2]))
                     .netizen_rate10000(10)
                     .netizen_rate_number(Integer.parseInt(netizen[3].substring(0, netizen[3].length() - 4).replace(",", "")))
                     .netizen_rate_male(Double.parseDouble(netizen[5]))
                     .netizen_rate_female(Double.parseDouble(netizen[7]))
                     .build();

        } else if(divList.size() == 2) {


             WebElement div_audience = divList.get(0);
             String[] audience = div_audience.getText().split("\n");

             webDriver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[2]/div[2]/div/div/div[1]/div/div/ul/li[2]/a")).click();

             WebElement div_netizen = webDriver.findElements(By.className("lego_rating_box_see")).get(1);
             System.out.println(div_netizen.getText());
             String[] netizen = div_netizen.getText().split("\n");

             return RateDto.builder()
                     .siteName("Naver")
                     .audience_rate(Double.parseDouble(audience[2]))
                     .audience_rate10000(10)
                     .audience_rate_number(Integer.parseInt(audience[3].substring(0, audience[3].length() - 4).replace(",", "")))
                     .audience_rate_male(Double.parseDouble(audience[5]))
                     .audience_rate_female(Double.parseDouble(audience[7]))
                     .netizen_rate(Double.parseDouble(netizen[2]))
                     .netizen_rate10000(10)
                     .netizen_rate_number(Integer.parseInt(netizen[3].substring(0, netizen[3].length() - 4).replace(",", "")))
                     .netizen_rate_male(Double.parseDouble(netizen[5]))
                     .netizen_rate_female(Double.parseDouble(netizen[7]))
                     .build();

         } else {
            return null;
        }
    }



    private WebDriver getWebDriver() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // webDriver 옵셜 설정.
        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");

        // webDriver 생성
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS); // 페이지를 불러오는 여유시간
        webDriver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
        return webDriver;
    }
}
