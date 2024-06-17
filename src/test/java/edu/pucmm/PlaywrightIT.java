package edu.pucmm;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class PlaywrightIT {
    private static Playwright playwright; // Proyecto actual del framework
    private static Browser browser; // Navegador en donde se realizaran las pruebas
    protected Page page; // Página donde se está la información actualmente
    private BrowserContext browserContext; // Contexto del browser

    @BeforeAll
    static void beforeAll(){
        playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.headless = false;
        browser = browserType.launch(launchOptions);
    }

    @AfterAll
    static void afterAll(){
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void beforeEach(){
        browserContext = browser.newContext();

        page = browserContext.newPage();
    }

    @AfterEach
    void afterEach(){
        page.close();
        browserContext.close();
    }
}
