package jp.taira.sample.infrastructure.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * ユーザエンティティ
 */
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "mail", "delete_flag" }) })
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** ユーザID */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    /** ニックネーム */
    private String nickname;

    /** メールアドレス */
    private String mail;

    /** パスワード */
    private String password;

    /** 登録状態 */
    private Boolean registrationFlag;

    /** ユーザ区分 */
    private Integer userType;

    /** 削除フラグ */
    @Column(name = "delete_flag", nullable = false)
    private Integer deleteFlag;
}
