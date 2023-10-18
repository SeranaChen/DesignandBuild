package webProject.dao;

import webProject.vo.*;


//an interface written to offer specified action of showing maze information
public interface ShowMazeInfoDAO {
	public String[][] queryByMazeShowInfo (String username)throws Exception;
}
