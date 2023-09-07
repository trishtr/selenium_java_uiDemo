package models.components;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class ComponentExploring {

    public<T extends LoginPage> void login(Class<T> loginPageClass){
        //define parameters that we think we will use it with the constructor
        //create constructor with empty parameters

        Class<?>[] parameters = new Class[]{WebDriver.class};


        try {
            Constructor<T> constructor = loginPageClass.getConstructor(parameters);
            T loginPageObject = constructor.newInstance(DriverFactory.getChromeDriver());
            loginPageObject.inputUsername();
            loginPageObject.inputPwd();
            loginPageObject.clickOnLoginBtn();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        new ComponentExploring().login(InternalLoginPage.class);
        System.out.println("--------------------------");
        new ComponentExploring().login(ExternalLoginPage.class);
    }
}
