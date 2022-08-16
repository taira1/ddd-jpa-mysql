package jp.taira.sample.presentation.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class UserListResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    private String nickname;

    private String mail;

}