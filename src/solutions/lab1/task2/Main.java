package solutions.lab1.task2;

public class Main {
    public static void main(String[] args) {
        String url = "https://test.ru/test/1072/pagejsp?intParam=12345&doubleParam=3.14&textParameter=someText";

        SimpleUrl simpleUrl = new SimpleUrl();

        // протокол
        int protocolEndIndex = url.indexOf("://");
        String protocol = url.substring(0, protocolEndIndex);
        simpleUrl.setProtocol(protocol);
        
        // адрес
        int addressStartIndex = protocolEndIndex + 3;
        int addressEndIndex = url.indexOf("/", addressStartIndex);
        String address = url.substring(addressStartIndex, addressEndIndex);
        simpleUrl.setAddress(address);

        // название сайта и доменная зона
        int siteDotIndex = address.indexOf(".");
        String siteName = address.substring(0, siteDotIndex);
        String domainZone = address.substring(siteDotIndex + 1);
        simpleUrl.setSiteName(siteName);
        simpleUrl.setDomainZone(domainZone);

        // название страницы и её расширение
        int lastSlashIndex = url.lastIndexOf("/");
        int questionMarkIndex = url.indexOf("?");
        String webPage = url.substring(lastSlashIndex + 1, questionMarkIndex);
        
        String[] webPageSplitted = webPage.split("\\.");
        if (webPageSplitted.length > 1) {
            System.out.println(webPageSplitted[0] + webPageSplitted[1]);
            simpleUrl.setWebpageName(webPageSplitted[0]);
            simpleUrl.setWebPageExtension(webPageSplitted[1]);
        } else {
            simpleUrl.setWebpageName(webPage);
        }

        // параметры
        String paramsString = url.substring(questionMarkIndex + 1);
        String[] paramsList = paramsString.split("&");
        for (String elem : paramsList) {
            String[] keyValue = elem.split("=");
            String key = keyValue[0];
            String value = keyValue[1];

            switch (key) {
                case "intParam":
                    simpleUrl.setIntParam(Integer.parseInt(value));
                case "doubleParam":
                    simpleUrl.setDoubleParam(Double.parseDouble(value));
                case "textParameter":
                    simpleUrl.setTextParameter(value);
            }
        }

        System.out.println(simpleUrl);
    }
}
