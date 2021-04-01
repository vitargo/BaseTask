package com.github.gui.crud.repository.impl;

import com.github.gui.crud.utils.JDBCConnectionPool;

public class PeoplePostgreSQLRepo extends AbstractJDBCRepo {

    public PeoplePostgreSQLRepo(JDBCConnectionPool pool) {
        super(pool);
    }
}
