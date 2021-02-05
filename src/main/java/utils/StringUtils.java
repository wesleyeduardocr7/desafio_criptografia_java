package utils;

public class StringUtils {

    public static String retirarCaracteresNumericos(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll("[\\d]", "");
    }
}
