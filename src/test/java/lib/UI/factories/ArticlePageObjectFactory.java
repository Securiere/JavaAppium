package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.ArticlePageObject;
import lib.UI.android.AndroidArticlePageObject;
import lib.UI.ios.IOSArticlePageObject;
import lib.UI.mobile_web.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSArticlePageObject(driver);
        } else {
            return new MWArticlePageObject(driver);
        }
    }
}
