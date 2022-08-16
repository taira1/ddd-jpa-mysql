package jp.taira.sample.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザー区分
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserType {

    USER(0, "ユーザー"),
    ADMIN(1, "管理者"),
    ;

    @Getter
    private Integer key;

    @Getter
    private String value;

}
