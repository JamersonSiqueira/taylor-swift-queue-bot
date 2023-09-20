package com.jamerson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class main {
        public static void main(String[] args) {
            //Chromeinstance padrão
            ChromeOptions co1 = new ChromeOptions();
            co1.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver/chromedriver.exe");
            WebDriver driver = new ChromeDriver(co1);
            driver.get("https://taylor-swift-sp.sales.ticketsforfun.com.br/");
            WebElement spanElement = driver.findElement(By.id("hlLinkToQueueTicket2"));
            WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("MainPart_pMessageOnQueueTicket")));
            String pageText = driver.findElement(By.tagName("body")).getText();
            System.out.println(pageText);
            String footer = driver.findElement(By.id("hlLinkToQueueTicket2")).getText();
            System.out.println(footer);
            WebElement spanElement2 = driver.findElement(By.id("MainPart_lbQueueNumber"));
            String textoPosicao = spanElement2.getText();
            String textoSpan = spanElement.getText();
            System.out.println("Texto do span do chrome normal: " + textoSpan);
            System.out.println("Posição na fila do chrome normal: " + textoPosicao);


            //Chromeinstance incognito
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--incognito");
            WebDriver chromeIncog = new ChromeDriver(co);
            chromeIncog.get("https://taylor-swift-sp.sales.ticketsforfun.com.br/");
            WebElement spanElementIncognito = chromeIncog.findElement(By.id("hlLinkToQueueTicket2"));
            String textoSpanIncognito = spanElementIncognito.getText();
            System.out.println("Texto do span do chrome incognito: " + textoSpanIncognito);

            //mozilla
            System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
            WebDriver mdriver = new FirefoxDriver();
            mdriver.get("https://taylor-swift-sp.sales.ticketsforfun.com.br/");
            WebElement spanElementm = mdriver.findElement(By.id("hlLinkToQueueTicket2"));
            String textoSpanm = spanElementm.getText();
            System.out.println("Texto do span do firefox normal: " + textoSpanm);

        }
    }
