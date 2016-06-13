package origamiV2.origamiV2PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by umahaea on 6/13/16.
 */
public class DrawerPageObjects {

    public WebDriver driver;
    public AppiumDriver appium;

    public DrawerPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public DrawerPageObjects(AppiumDriver appium) {
        this.appium = appium;
    }

    public By toggleLeftDrawerLink = By.linkText("Toggle Left Drawer");
    public By toggleRightDrawerLink = By.linkText("Toggle Right Drawer");

    public By openLeftDrawerLink = By.linkText("Open Left Drawer");
    public By openRightDrawerLink = By.linkText("Open Right Drawer");

    public By closeLeftDrawerLink = By.linkText("Close Left Drawer");
    public By closeRightDrawerLink = By.linkText("Close Right Drawer");

    public By closeLeftDrawer = By.xpath("//div[@class='o-drawer-animated o-drawer o-drawer-left o-drawer-open']/a");
    public By closeRightDrawer = By.xpath("//div[@class='o-drawer-right o-drawer-animated o-drawer o-drawer-open']/a");

    public By leftDrawerOpened = By.xpath("//div[@class='o-drawer-animated o-drawer o-drawer-left o-drawer-open']");
    public By leftDrawerClosed = By.xpath("//div[@class='o-drawer-animated o-drawer o-drawer-left']");

    public By rightDrawerOpened = By.xpath("//div[@class='o-drawer-right o-drawer-animated o-drawer o-drawer-open']");
    public By rightDrawerClosed = By.xpath("//div[@class='o-drawer-right o-drawer-animated o-drawer']");

    public By useDataTargetButton=By.xpath("//button[@data-target='#drawer-example']");
}