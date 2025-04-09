package com.ssg.jdbcex.todo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionListener;

@Log4j2
@WebListener
public class LoginListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();

        if (name.equals("loginInfo")) {
            log.info("user logged in.....");
            log.info(value);

        }
    }
}
