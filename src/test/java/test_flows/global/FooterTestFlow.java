package test_flows.global;

import models.components.global.footer.*;
import models.components.global.header.TopMenuComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComp() throws IllegalAccessException {

        HomePage homePage = new HomePage(driver);

        FooterComponent footerComponent = homePage.footerComponent();

        verifyInformationColumn(footerComponent);
        verifyCustomerServiceColumn(footerComponent);
        verifyAccountColumn(footerComponent);
        verifyFollowUsColumn(footerComponent);

    }

    private void verifyInformationColumn(FooterComponent footerComponent) throws IllegalAccessException {
        InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComponent();
        String actualColumnTitle = informationColumnComponent.headerElem().getText().trim();
        String expectedTitle = "INFORMATION";

        Assert.assertEquals(actualColumnTitle, expectedTitle, "Column Title is incorrect");

        // add expected data into Arrays.asList
        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Return", "" ,"" );
        List<String> expectedLinkHrefs = Arrays.asList("/sitemap", "/shipping-returns" , "", "");

        verifyColumnData(informationColumnComponent, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyCustomerServiceColumn(FooterComponent footerComponent) throws IllegalAccessException {
        CustomerServiceColumnComponent customerServiceColumnComponent = footerComponent.customerServiceColumnComponent();
        String actualColumnTitle = customerServiceColumnComponent.headerElem().getText().trim();
        String expectedTitle = "CUSTOMER SERVICE";

        Assert.assertEquals(actualColumnTitle, expectedTitle, "Column Title is incorrect");


//        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Return" + "" + "" );
//        List<String> expectedLinkHrefs = Arrays.asList("/sitemap", "/shipping-returns", "");
//
//
//        verifyColumnData(customerServiceColumnComponent, expectedLinkTexts, expectedLinkHrefs);


    }

    private void verifyAccountColumn(FooterComponent footerComponent) throws IllegalAccessException {
        AccountColumnComponent accountColumnComponent = footerComponent.accountColumnComponent();
        String actualColumnTitle = accountColumnComponent.headerElem().getText().trim();


        String expectedTitle = "ACCOUNT";

        Assert.assertEquals(actualColumnTitle, expectedTitle, "Column Title is incorrect");


//        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Return" + "" + "" );
//        List<String> expectedLinkHrefs = Arrays.asList("/sitemap", "/shipping-returns", "");
//
//
//        verifyColumnData(accountColumnComponent, expectedLinkTexts, expectedLinkHrefs);
    }

    private void verifyFollowUsColumn(FooterComponent footerComponent) throws IllegalAccessException {
        FollowUsColumnComponent followUsColumnComponent = footerComponent.followUsColumnComponent();
        String actualColumnTitle = followUsColumnComponent.headerElem().getText().trim();


        String expectedTitle = "FOLLOW US";

        Assert.assertEquals(actualColumnTitle, expectedTitle, "Column Title is incorrect");


//        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Return" + "" + "" );
//        List<String> expectedLinkHrefs = Arrays.asList("/sitemap", "/shipping-returns", "");
//
//
//        verifyColumnData(followUsColumnComponent, expectedLinkTexts, expectedLinkHrefs);
    }

    public void verifyColumnData(FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedHrefs ){

        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHrefs = new ArrayList<>();

        for(WebElement link: footerColumnComponent.linkElems()){
            actualLinkTexts.add(link.getText().trim());
            actualLinkHrefs.add(link.getAttribute("href"));
        }

        if(actualLinkTexts.isEmpty() || actualLinkHrefs.isEmpty()) {
            Assert.fail("Text or hyperlink is empty");
        }

        //Link text verification | Missing a logic way

        Assert.assertTrue(actualLinkHrefs.size() == expectedLinkTexts.size(), "Texts in footer column is in correct");

        for (String actualLinkText : actualLinkTexts){
            System.out.println(actualLinkText);
            Assert.assertTrue(expectedLinkTexts.contains(actualLinkText), actualLinkText + "is incorrect value");
        }

        //Verify link href | Missing a logic way
        Assert.assertTrue(actualLinkHrefs.size() == expectedHrefs.size(), "Texts in footer is incorrect");

        for(String actualLinkHref : actualLinkHrefs){
            System.out.println(actualLinkHref);
            Assert.assertTrue(actualLinkHrefs.contains(actualLinkHref), actualLinkHref + "is incorrect value");
        }




    }

    public void verifyProductCartFooterComp() throws IllegalAccessException {
        //Random pick up an item

        HomePage homePage = new HomePage(driver);

        TopMenuComponent topMenuComponent = homePage.topMenuComponent();

        List<TopMenuComponent.MainCartItem> mainItemElems = topMenuComponent.mainItemElems();

        //TODO: throw error when mainItemElems is empty

        TopMenuComponent.MainCartItem randomMainItemElem = mainItemElems.get(new SecureRandom().nextInt(mainItemElems.size()));

        String randomCatHref = randomMainItemElem.cartItemLinkElem().getAttribute("href");

        //Get sublist,  if main item has sublist, click on random item

        List<TopMenuComponent.CartItemComponent> cartItemComponents = randomMainItemElem.cartItemComps();

        if(cartItemComponents.isEmpty()){
            randomMainItemElem.cartItemLinkElem().click();
        }else{
            int randomIndex = new SecureRandom().nextInt(cartItemComponents.size());
            TopMenuComponent.CartItemComponent randomCartItemComponent = cartItemComponents.get(randomIndex);
            randomCatHref = randomCartItemComponent.getComponent().getDomAttribute("href");
            randomCartItemComponent.getComponent().click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(randomCatHref));

        //Call verify Footer Comp
        verifyFooterComp();
    }

}
