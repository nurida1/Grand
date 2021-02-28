import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Grand {

    WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(), 2);

    Actions actions; //u use actions in two Test, it can cause an issue, therefore outside the Test

    @Test
    public void GrandCoin() throws InterruptedException {
        //1. get our page
        Driver.getDriver().get("https://app.grandcoin.pro/r/RkX");
        //creating actions instance to be able to use its methods
        //  Driver.getDriver().manage().window().maximize();

        Actions actions = new Actions(Driver.getDriver());
        //2. sign in
        WebElement signIn = Driver.getDriver().findElement(By.linkText("Sign in"));
        signIn.click();
        Thread.sleep(2000);

        //3.login
        WebElement email = Driver.getDriver().findElement(By.id("inputEmail"));
        email.sendKeys("Lashesnoori@gmail.com");

        Thread.sleep(2000);
        WebElement password = Driver.getDriver().findElement(By.id("mat-input-7"));
        password.sendKeys("123456Nn");

        Thread.sleep(4000);
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//html/body/app-root/app-auth/div/app-login/mat-card/form/div/app-flat-button/button/span[1]/div[2]/span"));
        signInButton.click();

        Thread.sleep(30000);
        WebElement sideBar = Driver.getDriver().findElement(By.id("sidebar-toggle"));
        sideBar.click();

        Thread.sleep(2000);
        WebElement tasksButton = Driver.getDriver().findElement(By.xpath("/html/body/app-root/app-client/mat-sidenav-container/mat-sidenav[1]/div/mat-list/a[3]"));
        tasksButton.click();

        // click insta image
        //   /html/body/app-root/app-client/mat-sidenav-container/mat-sidenav-content/div[2]/app-tasks/div/div[2]/app-task/mat-card/a/mat-icon  broken image

        Thread.sleep(3000);
        WebElement image = Driver.getDriver().findElement(By.xpath("/html/body/app-root/app-client/mat-sidenav-container/mat-sidenav-content/div[2]/app-tasks/div/div[2]/app-task/mat-card/a/img"));
        image.click();

        Thread.sleep(3000);
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        //Switch to Insta:
        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains("https://www.instagram.com")) {
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://www.instagram.com"));
                break; //if matching it will assert and it will break the loop
            }
        }

        // login Instagram
        Thread.sleep(7000);
        WebElement loginInsta = Driver.getDriver().findElement(By.xpath("//*[@id='react-root']/section/nav/div[2]/div/div/div[3]/div/span/a[1]/button"));
        loginInsta.click();

        Thread.sleep(2000);
        WebElement emailInsta = Driver.getDriver().findElement(By.name("username"));
        emailInsta.sendKeys("noora_grand");

        Thread.sleep(2000);
        WebElement pwInsta = Driver.getDriver().findElement(By.name("password"));
        pwInsta.sendKeys("123456Nn");

        Thread.sleep(2000);
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//*[@id='loginForm']/div/div[3]/button"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        //do not save password
        Thread.sleep(8000);
        WebElement notSavePW = Driver.getDriver().findElement(By.xpath("//*[@id='react-root']/section/main/div/div/div/div/button"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(notSavePW));
        notSavePW.click();

        //like
        Thread.sleep(10000);
        WebElement like1 = Driver.getDriver().findElement(By.xpath("//span[@class='fr66n']"));
        like1.click();

        //comment
        //random comment
        Thread.sleep(8000);
        WebElement comment = Driver.getDriver().findElement(By.className("Ypffh"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(comment));
        comment.click();
        Thread.sleep(4000);
        comment = Driver.getDriver().findElement(By.className("Ypffh"));
        //generate random comment: https://www.edureka.co/community/34333/search-multiple-keywords-random-manner-using-selenium-java
        String str[] = {"Красота", "Grand", "Крипта", "Гранд", "Круто", "Класс",
                "Красота", "Здорово", "Интересно", "Отлично", "Супер", "Прекрасно",
                "Красиво", "Оригинально", "Превосходно", "Присоединяйся","Гранды",
                "Полезная_инфа", "Отличная_информация", "Счастье", "Супер_пост!",
                "Прекрасно_выглядишь!", "Очень_оригинально", "Поздравляю!", "Приглашаю_на_страницу!",
                "Приходи_в_проект!", "Приглашаю_в_проект!", "Приходите", "Присоединяйся_к_нам!", "Бизнесс_без_вложений"};

        int j[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,17,18, 19, 20,
                    21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        Random generator = new Random();
        int randomIndex = generator.nextInt(j.length);
        int k = j[randomIndex];

        try {
            if (comment.isDisplayed()) {
                comment.sendKeys(str[k]);
                Thread.sleep(5000);
                comment.sendKeys(Keys.ENTER);

            } else {
                // limited comments
                //unabled comments

                //close instagram page
                WebElement close = Driver.getDriver().findElement(By.xpath("/html/body"));
                Thread.sleep(4000);
                close.sendKeys(Keys.CONTROL+"w");

                //go back to gc and replace task
                Thread.sleep(10000);
                for (String each : windowHandles) {
                    Driver.getDriver().switchTo().window(each);
                    if (Driver.getDriver().getCurrentUrl().contains("https://app.grandtime.org/tasks")) {
                        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://app.grandtime.org/tasks"));
                        break; //if matching it will assert and it will break the loop
                    }
                }

                //3 dots
                ///html/body/app-root/app-client/mat-sidenav-container/mat-sidenav-content/div[2]/app-tasks/div/div[2]/app-task/mat-card/mat-card-header/div[3]/button/span[1]/mat-icon
                Thread.sleep(5000);
                WebElement threeDots = Driver.getDriver().findElement(By.xpath("//html/body/app-root/app-client/mat-sidenav-container/mat-sidenav-content/div[2]/app-tasks/div/div[2]/app-task/mat-card/mat-card-header/div[3]/button/span[1]/mat-icon"));
                threeDots.click();

                //replace button
                ////*[@id="mat-menu-panel-0"]/div/button[2]/span
                Thread.sleep(5000);
                WebElement replaceImage = Driver.getDriver().findElement(By.xpath("//*[@id='mat-menu-panel-0']/div/button[2]/span"));
                replaceImage.click();
            }

        } catch (Exception exception){
            System.out.println("Exception has been thrown.");
        }

        //To close instagram window  -- Not working
        Thread.sleep(4000);
        WebElement close = Driver.getDriver().findElement(By.xpath("/html/body"));
        Thread.sleep(4000);
        close.sendKeys(Keys.CONTROL+"w");

        //go back to GC
        Thread.sleep(10000);
        for (String each : windowHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains("https://app.grandtime.org/tasks")) {
                Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://app.grandtime.org/tasks"));
                break; //if matching it will assert and it will break the loop
            }
        }

        // check task
        WebElement checkTask = Driver.getDriver().findElement(By.xpath("/html/body/app-root/app-client/mat-sidenav-container/mat-sidenav-content/div[2]/app-tasks/div/div[2]/app-task/mat-card/app-flat-button/button/span[1]/div[2]/span"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(checkTask));
        checkTask.click();

        Thread.sleep(15000);

        for (int i = 0; i <50 ; i++) {

            Thread.sleep(15000);
            image.click();

            //Switch to Insta:
            Thread.sleep(3000);
            for (String each : windowHandles) {
                Driver.getDriver().switchTo().window(each);
                if (Driver.getDriver().getCurrentUrl().contains("https://www.instagram.com")) {
                    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://www.instagram.com"));
                    break; //if matching it will assert and it will break the loop
                }
            }

            //like
            Thread.sleep(8000);
            like1.click();

            //comment
            Thread.sleep(4000);
            explicitWait.until(ExpectedConditions.elementToBeClickable(comment));
            comment.click();
            Thread.sleep(4000);
            comment = Driver.getDriver().findElement(By.className("Ypffh"));
            comment.sendKeys(str[k]);
            Thread.sleep(5000);
            comment.sendKeys(Keys.ENTER);

            //To close instagram window  -- Not working
            Thread.sleep(4000);
            close.sendKeys(Keys.CONTROL,Keys.F4);

            //go back to GC
            Thread.sleep(5000);
            for (String each : windowHandles) {
                Driver.getDriver().switchTo().window(each);
                if (Driver.getDriver().getCurrentUrl().contains("https://app.grandtime.org/tasks")) {
                    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://app.grandtime.org/tasks"));
                    break; //if matching it will assert and it will break the loop
                }
            }

            // check task
            explicitWait.until(ExpectedConditions.elementToBeClickable(checkTask));
            checkTask.click();

        }

    }

    @Test
    public void instagram() throws InterruptedException {

        Driver.getDriver().get("https://www.instagram.com/p/CK9tB6kjSIc/");
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement like = Driver.getDriver().findElement(By.xpath("//span[@class='fr66n']"));
        like.click();

        Thread.sleep(2000);
        WebElement emailInsta = Driver.getDriver().findElement(By.name("username"));
        emailInsta.sendKeys("noora_grand");

        Thread.sleep(2000);
        WebElement pwInsta = Driver.getDriver().findElement(By.name("password"));
        pwInsta.sendKeys("123456Nn");

        WebElement loginInButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]/button/div"));
        explicitWait.until(ExpectedConditions.visibilityOf(loginInButton)).click();

        //Thread.sleep(5000);
        //WebElement like1 = Driver.getDriver().findElement(By.xpath("//span[@class='fr66n']"));
        //like1.click();

        //do not save password
        Thread.sleep(3000);
        WebElement notSavePW = Driver.getDriver().findElement(By.xpath("//*[@id='react-root']/section/main/div/div/div/div/button"));
        notSavePW.click();

        //comment
        Thread.sleep(4000);
        WebElement comment = Driver.getDriver().findElement(By.className("Ypffh"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(comment));
        comment.click();
        Thread.sleep(4000);
        comment = Driver.getDriver().findElement(By.className("Ypffh"));
        //generate random comment: https://www.edureka.co/community/34333/search-multiple-keywords-random-manner-using-selenium-java
        String str[] = {"Красота", "Grand", "Крипта", "Гранд", "Круто", "Класс", "Красота", "Здорово", "Интересно", "Отлично", "Супер", "Прекрасно", "Красиво", "Оригинально", "Превосходно", "Присоединяйся"};
        int j[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Random generator = new Random();
        int randomIndex = generator.nextInt(j.length);
        int k = j[randomIndex];
        comment.sendKeys(str[k]);
        Thread.sleep(5000);
        comment.sendKeys(Keys.ENTER);

    }

        //checkTask
    @Test
    public void checkTask() throws InterruptedException {

        Driver.getDriver().get("https://app.grandtime.org/tasks");
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement email = Driver.getDriver().findElement(By.id("inputEmail"));
        email.sendKeys("Lashesnoori@gmail.com");

        Thread.sleep(10000);
        WebElement password = Driver.getDriver().findElement(By.id("mat-input-1"));
        password.sendKeys("123456Nn");

        Thread.sleep(4000);
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//html/body/app-root/app-auth/div/app-login/mat-card/form/div/app-flat-button/button/span[1]/div[2]/span"));
        signInButton.click();

        WebElement checkTask = Driver.getDriver().findElement(By.xpath("/html/body/app-root/app-client/mat-sidenav-container/mat-sidenav-content/div[2]/app-tasks/div/div[2]/app-task/mat-card/app-flat-button/button/span[1]/div[2]/span"));
        explicitWait.until(ExpectedConditions.elementToBeClickable(checkTask));
        checkTask.click();
    }
}

