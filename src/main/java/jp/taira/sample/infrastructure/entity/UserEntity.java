package jp.taira.sample.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ユーザーエンティティ
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 姓 */
    private String firstname;

    /** 名 */
    private String lastname;

    /** 性別 */
    private String gender;

}
