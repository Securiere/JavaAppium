package lib.UI.android;

import lib.UI.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text='{SUBSTRING}')]";
        SEARCH_ARTICLE_FOR_TITLE_AND_DESCRIPTION = "xpath://android.widget.LinearLayout[*[@text='{SUBSTRING_TITLE}'] and *[@text='{SUBSTRING_DESC}']]";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text= 'No results found']";
        SEARCH_TITLE_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/view_page_header_container']/*[@resource-id='org.wikipedia:id/view_page_title_text']";
        SEARCH_RESULTS_LIST = "id:org.wikipedia:id/page_list_item_container";
        SECOND_RESULT_XPATH = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@index=1]";
        SEARCH_INPUT_TEXT = "id:org.wikipedia:id/search_src_text";
    }
    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
