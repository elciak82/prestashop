package tests.pagetitles;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.HeaderComponent;

public class LoginPageTests extends BaseTest {
    HeaderComponent header = new HeaderComponent(driver);

    @Test(testName = "Verify Login Page title.")
    @Description("Test verifying Login Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-8")
    @Parameters("browser: chrome")
    public void verifyLoginPageTitleTest() {
        header.clickOnSignInLink();

        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.Titles.LOGIN_PAGE.getPageTitle());

    }
}
