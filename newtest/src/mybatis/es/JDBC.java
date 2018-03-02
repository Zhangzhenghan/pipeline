package mybatis.es;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JDBC {
	
	//数据库连接
			private String driver="com.mysql.jdbc.Driver";
//			private String url="jdbc:mysql://localhost:3306/mydb";//连接数据库字符串
			private String url="jdbc:mysql://172.16.2.162:3307/text_db";
			private String uid="root";//数据库
			private String pwd="root";//用户密码
			Connection conn=null;//数据库连接对象
			
			//获取数据库连接对象
			public Connection getConnection(){
				if(conn==null){
					try{
						Class.forName(driver);//加载驱动
						conn=DriverManager.getConnection(url,uid,pwd);//建立连接
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				return conn;
			}
			
			//关闭数据库连接
			public void closeAll(Connection conn,Statement stmt,ResultSet rs){
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(stmt!=null){
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}

		//增删改操作
		public int exceutUpdate(String prepareSql,Object[] param){
			PreparedStatement pstmt=null;
			int num=0;
			conn=getConnection();
			
			try {
				pstmt=conn.prepareStatement(prepareSql);
				if(param!=null){
					for(int i=0;i<param.length;i++){
						pstmt.setObject(i+1,param[i]);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn,pstmt,null);
			}
			return num;
		}
		
		//批量添加
		public int insertInfo(List<Map> list,String sql){
			String uuid="";
			PreparedStatement pstmt=null;
			int num=0;
			conn=getConnection();
			try {
				pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					for(Map map:list){
						uuid =  UUID.randomUUID().toString();//.replaceAll("-", "");
						pstmt.setString(1, (String) uuid);  
						pstmt.setString(2, (String) map.get("value"));  
						pstmt.addBatch(); 
					}
				pstmt.executeBatch();  
//				      conn.commit();  
//				      conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeAll(conn,pstmt,null);
			}
			
			return num;
		}

}
