package webProject.dao;

import webProject.vo.*;

//an interface written to offer specified action of adding maze information 
public interface AddMazeInfoDAO {
	public int queryByMazeNewInfo (MazeInfo mazenewinfo)throws Exception;
}
