package pages.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.page.BasePage;


public class DashboardPage extends BasePage {
    @FindBy(id = "mainSearchbar")
    private WebElement mainSearchBar;

    public void goToDashboardPage() {
        browserActionsPage.visit("https://www.liverpool.com.mx/tienda/home");
    }

    public void enterTextToSearch(String textToSearch) {
        keyboardActions.enter(mainSearchBar, textToSearch);
    }
}