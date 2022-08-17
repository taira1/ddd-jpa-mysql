package jp.taira.sample.domain.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登録状態
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RegistrationFlag {

    DEFINITIVE(true, "本登録"),
    PROVISIONAL(false, "仮登録"),
    ;

    @Getter
    private final Boolean key;

    @Getter
    private final String value;
}
