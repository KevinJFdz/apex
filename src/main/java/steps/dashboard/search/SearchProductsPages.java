package steps.dashboard.search;

import pages.serchresults.SearchFiltersSectionPage;
import pages.serchresults.SearchResultsPage;
import steps.base.models.ProductCard;
import steps.dashboard.DashboardPages;

import java.util.List;

public class SearchProductsPages extends DashboardPages {
    SearchFiltersSectionPage searchFiltersSectionPage = new SearchFiltersSectionPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    public void searchProduct(String productToSearch){
        dashboardPage.enterTextToSearch(productToSearch);
    }

    public List<ProductCard> getProductsSearchResults(){
        return searchResultsPage.getProductCardsInformation();
    }

    public void setSizeFilter(String size){
        searchFiltersSectionPage.checkSizeFilterBySizeValue(size);
    }

    public void setPriceAboveTenThousandFilter(){
        searchFiltersSectionPage.clickPriceRangeRadioButtonGreater10000();
    }

    public void setBrandFilter(String brand){
        searchFiltersSectionPage.selectBrand(brand);
    }
}
