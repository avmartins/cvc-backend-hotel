package com.herokuapp.cvcbackendhotel.component.util;

/**
 * Classe responsavel por fazer a build da uri.
 */
public final class CallUtil {

    private CallUtil() {}

    public static String executeHotelsAvail(String config) {
        return build(config, "hotels/avail/{cityCode}");
    }

    public static String executeHotels(String config) {
        return build(config, "hotels/{id}");
    }

    private static String build(String config, String uri) {
        StringBuilder url = new StringBuilder();
        url.append(config);
        url.append(uri);
        return url.toString();
    }

}
