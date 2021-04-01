package com.github.gui.crud.repository.impl;

import com.github.gui.crud.utils.JDBCConnectionPool;

public class PeopleH2Repo extends AbstractJDBCRepo {

    public PeopleH2Repo(JDBCConnectionPool pool) {
        super(pool);
    }
}
