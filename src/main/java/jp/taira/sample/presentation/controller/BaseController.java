package jp.taira.sample.presentation.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class BaseController {

    protected HttpHeaders getApplicationJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));

        return headers;
    }
}

