package com.incture.utility;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataConnector {

	//public static void OracleDB_WB(){
	public static ArrayList<ArrayList <String>> FetchQuery(String query){
		Connection conn=null;
		ArrayList<ArrayList <String>> matrix = new ArrayList<ArrayList <String>>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =DriverManager.getConnection("jdbc:oracle:thin:@//34.213.118.108:1521/xe","cwpmc","CWPMC");
			Statement st=conn.createStatement();
			DatabaseMetaData dbmd = conn.getMetaData();
			ResultSetMetaData rsmd;
			ResultSet rs = st.executeQuery(query);
			rsmd = rs.getMetaData();
			
			//int i=0;
			while(rs.next()){
				ArrayList oneRow = new ArrayList<>();
				for(int i=1; i<=rsmd.getColumnCount();i++){
					oneRow.add(rs.getString(i));
				}
				matrix.add(oneRow);
			}
			//System.out.println(matrix);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				conn.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		return matrix;
		}	
	
}
