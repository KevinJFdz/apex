package steps.dashboard;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DashboardSteps {
    DashboardPages dashboardPages = new DashboardPages();

    @Given("the Liverpool customer is on the dashboard page")
    public void theLiverpoolCustomerIsOnTheDashboardPage() {
        dashboardPages.goToDashboardPage();
    }

    @When("the Liverpool customer navigates to the categories section")
    public void theLiverpoolCustomerNavigatesToTheCategoriesSection() {
        dashboardPages.goToCategoriesSection();
    }

    @And("the Liverpool customer selects the {string} category")
    public void theLiverpoolCustomerSelectsTheCategory(String categoryName) {
        dashboardPages.goToSectionByName(categoryName);
    }

    @And("And the Liverpool customer chooses the {string} subcategory")
    public void andTheLiverpoolCustomerChoosesTheSubcategory(String subCategoryName) {
        dashboardPages.goToSubCategoryByName(subCategoryName);
    }
}