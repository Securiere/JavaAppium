package lib.UI.ios;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name = 'Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value = 'Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        SEARCH_ARTICLE_FOR_TITLE_AND_DESCRIPTION = "xpath://android.widget.LinearLayout[*[@text='{SUBSTRING_TITLE}'] and *[@text='{SUBSTRING_DESC}']]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name= 'No results found']";
        SEARCH_TITLE_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/view_page_header_container']/*[@resource-id='org.wikipedia:id/view_page_title_text']";
    }
    public IOSSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
