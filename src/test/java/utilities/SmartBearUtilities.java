package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {
    /*
Mini-Task: • Create a method called loginToSmartBear
• This method simply logs in to SmartBear when you call it.
• Accepts WebDriver type as parameter
     */
    public static void login(WebDriver driver){
        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

    }
/*

• Method takes WebDriver object and String(name).
•Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether given name is in the list or not.
 */
    /*
    public static void verifyOrder(WebDriver driver, String name) {
       List<WebElement> names = driver.findElements(By.xpath("//div//td[2]"));
        String actualName = "";
        String expectedName = name;

        for (WebElement each : names ) {
            if (each.getText().equals(expectedName)) {
                actualName += each.getText();
            }
        }
          Assert.assertTrue(actualName.equals(expectedName));
      }
     */

    public static void verifyOrder (WebDriver driver, String name) {
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //iter command
        for (WebElement each : namesList) {
            if (each.getText().equals(name)) {
                Assert.assertTrue(true);
                return; //exit the whole method
                }
        }
        Assert.fail("The name does not exist in the list! Verification failed!");

    }

//Practice #5: Method: printNamesAndCities
// • Create a method named printNamesAndCities in SmartBearUtils class.
// • Method takes WebDriver object.
// • This method should simply print all the names in the List of All Orders.
// • Create a new TestNG test to test if the method is working as expected.
// • Output should be like:
// • Name1: name , City1: city
// • Name2: name , City2: city
/*
    public static void printNamesAndCities (WebDriver driver) {

        List<WebElement> names = driver.findElements(By.xpath("//table[@class = 'SampleTable']//td[2]" ) );
        List<WebElement> cities = driver.findElements(By.xpath("//table[@class = 'SampleTable']//td[7]") );

        int count = 1;
        int i = 0;
        for (WebElement each : names) {
            System.out.println("Name" +count+": " + each.getText() + ", " + ("City" + count+": "+cities.get(i).getText()) );
            count ++;
            i++;
        }

    }
    */
    public static void printNamesAndCities(WebDriver driver) {
        //The list where we store all the names in the web table
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //The list where we store all the cities in the web table
        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        //Instead of creating for-each loop, we will create regular for loop
        //because we can use the int i index number to get both names and cities values

        int count = 0;
        for (int i =0; i<namesList.size(); i++) {
            System.out.println("Name " + namesList.get(i).getText() +", Cities: " + citiesList.get(i).getText());

        }

    }

    //TC #11 : Create a method called removeName()
    // 1. Accepts two parameters: WebDriver, String name
    // 2. Method will remove the given name from the list of Smartbear
    // 3. Create a new TestNG test, and call your method.
    // 4. Assert that your method removed the given name

    public static void removeName(WebDriver driver, String name) {
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        List<WebElement> checkBox = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[1]"));
        WebElement delete = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']"));

        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).getText().equalsIgnoreCase(name)) {
                checkBox.get(i).click();
                delete.click();
                return;
            }
        }

    }

}






















