package elements.elementsPageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputsPageObjects {

    public WebDriver driver;
    public AppiumDriver appium;

    public InputsPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public InputsPageObjects(AppiumDriver appium) {
        this.appium = appium;
    }

    public By input_text_active = By.id("input-text-active");
    public By input_text_active_placeholder = By.id("input-text-active-PH");
    public By input_text_active_small = By.id("input-text-active-small");
    public By input_text_active_small_placeholder = By.id("input-text-active-small-PH");

    public By input_text_readonly = By.id("input-text-readonly");
    public By input_text_readonly_small = By.id("input-text-readonly-small");

    public By input_text_disable = By.id("input-text-disabled");
    public By input_text_disable_small = By.id("input-text-disabled-small");

    public By input_text_error1 = By.id("input-text-error1");
    public By input_text_error2 = By.id("input-text-error2");

    public By input_text_error1_small1 = By.id("input-text-error1-small");
    public By input_text_error1_small2 = By.id("input-text-error2-small");

    //Checkboxes
    public By checkedCheckBox = By.id("checkedCheckBox");
    public By labelForCheckedCheckBox = By.id("labelForCheckedCheckBox");
    public By unCheckedCheckBox = By.id("unCheckedCheckBox");
    public By labelForUnCheckedCheckBox = By.id("labelForUnCheckedCheckBox");
    public By readDisabledUncheckedCheckBox = By.id("readDisabledUncheckedCheckBox");
    public By labelForReadDisabledUncheckedCheckBox = By.id("labelForReadDisabledUncheckedCheckBox");
    public By readDisabledCheckedCheckBox = By.id("readDisabledCheckedCheckBox");
    public By labelForReadDisabledCheckedCheckBox = By.id("labelForReadDisabledCheckedCheckBox");
    public By smallCheckedCheckBox = By.id("smallCheckedCheckBox");
    public By labelForSmallCheckedCheckBox = By.id("labelForSmallCheckedCheckBox");

    //Radios
    public By checkedRadio = By.id("checkedRadio");
    public By labelForCheckedRadio = By.id("labelForCheckedRadio");
    public By unCheckedRadio = By.id("unCheckedRadio");
    public By labelForUnCheckedRadio = By.id("labelForUnCheckedRadio");
    public By readDisabledUncheckedRadio = By.id("readDisabledUncheckedRadio");
    public By labelForReadDisabledUncheckedRadio = By.id("labelForReadDisabledUncheckedRadio");
    public By readDisabledCheckedRadio = By.id("readDisabledCheckedRadio");
    public By labelForReadDisabledCheckedRadio = By.id("labelForReadDisabledCheckedRadio");
    public By smallCheckedRadio = By.id("smallCheckedRadio");
    public By labelForSmallCheckedRadio = By.id("labelForSmallCheckedRadio");

    //TextArea
    public By largeSizeTextArea=By.id("largeSizeTextArea");
    public By labelForLargeSizeTextArea=By.id("labelForLargeSizeTextArea");
    public By smallSizeTextArea=By.id("smallSizeTextArea");
    public By labelForSmallSizeTextArea=By.id("labelForSmallSizeTextArea");
    public By placeholderTextArea=By.id("placeholderTextArea");
    public By labelForPlaceholderTextArea=By.id("labelForPlaceholderTextArea");
    public By disabledTextArea=By.id("disabledTextArea");
    public By labelForDisabledTextArea=By.id("labelForDisabledTextArea");
    public By readOnlyTextArea=By.id("readOnlyTextArea");
    public By labelForReadOnlyTextArea=By.id("labelForReadOnlyTextArea");
    public By errorTextArea=By.id("errorTextArea");
    public By labelForErrorTextArea=By.id("labelForErrorTextArea");
    public By textAreaError=By.id("labelForErrorTextArea-error");

    //Select box page objects
    public By selectbox_normal = By.id("selectbox-normal");
    public By selectbox_small = By.id("selectbox-small");
    public By selectbox_readonly = By.id("selectbox-readonly");
    public By selectbox_disabled = By.id("selectbox-disabled");
    public By selectbox_error = By.id("selectbox-error");
}

