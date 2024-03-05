package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiCSDL {
	public Connection cn;
	public void knCSDL() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://DESKTOP-12J6D6C\\\\SQLEXPRESS:1433;databaseName=FastFoodStore;user=sa; password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
}
