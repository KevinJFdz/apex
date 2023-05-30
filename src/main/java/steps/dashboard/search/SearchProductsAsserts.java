package steps.dashboard.search;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.serchresults.SearchFiltersSectionPage;
import steps.base.models.ProductCard;

import java.util.List;

public class SearchProductsAsserts {
    SearchFiltersSectionPage searchFiltersSectionPage = new SearchFiltersSectionPage();
    public void assertTitleProductsContainText(List<ProductCard> productCards, String textSearched) {
        SoftAssert softAssert = new SoftAssert();
        for (ProductCard productCard : productCards) {
            assertTitleProductContainsText(textSearched, productCard, softAssert);
        }
        softAssert.assertAll();
    }

    private void assertTitleProductContainsText(String textSearched, ProductCard productCard, SoftAssert softAssert) {
        String[] wordsToSearch = textSearched.split("\\s+");

        for (String word : wordsToSearch) {
            boolean wordFound = productCard.getTitle().toLowerCase().contains(word.toLowerCase());
            softAssert.assertTrue(wordFound, "The product title '" + productCard.getTitle() + "' doesn't contain the searched text: " + textSearched);
        }

    }

    public void assertTitleAndPriceAreDisplayedInProductCards(List<ProductCard> productCards) {
        SoftAssert softAssert = new SoftAssert();
        for (ProductCard productCard : productCards) {
            assertTitleAndPriceAreDisplayedInProductCard(productCard, softAssert);
        }
        softAssert.assertAll();
    }

    private void assertTitleAndPriceAreDisplayedInProductCard(ProductCard productCard, SoftAssert softAssert) {
        softAssert.assertTrue(productCard.getTitle() != null, "The product title is not displayed");
        softAssert.assertTrue(productCard.getPrice() != null, "The product price is not displayed");
    }

    public void assertSizeAndPriceFiltersAreDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchFiltersSectionPage.isPriceFilterDisplayed(), "The price filter is not displayed");
        softAssert.assertTrue(searchFiltersSectionPage.isSizeFilterDisplayed(), "The size filter is not displayed");
        softAssert.assertAll();
    }

    public void assertSearchResultNumbersEqualsToSearchResultDisplayed(List<ProductCard> displayedProductCards){
        int expectedResultCount = searchFiltersSectionPage.getFilteredResultsCount();
        int actualResultCount = displayedProductCards.size();
        Assert.assertEquals(actualResultCount, expectedResultCount, "The displayed search result count does not match the expected result count.");
    }
}