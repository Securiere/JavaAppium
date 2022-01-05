package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.MyListsPageObject;
import lib.UI.NavigationUI;
import lib.UI.android.AndroidMyListsPageObject;
import lib.UI.android.AndroidNavigationUI;
import lib.UI.ios.iOSMyListsPageObject;
import lib.UI.ios.iOSNavigationUI;

/* Тут собраны все методы */
abstract public class MyListsPageObject extends MainPageObject{

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            SEARCH_RESULT_ELEMENTS_IN_MY_LIST;
            //FOLDER_BY_ID_TPL = "id:org.wikipedia:id/item_title";

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

/*    private static String getFolderById(String id)
    {
        return FOLDER_BY_ID_TPL.replace("org.wikipedia:id/item_title", id);
    }*/

        public MyListsPageObject(AppiumDriver driver)
        {
            super(driver);
        }

        public void openFolderByName(String name_of_folder)
        {
            String folder_name_xpath = getFolderXpathByName(name_of_folder);
            this.waitForElementAndClick(
                    folder_name_xpath,
                    "Cannot find find folder by name " + name_of_folder,
                    15
            );
        }

    /*public void openFolderById(String id)
    {
        String folder_name_id = getFolderById(id);
        this.waitForElementAndClick(
                folder_name_id,
                "Cannot find find folder by id " + id,
                15
        );
    }*/

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title " + article_title, 15);
    }

        public void waitForArticleToDisappearByTitle(String article_title)
        {
            String article_xpath = getSavedArticleXpathByTitle(article_title);
            this.waitForElementNotPresent(article_xpath, "Saved article still present with title " + article_title, 15);
        }

        public void swipeByArticleToDelete(String article_title)
        {
            this.waitForArticleToAppearByTitle(article_title);
            String article_xpath = getSavedArticleXpathByTitle(article_title);
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article"
            );
            if(Platform.getInstance().isIOS()) {
                this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
            }
            this.waitForArticleToDisappearByTitle(article_title);
        }

    //Подсчет количества статей в Избранном
    public int getAmountOfFoundArticlesInMyList()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENTS_IN_MY_LIST,
                "Cannot find any element by the request",
                15);

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENTS_IN_MY_LIST);
    }
    public static void waitForArticleDissapearByTitle(String article_title){
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath,
                "Saved article is still present with title "+ article_title,
                5);
    }
}
