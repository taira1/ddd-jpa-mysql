package jp.taira.sample.presentation.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

}
