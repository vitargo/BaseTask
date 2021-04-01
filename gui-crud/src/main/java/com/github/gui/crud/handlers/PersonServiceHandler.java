package com.github.gui.crud.handlers;

import com.github.gui.crud.exceptions.NotValidParameterException;
import com.github.gui.crud.services.IPeopleService;
import com.github.gui.crud.utils.people.PersonNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Objects;

public class PersonServiceHandler implements InvocationHandler {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceHandler.class);

    private final IPeopleService peopleService;

    public PersonServiceHandler(IPeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Before call to method: {}, with args: {}", method.getName(), args);
        Parameter[] params = method.getParameters();
        for (int i = 0; i < params.length; i++) {
            if(params[i].isAnnotationPresent(PersonNotNull.class)){
                if(Objects.isNull(args[i])){
                    throw new NotValidParameterException("Person can not be null!");
                }
            }
        }
        Object result = null;
        try {
            result = method.invoke(peopleService, args);
        } catch (UndeclaredThrowableException e) {
            log.info(e.getMessage());
        }

        log.info("After call to method: {}", result);
        return result;
    }
}
