package lib.UI.factories;

import lib.Platform;
import lib.UI.NavigationUI;
import lib.UI.android.AndroidNavigationUI;
import lib.UI.ios.IOSNavigationUI;
import lib.UI.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;


public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        } else if (Platform.getInstance().isIOS()){
            return new IOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }
    }
}
