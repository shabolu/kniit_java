package solutions.lab1.task2;

public class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;
    private String webpageName;
    private String webPageExtension;

    private int intParam;
    private double doubleParam;
    private String textParameter;

    public String getProtocol() {
        return protocol;
    }
    public String getAddress() {
        return address;
    }
    public String getDomainZone() {
        return domainZone;
    }
    public String getSiteName() {
        return siteName;
    }
    public String getWebpageName() {
        return webpageName;
    }
    public String getWebPageExtension() {
        return webPageExtension;
    }

    public int getIntParam() {
        return intParam;
    }
    public double getDoubleParam() {
        return doubleParam;
    }
    public String getTextParameter() {
        return textParameter;
    }
 
    public void setProtocol(String protocol) {
        this.protocol = protocol; 
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }
    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtension = webPageExtension;
    }

    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }
    public void setDoubleParam(double doubleParam) {
        this.doubleParam = doubleParam;
    }
    public void setTextParameter(String textParameter) {
        this.textParameter = textParameter;
    }

    @Override
    public String toString() {
        return  "protocol = " + protocol + "\n" +
                "address = " + address + "\n" +
                "domainZone = " + domainZone + "\n" +
                "siteName = " + siteName + "\n" +
                "webpageName = " + webpageName + "\n" +
                "webPageExtension = " + webPageExtension + "\n" +
                "intParam = " + intParam + "\n" +
                "doubleParam = " + doubleParam + "\n" +
                "textParameter = " + textParameter;
    }
}