package fr.lfednail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JsonWebRequest {
    public static String getRequest(String url){
        // Optional: headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // or omit for visible browser

        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the anti-bot protected URL
            driver.get(url);

            // Wait a bit for redirect & JavaScript to run
            Thread.sleep(3000); // or use WebDriverWait if you prefer

            // Get just the raw JSON content
            String json = driver.findElement(By.tagName("pre")).getText();

            // Print clean JSON
            return json;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
