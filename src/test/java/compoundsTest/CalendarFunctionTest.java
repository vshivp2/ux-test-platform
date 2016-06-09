package compoundsTest;

import java.io.File;


import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import utilities.BaseClass;

public class CalendarFunctionTest extends BaseClass {
	private final String url = "http://localhost:8000/#/components/calendar";
	private String inputFilePath = "http://54.209.35.224/#/components/calendar";
	private String localUrl = new File(inputFilePath).getAbsolutePath();
	private static String env;
	private static String mobileDevice;
	private static String setMobile;
	private static String browser;
	private static String mBrowser;
	String fetchCharacter;
	String content;
	String actualContent;
	String code;
	boolean result= false;
	boolean resultOne= false;
	boolean resultTwo= false;
	boolean resultThree = false;
	final static Logger log = Logger.getLogger(CalendarFunctionTest.class.getName());
	int count = 1;

	@Parameters({ "runEnv", "mobile", "mobDeviceName", "sauceBrowser", "mobBrowser" })
	@BeforeClass(alwaysRun = true)
	private void TypographyTestBeforeClass(String runEnv, String mobile, String mobDeviceName, String sauceBrowser,
			String mobBrowser) {
		env = runEnv;
		mobileDevice = mobDeviceName;
		browser = sauceBrowser;
		mBrowser = mobBrowser;
		setMobile = mobile;
	}

	private void chooseEnv() {
		if (env.equals("sauce")) {
			commonUtils.getUrl(url);
		} else {
			commonUtils.getUrl("http://54.209.35.224/#/components/calendar");
		}
	}

	/*************************************** DeskTop *****************************/
	// Feature: Highlight Test
	@DataProvider(name = "Highlight Test")
	private Object[][] getHighlightTestData() {
		return new Object[][] {
				{ clndrFuncPgObj.dayOne,clndrFuncPgObj.day,clndrFuncPgObj.dayTwo, "#107aca", "#9dc0db", }

		};
	}

	@Test(enabled = true, testName = "Highlight Test", dataProvider = "Highlight Test", groups = { "desktop" })
	private void HighlightTest(By elementOne, By element, By elementTwo, String slctdColor, String hgltColor)
			throws InterruptedException {
		chooseEnv();
		result = verifyColor(elementOne, element, elementTwo, slctdColor, hgltColor);
		Assert.assertTrue(result);
	}

	// Feature: Month Label Test
	@DataProvider(name = "MonthLabel Test")
	private Object[][] getMonthLabelTestData() {
		return new Object[][] { { clndrFuncPgObj.buttonLeft, 12, "May 2015" },
				{ clndrFuncPgObj.buttonRight, 12, "July 2017" }, { clndrFuncPgObj.buttonLeft, 3, "February 2016" },
				{ clndrFuncPgObj.buttonLeft, 1, "April 2016" }

		};
	}

	@Test(enabled = true, testName = "Month Label Test", dataProvider = "MonthLabel Test", groups = { "desktop" })
	private void MonthLabelTest(By element, int count, String text) throws InterruptedException {
		chooseEnv();
		result = verifyMonth(element, count, text);
		Assert.assertTrue(result);
	}

	/*// Feature: Spacing Test
	@DataProvider(name = "SpacingTestData")
	private Object[][] getSpacingTestData() {
		return new Object[][] { { clndrPgObj.calendar, "20px" }

		};
	}

	// Spacing Test-1
	@Test(enabled = true, testName = "Calendar Spacing Test", dataProvider = "SpacingTestData", groups = { "desktop" })
	private void SpacingTest(By element, String padding) {
		chooseEnv();
		result = verifySpace(element, padding);
		Assert.assertTrue(result);
	}

	@DataProvider(name = "DaySpacingTestData")
	private Object[][] getDaySpacingTestData() {
		return new Object[][] { { clndrPgObj.dayLbl, "1px 1px" }, { clndrPgObj.crntMnthDate, "1px 1px" },
				{ clndrPgObj.crntMnthDateHih, "1px 1px" }, { clndrPgObj.crntMnthDatedis, "1px 1px" },
				{ clndrPgObj.crntMnthDateout, "1px 1px" }, { clndrPgObj.crntMnthDateslct, "1px 1px" } };
	}

	// Spacing Test-2
	@Test(enabled = true, testName = "Calendar Spacing Test", dataProvider = "DaySpacingTestData", groups = {
			"desktop" })
	private void DaySpacingTest(By element, String paddingArndDte) {
		chooseEnv();
		result = verifySpaceBtwn(element, paddingArndDte);
		Assert.assertTrue(result);
	}

	// Feature: Month Label Test
	@DataProvider(name = "LabelTestData")
	private Object[][] getLabelTestData() {
		return new Object[][] {
				{ clndrPgObj.monthLbl, new String[] { "21.93px", "22px" }, "28px", "#231F20", "50px" } };
	}

	// Label Test-1
	@Test(enabled = true, testName = "Month label Test", dataProvider = "LabelTestData", groups = { "desktop" })
	private void LabelTest(By element, String[] txtSize, String lnHieght, String fntColor, String lblHeight) {
		chooseEnv();
		result = verifyLabel(element, txtSize, lnHieght, fntColor, lblHeight);
		Assert.assertTrue(result);
	}

	// Feature: Day Label Test
	@DataProvider(name = "DayLabelTestData")
	private Object[][] getDayLabelTestData() {
		return new Object[][] { { clndrPgObj.dayLbl, "16px", "18px", "#231F20", "12px" }, };
	}

	// Day Label Test-1
	@Test(enabled = true, testName = "Day label Test", dataProvider = "DayLabelTestData", groups = { "desktop" })
	private void DayLabelTest(By element, String txtSize, String lnHieght, String fntColor, String padBottom) {
		chooseEnv();
		result = verifyDayLabel(element, txtSize, lnHieght, fntColor, padBottom);
		Assert.assertTrue(result);
	}

	// Feature: Border Test
	@DataProvider(name = "BorderTestData")
	private Object[][] getBorderTestData() {
		return new Object[][] { { clndrPgObj.calendar, "1px", "#D0D0D0", "50px", "20px", "20px" }, };
	}

	// Border Test-1
	@Test(enabled = true, testName = "Border Test", dataProvider = "BorderTestData", groups = { "desktop" })
	private void BorderTest(By element, String brdrSize, String brdrColor, String brdrHeight, String leftPadding,
			String rightPadding) {
		chooseEnv();
		result = verifyBorder(element, brdrSize, brdrColor, brdrHeight, leftPadding, rightPadding);
		Assert.assertTrue(result);
	}

	// Feature: Date Test
	@DataProvider(name = "DateTestData")
	private Object[][] getDateTestData() {
		return new Object[][] { { clndrPgObj.crntMnthDate, "16px", "18px" },
				{ clndrPgObj.crntMnthDatedis, "16px", "18px" }, { clndrPgObj.crntMnthDateHih, "16px", "18px" },
				{ clndrPgObj.crntMnthDateout, "16px", "18px" }, { clndrPgObj.crntMnthDateslct, "16px", "18px" }, };
	}

	// Date Test-1
	@Test(enabled = true, testName = "Date Test", dataProvider = "DateTestData", groups = { "desktop" })
	private void DateTest(By element, String txtSize, String lnHeight) {
		chooseEnv();
		result = verifyDate(element, txtSize, lnHeight);
		Assert.assertTrue(result);
	}

	// Feature: Size Test
	@DataProvider(name = "SizeTestData")
	private Object[][] getSizeTestData() {
		return new Object[][] { { clndrPgObj.crntMnthDate, new String[] { "35px" }, new String[] { "40px" } },
				{ clndrPgObj.crntMnthDatedis, new String[] { "35px" }, new String[] { "40px" } },
				{ clndrPgObj.crntMnthDateHih, new String[] { "35px" }, new String[] { "40px" } },
				{ clndrPgObj.crntMnthDateout, new String[] { "35px" }, new String[] { "40px" } },
				{ clndrPgObj.crntMnthDateslct, new String[] { "35px" }, new String[] { "40px" } },

		};
	}

	// size Test-1
	@Test(enabled = true, testName = "Size Test", dataProvider = "SizeTestData", groups = { "desktop" })
	private void SizeTest(By element, String[] hieght, String[] width) {
		chooseEnv();
		result = verifySize(element, hieght, width);
		Assert.assertTrue(result);
	}

	// Calender States Test

	// Feature:State Test
	@DataProvider(name = "StateTestData")
	private Object[][] getStateTestData() {
		return new Object[][] { { clndrPgObj.crntMnthDate, "#F8F8F8", "#231F20" },
				{ clndrPgObj.crntMnthDateout, "#FFFFFF", "#231F20" },
				{ clndrPgObj.crntMnthDatedis, "#E6E6E6", "#A6A8AB" },
				{ clndrPgObj.crntMnthDateHih, "#9DC0DB", "#231F20" }, };
	}

	// size Test-1
	@Test(enabled = true, testName = "State Test", dataProvider = "StateTestData", groups = { "desktop" })
	private void StateTest(By element, String bckColor, String txtColor) {
		chooseEnv();
		result = verifyState(element, bckColor, txtColor);
		Assert.assertTrue(result);
	}

	// Feature:Hover State Test
	@DataProvider(name = "HoverStateTestData")
	private Object[][] getHoverStateTestData() {
		return new Object[][] { { clndrPgObj.crntMnthDate, clndrPgObj.calendar, "#0C5D99", "#FFFFFF" }, };
	}

	// size Test-2
	@Test(enabled = true, testName = "Hover State Test", dataProvider = "HoverStateTestData", groups = { "desktop" })
	private void HoverStateTest(By element, By element2, String bckColor, String txtColor) {
		chooseEnv();
		result = verifyHoverState(element, element2, bckColor, txtColor);
		Assert.assertTrue(result);
	}

	// Feature:Hover Month Control Test
	@DataProvider(name = "HoverMonthControlData")
	private Object[][] getHoverMonthControlData() {
		return new Object[][] { { clndrPgObj.iconLeft, "February" }, { clndrPgObj.iconRight, "April" }, };
	}

	// Hover Month Control Test
	@Test(enabled = true, testName = "Hover Month Control Test", dataProvider = "HoverMonthControlData", groups = {
			"desktop" })
	private void HoverMonthControlTest(By element, String txtMonth) {
		chooseEnv();
		result = verifyHoverMonthControl(element, txtMonth);
		Assert.assertTrue(result);
	}

	// Feature:Days of Week Test
	@DataProvider(name = "DaysOfWeekTestData")
	private Object[][] getDaysOfWeekTestData() {
		return new Object[][] { { clndrPgObj.daySunday, "Sunday", "S" }, { clndrPgObj.dayMonday, "Monday", "M" },
				{ clndrPgObj.dayTuesday, "Tuesday", "T" }, { clndrPgObj.dayWednesday, "Wednesday", "W" },
				{ clndrPgObj.dayThursday, "Thursday", "T" }, { clndrPgObj.dayFriday, "Friday", "F" },
				{ clndrPgObj.daySaturday, "Saturday", "S" }, };
	}

	// Days of Week Test
	@Test(enabled = true, testName = "Days Of Week Test", dataProvider = "DaysOfWeekTestData", groups = { "desktop" })
	private void DaysOfWeekTest(By element, String day, String txtDay) {
		chooseEnv();
		result = verifyDaysOfWeek(element, day, txtDay);
		Assert.assertTrue(result);
	}*/

	/********************** Mobile ********************************************************/
	@DataProvider(name = "HighlightMobile Test")
	private Object[][] getHighlightMobileTestData() {
		return new Object[][] {
				{ ScreenOrientation.LANDSCAPE, clndrFuncPgObj.dayOne, clndrFuncPgObj.day, clndrFuncPgObj.dayTwo,
						"#107aca", "#9dc0db", },
				{ ScreenOrientation.PORTRAIT, clndrFuncPgObj.dayOne, clndrFuncPgObj.day, clndrFuncPgObj.dayTwo,
						"#107aca", "#9dc0db", }

		};
	}

	// Feature: Highlight Test
	@Test(enabled = true, testName = "HighlightMobile Test", dataProvider = "HighlightMobile Test", groups = {
			"mobile" })
	private void HighlightMobileTest(ScreenOrientation mode, By elementOne, By element, By elementTwo,
			String slctdColor, String hgltColor) throws InterruptedException {
		commonUtils.getUrl(url, "mobile");
		appium.rotate(mode);
		System.out.println("llllllllllllllllllllllll");
		result = verifyColor(elementOne, element, elementTwo, slctdColor, hgltColor, "mobile");
		Assert.assertTrue(result);
	}

	// Feature: Month Label Test
	@DataProvider(name = "MonthLabelMobile Test")
	private Object[][] getMonthLabelMobileTestData() {
		return new Object[][] { { ScreenOrientation.LANDSCAPE, clndrFuncPgObj.buttonLeft, 12, "May 2015" },
				{ ScreenOrientation.LANDSCAPE, clndrFuncPgObj.buttonRight, 12, "July 2017" },
				{ ScreenOrientation.LANDSCAPE, clndrFuncPgObj.buttonLeft, 3, "February 2016" },
				{ ScreenOrientation.LANDSCAPE, clndrFuncPgObj.buttonLeft, 1, "April 2016" },
				{ ScreenOrientation.PORTRAIT, clndrFuncPgObj.buttonLeft, 12, "May 2015" },
				{ ScreenOrientation.PORTRAIT, clndrFuncPgObj.buttonRight, 12, "July 2017" },
				{ ScreenOrientation.PORTRAIT, clndrFuncPgObj.buttonLeft, 3, "February 2016" },
				{ ScreenOrientation.PORTRAIT, clndrFuncPgObj.buttonLeft, 1, "April 2016" }

		};
	}

	@Test(enabled = true, testName = "Month Label Mobile Test", dataProvider = "MonthLabelMobile Test", groups = {
			"mobile" })
	private void MonthLabelMobileTest(ScreenOrientation mode, By element, int count, String text)
			throws InterruptedException {
		commonUtils.getUrl(url, "mobile");
		appium.rotate(mode);
		result = verifyMonth(element, count, text, "mobile");
		Assert.assertTrue(result);
	}

	/*************
	 * Common methods
	 * 
	 * @throws InterruptedException
	 ************/

	public boolean verifyColor(By elementOne, By element, By elementTwo, String slctdColor, String hgltColor)
			throws InterruptedException {
		commonUtils.click(elementOne);
		commonUtils.click(elementTwo);

		String actlhgltColor = commonUtils.getCSSValue(element, "background-color");
		String actlSlctColorOne = commonUtils.getCSSValue(elementOne, "background-color");
		String actlSlctColorTwo = commonUtils.getCSSValue(elementTwo,"background-color" );
		 resultOne = commonUtils.assertValue(actlhgltColor, commonUtils.hex2Rgb(hgltColor),
				element + " - Background color is not as in spec");
		 resultTwo = commonUtils.assertValue(actlSlctColorOne, commonUtils.hex2Rgb(slctdColor),
				element + " - Background color is not as in spec");
		 resultThree =commonUtils.assertValue(actlSlctColorTwo, commonUtils.hex2Rgb(slctdColor),
					element + " - Background color is not as in spec");
		if (resultOne == true && resultTwo == true && resultThree == true) 
			return true;
		else
			return false;

	}

	public boolean verifyColor(By elementOne, By element, By elementTwo, String slctdColor, String hgltColor,
			String device) throws InterruptedException {
		System.out.println("llllllllllllllllllllllll");
		commonUtils.click(elementOne, device);
		commonUtils.click(elementTwo, device);
		System.out.println("llllllllllllllllllllllll");
		String actlhgltColor = commonUtils.getCSSValue(element, "background-color", device);
		String slcthgltColorOne = commonUtils.getCSSValue(elementOne, "background-color", device);
		String slcthgltColorTwo = commonUtils.getCSSValue(elementTwo, "background-color", device);
		System.out.println("llllllllllllllllllllllll");
		 resultOne = commonUtils.assertValue(actlhgltColor, commonUtils.hex2Rgb(hgltColor),
				element + " - Background color is not as in spec");
		 resultTwo = commonUtils.assertValue(slcthgltColorOne, commonUtils.hex2Rgb(slctdColor),
				element + " - Background color is not as in spec");
		 resultTwo = commonUtils.assertValue(slcthgltColorTwo, commonUtils.hex2Rgb(slctdColor),
					element + " - Background color is not as in spec");
		if (resultOne == true && resultTwo == true && resultThree == true)
			result = true;
		else
			result = false;
		System.out.println("llllllllllllllllllllllll");
		return result;

	}

	public boolean verifyMonth(By element, int count, String text) {
		driver.navigate().refresh();
		for (int x = 0; x <= count; x++) {
			commonUtils.click(element);
		}
		String actText = commonUtils.getText(clndrFuncPgObj.mnthLabel);

		result = commonUtils.assertValue(actText, text, "Text is Not as expected");

		return result;
	}

	public boolean verifyMonth(By element, int count, String text, String device) {
		driver.navigate().refresh();
		for (int x = 0; x <= count; x++) {
			commonUtils.click(element, device);
		}
		String actText = commonUtils.getText(clndrFuncPgObj.mnthLabel, device);

		result = commonUtils.assertValue(actText, text, "Text is Not as expected");

		return result;
	}

	public boolean verifySpace(By element, String paddingArndDate) {
		String actlPaddingArndDate = commonUtils.getCSSValue(element, "padding-right");
		boolean result = commonUtils.assertValue(actlPaddingArndDate, paddingArndDate,
				element + " - Padding is not as in spec");
		return result;
	}

	public boolean verifySpace(By element, String paddingArndDate, String device) {
		String actlPaddingArndDate = commonUtils.getCSSValue(element, "padding-right", device);
		boolean result = commonUtils.assertValue(actlPaddingArndDate, paddingArndDate,
				element + " - Padding is not as in spec");
		return result;
	}

	public boolean verifySpaceBtwn(By element, String paddingArndDate) {
		String actlPaddingArndDate = commonUtils.getCSSValue(element, "border-spacing");
		boolean result = commonUtils.assertValue(actlPaddingArndDate, paddingArndDate,
				element + " - border-spacing is not as in spec");
		return result;
	}

	public boolean verifySpaceBtwn(By element, String paddingArndDate, String device) {
		String actlPaddingArndDate = commonUtils.getCSSValue(element, "border-spacing", device);
		boolean result = commonUtils.assertValue(actlPaddingArndDate, paddingArndDate,
				element + " - border-spacing is not as in spec");
		return result;
	}

	public boolean verifyLabel(By element, String[] txtSize, String lnHieght, String fntColor, String lblHeight) {
		String actltxtsize = commonUtils.getCSSValue(element, "font-size");
		String actlnHeight = commonUtils.getCSSValue(element, "line-height");
		String actlfntColor = commonUtils.getCSSValue(element, "color");

		boolean result1 = commonUtils.assertCSSProperties(element + " - Font Size is not as in spec", actltxtsize,
				txtSize);
		boolean result2 = commonUtils.assertValue(actlnHeight, lnHieght, element + " - Line Height is not as in spec");
		boolean result3;
		if (browser.equals("edge")) {
			result3 = commonUtils.assertValue(actlfntColor, commonUtils.hex2RgbWithoutTransparency(fntColor),
					element + " - Font color is not as in spec");
		} else {
			result3 = commonUtils.assertValue(actlfntColor, commonUtils.hex2Rgb(fntColor),
					element + " - Font color is not as in spec");
		}

		if (result1 == true && result2 == true && result3 == true)
			result = true;
		else
			result = false;
		return result;
	}

	public boolean verifyLabel(By element, String txtSize, String lnHieght, String fntColor, String lblHeight,
			String device) {
		String actltxtsize = commonUtils.getCSSValue(element, "font-size", device);
		String actlnHeight = commonUtils.getCSSValue(element, "line-height", device);
		String actlfntColor = commonUtils.getCSSValue(element, "color", device);

		boolean result1 = commonUtils.assertValue(actltxtsize, txtSize, element + " - Font Size is not as in spec");
		boolean result2 = commonUtils.assertValue(actlnHeight, lnHieght, element + " - Line Height is not as in spec");
		boolean result3 = commonUtils.assertValue(actlfntColor, commonUtils.hex2Rgb(fntColor),
				element + " - Font color is not as in spec");

		if (result1 == true && result2 == true && result3 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyDayLabel(By element, String txtSize, String lnHieght, String fntColor, String padBottom) {
		String actltxtsize = commonUtils.getCSSValue(element, "font-size");
		String actlnHeight = commonUtils.getCSSValue(element, "line-height");
		String actlfntColor = commonUtils.getCSSValue(element, "color");
		String actlpadBottom = commonUtils.getCSSValue(element, "padding-bottom");

		boolean result1 = commonUtils.assertValue(actltxtsize, txtSize, element + " - Font Size is not as in spec");
		boolean result2 = commonUtils.assertValue(actlnHeight, lnHieght, element + " - Line Height is not as in spec");
		boolean result3;
		if (browser.equals("edge")) {
			result3 = commonUtils.assertValue(actlfntColor, commonUtils.hex2RgbWithoutTransparency(fntColor),
					element + " - Font color is not as in spec");
		} else {
			result3 = commonUtils.assertValue(actlfntColor, commonUtils.hex2Rgb(fntColor),
					element + " - Font color is not as in spec");
		}

		boolean result4 = commonUtils.assertValue(actlpadBottom, padBottom,
				element + " - Padding Bottom is not as in spec");

		if (result1 == true && result2 == true && result3 == true && result4 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyDayLabel(By element, String txtSize, String lnHieght, String fntColor, String padBottom,
			String device) {
		String actltxtsize = commonUtils.getCSSValue(element, "font-size", device);
		String actlnHeight = commonUtils.getCSSValue(element, "line-height", device);
		String actlfntColor = commonUtils.getCSSValue(element, "color", device);
		String actlfntpadBottom = commonUtils.getCSSValue(element, "padding-bottom", device);

		boolean result1 = commonUtils.assertValue(actltxtsize, txtSize, element + " - Font Size is not as in spec");
		boolean result2 = commonUtils.assertValue(actlnHeight, lnHieght, element + " - Line Height is not as in spec");
		boolean result3 = commonUtils.assertValue(actlfntColor, commonUtils.hex2Rgb(fntColor),
				element + " - Font color is not as in spec");
		boolean result4 = commonUtils.assertValue(actlfntpadBottom, padBottom,
				element + " - Padding-Bottom is not as in spec");

		if (result1 == true && result2 == true && result3 == true && result4 == true)
			result = true;
		else
			result = false;
		return result;

	}

	private boolean verifyBorder(By element, String brdrSize, String brdrColor, String brdrHeight, String leftPadding,
			String rightPadding) {
		String actborder = commonUtils.getCSSValue(element, "border-top-width");
		String actbrdrColor = commonUtils.getCSSValue(element, "border-left-color");
		String actbrdrHeight = commonUtils.getCSSValue(element, "line-height");
		String actbrdrLeftPadding = commonUtils.getCSSValue(element, "padding-left");
		String actbrdrRightPadding = commonUtils.getCSSValue(element, "padding-right");

		boolean result1 = commonUtils.assertValue(actborder, brdrSize, element + " - Line Height is not as in spec");

		boolean result2;
		if (browser.equals("edge")) {
			result2 = commonUtils.assertValue(actbrdrColor, commonUtils.hex2RgbWithoutTransparency(brdrColor),
					element + " - Border left color is not as in spec");
		} else {
			result2 = commonUtils.assertValue(actbrdrColor, commonUtils.hex2Rgb(brdrColor),
					element + " - Border left color is not as in spec");
		}

		boolean result3 = commonUtils.assertValue(actbrdrHeight, brdrHeight, element + " - Height is not as in spec");
		boolean result4 = commonUtils.assertValue(actbrdrLeftPadding, leftPadding,
				element + " - Padding Left is not as in spec");
		boolean result5 = commonUtils.assertValue(actbrdrRightPadding, rightPadding,
				element + " - Padding Right is not as in spec");

		if (result1 == true && result2 == true && result3 == true && result4 == true && result5 == true)
			result = true;
		else
			result = false;
		return result;

	}

	private boolean verifyBorder(By element, String brdrSize, String brdrColor, String brdrHeight, String leftPadding,
			String rightPadding, String device) {
		String actborder = commonUtils.getCSSValue(element, "border-top-width", device);
		String actbrdrColor = commonUtils.getCSSValue(element, "border-left-color", device);
		String actbrdrHeight = commonUtils.getCSSValue(element, "line-height", device);
		String actbrdrLeftPadding = commonUtils.getCSSValue(element, "padding-left", device);
		String actbrdrRightPadding = commonUtils.getCSSValue(element, "padding-right", device);

		boolean result1 = commonUtils.assertValue(actborder, brdrSize, element + " - Line Height is not as in spec");
		boolean result2 = commonUtils.assertValue(actbrdrColor, commonUtils.hex2Rgb(brdrColor),
				element + " - Font color is not as in spec");
		boolean result3 = commonUtils.assertValue(actbrdrHeight, brdrHeight, element + " - Height is not as in spec");
		boolean result4 = commonUtils.assertValue(actbrdrLeftPadding, leftPadding,
				element + " - Padding Left is not as in spec");
		boolean result5 = commonUtils.assertValue(actbrdrRightPadding, rightPadding,
				element + " - Padding Right is not as in spec");

		if (result1 == true && result2 == true && result3 == true && result4 == true && result5 == true)
			result = true;
		else
			result = false;
		return result;

	}

	private boolean verifyDate(By element, String txtSize, String lnHeight) {
		String actltxtsize = commonUtils.getCSSValue(element, "font-size");
		String actlnHeight = commonUtils.getCSSValue(element, "line-height");

		boolean result1 = commonUtils.assertValue(actltxtsize, txtSize, element + " - Font Size is not as in spec");
		boolean result2 = commonUtils.assertValue(actlnHeight, lnHeight, element + " - Line Height is not as in spec");

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyDate(By element, String txtSize, String lnHeight, String device) {
		String actltxtsize = commonUtils.getCSSValue(element, "font-size", device);
		String actlnHeight = commonUtils.getCSSValue(element, "line-height", device);

		boolean result1 = commonUtils.assertValue(actltxtsize, txtSize, element + " - Font Size is not as in spec");
		boolean result2 = commonUtils.assertValue(actlnHeight, lnHeight, element + " - Line Height is not as in spec");

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifySize(By element, String[] hieght, String[] width) {
		String acthieght = commonUtils.getCSSValue(element, "height");
		String actnwidth = commonUtils.getCSSValue(element, "width");

		boolean result1 = commonUtils.assertCSSProperties(element + " - Line-Height is not as in spec", acthieght,
				hieght);
		boolean result2 = commonUtils.assertCSSProperties(element + " - Width  is not as in spec", actnwidth, width);

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifySize(By element, String[] hieght, String[] width, String device) {
		String acthieght = commonUtils.getCSSValue(element, "height", device);
		String actnwidth = commonUtils.getCSSValue(element, "width", device);

		boolean result1 = commonUtils.assertCSSProperties(element + " - Height is not as in spec", acthieght, hieght);
		boolean result2 = commonUtils.assertCSSProperties(element + " - Width  is not as in spec", actnwidth, width);

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyState(By element, String bckColor, String txtColor) {
		String actbckColor = commonUtils.getCSSValue(element, "background-color");
		String acttxtColor = commonUtils.getCSSValue(element, "color");

		boolean result1;
		if (browser.equals("edge")) {
			result1 = commonUtils.assertValue(acttxtColor, commonUtils.hex2RgbWithoutTransparency(txtColor),
					element + " - Text color is not as in spec");
		} else {
			result1 = commonUtils.assertValue(acttxtColor, commonUtils.hex2Rgb(txtColor),
					element + " - Text color is not as in spec");
		}

		boolean result2;
		if (browser.equals("edge")) {
			result2 = commonUtils.assertValue(actbckColor, commonUtils.hex2RgbWithoutTransparency(bckColor),
					element + " - Background color  is not as in spec");
		} else {
			result2 = commonUtils.assertValue(actbckColor, commonUtils.hex2Rgb(bckColor),
					element + " - Background color  is not as in spec");
		}

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyState(By element, String bckColor, String txtColor, String device) {
		String actbckColor = commonUtils.getCSSValue(element, "background-color", device);
		String acttxtColor = commonUtils.getCSSValue(element, "color", device);

		boolean result1 = commonUtils.assertValue(acttxtColor, commonUtils.hex2Rgb(txtColor),
				element + " - Text color is not as in spec");
		boolean result2 = commonUtils.assertValue(actbckColor, commonUtils.hex2Rgb(bckColor),
				element + " - Background color  is not as in spec");

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyHoverState(By element, By element2, String bckColor, String txtColor) {
		commonUtils.hoverOnElement(element);
		String actbckColor = commonUtils.getCSSValue(element, "background-color");
		String acttxtColor = commonUtils.getCSSValue(element, "color");
		commonUtils.hoverOnElement(element2);

		boolean result1;
		if (browser.equals("edge")) {
			result1 = commonUtils.assertValue(acttxtColor, commonUtils.hex2RgbWithoutTransparency(txtColor),
					element + " - Text color is not as in spec");
		} else {
			result1 = commonUtils.assertValue(acttxtColor, commonUtils.hex2Rgb(txtColor),
					element + " - Text color is not as in spec");
		}

		boolean result2;
		if (browser.equals("edge")) {
			result2 = commonUtils.assertValue(actbckColor, commonUtils.hex2RgbWithoutTransparency(bckColor),
					element + " - Background color  is not as in spec");
		} else {
			result2 = commonUtils.assertValue(actbckColor, commonUtils.hex2Rgb(bckColor),
					element + " - Background color  is not as in spec");
		}

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyHoverState(By element, String bckColor, String txtColor, String device) {
		// commonUtils.hoverOnElement(element);
		String actbckColor = commonUtils.getCSSValue(element, "background-color", device);
		String acttxtColor = commonUtils.getCSSValue(element, "color", device);

		boolean result1 = commonUtils.assertValue(acttxtColor, commonUtils.hex2Rgb(txtColor),
				element + " - Text color is not as in spec");
		boolean result2 = commonUtils.assertValue(actbckColor, commonUtils.hex2Rgb(bckColor),
				element + " - Background color  is not as in spec");

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyHoverMonthControl(By element, String txtMonth) {
		commonUtils.hoverOnElement(element);
		String actMonth = commonUtils.getAttributeValue(element, "title");

		boolean result1 = commonUtils.assertValue(actMonth, txtMonth, element + " - Month is not as in spec");

		if (result1 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyDaysOfWeek(By element, String day, String txtDay) {

		String actDay = commonUtils.getAttributeValue(element, "title");
		String actDayText = commonUtils.getText(element);

		boolean result1 = commonUtils.assertValue(actDay, day, element + " - Day is not as in spec");
		boolean result2 = commonUtils.assertValue(actDayText, txtDay, element + " - Day Text is not as in spec");

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyHoverMonthControl(By element, String txtMonth, String device) {
		// commonUtils.hoverOnElement(element);
		String actMonth = commonUtils.getAttributeValue(element, "title", device);

		boolean result1 = commonUtils.assertValue(actMonth, txtMonth, element + " - Month is not as in spec");

		if (result1 == true)
			result = true;
		else
			result = false;
		return result;
	}

	private boolean verifyDaysOfWeek(By element, String day, String txtDay, String device) {

		String actDay = commonUtils.getAttributeValue(element, "title", device);
		String actDayText = commonUtils.getText(element, device);

		boolean result1 = commonUtils.assertValue(actDay, day, element + " - Day is not as in spec");
		boolean result2 = commonUtils.assertValue(actDayText, txtDay, element + " - Day Text is not as in spec");

		if (result1 == true && result2 == true)
			result = true;
		else
			result = false;
		return result;
	}

	@BeforeMethod(alwaysRun = true)
	private void beforeMethod(Method method) {
		System.out.println(count + ".- Test Method----> " + this.getClass().getSimpleName() + "::" + method.getName());
		count++;
	}

	@AfterMethod(alwaysRun = true)
	private void afterMethod() {
		System.out.println("_________________________________________________");
	}

}
