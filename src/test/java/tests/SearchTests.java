package tests;

import lib.CoreTestCase;
import lib.UI.SearchPageObject;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/* Тесты связанные с поиском */
public class SearchTests extends CoreTestCase
{
    /* Поиск статьи */
    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    /* Поиск и его отмена */
    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    /* Убедиться, что есть статьи удовлетворяющие условиям поиска */
    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }

    /* Убедиться, что поиск ничего не найдет по запросу */
    @Test
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
    public void testAmountOfSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }

    /* Ex. 6 Ищет заголовок статьи. Должен падать */
    @Test
    public void testFindTheTitle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        SearchPageObject.assertTitleIsPresent();
    }
    /* Ex.9 */
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
    }

    @Test
    public void testSearchWordInResultList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        String keyWord = "Java";
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(keyWord);
        SearchPageObject.assertForWordByResultsSearch(keyWord);
    }
}
