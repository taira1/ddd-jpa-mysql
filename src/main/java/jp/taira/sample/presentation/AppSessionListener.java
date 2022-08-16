package jp.taira.sample.presentation;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        log.debug("sessionCreated. {}", sessionEvent.getSession().getId());

        HttpSession session = sessionEvent.getSession();
        session.setMaxInactiveInterval(1800);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        log.debug("sessionDestroyed. {}", sessionEvent.getSession().getId());
    }
}
