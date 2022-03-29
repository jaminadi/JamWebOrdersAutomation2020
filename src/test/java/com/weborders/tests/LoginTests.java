package com.weborders.tests;

import com.weborders.pages.LoginPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginTests extends AbstractBaseTest{

    @Test
    public void login(){
        extentTest = extentReports.createTest("Verify page logo");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        assertEquals(loginPage.getPageLogoText(), "Web Orders");

        extentTest.pass("Logo verified!");
    }
}
