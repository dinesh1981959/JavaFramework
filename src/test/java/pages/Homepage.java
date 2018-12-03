package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import java.util.Iterator;
import java.util.List;

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

    @FindBy(xpath = "//div[@class='col-xs-9']/small[contains(text(),'Purple Camera')]")
    WebElement cartValidation;

    public void addToCart(String item,String category){
        List<WebElement> list= driver.findElements(By.xpath("//*[@id='app']/div/div[1]/div[2]/div[@class='col-sm-12']"));
        Iterator<WebElement>iterator=list.iterator();
        while(iterator.hasNext()){
            WebElement element=iterator.next();
            List<WebElement> header= element.findElements(By.tagName("h3"));
            for(WebElement testHeader: header){
                if(testHeader.getText().equals(category)){
                    List<WebElement> items= element.findElements(By.tagName("strong"));
                    for (int i=0;i<items.size();i++){
                        String selectItem=items.get(i).getText();
                        if (selectItem.equals(item)){
                            int a=++i;
                            driver.findElement(By.xpath("//*[@class='input-group-btn']/button[@type='button']/i[@class='fa fa-unsorted']")).click();
                            driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[2]/div[1]/li["+a+"]/button")).click();
                        }
                    }
                    break;
                }
            }
        }
    }

    public void cartValidation() throws InterruptedException {
        for (int i=0;i<10;i++){
            if(cartValidation.isDisplayed()){
                Assert.assertTrue(cartValidation.isDisplayed());
            }else
            {
                Thread.sleep(1000);
            }
        }
    }

}
