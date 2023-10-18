package webProject.vo;

public class MazeInfo {
	private String robot_name;
	private String username;
	private StringBuffer path = new StringBuffer();
	private StringBuffer time_interval = new StringBuffer();
	private String treasure_picture;
	public String getRobot_name() {
		return robot_name;
	}
	public void setRobot_name(String robot_name) {
		this.robot_name = robot_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public StringBuffer getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = this.path.append(path);
	}
	public StringBuffer getTime_interval() {
		return time_interval;
	}
	public void setTime_interval(String time_interval) {
		this.time_interval.delete(0, this.time_interval.length());
		this.time_interval = this.time_interval.append(time_interval);
	}
	public String getTreasure_picture() {
		return treasure_picture;
	}
	public void setTreasure_picture(String treasure_picture) {
		this.treasure_picture = treasure_picture;
	}
}
