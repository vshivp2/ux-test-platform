package origamiV2Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BaseClass;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

/**
 * Created by umahaea on 6/10/16.
 */
public class DrawerTest extends BaseClass {

    private final String drawerUrl = "http://localhost:8000/src/main/java/origamiV2/fixtures/drawer/drawer.html";
    private boolean isDrawerOpened = false;
    private boolean isDrawerClosed = false;
    private String contentInDrawer="";
    private boolean isContentInDrawer=false;

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
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        Assert.assertTrue(isDrawerOpened);
    }

    //Toggle Drawer
    @DataProvider(name = "Toggle Drawer Test Data")
    public Object[][] getToggleDrawerTest() {
        return new Object[][]{
                {"left drawer", drawerPgObj.openLeftDrawerLink, drawerPgObj.toggleLeftDrawerLink, drawerPgObj.closeLeftDrawerLink, drawerPgObj.leftDrawerOpened, drawerPgObj.leftDrawerClosed},
                {"right drawer", drawerPgObj.openRightDrawerLink, drawerPgObj.toggleRightDrawerLink, drawerPgObj.closeRightDrawerLink, drawerPgObj.rightDrawerOpened, drawerPgObj.rightDrawerClosed}
        };
    }

    @Test(testName = "Toggle Drawer Test", dataProvider = "Toggle Drawer Test Data", groups = "desktop-ci")
    private void toggleDrawerTest(String drawerType, By openDrawerLinkElement, By toggleDrawerLinkElement, By closeDrawerLinkElement, By drawerOpenStatusElement, By drawerClosedStatusElement) throws Exception {
        commonUtils.getUrl(drawerUrl);

        commonUtils.click(openDrawerLinkElement);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        Assert.assertTrue(isDrawerOpened);

        commonUtils.click(toggleDrawerLinkElement);
        isDrawerClosed = commonUtils.isElementsVisibleOnPage(drawerClosedStatusElement);
        Assert.assertTrue(isDrawerClosed);

        commonUtils.click(toggleDrawerLinkElement);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        Assert.assertTrue(isDrawerOpened);

        commonUtils.click(closeDrawerLinkElement);
        isDrawerClosed = commonUtils.isElementsVisibleOnPage(drawerClosedStatusElement);
        Assert.assertTrue(isDrawerClosed);
    }

    //Close Drawer
    @DataProvider(name = "Close Drawer Test Data")
    public Object[][] getCloseDrawerTest() {
        return new Object[][]{
                {"left drawer", drawerPgObj.openLeftDrawerLink, drawerPgObj.closeLeftDrawerLink, drawerPgObj.leftDrawerOpened, drawerPgObj.leftDrawerClosed},
                {"right drawer", drawerPgObj.openRightDrawerLink, drawerPgObj.closeRightDrawerLink, drawerPgObj.rightDrawerOpened, drawerPgObj.rightDrawerClosed}
        };
    }

    @Test(testName = "Close Drawer Test", dataProvider = "Close Drawer Test Data", groups = "desktop-ci")
    private void closeDrawerTest(String drawerType, By openDrawerLinkElement, By closeDrawerLinkElement, By drawerOpenStatusElement, By drawerClosedStatusElement) throws Exception {
        commonUtils.getUrl(drawerUrl);

        commonUtils.click(openDrawerLinkElement);
        isDrawerOpened = commonUtils.isElementPresent(drawerOpenStatusElement);
        Assert.assertTrue(isDrawerOpened);

        commonUtils.click(closeDrawerLinkElement);
        isDrawerClosed = commonUtils.isElementPresent(drawerClosedStatusElement);
        Assert.assertFalse(isDrawerClosed);
    }

    //User data-target
    @Test(testName = "Use Data Target Test", groups = "desktop-ci")
    private void useDataTargetForDrawerTest() throws Exception {
        String text="Using data-target instead of href.";
        commonUtils.getUrl(drawerUrl);

        commonUtils.click(drawerPgObj.useDataTargetButton);
        isDrawerOpened = commonUtils.isElementPresent(drawerPgObj.rightDrawerOpened);
        Assert.assertTrue(isDrawerOpened);
        contentInDrawer=commonUtils.getText(drawerPgObj.rightDrawerOpened);
        isContentInDrawer = commonUtils.assertValue(contentInDrawer,text,"Error: Data Target is not working as per the spec");
        Assert.assertTrue(isContentInDrawer);
    }

    @BeforeMethod(alwaysRun = true)
    private void beforeMethod(Method method) throws Exception {
        System.out.println("Test Method----> " + this.getClass().getSimpleName() + "::" + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    private void afterMethod() {
        System.out.println("_________________________________________________");
    }
}