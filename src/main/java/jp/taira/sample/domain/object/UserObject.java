package jp.taira.sample.domain.object;

import lombok.Builder;
import lombok.Data;

/**
 * ユーザードメインオブジェクト
 */
@Data
@Builder
public class UserObject {

    private String nickname;
}
