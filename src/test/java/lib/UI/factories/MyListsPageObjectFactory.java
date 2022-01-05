package lib.UI.factories;

import lib.Platform;
import lib.UI.android.AndroidMyListsPageObject;
import lib.UI.ios.IOSMyListsPageObject;
import lib.UI.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import lib.UI.MyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListsPageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
    }
}
