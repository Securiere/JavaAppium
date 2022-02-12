package lib.UI.mobile_web;

import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL ="xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";
        SEARCH_RESULT_ELEMENTS_IN_MY_LIST = "id:???"; /*should know */
        REMOVE_FROM_SAVED_BY_LINK_TPL = "xpath://ul[contains(@class, 'watchlist')]//a[@href='{LINK_TEXT}']/../a[contains(@class, 'watched')]";
        REMOVE_FROM_SAVED_BUTTON_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]/../../a[contains(@class, 'watched')]";
        //FOLDER_BY_ID_TPL = "id:org.wikipedia:id/item_title";
        ARTICLE_IN_THE_LIST_BY_LINK_TPL = "xpath://ul[contains(@class, 'watchlist')]//a[@href='{LINK_TEXT}']";
    }
    public MWMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
