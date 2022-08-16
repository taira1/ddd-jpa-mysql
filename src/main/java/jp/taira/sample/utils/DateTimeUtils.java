package jp.taira.sample.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DateTimeUtils {

    /** 日付の区切り文字 */
    public enum DATE_SPLIT {
        SLASH("/"),
        HYPHEN("-"),
        DOT("."),
        ;

        private String value;

        DATE_SPLIT(String value) {
            this.value = value;
        }

    }

    /** 年月日フォーマット */
    public static final String DATE_FORMAT_FIXED = "uuuu" + DATE_SPLIT.SLASH.value + "MM" + DATE_SPLIT.SLASH.value + "dd";

    /** 時分フォーマット */
    public static final String TIME_FORMAT_FIXED = "HH:mm";

    /** 時分秒フォーマット */
    public static final String TIME_FORMAT_FULL_FIXED = TIME_FORMAT_FIXED + ":ss";

    /** 年月日時分フォーマット */
    public static final String DATETIME_FORMAT_FIXED = DATE_FORMAT_FIXED + " " + TIME_FORMAT_FIXED;

    /** 年月日時分秒フォーマット */
    public static final String DATETIME_FORMAT_FULL_FIXED = DATE_FORMAT_FIXED + " " + TIME_FORMAT_FULL_FIXED;

    /**
     * LocalDateTimeを、文字列に変換する。
     *
     * @param target 変換対象
     * @param format 変換するフォーマット
     * @return 変換後の文字列
     */
    public static String toString(final LocalDateTime target, final DateTimeFormatter format) {
        if (target == null || format == null) {
            return null;
        }

        try {
            return target.format(format.withResolverStyle(ResolverStyle.STRICT));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * LocalDateTimeを、文字列に変換する。
     *
     * @param target 変換対象
     * @param pattern パターン文字列
     * @param dateSplit 日付の区切り文字
     * @return 変換後の文字列
     */
    public static String toString(final LocalDateTime target, final String pattern, DATE_SPLIT dateSplit) {
        if (target == null || StringUtils.isEmpty(pattern)) {
            return null;
        }

        return toString(target, DateTimeFormatter.ofPattern(pattern.replace(DATE_SPLIT.SLASH.value, dateSplit.value)));
    }

    /**
     * LocalDateTimeを、文字列に変換する。
     *
     * @param target 変換対象
     * @param pattern パターン文字列
     * @return 変換後の文字列
     */
    public static String toString(final LocalDateTime target, final String pattern) {
        if (target == null || StringUtils.isEmpty(pattern)) {
            return null;
        }

        return toString(target, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * LocalDateTimeを、文字列に変換する。<br>
     * DATETIME_FORMAT_FIXED で変換を行う。
     *
     * @param target 変換対象
     * @param dateSplit 日付の区切り文字
     * @return 変換後の文字列(固定長)
     */
    public static String toString(final LocalDateTime target, DATE_SPLIT dateSplit) {
        return toString(target, DATETIME_FORMAT_FIXED, dateSplit);
    }

    /**
     * LocalDateTimeを、文字列に変換する。<br>
     * DATETIME_FORMAT_FIXED で変換を行う。
     *
     * @param target 変換対象
     * @return 変換後の文字列(固定長)
     */
    public static String toString(final LocalDateTime target) {
        return toString(target, DATETIME_FORMAT_FIXED, DATE_SPLIT.SLASH);
    }

    /**
     * LocalDateTimeを、文字列に変換する。<br>
     * '年月日時分秒'フォーマット(DATETIME_FORMAT_FULL_FIXED)で変換を行う。
     *
     * @param target 変換対象
     * @return 変換後の文字列(固定長)
     */
    public static String toFullString(final LocalDateTime target) {
        return toString(target, DATETIME_FORMAT_FULL_FIXED);
    }
}
