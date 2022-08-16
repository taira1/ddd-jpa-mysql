package jp.taira.sample.presentation.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import jp.taira.sample.utils.DateTimeUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
abstract class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    private String datetime = DateTimeUtils.toFullString(LocalDateTime.now());

}
