package webProject.dao;

import webProject.vo.*;

//an interface written to offer specified action of showing robot information
public interface ShowRobotInfoDAO {
	public String[][] queryByRobotShowInfo (RobotNewInfo robotshowinfo)throws Exception;
}
