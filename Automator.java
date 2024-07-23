//import java.time.Duration;
//import java.util.List;
//import java.util.Random;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.By.ById;
//import org.openqa.selenium.By.ByLinkText;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Automator {
//    public static void main(String[] args) {
//    	Random rand=new Random();
//    	System.setProperty("webdriver.chrome.driver", "/home/arclight/Coding/DEVops/chromedriver-linux64/chromedriver");
//
//        // Create a new instance of the Chrome driver
//        WebDriver driver = new ChromeDriver();
//
//        try {
//            // Navigate to the website
//            driver.get("https://www.autodraw.com/");
////            driver.manage().window().maximize();
//            
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//            
//            WebElement button = driver.findElement(By.xpath("//div[@class='button green' and text()=' Start Drawing ']"));
//            button.click();
//            
//            
//            Actions action=new Actions(driver);
//            WebElement canvas=driver.findElement(By.id("main-canvas"));
//            int a=rand.nextInt(0,10);
//            int b=rand.nextInt(0,10);
//
//            action.moveToElement(canvas,a,b).clickAndHold()   
//            
//            .moveByOffset(rand.nextInt(0,100),  rand.nextInt(0,100))
//            .moveByOffset(rand.nextInt(0,100),  rand.nextInt(0,100)) 
//            .moveByOffset(-rand.nextInt(0,100), rand.nextInt(0,100)) 
//            .moveByOffset(rand.nextInt(0,100), -rand.nextInt(0,100)) 
//            .moveByOffset(rand.nextInt(0,100),  rand.nextInt(0,100))
//            .release().perform();
//            
//            Thread.sleep(400);
//            
//            WebElement suggestionsPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("autodraw-suggestions")));
//            List<WebElement> images = suggestionsPanel.findElements(By.xpath(".//div[@class='thumbs']//img"));
//
//            for (WebElement img : images) {
//                String src = img.getAttribute("src");
//                System.out.println(src);
//                WebElement rect = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//img[@src='%s']",src))));               
//                rect.click();
//                Thread.sleep(300);
//            }
//            
//            WebElement selector=driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/pointer.svg']"));
//            selector.click();          
//            action.moveToElement(canvas, 0, 0).clickAndHold().moveByOffset(100,100).release().perform();
//            canvas.click();
//            action.moveByOffset(a,b).clickAndHold().moveToLocation(2,3).release().perform();
//            
//            
//            WebElement typer=driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/type.svg']"));
//            typer.click();
//            
//            action.moveToElement(canvas,2, 2).click().perform();
//            action.sendKeys("SUJOY RAY").perform();
//            Thread.sleep(400);
//            
//            
//            List<WebElement> coloring = driver.findElements(By.xpath("//div[@id='swatch-wrap']//div"));
//            
//            for (WebElement element : coloring) {
//                try {
//					element.click();
//					action.moveToElement(canvas,2, 4).click().perform();
//					Thread.sleep(300);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//            }
//            
//            
//            WebElement color=driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/bucket.svg']"));
//            color.click();
//            canvas.click();
//            
//            
//            
//            WebElement zoom=driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/zoom.svg']"));
//            zoom.click();
//            
//
//            String[] paths = {
//                    "//div[@class='zoom-preset active']",
//                    "//div[@class='settings-panel']/div[contains(.,'150%')]",
//                    "//div[@class='settings-panel']/div[contains(.,'200%')]",
//                    "//div[@class='settings-panel']/div[contains(.,'250%')]",
//                    "//div[@class='settings-panel']/div[contains(.,'300%')]"
//                };
//            
//            for (String i : paths) {
//                WebElement zoomValue=driver.findElement(By.xpath(i));
//                zoomValue.click();
//                Thread.sleep(300);
//                }
//            
//            
//            
//
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        } finally {
//        }
//    }
//}
//

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automator {
    public static void main(String[] args) {
        Random rand = new Random();
        System.setProperty("webdriver.chrome.driver", "/home/arclight/Coding/DEVops/chromedriver-linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://www.autodraw.com/");

            // Start Drawing button
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button green' and text()=' Start Drawing ']")));
            button.click();

            WebElement canvas = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("main-canvas")));
            int a = rand.nextInt(10);
            int b = rand.nextInt(10);

            // Draw random shapes
            action.moveToElement(canvas, a, b).clickAndHold()
                .moveByOffset(rand.nextInt(100), rand.nextInt(100))
                .moveByOffset(rand.nextInt(100), rand.nextInt(100))
                .moveByOffset(-rand.nextInt(100), rand.nextInt(100))
                .moveByOffset(rand.nextInt(100), -rand.nextInt(100))
                .moveByOffset(rand.nextInt(100), rand.nextInt(100))
                .release().perform();

            Thread.sleep(400);

            // Handle suggestions
            WebElement suggestionsPanel = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("autodraw-suggestions")));
            List<WebElement> images = suggestionsPanel.findElements(By.xpath(".//div[@class='thumbs']//img"));

            for (WebElement img : images) {
                String src = img.getAttribute("src");
                System.out.println(src);
                WebElement rect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//img[@src='%s']", src))));
                js.executeScript("arguments[0].scrollIntoView(true);", rect);
                js.executeScript("arguments[0].click();", rect);
                Thread.sleep(300);
            }

            // Select and move shapes
            WebElement selector = driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/pointer.svg']"));
            selector.click();
            action.moveToElement(canvas, 0, 0).clickAndHold().moveByOffset(100, 100).release().perform();
            canvas.click();
            action.moveByOffset(a, b).clickAndHold().moveByOffset(2, 3).release().perform();

            // Add text
            WebElement typer = driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/type.svg']"));
            typer.click();
            action.moveToElement(canvas, 2, 2).click().sendKeys("SUJOY RAY").perform();
            Thread.sleep(400);

            // Change colors
            List<WebElement> coloring = driver.findElements(By.xpath("//div[@id='swatch-wrap']//div"));
            for (WebElement element : coloring) {
                try {
                    element.click();
                    action.moveToElement(canvas, 2, 4).click().perform();
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Fill with color
            WebElement color = driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/bucket.svg']"));
            color.click();
            canvas.click();
            Thread.sleep(300);

            // Zoom functionality
            WebElement zoom = driver.findElement(By.xpath("//img[@src='/assets/images/icons/tools/zoom.svg']"));
            zoom.click();

            String[] paths = {
                "//div[@class='zoom-preset active']",
                "//div[@class='settings-panel']/div[contains(.,'150%')]",
                "//div[@class='settings-panel']/div[contains(.,'200%')]",
                "//div[@class='settings-panel']/div[contains(.,'250%')]",
                "//div[@class='settings-panel']/div[contains(.,'300%')]"
            };

            for (String path : paths) {
                WebElement zoomValue = driver.findElement(By.xpath(path));
                zoomValue.click();
                Thread.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}















