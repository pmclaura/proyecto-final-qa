package page.ticktick;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectSection {
    public MenuProjectSection menuProjectSection= new MenuProjectSection();
    public Label selectListLabel = new Label(By.xpath("//a[contains(@class,'drop-hover-effect')]/p[text()='Lists']"));
    public Button addNewProjectButton = new Button(By.xpath("//*[@id='project-list-scroller']/div[2]/section[1]/div[1]/li/a/button[2]"));
    public TextBox nameProjectTxBox = new TextBox(By.id("edit-project-name"));
    public Button addProjectButton = new Button(By.xpath("//button[text()='Save']"));

    public void clickOnProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//button/p[contains(text(),'"+nameProject+"')]"));
        projectCreated.click();
    }

    public boolean isProjectDisplayedInList(String nameProject){
        Label projectCreated = new Label(By.xpath("//button/p[contains(text(),'"+nameProject+"')]"));
        return projectCreated.isControlDisplayed();
    }

    public Label getProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//button/p[contains(text(),'"+nameProject+"')]"));
        return projectCreated;
    }
}
