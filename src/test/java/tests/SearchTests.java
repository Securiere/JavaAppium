package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.UI.SearchPageObject;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/* Тесты связанные с поиском */
@Epic("Tests for Searching")
public class SearchTests extends CoreTestCase
{
    /* Поиск статьи */
    @Test
    @Feature(value = "Search")
    @DisplayName("Check search results")
    @Description("Search for 'Java' and wait for the 'Object-oriented...' search result")
    @Step("Start test 'testSearch'")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    /* Поиск и его отмена */
    @Test
    @Feature(value = "Search")
    @DisplayName("Test 'Cancel Search' button")
    @Description("Initialize 'Search' input field, check that the 'Cancel Search' button presents and works")
    @Step("Start 'testCancelSearch'")
    @Severity(value = SeverityLevel.MINOR)
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    /* Убедиться, что есть статьи удовлетворяющие условиям поиска */
    @Test
    @Feature(value = "Search")
    @DisplayName("Check that search results are not empty")
    @Description("Search for 'Linkin Park Discography' and check that there are some resultsfor it")
    @Step("Start 'testAmountOfNotEmptySearch'")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }

    /* Убедиться, что поиск ничего не найдет по запросу */
    @Test
    @Feature(value = "Search")
    @DisplayName("Check for empty search results")
    @Description("Search for 'jkdfifskfygsdgf' and check that there is no result for search")
    @Step("Start 'testAmountOfEmptySearch'")
    @Severity(value = SeverityLevel.MINOR)
    public void testAmountOfEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "jkdfifskfygsdgf";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

/* Ex. 4 Убедиться, что все результаты соответствуют запросу */
    @Test
    @Feature(value = "Search")
    @DisplayName("Search some articles")
    @Description("Search that there are some results for 'Java' search")
    @Step("Start 'testAmountOfSearch'")
    @Severity(value = SeverityLevel.MINOR)
    public void testAmountOfSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }

    /* Ex. 6 Ищет заголовок статьи. Должен падать */
    @Test
    @Feature(value = "Search")
    @DisplayName("Search the title of the article")
    @Description("Search 'Object-oriented programming language' for 'Java'")
    @Step("Start 'testFindTheTitle'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testFindTheTitle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        SearchPageObject.assertTitleIsPresent();
    }
    /* Ex.9
    @Test
    public void testSearchForTitleAndDescription() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        HashMap<String, String> TitleAndNDescription = new HashMap<>();
        TitleAndNDescription.put("Java", "Island of Indonesia");
        TitleAndNDescription.put("JavaScript", "Programming language");
        TitleAndNDescription.put("Java (programming language)", "Object-oriented programming language");

        for (Map.Entry<String, String> kv : TitleAndNDescription.entrySet()) {
            SearchPageObject.waitForElementByTitleAndDescription(kv.getKey(), kv.getValue());
        }
    }*/

    @Test
    @Feature(value = "Search")
    @DisplayName("Check search results by titles and descriptions")
    @Description("Search for 'Java' and wait for three correct search results to appear")
    @Step("Start test 'testSearchByTitleAndDescription'")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearchByTitleAndDescription()
    {
        String[] Titles = new String[]{"Java", "JavaScript", "Java (programming language)"};
        String[] Descriptions = new String[]{"Island of Indonesia", "Programming language", "Object-oriented programming language"};

        if (Platform.getInstance().isMW()) {
            Descriptions[0] = "Indonesian island";
            Descriptions[1] = "High-level programming language";
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        for (int i = 0; i < 3; i++) {
            SearchPageObject.waitForElementByTitleAndDescription(Titles[i], Descriptions[i]);
        }
    }

    @Test
    @Feature(value = "Search")
    @DisplayName("Search concrete name in search result")
    @Description("Search for 'Java'")
    @Step("Start 'testSearchWordInResultList'")
    @Severity(value = SeverityLevel.MINOR)
    public void testSearchWordInResultList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String keyWord = "Java";
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(keyWord);
        SearchPageObject.assertForWordByResultsSearch(keyWord);
    }
}
