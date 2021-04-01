package com.github.gui.crud.repository.impl;

import com.github.gui.crud.utils.JDBCConnectionPool;

public class PeopleMySqlRepo extends AbstractJDBCRepo {

    public PeopleMySqlRepo(JDBCConnectionPool pool) {
        super(pool);
    }
}
