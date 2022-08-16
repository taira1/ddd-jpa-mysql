package jp.taira.sample.common;

/**
 * URL 定数クラス
 */
public class UrlConstants {

    private UrlConstants() {
        throw new IllegalAccessError("Constants class.");
    }

    public static final String ROOT = "/";

    public static final String API_PREFIX = "/api";

    public static final String LOGIN = API_PREFIX + "/login";

    public static final String USER = API_PREFIX + "/user";

    public static final String USER_LIST = USER + "/list";

}
