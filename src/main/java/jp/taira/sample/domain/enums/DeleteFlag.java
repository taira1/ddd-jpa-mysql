package jp.taira.sample.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザ区分
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DeleteFlag {

    DEFAULT(0, "デフォルト"),
    DELETE(1, "削除"),
    ;

    private Integer key;

    private String value;

}
