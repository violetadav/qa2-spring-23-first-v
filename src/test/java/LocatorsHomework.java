import org.openqa.selenium.By;

import java.util.PrimitiveIterator;

public class LocatorsHomework {

    //1a
    private final By PIEDAVAJUMS_BIZNESAM_BTN = By.xpath(".//a[@href = 'https://www.1a.lv/kp/piedavajums-biznesam/fn']");
    private final By PICKUP_POINTS = By.xpath(".//a[@class = 'site-top__menu-right-link'][@href = '/stores']");
    private final By LANG_BTN_LV = By.xpath(".//a[@hreflang = 'lv']");
    private final By LANG_BTN_RU = By.xpath(".//a[@hreflang = 'ru']");
    private final By CART_ICON = By.xpath(".//i[@class = 'cart-block__icon icon-svg']");
    private final By SEARCH_ICON = By.xpath(".//div[@class = 'main-search__submit']");
    private final By MAIN_LOGO = By.xpath(".//a[@class = 'main-logo']");
    private final By SMART_NET_BTN = By.xpath(".//img[@class = 'smart-net-banner__logo']");
    private final By MAIN_MENU_ICON = By.xpath(".//i[@class = 'main-menu__handle-icon icon-svg']");
    private final By SMART_NET_BANNER_IMAGE = By.xpath(".//img[@src = '/assets/smart_net/banner-icon-gift-a5f4be14455f68215791cf2fca3f688264cd5286c14ddb485388185484dbc715.svg']");

    //Amazon
    private final By AMAZON_MAIN_LOGO = By.id("nav-logo-sprites");
    private final By SEARCH_BAR = By.id("nav-search-bar-form");
    private final By SIGN_IN_ACCOUNT_BTN = By.xpath(".//a[@href = 'https://www.amazon.de/-/en/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.de%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=deflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&']");
    private final By BASKET_BTN = By.xpath(".//a[@href = 'https://www.amazon.de/-/en/gp/cart/view.html?ref_=nav_cart']");
    private final By HAMB_MENU_ICON_LABEL = By.id("nav-hamburger-menu");
    private final By NEXT_ICON = By.xpath(".//i[@class = 'a-icon a-icon-next-rounded']");
    private final By DESKTOP_GRID_2 = By.id("desktop-grid-2");

    //Google
    private final By GOOGLE_SEARCH_BAR = By.xpath(".//div[@class = 'RNNXgb']");
    private final By QUICK_SETTINGS_ICON = By.xpath(".//div[@class = 'c58wS']");
    private final By ACCOUNT_ICON = By.xpath(".//div[@class = 'gb_b gb_Qd gb_2f gb_v gb_Xd']");
    private final By MORE_BTN = By.xpath(".//div[@jsname = 'LgbsSe'][@class = 'GOE98c']");
    private final By TOOLS_BTN = By.xpath(".//div[@class = 't2vtad']");
    private final By RESULT_STATS = By.id("result-stats");
    private final By ABOUT_BTN_IN_FIRST_RESULT = By.xpath(".//div[@class = 'BYM4Nd']//div[@class = 'iTPLzd rNSxBe lUn2nc']");
    private final By GOOGLE_INFO_BLOCK = By.xpath(".//div[@class = 'liYKde g VjDLd']");

    //Booking
    private final By BOOKING_MAIN_LOGO = By.xpath(".//span[@data-testid = 'header-logo']");
    private final By CURRENCY_BTN = By.xpath(".//button[@data-testid = 'header-currency-picker-trigger']");
    private final By NOTIFICATIONS_ICON = By.xpath(".//div[@class = 'dd9784d118']");
    private final By GENIUS_LEVEL_INFO = By.xpath(".//span[@class = 'd8eab2cf7f a2552429ab']");
    private final By AIRPORT_TAXIS_BTN = By.id("airport_taxis");
    private final By WHERE_TO_NEXT_BANNER = By.xpath(".//span[@class = 'fa27fe07b6 c0ec8bd590 e0ff951c3e']");
    private final By CHECK_IN_CHECK_OUT_FIELD = By.xpath(".//div[@class = 'd606c76c5a']");
    private final By SEARCH_BUTTON = By.xpath(".//button[@class = 'fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 c938084447 f4605622ad aa11d0d5cd']");
    private final By TRAVEL_FOR_WORK_BTN = By.xpath(".//label[@class = 'a1b3f50dcd be36d14cea b2fe1a41c3 d19ba76520 efeda70352']");
    private final By COVID19_SUPPORT = By.xpath(".//div[@data-capla-component = 'b-index-lp-web-mfe/GlobalAlerts']");
    private final By RECENT_SEARCHES = By.xpath(".//span[@class = 'bui-title__text']");

}
