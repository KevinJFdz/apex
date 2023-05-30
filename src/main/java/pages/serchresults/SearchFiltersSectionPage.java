package pages.serchresults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.page.BasePage;

import java.util.List;

public class SearchFiltersSectionPage extends BasePage {
    @FindBy(css = "span.searchNum-result")
    private WebElement filteredResultsCountLabel;

    @FindBy(css = "div.plp-filters-container >div.mdc-chip-set")
    private List<WebElement> filtersAppliedTabs;
    @FindBy(css = "div.m-plp__filterSection:has(label[title=\"Marcas\"])")
    private WebElement brandFilterSection;
    @FindBy(css = "div.m-plp__filterSection:has(label[title=\"Marcas\"] ) div.m-checkbox__button")
    private List<WebElement> brandFilterOptionsCheckboxes;
    private final By brandCheckBoxLocator = By.cssSelector("input[id*=\"brand\"]");
    private final By brandLabelLocator = By.cssSelector("label");
    @FindBy(id = "search-filter-brands")
    private WebElement brandSearchFilterInput;
    @FindBy(css = "div.m-plp__filterSection:has(label[title=\"Tamaño\"])")
    private WebElement sizeFilterSection;
    @FindBy(css = "div.m-plp__filterSection:has(label[title=\"Tamaño\"]) div.m-checkbox__button")
    private List<WebElement> sizeFilterOptionsCheckboxes;
    private final By sizeCheckBoxLocator = By.cssSelector("input[id*=\"variants.normalizedSize-\"]");
    private final By sizeLabelLocator = By.cssSelector("label");
    @FindBy(css = "div.m-plp__filterSection:has(label[title=\"Precios\"])")
    private WebElement priceFilterSection;
    @FindBy(css = "div.m-plp__filterSection:has(label[title=\"Precios\"]) div.m-radioButton")
    private List<WebElement> priceFilterOptionsRadioButtons;
    private final By priceRadioButtonLocator = By.cssSelector("input[id*=\"variants.prices.sortPrice\"]");
    private final By priceLabelLocator = By.cssSelector("label");

    public int getFilteredResultsCount() {
        String filteredResultsCount = elementInformationActions.getText(filteredResultsCountLabel);
        return parseFilteredResultsCount(filteredResultsCount);
    }

    public void waitForFilteredResultsUpdate(String filteredResultsCount) {
        if (isFilteredResultsCountDisplayed())
            waitsActions.waitToTextToBePresentInElement(filteredResultsCountLabel, filteredResultsCount);
    }

    public boolean isFilteredResultsCountDisplayed() {
        return statusElementActions.isDisplayed(filteredResultsCountLabel, 1);
    }

    private int parseFilteredResultsCount(String searchNumber) {
        return Integer.parseInt(searchNumber.replaceAll("\\D+", ""));
    }

    public boolean isSizeFilterDisplayed() {
        return statusElementActions.isDisplayed(sizeFilterSection);
    }

    public void checkSizeFilterBySizeValue(String sizeValue) {
        WebElement sizeOption = findElementActions.findElementInAListByContainsText(sizeFilterOptionsCheckboxes, sizeValue);
        String searchResultAfterTheFilter = getNumberOfProductPerSize(sizeOption);
        mouseActions.click(sizeOption, sizeCheckBoxLocator, false);
        waitForFilteredResultsUpdate(searchResultAfterTheFilter);
    }

    private String getNumberOfProductPerSize(WebElement sizeOption) {
        String sizeLabel = elementInformationActions.getText(sizeOption, sizeLabelLocator);
        return formatNumberOfProductLabel(sizeLabel);
    }

    private String formatNumberOfProductLabel(String productLabel) {
        return productLabel.substring(productLabel.indexOf("(") + 1, productLabel.indexOf(")"));
    }

    public boolean isPriceFilterDisplayed() {
        return statusElementActions.isDisplayed(priceFilterSection);
    }

    public void clickPriceRangeRadioButtonGreater10000() {
        int priceFilterOptionSize = priceFilterOptionsRadioButtons.size();
        WebElement priceOption = priceFilterOptionsRadioButtons.get(priceFilterOptionSize - 1);
        String searchResultAfterTheFilter = getNumberOfProductPerPrice(priceOption);
        mouseActions.click(priceOption, priceRadioButtonLocator, false);
        waitForFilteredResultsUpdate(searchResultAfterTheFilter);
    }

    public String getNumberOfProductPerPrice(WebElement priceOption) {
        String sizeLabel = elementInformationActions.getText(priceOption, priceLabelLocator);
        return formatNumberOfProductLabel(sizeLabel);
    }

    public void selectBrand(String brandName) {
        searchBrand(brandName);
        WebElement brandOption = brandFilterOptionsCheckboxes.get(0);
        String searchResultAfterTheFilter = getNumberOfProductPerBrand(brandOption);
        mouseActions.click(brandOption, brandCheckBoxLocator, false);
        waitForFilteredResultsUpdate(searchResultAfterTheFilter);
    }

    private void searchBrand(String brandName) {
        keyboardActions.enter(brandSearchFilterInput, brandName);
    }

    public String getNumberOfProductPerBrand(WebElement brandOption) {
        String brandLabel = elementInformationActions.getText(brandOption, brandLabelLocator);
        return formatNumberOfProductLabel(brandLabel);
    }
}
