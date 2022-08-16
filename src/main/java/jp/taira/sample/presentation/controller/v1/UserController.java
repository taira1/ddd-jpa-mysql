package jp.taira.sample.presentation.controller.v1;

import jp.taira.sample.common.UrlConstants;
import jp.taira.sample.presentation.controller.BaseController;
import jp.taira.sample.presentation.response.UserListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ユーザコントローラークラス
 */
@RestController
@RequestMapping(UrlConstants.USER)
@Tag(name = "")
@RequiredArgsConstructor
@Log4j2
public class UserController extends BaseController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "ユーザ保存", description = "")
    public void create() {
        log.debug("");
    }

    @RequestMapping(value = UrlConstants.USER_LIST, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "ユーザリスト", description = "")
    public UserListResponse list() {
        log.debug("");

        return UserListResponse.builder().build();
    }

}

