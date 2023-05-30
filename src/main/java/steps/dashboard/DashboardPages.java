package steps.dashboard;

import pages.dashboard.DashboardPage;
import pages.dashboard.MegaMenuSectionPage;

public class DashboardPages {
    protected DashboardPage dashboardPage = new DashboardPage();
    protected MegaMenuSectionPage megaMenuSectionPage = new MegaMenuSectionPage();

    public void goToDashboardPage(){
        dashboardPage.goToDashboardPage();
    }

    public void goToCategoriesSection(){
        megaMenuSectionPage.hoverCategoriesDropDownButton();
    }

    public void goToSectionByName(String sectionName){
        megaMenuSectionPage.hoverCategorySectionMenuItemByName(sectionName);
    }

    public void goToSubCategoryByName(String subCategoryName){
        megaMenuSectionPage.clickSubCategorySectionMenuItemByName(subCategoryName);
    }
}
