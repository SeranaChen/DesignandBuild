package webProject.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webProject.dao.UserDAO;
import webProject.db.DBConnect;
import webProject.vo.UserInfo;

/*
 * the class about all the action on the user information
 */
public class UserDAOImpl implements UserDAO {

	//compare the information when login and decide whether it is a legal user
	public int queryByUserInfo(UserInfo userinfo) throws Exception {
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
  
        // specified action about database   
        try{   
            // connect to database   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,userinfo.getUsername()) ;   
            // search action   
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){  
                // find out content and compare 
                if(rs.getString("password").equals(userinfo.getPassword())){
                	flag = 1;
                } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // close connection   
            dbc.close() ;   
        }   
		return flag;
	}
	
	//a register action one which mainly writes information into database
	public UserInfo queryByUserInfo(String username) throws Exception {
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
     
        try{   
            // connect to database   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,username) ;   
            // search action  
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){  
               UserInfo info=new UserInfo();
               
               //write information into variable firstly
               info.setUserid(rs.getInt("userid"));
               info.setAge(rs.getString("age"));
               info.setEmail(rs.getString("email"));
               info.setGender(rs.getString("gender"));
               info.setPassword(rs.getString("password"));
               info.setTel(rs.getString("tel"));
               info.setUsername(rs.getString("username"));
               return info;
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // close connection   
            dbc.close() ;   
        }   
		return null;
	}
	
	//a register action which mainly writes information into database
	@Override
	public boolean addUser(String username, String password, String gender, String age, String tel, String email) {
		String sql="insert into userinfo(username,password,gender,age,tel,email) values ('"+username+"','"+password+"','"+gender+"','"+age+"','"+tel+"','"+email+"')";
		 PreparedStatement pstmt = null ;   
	        DBConnect dbc = null;   
	  
	          
	        try{   
	             
	            dbc = new DBConnect() ;   
	            pstmt = dbc.getConnection().prepareStatement(sql) ; 
	            pstmt.executeUpdate(); 
	            pstmt.close() ;   
	        }catch (SQLException e){   
	            System.out.println(e.getMessage());   
	        }finally{   
	            dbc.close() ;   
	        }   
		return true;
	}

	
	//an updating action which mainly writes information into database
	@Override
	public boolean updateUser(String username, String password, String gender, String age, String tel, String email,int userid) {
		String sql="update userinfo set username='"+username+"',password='"+password+"',gender='"+gender+"',age='"+age+"',tel='"+tel+"',email='"+email+"' where userid="+userid+"";
		 PreparedStatement pstmt = null ;   
	        DBConnect dbc = null;   
	  
	          
	        try{   
	             
	            dbc = new DBConnect() ;   
	            pstmt = dbc.getConnection().prepareStatement(sql) ; 
	            pstmt.executeUpdate(); 
	            pstmt.close() ;   
	        }catch (SQLException e){   
	            System.out.println(e.getMessage());   
	        }finally{   
	            dbc.close() ;   
	        }   
		return true;
	}

}
