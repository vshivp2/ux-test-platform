package compounds.compoundsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class CalendarFunctionsPageObjects {
	public WebDriver driver;
    public AppiumDriver appium;

    public CalendarFunctionsPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public CalendarFunctionsPageObjects() {
        this.appium = appium;
    }
    
    public By dayOne=By.xpath(".//td[text()='8']");
    public By dayTwo=By.xpath(".//td[text()='16']");
    public By day = By.xpath(".//td[text()='9']");
    public By buttonLeft = By.xpath(".//button[1]");
    public By buttonRight = By.xpath(".//button[2]");
    public By mnthLabel = By.xpath(".//h3");
    
    public By monthLbl=By.xpath("//h3[@class='pe-calendar-month']");
    public By calendar=By.xpath("//div[@class='pe-calendar']");			
    public By calendar_table=By.xpath("//table[@class='pe-calendar-dates']");	
    public By dayLbl=By.xpath("//abbr[text()='M']/..");	
    public By crntMnthDate=By.xpath("//div[text()='15']/..");	
    public By crntMnthDateHih=By.xpath("//td[contains(@class,'pe-calendar-dates--highlighted')]");	
    public By crntMnthDateout=By.xpath("//td[contains(@class,'pe-calendar-dates--outside')]");	
    public By crntMnthDateslct=By.xpath("//td[contains(@class,'pe-calendar-dates--selected')]")	;
    public By crntMnthDatedis=By.id("curnt_mnth_day_dis");	//Not available
    public By iconLeft=By.xpath("//button[@class='pe-icon--chevron-left']")	;		
    public By iconRight=By.xpath("//button[@class='pe-icon--chevron-right']");	
    public By daySunday=By.xpath("//abbr[@title='Sunday']")	;	
    public By dayMonday=By.xpath("//abbr[@title='Monday']")	;	
    public By dayTuesday=By.xpath("//abbr[@title='Tuesday']");		
    public By dayWednesday=By.xpath("//abbr[@title='Wednesday']");		
    public By dayThursday=By.xpath("//abbr[@title='Thursday']");		
    public By dayFriday=By.xpath("	//abbr[@title='Friday']")	;
    public By daySaturday=By.xpath("//abbr[@title='Saturday']")	;

    
}
