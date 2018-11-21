package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.Random;

public class Homepage extends LoadableComponent<Homepage> {

    private WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void isLoaded() throws Error {
        // TODO Auto-generated method stub
    }

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    WebElement signIn;

    @FindBy(id = "ap_email")
    WebElement emailAddress;

    @FindBy(xpath = "//div[@id='auth-password-missing-alert']/div/div[@class='a-alert-content']")
    WebElement loginError;

    @FindBy(id = "signInSubmit")
    WebElement continueButton;



    public void signInButton() {
        signIn.click();
    }

    public void emailAddressInputField() {
        driver.findElement(By.cssSelector("h1[class='a-spacing-small']")).isDisplayed();
        Random rand = new Random();
        int value = rand.nextInt(100);
        emailAddress.sendKeys("testEmail"+value+"@mailinator.com");
        selectContinueButton();
    }

    public void accountLink() throws InterruptedException {
        WebElement link=driver.findElement(By.id("nav-link-yourAccount"));
        Actions action= new Actions(driver);
        action.moveToElement(link).build().perform();
        for (int i=1;i<10;i++) {
            if (signIn.isDisplayed()) {
                signInButton();
                break;
            } else {
                Thread.sleep(500);
            }
        }
    }

    public void selectContinueButton(){
        continueButton.click();
    }

    public void verifyLoginError(String errorMessage,String field){

        if(loginError.isDisplayed()){
            String ActualErrorMessage=loginError.getText();
            if (ActualErrorMessage.equals(errorMessage)){
                System.out.println("PASS: Error message displayed successfully for the "+field+" field");
                Assert.assertTrue(loginError.isDisplayed());
            }else{
                Assert.fail("In correct Error message displayed: "+ActualErrorMessage);
            }
        }
    }
}
