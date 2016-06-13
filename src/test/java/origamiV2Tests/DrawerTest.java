package origamiV2Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BaseClass;

/**
 * Created by umahaea on 6/10/16.
 */
public class DrawerTest extends BaseClass {

    private final String drawerUrl = "http://localhost:8000/src/main/java/origamiV2/fixtures/drawer/drawer.html";
    //private final String drawerUrl = "file:///Users/umahaea/Documents/workspace/ux-test-platform/src/main/java/origamiV2/fixtures/drawer/drawer.html";
    private boolean isDrawerOpened = false;

    final static Logger log = Logger.getLogger(DrawerTest.class.getName());

    //Open Drawer
    @DataProvider(name = "Open Drawer Test Data")
    public Object[][] getOpenDrawerTest() {
        return new Object[][]{
                {"left drawer", drawerPgObj.openLeftDrawerLink, drawerPgObj.leftDrawerOpened},
                {"right drawer", drawerPgObj.openRightDrawerLink, drawerPgObj.rightDrawerOpened}
        };
    }

    @Test(testName = "Open Drawer Test", dataProvider = "Open Drawer Test Data", groups = "desktop-ci")
    private void openDrawerTest(String drawerType, By drawerLinkElement, By drawerOpenStatusElement) throws Exception {
        commonUtils.getUrl(drawerUrl);
        commonUtils.click(drawerLinkElement);
        Thread.sleep(1000);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println("isDrawerOpened: " + isDrawerOpened);
        Assert.assertTrue(isDrawerOpened);
    }

    //Toggle Drawer
    @DataProvider(name = "Toggle Drawer Test Data")
    public Object[][] getToggleDrawerTest() {
        return new Object[][]{
                {"left drawer", drawerPgObj.openLeftDrawerLink, drawerPgObj.toggleLeftDrawerLink, drawerPgObj.closeLeftDrawerLink, drawerPgObj.leftDrawerOpened},
                {"right drawer", drawerPgObj.openRightDrawerLink, drawerPgObj.toggleRightDrawerLink, drawerPgObj.closeRightDrawerLink, drawerPgObj.rightDrawerOpened}
        };
    }

    @Test(testName = "Toggle Drawer Test", dataProvider = "Toggle Drawer Test Data", groups = "desktop-ci")
    private void toggleDrawerTest(String drawerType, By openDrawerLinkElement, By toggleDrawerLinkElement, By closeDrawerLinkElement, By drawerOpenStatusElement) throws Exception {
        commonUtils.getUrl(drawerUrl);
        commonUtils.click(openDrawerLinkElement);
        Thread.sleep(1000);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println(isDrawerOpened);
        Assert.assertTrue(isDrawerOpened);

        commonUtils.click(toggleDrawerLinkElement);
        Thread.sleep(1000);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println(isDrawerOpened);
        Assert.assertFalse(isDrawerOpened);

        commonUtils.click(toggleDrawerLinkElement);
        Thread.sleep(1000);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println(isDrawerOpened);
        Assert.assertTrue(isDrawerOpened);

        commonUtils.click(closeDrawerLinkElement);
        Thread.sleep(1000);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println(isDrawerOpened);
        Assert.assertFalse(isDrawerOpened);
    }

    //Close Drawer
    @DataProvider(name = "Close Drawer Test Data")
    public Object[][] getCloseDrawerTest() {
        return new Object[][]{
                {"left drawer", drawerPgObj.openLeftDrawerLink, drawerPgObj.closeLeftDrawerLink, drawerPgObj.leftDrawerOpened},
                {"right drawer", drawerPgObj.openRightDrawerLink, drawerPgObj.closeRightDrawerLink, drawerPgObj.rightDrawerOpened}
        };
    }

    @Test(testName = "Close Drawer Test", dataProvider = "Close Drawer Test Data", groups = "desktop-ci")
    private void closeDrawerTest(String drawerType, By openDrawerLinkElement, By closeDrawerLinkElement, By drawerOpenStatusElement) throws Exception {
        commonUtils.getUrl(drawerUrl);
        commonUtils.click(openDrawerLinkElement);
        Thread.sleep(1000);

        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println("isDrawerOpened: " + isDrawerOpened);
        Assert.assertTrue(isDrawerOpened);

        commonUtils.click(closeDrawerLinkElement);
        Thread.sleep(1000);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        System.out.println(isDrawerOpened);
        Assert.assertFalse(isDrawerOpened);
    }
}