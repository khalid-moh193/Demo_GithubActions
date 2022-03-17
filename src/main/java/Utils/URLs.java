package Utils;

public enum URLs {


    GOOGLE("https://www.google.com/"),
    GOOGLE_PLAY("https://play.google.com/store/apps");
    private String value;

    URLs(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
