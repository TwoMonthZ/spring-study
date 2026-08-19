package com.rly.springiocxml.factoryBean;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public @Nullable User getObject() throws Exception {
        return new User();
    }

    @Override
    public @Nullable Class<?> getObjectType() {
        return User.class;
    }
}
