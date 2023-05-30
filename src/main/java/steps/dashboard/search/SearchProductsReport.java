package steps.dashboard.search;


import steps.base.models.ProductCard;
import support.cucumber.CucumberManager;

import java.util.List;

public class SearchProductsReport {
    public void attachProductsToReport(List<ProductCard> productCards) {
        for (ProductCard productCard : productCards) {
            attachProductToReport(productCard);
        }
    }

    public void attachProductToReport(ProductCard productCard) {
        CucumberManager.attachScreenshotToReport(productCard.getTitle() , productCard.getScreenShoot());
    }
}