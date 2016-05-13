package elementsTests;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import utilities.BaseClass;


public class InputsTest extends BaseClass {

	private final String url = "http://localhost:8000/src/main/java/elements/fixtures/inputs.html";
	private String inputFilePath = "src/main/java/elements/fixtures/inputs.html";
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
	Boolean result;
	final static Logger log = Logger.getLogger(InputsTest.class.getName());

	@Parameters({ "runEnv", "mobile", "mobDeviceName", "sauceBrowser", "mobBrowser" })
	@BeforeClass(alwaysRun = true)
	private void InputsTestBeforeClass(String runEnv, String mobile, String mobDeviceName, String sauceBrowser, String mobBrowser) {
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
			commonUtils.getUrl("file://" + localUrl);
		}
	}
	
	/**********************************************************************************************************************************************
	 * 														DESKTOP TESTS
	 * 
	 *********************************************************************************************************************************************/
	@DataProvider(name = "InputTextDimensionsSpacingData")
	private Object[][] InputTextDimensionsSpacingData() {
		return new Object[][]{
				{ inputsPgObj.input_text_active, "36px", "14px", "0px" },
				{ inputsPgObj.input_text_active_small, "28px", "10px", "0px" }
		};
	}
	 
	@Test(testName = "verifyInputTextDimensionsSpacingTest", dataProvider = "InputTextDimensionsSpacingData", groups = {"desktop"})
	private void verifyInputTextDimensionsSpacingTest(By element, String height, String horizontal_padding, String vertical_padding) throws InterruptedException {
		chooseEnv();
		result = verifyDimensionSpacing(element, height, horizontal_padding, vertical_padding);
		Assert.assertTrue(result);
	}

	@DataProvider(name = "InputTextActiveData")
	private Object[][] InputTextActiveData() {
		return new Object[][]{
			 { inputsPgObj.input_text_active, "solid 1px #d0d0d0", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
			 { inputsPgObj.input_text_active_small, "solid 1px #d0d0d0", "#ffffff", "#231F20", "14px", "16px", "3px", "inline-block", "middle", "Input Text"},
			 { inputsPgObj.input_text_readonly, "solid 1px #d0d0d0", "#f2f2f2", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
			 { inputsPgObj.input_text_disable, "solid 1px #d0d0d0", "#f2f2f2", "#a6a8ab", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
			 { inputsPgObj.input_text_error1, "solid 1px #D0021B", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
			 { inputsPgObj.input_text_error2, "solid 1px #D0021B", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"}				 
		};
	}
	 
	@Test(testName = "VerifyInputTextActiveTest", dataProvider = "InputTextActiveData", groups = {"desktop"})
	private void VerifyInputTextActiveTest(By element, String border, String background, String color, String fontsize, String lineheight, String borderradius, String display, String verticalalign, String component) throws InterruptedException {
		chooseEnv();
		result = verifyInputTextActive(element, border, background, color, fontsize, lineheight, borderradius, display, verticalalign, component);
		Assert.assertTrue(result);
	}

	@DataProvider(name = "InputTextErrorBoxShadowData")
	private Object[][] InputTextErrorBoxShadowData() {
		return new Object[][]{
			 { inputsPgObj.input_text_error1, "#d0021b 0px 0px 4px 0px"},
			 { inputsPgObj.input_text_error2, "#d0021b 0px 0px 4px 0px"}				 
		};
	}
	 
	@Test(testName = "verifyInputTextErrorBoxShadowTest", dataProvider = "InputTextErrorBoxShadowData", groups = {"desktop"})
	private void verifyInputTextErrorBoxShadowTest(By element, String boxshadow) throws InterruptedException {
		chooseEnv();      
		String[] boxShadowArr=boxshadow.split(" ");
		String expBoxShadowColor=commonUtils.hex2RgbWithoutTransparency(boxShadowArr[0]);
		String expBoxShadow=expBoxShadowColor+" "+boxShadowArr[1]+" "+boxShadowArr[2]+" "+boxShadowArr[3]+" "+boxShadowArr[4];
				
		String actBoxShadow = commonUtils.getCSSValue(element, "box-shadow");
		
		result = commonUtils.assertValue(actBoxShadow, expBoxShadow, element+" Input Text error box-shadow specification Failed");
		Assert.assertTrue(result);
	 }
	
	/**********************************************************************************************************************************************
	 * 														MOBILE TESTS
	 * 
	 *********************************************************************************************************************************************/
	 @DataProvider(name = "InputTextDimensionsSpacingMobileData")
	 private Object[][] InputTextDimensionsSpacingMobileData() {
		 return new Object[][]{
			 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_active, "36px", "14px", "0px"},
			 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_active_small, "28px", "10px", "0px"},
			 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_active, "36px", "14px", "0px"},
			 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_active_small, "28px", "10px", "0px"}
		 };
	 }
	 
	 @Test(testName = "verifyInputTextDimensionsSpacingMobileTest", dataProvider = "InputTextDimensionsSpacingMobileData", groups = {"mobile"})
	 private void verifyInputTextDimensionsSpacingMobileTest(ScreenOrientation mode, By element, String height, String horizontal_padding, String vertical_padding) throws InterruptedException {
	   commonUtils.getUrl(url, "mobile");
	   appium.rotate(mode);
	   result = verifyDimensionSpacing(element, height, horizontal_padding, vertical_padding, "mobile");
	   Assert.assertTrue(result);
	 }

	@DataProvider(name = "InputTextActiveMobileData")
	private Object[][] InputTextActiveMobileData() {
		return new Object[][]{
				 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_active, "solid 1px #d0d0d0", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_active_small, "solid 1px #d0d0d0", "#ffffff", "#231F20", "14px", "16px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_readonly, "solid 1px #d0d0d0", "#f2f2f2", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_disable, "solid 1px #d0d0d0", "#f2f2f2", "#a6a8ab", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_error1, "solid 1px #D0021B", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.PORTRAIT, inputsPgObj.input_text_error2, "solid 1px #D0021B", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_active, "solid 1px #d0d0d0", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_active_small, "solid 1px #d0d0d0", "#ffffff", "#231F20", "14px", "16px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_readonly, "solid 1px #d0d0d0", "#f2f2f2", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_disable, "solid 1px #d0d0d0", "#f2f2f2", "#a6a8ab", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_error1, "solid 1px #D0021B", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"},
				 { ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_error2, "solid 1px #D0021B", "#ffffff", "#231F20", "16px", "18px", "3px", "inline-block", "middle", "Input Text"}	
		};
	}
	 
	@Test(testName = "verifyInputTextDimensionsSpacingMobileTest", dataProvider = "InputTextActiveMobileData", groups = {"mobile"})
	private void verifyInputTextActiveMobileTest(ScreenOrientation mode, By element, String border, String background, String color, String fontsize, String lineheight, String borderradius, String display, String verticalalign,String component) throws InterruptedException {
		commonUtils.getUrl(url, "mobile");
		appium.rotate(mode);
		result = verifyInputTextActive(element, border, background, color, fontsize, lineheight, borderradius, display, verticalalign, "mobile", component);
		Assert.assertTrue(result);
	}

	@DataProvider(name = "InputTextErrorBoxShadowMobileData")
	private Object[][] InputTextErrorBoxShadowMobileData() {
		return new Object[][]{
			{ ScreenOrientation.PORTRAIT, inputsPgObj.input_text_error1, "#d0021b 0px 0px 4px 0px"},
			{ ScreenOrientation.PORTRAIT, inputsPgObj.input_text_error2, "#d0021b 0px 0px 4px 0px"},			
			{ ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_error1, "#d0021b 0px 0px 4px 0px"},
			{ ScreenOrientation.LANDSCAPE, inputsPgObj.input_text_error2, "#d0021b 0px 0px 4px 0px"}		 
		};
	}
	 
	@Test(testName = "Verify Text Input Error State Box Shadow", dataProvider = "InputTextErrorBoxShadowMobileData", groups = {"mobile"})
	private void verifyInputTextErrorBoxShadowMobileTest(ScreenOrientation mode, By element, String boxshadow) throws InterruptedException {
		commonUtils.getUrl(url, "mobile");
		appium.rotate(mode);      
		String[] boxShadowArr=boxshadow.split(" ");
		String expBoxShadowColor=commonUtils.hex2RgbWithoutTransparency(boxShadowArr[0]);
		String expBoxShadow=expBoxShadowColor+" "+boxShadowArr[1]+" "+boxShadowArr[2]+" "+boxShadowArr[3]+" "+boxShadowArr[4];
				
		String actBoxShadow = commonUtils.getCSSValue(element, "box-shadow", "mobile");
		
		result = commonUtils.assertValue(actBoxShadow, expBoxShadow, element+" Input Text error box-shadow specification Failed");
		Assert.assertTrue(result);
	}
	
	/**********************************************************************************************************************************************
	 * 														COMMON METHODS
	 * 
	 *********************************************************************************************************************************************/

	private Boolean verifyDimensionSpacing(By element, String height, String horizontal_padding, String vertical_padding) {
		// get Height
		String actualHeight = commonUtils.getCSSValue(element, "height");
		// get left Padding
		String actualPaddingLeft = commonUtils.getCSSValue(element, "padding-left");
		// get right Padding
		String actualPaddingRight = commonUtils.getCSSValue(element, "padding-right");
		// get top Padding
		String actualPaddingTop = commonUtils.getCSSValue(element, "padding-top");
		// get bottom Padding
		String actualPaddingBottom = commonUtils.getCSSValue(element, "padding-bottom");
		
		boolean result_height = commonUtils.assertValue(actualHeight, height, "Element:"+element+" Input Text height specification Failed");
		boolean result_paddingLeft = commonUtils.assertValue(actualPaddingLeft, horizontal_padding, "Element:"+element+" Input Text padding-left specification Failed");
		boolean result_paddingRight = commonUtils.assertValue(actualPaddingRight, horizontal_padding, "Element:"+element+" Input Text padding-right specification Failed");
		boolean result_paddingTop = commonUtils.assertValue(actualPaddingTop, vertical_padding, "Element:"+element+" Input Text padding-top specification Failed");
		boolean result_paddingBottom = commonUtils.assertValue(actualPaddingBottom, vertical_padding, "Element:"+element+" Input Text padding-bottom specification Failed");
		
		if (result_height == true && result_paddingLeft == true && result_paddingRight == true && result_paddingTop == true && result_paddingBottom == true) {
			return true;
		} else {
			return false;
		}
	}
	
	private Boolean verifyDimensionSpacing(By element, String height, String horizontal_padding, String vertical_padding, String mobile) {
		// get Height
		String actualHeight = commonUtils.getCSSValue(element, "height", "mobile");
		// get left Padding
		String actualPaddingLeft = commonUtils.getCSSValue(element, "padding-left", "mobile");
		// get right Padding
		String actualPaddingRight = commonUtils.getCSSValue(element, "padding-right", "mobile");
		// get top Padding
		String actualPaddingTop = commonUtils.getCSSValue(element, "padding-top", "mobile");
		// get bottom Padding
		String actualPaddingBottom = commonUtils.getCSSValue(element, "padding-bottom", "mobile");
		
		boolean result_height = commonUtils.assertValue(actualHeight, height, "Element:"+element+" Input Text height specification Failed");
		boolean result_paddingLeft = commonUtils.assertValue(actualPaddingLeft, horizontal_padding, "Element:"+element+" Input Text padding-left specification Failed");
		boolean result_paddingRight = commonUtils.assertValue(actualPaddingRight, horizontal_padding, "Element:"+element+" Input Text padding-right specification Failed");
		boolean result_paddingTop = commonUtils.assertValue(actualPaddingTop, vertical_padding, "Element:"+element+" Input Text padding-top specification Failed");
		boolean result_paddingBottom = commonUtils.assertValue(actualPaddingBottom, vertical_padding, "Element:"+element+" Input Text padding-bottom specification Failed");
		
		if (result_height == true && result_paddingLeft == true && result_paddingRight == true && result_paddingTop == true && result_paddingBottom == true) {
			return true;
		} else {
			return false;
		}
	}

	private Boolean verifyInputTextActive(By element, String border, String background, String color, String fontsize, String lineheight, String borderradius, String display, String verticalalign,String component) {
		String[] borderArray=border.split(" ");
		String border_style=borderArray[0];
		String border_width=borderArray[1];
		String border_color=commonUtils.hex2Rgb(borderArray[2]);
		
		// get border
		String actualBorderWidth = commonUtils.getCSSValue(element, "border-top-width");
		// get border
		String actualBorderStyle = commonUtils.getCSSValue(element, "border-top-style");
		// get border
		String actualBorderColor = commonUtils.getCSSValue(element, "border-top-color");
		// get background
		String actualBackgroundColor = commonUtils.getCSSValue(element, "background-color");
		// get color
		String actualColor = commonUtils.getCSSValue(element, "color");
		// get font size
		String actualFontSize = commonUtils.getCSSValue(element, "font-size");
		// get line height
		String actualLineHeight = commonUtils.getCSSValue(element, "line-height");
		// get display
		String actualDisplay = commonUtils.getCSSValue(element, "display");
		// get vertical-align
		String actualVerticalAlign = commonUtils.getCSSValue(element, "vertical-align");
		
		boolean result_border1 = commonUtils.assertValue(actualBorderWidth, border_width, "Element:"+element+" Component:"+component+" border-width specification Failed");
		boolean result_border2 = commonUtils.assertValue(actualBorderStyle, border_style, "Element:"+element+" Component:"+component+" border-style specification Failed");
		boolean result_border3 = commonUtils.assertValue(actualBorderColor, border_color, "Element:"+element+" Component:"+component+" border-color specification Failed");
		boolean result_background = commonUtils.assertValue(actualBackgroundColor, commonUtils.hex2Rgb(background), "Element:"+element+" Component:"+component+" background specification Failed");
		boolean result_color = commonUtils.assertValue(actualColor, commonUtils.hex2Rgb(color), "Element:"+element+" Component:"+component+" color specification Failed");
		boolean result_fontsize = commonUtils.assertValue(actualFontSize, fontsize, "Element:"+element+" Component:"+component+" font-size specification Failed");
		boolean result_lineheight = commonUtils.assertValue(actualLineHeight, lineheight, "Element:"+element+" Component:"+component+" line-height specification Failed");
		boolean result_borderradius = verifyBorderRadius(element, borderradius, borderradius, borderradius, borderradius);
		boolean result_display = commonUtils.assertValue(actualDisplay, display, "Element:"+element+" Component:"+component+" display specification Failed");
		boolean result_verticalalign = commonUtils.assertValue(actualVerticalAlign, verticalalign, "Element:"+element+" Component:"+component+" vertical-align specification Failed");
		
		if (result_border1 == true && result_border2 == true && result_border3 == true && result_background == true && result_color == true && result_fontsize == true && result_lineheight == true && result_borderradius == true && result_display == true && result_verticalalign == true) {
			return true;
		} else {
			return false;
		}
	}	
	
	private Boolean verifyInputTextActive(By element, String border, String background, String color, String fontsize, String lineheight, String borderradius, String display, String verticalalign, String mobile,String component) {
		String[] borderArray=border.split(" ");
		String border_style=borderArray[0];
		String border_width=borderArray[1];
		String border_color=commonUtils.hex2Rgb(borderArray[2]);
		
		// get border
		String actualBorderWidth = commonUtils.getCSSValue(element, "border-top-width", "mobile");
		// get border
		String actualBorderStyle = commonUtils.getCSSValue(element, "border-top-style", "mobile");
		// get border
		String actualBorderColor = commonUtils.getCSSValue(element, "border-top-color", "mobile");
		// get background
		String actualBackgroundColor = commonUtils.getCSSValue(element, "background-color", "mobile");
		// get color
		String actualColor = commonUtils.getCSSValue(element, "color", "mobile");
		// get font size
		String actualFontSize = commonUtils.getCSSValue(element, "font-size", "mobile");
		// get line height
		String actualLineHeight = commonUtils.getCSSValue(element, "line-height", "mobile");
		// get display
		String actualDisplay = commonUtils.getCSSValue(element, "display", "mobile");
		// get vertical-align
		String actualVerticalAlign = commonUtils.getCSSValue(element, "vertical-align", "mobile");
		
		boolean result_border1 = commonUtils.assertValue(actualBorderWidth, border_width, "Element:"+element+" Component:"+component+" border-width specification Failed");
		boolean result_border2 = commonUtils.assertValue(actualBorderStyle, border_style, "Element:"+element+" Component:"+component+" border-style specification Failed");
		boolean result_border3 = commonUtils.assertValue(actualBorderColor, border_color, "Element:"+element+" Component:"+component+" border-color specification Failed");
		boolean result_background = commonUtils.assertValue(actualBackgroundColor, commonUtils.hex2Rgb(background), "Element:"+element+" Component:"+component+" background specification Failed");
		boolean result_color = commonUtils.assertValue(actualColor, commonUtils.hex2Rgb(color), "Element:"+element+" Component:"+component+" color specification Failed");
		boolean result_fontsize = commonUtils.assertValue(actualFontSize, fontsize, "Element:"+element+" Component:"+component+" font-size specification Failed");
		boolean result_lineheight = commonUtils.assertValue(actualLineHeight, lineheight, "Element:"+element+" Component:"+component+" line-height specification Failed");
		boolean result_borderradius = verifyBorderRadiusMobile(element, borderradius, borderradius, borderradius, borderradius, "mobile");
		boolean result_display = commonUtils.assertValue(actualDisplay, display, "Element:"+element+" Component:"+component+" display specification Failed");
		boolean result_verticalalign = commonUtils.assertValue(actualVerticalAlign, verticalalign, "Element:"+element+" Component:"+component+" vertical-align specification Failed");
	
		if (result_border1 == true && result_border2 == true && result_border3 == true && result_background == true && result_color == true && result_fontsize == true && result_lineheight == true && result_borderradius == true && result_display == true && result_verticalalign == true) {
			return true;
		} else {
			return false;
		}
	}
	
	private Boolean verifyBorderRadius(By element, String radius_top_left, String top_right_radius, String bottom_right_radius, String bottom_left_radius) {		
		// get radius_top_left
		String actual_radius_top_left = commonUtils.getCSSValue(element, "border-top-left-radius");
		// get top_right_radius
		String actual_top_right_radius = commonUtils.getCSSValue(element, "border-top-right-radius");
		// get bottom_right_radius
		String actual_bottom_right_radius = commonUtils.getCSSValue(element, "border-bottom-right-radius");
		// get bottom_left_radius
		String actual_bottom_left_radius = commonUtils.getCSSValue(element, "border-bottom-left-radius");
	
		boolean result_radius_top_left = commonUtils.assertValue(actual_radius_top_left, radius_top_left, "Element:"+ element +" Input Text border-top-left-radius specification Failed");
		boolean result_top_right_radius = commonUtils.assertValue(actual_top_right_radius, top_right_radius, "Element:"+ element +" Input Text border-top-right-radius specification Failed");
		boolean result_bottom_right_radius = commonUtils.assertValue(actual_bottom_right_radius, bottom_right_radius, "Element:"+ element +" Input Text border-bottom-right-radius specification Failed");
		boolean result_bottom_left_radius = commonUtils.assertValue(actual_bottom_left_radius, bottom_left_radius, "Element:"+ element +" Input Text border-bottom-left-radius specification Failed");
		
		if (result_radius_top_left == true && result_top_right_radius == true && result_bottom_right_radius == true && result_bottom_left_radius == true) {
			return true;
		} else {
			return false;
		}
	}
	
	private Boolean verifyBorderRadiusMobile(By element, String radius_top_left, String top_right_radius, String bottom_right_radius, String bottom_left_radius, String mobile) {		
		// get radius_top_left
		String actual_radius_top_left = commonUtils.getCSSValue(element, "border-top-left-radius", "mobile");
		// get top_right_radius
		String actual_top_right_radius = commonUtils.getCSSValue(element, "border-top-right-radius", "mobile");
		// get bottom_right_radius
		String actual_bottom_right_radius = commonUtils.getCSSValue(element, "border-bottom-right-radius", "mobile");
		// get bottom_left_radius
		String actual_bottom_left_radius = commonUtils.getCSSValue(element, "border-bottom-left-radius", "mobile");
	
		boolean result_radius_top_left = commonUtils.assertValue(actual_radius_top_left, radius_top_left, "Element:"+ element +" Input Text border-top-left-radius specification Failed");
		boolean result_top_right_radius = commonUtils.assertValue(actual_top_right_radius, top_right_radius, "Element:"+ element +" Input Text border-top-right-radius specification Failed");
		boolean result_bottom_right_radius = commonUtils.assertValue(actual_bottom_right_radius, bottom_right_radius, "Element:"+ element +" Input Text border-bottom-right-radius specification Failed");
		boolean result_bottom_left_radius = commonUtils.assertValue(actual_bottom_left_radius, bottom_left_radius, "Element:"+ element +" Input Text border-bottom-left-radius specification Failed");
		
		if (result_radius_top_left == true && result_top_right_radius == true && result_bottom_right_radius == true && result_bottom_left_radius == true) {
			return true;
		} else {
			return false;
		}
	}
	
    @BeforeMethod(alwaysRun = true)
    private void beforeMethod(Method method) {
        System.out.println("Test Method----> " + this.getClass().getSimpleName() + "::" + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    private void afterMethod() {
        System.out.println("_________________________________________________");
    }
}