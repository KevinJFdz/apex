package steps.base.models;

public class ProductCard {
    private String title;
    private String price;
    private int ratingsNumber;
    private byte[] screenShoot;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRatingsNumber() {
        return ratingsNumber;
    }

    public void setRatingsNumber(int ratingsNumber) {
        this.ratingsNumber = ratingsNumber;
    }

    public byte[] getScreenShoot() {
        return screenShoot;
    }

    public void setScreenShoot(byte[] screenShoot) {
        this.screenShoot = screenShoot;
    }
}
