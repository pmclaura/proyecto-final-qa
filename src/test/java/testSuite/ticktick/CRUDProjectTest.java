package testSuite.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CRUDProjectTest extends TestBase{

    @Test
    public void verifyCRUDPorject(){
        String projectCreated="MOJIX"+new Date().getTime();
        String projectUpdated="QA"+new Date().getTime();

        mainPage.loginLabel.click();
        loginSection.emailTxBox.setText(user);
        loginSection.passwordTxBox.setText(password);
        loginSection.loginButton.click();
        Assertions.assertTrue(menuSection.userConfigLabel.isControlDisplayed(), "ERROR! the login was faield");


        projectSection.selectListLabel.click();
        projectSection.addNewProjectButton.click();
        projectSection.nameProjectTxBox.setText(projectCreated);
        projectSection.addProjectButton.click();
        projectSection.selectListLabel.click();
        projectSection.getProject(projectCreated).waitControlIsDisplayedInThePage();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectCreated), "ERROR! the project was not created");
    }
}
