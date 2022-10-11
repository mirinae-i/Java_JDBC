package com.mirinae.db;

interface Connectable {

	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	static final String DB_ADDRESS = "localhost";
	static final String DB_PORT = "3306";
	static final String ID = "mirinae";
	static final String PW = "Mur73ARu";
	static final String DB_NAME = "m_member";
	static final String DB_URL = "jdbc:mariadb://" + DB_ADDRESS + ":" + DB_PORT + "/" + DB_NAME;
	
	void checkConn();
	void select();
	void insert(String name, String id, String pw);
}
