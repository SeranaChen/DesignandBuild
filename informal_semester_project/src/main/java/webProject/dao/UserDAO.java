package webProject.dao;

import webProject.vo.*;

//an interface written to offer specified action of user information
public interface UserDAO {
	public int queryByUserInfo (UserInfo userinfo) throws Exception;
	public UserInfo queryByUserInfo (String userinfo) throws Exception;

	public boolean addUser(String username, String password,String gender,String age,String tel,String email);
	public boolean updateUser(String username, String password,String gender,String age,String tel,String email,int userid);

}
