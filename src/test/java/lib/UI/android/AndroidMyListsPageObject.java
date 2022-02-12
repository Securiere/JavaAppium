package lib.UI.android;

import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {
    static {
        FOLDER_BY_NAME_TPL ="xpath://*[@text = '{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL ="xpath://*[@text='{TITLE}']";
        SEARCH_RESULT_ELEMENTS_IN_MY_LIST = "id:org.wikipedia:id/page_list_item_container";
        //FOLDER_BY_ID_TPL = "id:org.wikipedia:id/item_title";
    }
    public AndroidMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
