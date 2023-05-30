package pages.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.page.BasePage;

import java.util.List;

public class MegaMenuSectionPage extends BasePage {
    @FindBy(css = "li.m-navDesktop__section:has(ul.dropdown-menu)")
    private WebElement categoriesDropDownButton;

    @FindBy(css = "div.m-megamenu__category_menu-item")
    private List<WebElement> categoriesOptionsMenuItems;

    @FindBy(css = "div.popover[style*='display: block'] li:has(a.a-desktop__subcategoryTitle)")
    private List<WebElement> subCategoriesVisibleOptionsMenuItems;

    public void hoverCategoriesDropDownButton() {
        findElementActions.moveToElement(categoriesDropDownButton);
    }

    public void hoverCategorySectionMenuItemByName(String categoryName) {
        WebElement categoryItemMenu = findElementActions.findElementInAListByContainsText(categoriesOptionsMenuItems, categoryName);
        findElementActions.moveToElement(categoryItemMenu);
    }


    public void clickSubCategorySectionMenuItemByName(String subCategoryName) {
        WebElement subCategoryItemMenu = findElementActions.findElementInAListByContainsText(subCategoriesVisibleOptionsMenuItems, subCategoryName);
        mouseActions.click(subCategoryItemMenu);
    }

}
