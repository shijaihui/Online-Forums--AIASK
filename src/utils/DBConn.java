package utils;

import java.sql.*;

public class DBConn {
	
		private static DBConn singleton;
		
		public static DBConn getInstance(){
			try{
				if(null == singleton){
					Thread.sleep(1000);
					synchronized (DBConn.class){
						if(null == singleton){
							singleton = new DBConn();
						}
					}
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			return singleton;
		}

	   static  String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static  String DB_URL = "jdbc:mysql://localhost/qiuwen?characterEncoding=utf8&useAffectedRows=true";
	   static  String USER = "root";
	   static  String PASS = "0709";
	   
	   public static void setJDBC(String driver){
		   JDBC_DRIVER = driver;
	   }
	   public static void setDBURL(String url){
		   DB_URL = url;
	   }
	   public static void setUSER(String user){
		   USER = user;
	   }
	   public static void setPASS(String pass){
		   PASS = pass;
	   }

	   public static String getDRI(){
		   return JDBC_DRIVER;
	   }
	   
	   public static String getURL(){
		   return DB_URL;
	   }
	   
	   public static String getUsr(){
		   return USER;
	   }
	   
	   public static String getPWD(){
		   return PASS;
	   }
	   
	   
	   private Connection conn = null;
	   private Statement stmt = null;
	   private ResultSet rs = null;

	   public void startTrans(){
		   try{
			   Class.forName(JDBC_DRIVER);
			   System.out.println("Connecting to database...");
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   conn.setAutoCommit(false);
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			   System.out.println("transaction is start...");
	       }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }

	   public void startConn(){
		   try{
			   Class.forName(JDBC_DRIVER);
			   System.out.println("Connecting to database...");
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   conn.setAutoCommit(false);
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			   System.out.println("transaction is start...");
		   }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
	   
	   public ResultSet query(String sql){
		   try{
			   rs = stmt.executeQuery(sql);
			   return rs;
		   }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return rs;
	   }

	   public boolean execute(String sql){
		   try{
			   int rs = stmt.executeUpdate(sql);
			   if(rs == 0){
				   return false;
			   }else{
				   return true;
			   }
		   }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return false;
	   }

	   public void commit(){
		   try{
			   conn.commit();
		   }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }

	   public void rollback(){
		   try{
			   conn.rollback();
		   }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }

	   public void close(){
		   try{
			   //rs.close();
			   //stmt.close();
			   //conn.close();
			   conn.commit();
		   }catch(SQLException se){
			   se.printStackTrace();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	   }
}
