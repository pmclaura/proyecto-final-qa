package testSuite.ticktick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.ticktick.LoginSection;
import page.ticktick.MainPage;
import page.ticktick.MenuSection;
import page.ticktick.ProjectSection;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    MenuSection menuSection = new MenuSection();
    LoginSection loginSection = new LoginSection();
    ProjectSection projectSection = new ProjectSection();

    String user= GetProperties.getInstance().getUser();
    String password =GetProperties.getInstance().getPwd();

    //@BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    //@AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
