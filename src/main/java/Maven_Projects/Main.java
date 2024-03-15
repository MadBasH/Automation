package Maven_Projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Main {
    @FindBy(css = "html body.gender-popup-lock div#onetrust-consent-sdk div#onetrust-banner-sdk.otFlat.bottom.vertical-align-content div div.ot-sdk-container div.ot-sdk-row div#onetrust-button-group-parent.ot-sdk-three.ot-sdk-columns div#onetrust-button-group button#onetrust-accept-btn-handler")
    public WebElement cookie;
    @FindBy(css = "html body div#container div#header div#headerMain div#sticky-header div.wrapper div.header div#accountNavigation div div#account-navigation-container div.account-navigation-wrapper div.account-nav-item.user-login-container div.link.account-user p.link-text")
    public WebElement girisYap;

    @FindBy(css = "html body div#container div#header div#headerMain div#sticky-header div.wrapper div.header div#accountNavigation div div#account-navigation-container div.account-navigation-wrapper div.account-nav-item.user-login-container div.new-login-dropdown div.user-notloggedin-container.container-padding div.login-button")
    public WebElement girisYapHover;

    @FindBy(css = "html body div#container div#login-register div.lr-container div.q-layout.login form div.q-input-wrapper.email-input input#login-email.q-input")
    public WebElement ePosta;

    @FindBy(css = "html body div#container div#login-register div.lr-container div.q-layout.login form div.password-wrapper div.password div.q-input-wrapper input#login-password-input.q-input")
    public WebElement sifre;

    @FindBy(css = "html body div#container div#login-register div.lr-container div.q-layout.login form button.q-primary.q-fluid.q-button-medium.q-button.submit span")
    public WebElement girisButonu;

    @FindBy(css = "html body div#container div#header div#headerMain div#sticky-header div.wrapper div.header div#autoCompleteAppWrapper div#sfx-discovery-search-suggestions div.mOkuL__p div.N4M8bfaJ input.V8wbcUhU")
    public WebElement searchBar;

    @FindBy(css = "html body div#container div#header div#headerMain div#sticky-header div.wrapper div.header div#autoCompleteAppWrapper div#sfx-discovery-search-suggestions div.mOkuL__p div.N4M8bfaJ i.cyrzo7gC")
    public WebElement searchButton;
    //@FindBy(css = "html body div#container div div div#search-app div.search-app-container div.srch-rslt-cntnt div#sticky-aggregations div.aggrgtn-cntnr-wrppr div.fltrs-wrppr.hide-fltrs div.fltrs div.ReactVirtualized__Grid.ReactVirtualized__List.row-list div.ReactVirtualized__Grid__innerScrollContainer div div a.fltr-item-wrppr div.fltr-item-text")
    @FindBy(xpath = "//*[@id=\"sticky-aggregations\"]/div/div[1]/div[3]/div/div/div[1]/div/a/div[2]")
    public WebElement android;
    @FindAll(@FindBy(css = "div.search-app-container div.srch-rslt-cntnt div.srch-prdcts-cntnr.srch-prdcts-cntnr-V2:nth-child(2) div:nth-child(4) div:nth-child(1) > div.prdct-cntnr-wrppr > *"))
    public List<WebElement> samsungs;
    @FindBy(css = "div.search-app-container div.srch-rslt-cntnt div.srch-prdcts-cntnr.srch-prdcts-cntnr-V2:nth-child(2) div.prdct-cntnr-wrppr div.p-card-wrppr.with-campaign-view:nth-child(25) div.p-card-chldrn-cntnr.card-border a:nth-child(1) div.image-container > div.image-overlay")
    public WebElement besinciUrun;

    @FindBy(css = "div.product-detail-container div.flex-container:nth-child(2) div.product-container div.container-right-content div.product-detail-wrapper div.product-button-container:nth-child(4) div.favorite-button div.review-tooltip div.tooltip-indicator button.fv > i.i-heart")
    public WebElement favoriButonu;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div/a/div")
    public WebElement favoriList;

    @FindBy(css = "div.favorites-wrapper div.infinite-scroll-v2 div:nth-child(1) div.favored-product-container div.p-card-wrppr div.add-to-basket-container > div.basket-button")
    public WebElement sepeteEkle;

    @FindBy(css = "html body div#container div#header div#headerMain div#sticky-header div.wrapper div.header div#accountNavigation div div#account-navigation-container div.account-navigation-wrapper div.account-nav-item.basket-preview a.link.account-basket div.icon-container i.i-bagg-orange.hover-icon")
    public WebElement sepet;
    @FindBy(css = "html body div#container div div#basket-app-container div#pb-container div.pb-wrapper div.pb-merchant-group div.pb-basket-item-wrapper-v2 div.pb-basket-item div.pb-basket-item-details div.pb-basket-item-label-wrapper div.onboarding-wrapper.show div div.pb-basket-item-add-vas-label-tooltip-wrapper div.pb-info-tooltip.pb-basket-item-add-vas-label-onboarding-tooltip div.tooltip-content button")
    public WebElement anladim;
    @FindBy(css = "html body div#container div div#basket-app-container div#pb-container div.pb-wrapper div.pb-merchant-group div.pb-basket-item-wrapper-v2 div.pb-basket-item div.pb-basket-item-actions button i.i-trash")
    public WebElement kaldir;
    public Main(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}