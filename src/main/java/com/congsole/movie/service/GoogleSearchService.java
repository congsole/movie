package com.congsole.movie.service;

import com.congsole.movie.domain.Movie;
import com.congsole.movie.domain.MovieRepository;
import com.congsole.movie.watchaPediaDto.RateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleSearchService {

    private final MovieRepository movieRepository;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Chrome Driver/chromedriver.exe";
    ChromeOptions options = new ChromeOptions();

    public boolean firstSearchedContentWithCoopangPlay(String movieName) {

        String url = "https://www.google.com/search?q=" + movieName + "+-+쿠팡플레이";
        webDriver = getWebDriver();
        webDriver.get(url);

        List<WebElement> elementList = webDriver.findElements(By.className("LC20lb"));

        return elementList.get(0).getText().equals(movieName+" - 쿠팡플레이");
    }

    public int addWatchaRates() {
        List<Movie> movieList = movieRepository.findMoviesByProdYear(2012);
//        List<Movie> movieList = movieRepository.findMoviesByTitleContaining("호빗");
        RateDto rateDto;
        for(Movie movie: movieList) {
            if(movie.getRate() == 0 && !movie.getGenre().isEmpty() && !movie.getGenre().contains("에로") && !movie.getRepRlsDate().isEmpty()) {
                rateDto = searchWatchaRates(movie.getTitle(), movie.getProdYear()+"");
                if(rateDto != null) {
                    movie.addRate(rateDto.getRate(), rateDto.getRateNumber());
                    movieRepository.save(movie);
                }
            }
        }
        return 18;
    }

    public RateDto searchWatchaRates(String title, String prodYear) {
        String q = title.trim() + " (" + prodYear + ") - 왓챠피디아";
        String url = "https://www.google.com/search?q=" + q;
        webDriver = getWebDriver();
        webDriver.get(url);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

        String firstResult;
        try {
            try {
                firstResult = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/span/a/h3"))).getText();
                String newUrl = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/span/a")).getAttribute("href");
                webDriver.get(newUrl);
            } catch(Exception e) {
                firstResult = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/block-component/div/div[1]/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div[1]/div/span/a/h3"))).getText();
                String newUrl = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/block-component/div/div[1]/div/div/div/div/div[1]/div/div/div/div/div[2]/div/div/div[1]/div/span/a")).getAttribute("href");
                webDriver.get(newUrl);
            }
            if(
                    firstResult.equals(q)
                            || firstResult.equals(q + " - Watcha Pedia")
                            || (title.trim() + " (" + prodYear + ") - Watcha Pedia").equals(firstResult)
                            || ("왓챠피디아 - " + title.trim() + " (" + prodYear + ")").equals(firstResult)
                            || (firstResult.equals(title.trim().substring(0,title.trim().length()-3)+"(" + prodYear + ") - 왓챠피디아"))
                            || (firstResult.equals(title.trim().substring(0,title.trim().length()-3)+"(" + prodYear + ") - Watcha Pedia"))
                            || (firstResult.equals(title.trim().substring(0,title.trim().length()-3)+"(" + prodYear + ") - 왓챠피디아 - Watcha Pedia"))
                            || (firstResult.equals("왓챠피디아 - "+title.trim().substring(0,title.trim().length()-3)+"(" + prodYear + ")"))
            ) {

                double rate;
                String[] rateNumberRaw;
                int rateNumber;

                try {
                    webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("css-69ff8n"))).click();
                    rate = Double.parseDouble(webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/section/div/div[2]/div/div[1]/div/div[2]/section[1]/div[2]/section[1]/div[2]/div[2]/div[1]")).getText());
                    rateNumberRaw = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/section/div/div[2]/div/div[1]/div/div[2]/section[1]/div[2]/section[1]/div[2]/div[2]/div[2]")).getText().split("\n");
                } catch(Exception e) {
                    rate = Double.parseDouble(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("e15eo6m110"))).getText());
                    rateNumberRaw = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/section/div/div[2]/div/div[1]/div/div[2]/section[1]/div[2]/section[1]/div[2]/div/div[2]"))).getText().split("\n");

                }

                if(rateNumberRaw[1].contains("만")) {
                    rateNumber = Integer.parseInt(rateNumberRaw[1].substring(1, rateNumberRaw[1].length() - 3).replace(".", ""))*1000;
                } else {
                    rateNumber = Integer.parseInt(rateNumberRaw[1].substring(1, rateNumberRaw[1].length() - 2).replace(",", ""));
                }
                webDriver.quit();
                return new RateDto(rate, rateNumber);
            }
            webDriver.quit();
            return null;
        } catch(Exception e) {
            log.error(e.getMessage());
            log.error(title + " (" + prodYear + ")");
            webDriver.quit();
            return null;
        }
    }

    private WebDriver getWebDriver() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // webDriver 옵셜 설정.
        options.addArguments(
                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36",
                "Accept=text_html,application_xhtml+xml,application_xml;q=0.9,image_webp,**/**;q=0.8",
                "Accept-Language=en-US",
                "--remote-allow-origins=*");

//        options.addArguments("headless");
//        options.addArguments();

        // webDriver 생성
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 페이지를 불러오는 여유시간
        return webDriver;
    }
}
