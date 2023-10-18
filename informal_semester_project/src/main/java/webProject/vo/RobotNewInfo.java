package webProject.vo;

public class RobotNewInfo {
	private String robot_name;
	private String username;
	private StringBuffer robot_picture;
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
	public StringBuffer getPicture() {
		return robot_picture;
	}
	public void setPicture(StringBuffer robot_name_Buffer) {
		this.robot_picture = robot_name_Buffer;
	}
}
