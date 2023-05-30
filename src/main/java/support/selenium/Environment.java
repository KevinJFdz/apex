package support.selenium;

public enum Environment {
    STAG("stag"),
    DEV("dev");
    public final String name;

    Environment(String name) {
        this.name = name;
    }
}
