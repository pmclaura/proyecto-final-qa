package page.ticktick;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox emailTxBox = new TextBox(By.id("emailOrPhone"));
    public TextBox passwordTxBox = new TextBox(By.id("password"));
    public Button loginButton = new Button(By.xpath("//button[text()='Sign In']"));

    public void login(String user, String pwd){
        emailTxBox.setText(user);
        passwordTxBox.setText(pwd);
        loginButton.click();
    }
}
