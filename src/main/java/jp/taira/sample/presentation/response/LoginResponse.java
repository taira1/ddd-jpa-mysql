package jp.taira.sample.presentation.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class LoginResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;

    private String result;

    private String username;

    private String userid;

}
