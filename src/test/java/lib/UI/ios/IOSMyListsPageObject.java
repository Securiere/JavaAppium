package lib.UI.ios;

import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL ="xpath://XCUIElementTypeLink[contains(@name='{TITLE}')]";
        SEARCH_RESULT_ELEMENTS_IN_MY_LIST = "id:???"; /*should know */
        //FOLDER_BY_ID_TPL = "id:org.wikipedia:id/item_title";
    }
    public IOSMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
