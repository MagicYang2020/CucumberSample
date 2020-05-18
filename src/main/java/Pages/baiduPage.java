package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class baiduPage {
    
    @FindBy(how = How.ID, using = "kw")
    public WebElement searchBox;
    
    @FindBy(how = How.ID, using = "kw_tip")
    public WebElement searchText;
    
    @FindBy(how = How.ID, using = "su")
    public WebElement searchButton;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\'1\']/h3/a")
    public WebElement returnedResult;
}
