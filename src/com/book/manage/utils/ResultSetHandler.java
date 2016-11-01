package com.book.manage.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler<T>{
	T handle(ResultSet set) throws SQLException;
}
