package webProject.dao;

import webProject.vo.*;

//an interface written to offer specified action of deleting robot information
public interface DeleteRobotInfoDAO {
	public int queryByRobotDeleteInfo (RobotNewInfo robotdeleteinfo)throws Exception;
}
