package com.cg.ma.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.ma.exception.MobileException;

public class DBUtil {

	private static Connection con;
	public static Connection getConnection() throws MobileException {
		if(con==null) {
			try {
				InitialContext ic=new InitialContext();
				DataSource ds=(DataSource)ic.lookup("java:/OracleDS");
				con=ds.getConnection();
			} catch(NamingException e) {
				throw new MobileException("Problem in obtaining the DataSource"+e.getMessage());
			} catch(SQLException e) {
				throw new MobileException("Problem in DataBase "+e.getMessage());
			}
		}
		return con;
	}
	
}
