package pages.serchresults;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.page.BasePage;
import steps.base.models.ProductCard;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = "li.m-product__card")
    private List<WebElement> productCards;

    private final By productCardTitleLabel = By.cssSelector("h5.card-title");
    private final By productCardPriceLabel = By.cssSelector("p.a-card-discount");

    public List<ProductCard> getProductCardsInformation() {
        List<ProductCard> productCardsList = new ArrayList<>();
        for (WebElement productCard : productCards) {
            productCardsList.add(getProductCardInformation(productCard));
        }
        return productCardsList;
    }

    private ProductCard getProductCardInformation(WebElement productCardElement) {
        ProductCard productCard = new ProductCard();
        setProductCardTitle(productCard, productCardElement);
        setProductCardPrice(productCard, productCardElement);
        setProductCardScreenShoot(productCard, productCardElement);
        return productCard;
    }

    private void setProductCardTitle(ProductCard productCard, WebElement productCardElement) {
        try {
            String productCardTitle = getProductCardTitle(productCardElement);
            productCard.setTitle(productCardTitle);
        } catch (NoSuchElementException exception) {
        }
    }

    private String getProductCardTitle(WebElement productCardElement) {
        return elementInformationActions.getText(productCardElement, productCardTitleLabel);
    }

    private void setProductCardPrice(ProductCard productCard, WebElement productCardElement) {
        try {
            String productCardPrice = getProductCardPrice(productCardElement);
            productCard.setPrice(productCardPrice);
        } catch (NoSuchElementException exception) {
        }
    }

    private String getProductCardPrice(WebElement productCardElement) {
        return elementInformationActions.getText(productCardElement, productCardPriceLabel);
    }

    private void setProductCardScreenShoot(ProductCard productCard, WebElement productCardElement) {
        byte[] productCardScreenShoot = getProductCardScreenShoot(productCardElement);
        productCard.setScreenShoot(productCardScreenShoot);
    }

    private byte[] getProductCardScreenShoot(WebElement productCardElement) {
        return browserActionsPage.takeScreenshot(productCardElement);
    }
}
