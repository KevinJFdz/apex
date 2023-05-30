package steps.dashboard.search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.base.models.ProductCard;

import java.util.List;

public class SearchProductsSteps {
    SearchProductsPages searchProductsPages = new SearchProductsPages();
    SearchProductsReport searchProductsReport = new SearchProductsReport();
    SearchProductsAsserts searchProductsAsserts = new SearchProductsAsserts();

    @When("the Liverpool customer searches for {string}")
    public void theLiverpoolCustomerSearchesFor(String productToSearch) {
        searchProductsPages.searchProduct(productToSearch);
    }

    @Then("the Liverpool application should display search results with product titles containing {string}")
    public void theLiverpoolApplicationShouldDisplaySearchResultsWithProductTitlesContaining(String productToSearch) {
        List<ProductCard> productCardsResult = searchProductsPages.getProductsSearchResults();
        searchProductsReport.attachProductsToReport(productCardsResult);
        searchProductsAsserts.assertTitleProductsContainText(productCardsResult, productToSearch);
    }

    @Then("the Liverpool application should display the search results with titles and prices for each product")
    public void theLiverpoolApplicationShouldDisplayTheSearchResultsWithTitlesAndPricesForEachProduct() {
        List<ProductCard> productCardsResult = searchProductsPages.getProductsSearchResults();
        searchProductsReport.attachProductsToReport(productCardsResult);
        searchProductsAsserts.assertTitleAndPriceAreDisplayedInProductCards(productCardsResult);
    }

    @Then("the Liverpool application should display size and price filters")
    public void theLiverpoolApplicationShouldDisplaySizeAndPriceFilters() {
        searchProductsAsserts.assertSizeAndPriceFiltersAreDisplayed();
    }

    @And("the Liverpool customer applies the filters for size: {string} inches, price: above ten thousand, and brand: {string}")
    public void theLiverpoolCustomerAppliesTheFiltersForSizeInchesPriceAboveTenThousandAndBrand(String size, String brand) {
        searchProductsPages.setSizeFilter(size);
        searchProductsPages.setPriceAboveTenThousandFilter();
        searchProductsPages.setBrandFilter(brand);
    }

    @Then("the Liverpool application should display the same number of results as indicated by the applied filters")
    public void theLiverpoolApplicationShouldDisplayTheSameNumberOfResultsAsIndicatedByTheAppliedFilters() {
        List<ProductCard> productCardsResult = searchProductsPages.getProductsSearchResults();
        searchProductsReport.attachProductsToReport(productCardsResult);
        searchProductsAsserts.assertSearchResultNumbersEqualsToSearchResultDisplayed(productCardsResult);
    }

    @And("the Liverpool customer applies a filter for the {string} brand on the search results")
    public void theLiverpoolCustomerAppliesAFilterForTheBrandOnTheSearchResults(String brandName) {
        searchProductsPages.setBrandFilter(brandName);
    }
}
