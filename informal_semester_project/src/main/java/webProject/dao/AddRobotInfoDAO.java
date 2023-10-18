package webProject.dao;

import webProject.vo.*;

//an interface written to offer specified action of adding robot information
public interface AddRobotInfoDAO {
	public int queryByRobotNewInfo (RobotNewInfo robotnewinfo)throws Exception;
}
