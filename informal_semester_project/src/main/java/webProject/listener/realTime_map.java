package webProject.listener;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import webProject.dao.AddMazeInfoDAO;
import webProject.dao.UserDAO;
import webProject.vo.*;
import webProject.dao.impl.*;
import java.nio.file.*;
import java.util.concurrent.*;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class realTime_map implements FileAlterationListener {
	public static StringBuffer path_info = new StringBuffer();
	public static String[][] time_sets = new String[1000][2];
	public int is_watch_time = 0;
	static MazeInfo mazeinfo = new MazeInfo();
	static AddMazeInfoDAO mazeinfodao = new AddMazeInfoDAOImpl();
	
	private long lastFileTime = System.currentTimeMillis();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	
    public realTime_map(){
    	executor.scheduleAtFixedRate(this::checkForNewFiles, 10, 10, TimeUnit.SECONDS);
    }//The checkForNewFiles method starts executing after an initial delay of 10 seconds, and then executes again every 10 seconds
    
    private void checkForNewFiles() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFileTime >= 10000) {
            System.out.println("NO NEW DOCUMENT");
            realTime_map.mazeinfo.setPath(realTime_map.path_info.toString());
            realTime_map.mazeinfo.setTime_interval(realTime_map.time_sets[drawMap.number-1][1]);
            int flag;
			try {
				flag = realTime_map.mazeinfodao.queryByMazeNewInfo(realTime_map.mazeinfo);
				if(flag==1) {
	            	System.out.println("ALL THE PATHS OF ROBOT HAVE BEEN INPUT INTO THE DATABASE");
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
    
	@Override
	public void onDirectoryChange(File arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDirectoryCreate(File arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDirectoryDelete(File arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFileChange(File arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFileCreate(File file) {
		// TODO Auto-generated method stub
		lastFileTime = System.currentTimeMillis();
		String compressedPath = file.getAbsolutePath();
		String compressedPath_without_fileName = compressedPath.substring(0, compressedPath.lastIndexOf("\\"));
		System.out.println("compressedPath_without_fileName="+compressedPath_without_fileName);
		System.out.println("NEW：" + compressedPath);
		if (file.canRead()) {
			// TODO Read or reload the file contents
			System.out.println("CONTENT IS DIFFERENT, GO TO HANDLE IT");
			String suffix = compressedPath.substring(compressedPath.lastIndexOf(".")+1);
			System.out.println(suffix);
			
			//if the content is images, then takes the address into the variable mazeinfo.treasure_picture_path_cut
			if(suffix.equals("jpg")||suffix.equals("jpeg")||suffix.equals("png")) {
				System.out.println("compressedPath_without_fileName="+compressedPath_without_fileName);
				System.out.println("into image");
				String treasure_picture_path = compressedPath.substring(compressedPath.lastIndexOf("upload")+7);
				String treasure_picture_path_cut = treasure_picture_path.replaceAll("\\\\", "/");//replaceAll doesn't mutate the original string but makes a copy of the variable, so it needs a variable to follow
				String username_copy = treasure_picture_path.substring(0, treasure_picture_path.lastIndexOf("_"));
				String robot_name_copy = treasure_picture_path.substring(treasure_picture_path.lastIndexOf("_")+1, treasure_picture_path.lastIndexOf("\\data"));
				System.out.println(treasure_picture_path_cut);
				System.out.println(username_copy);
				System.out.println(robot_name_copy);
				mazeinfo.setUsername(username_copy);
				mazeinfo.setRobot_name(robot_name_copy);
				mazeinfo.setTreasure_picture(treasure_picture_path_cut);
			}
			//if the content is txt i.e. the path information, then takes the address into the variable path_info
			else if(suffix.equals("txt")) {
				System.out.println("compressedPath_without_fileName="+compressedPath_without_fileName);
				System.out.println("into txt");
				String treasure_picture_path = compressedPath.substring(compressedPath.lastIndexOf("upload")+7);
				String treasure_picture_path_cut = treasure_picture_path.replaceAll("\\\\", "/");//replaceAll doesn't mutate the original string but makes a copy of the variable, so it needs a variable to follow
				String username_copy = treasure_picture_path.substring(0, treasure_picture_path.lastIndexOf("_"));
				String robot_name_copy = treasure_picture_path.substring(treasure_picture_path.lastIndexOf("_")+1, treasure_picture_path.lastIndexOf("\\data"));
				System.out.println(treasure_picture_path_cut);
				System.out.println(username_copy);
				System.out.println(robot_name_copy);
				mazeinfo.setUsername(username_copy);
				mazeinfo.setRobot_name(robot_name_copy);
				mazeinfo.setTreasure_picture(treasure_picture_path_cut);
		        BufferedReader br;
		        //store the path information and draw the image(invoke the drawing function)
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(compressedPath)));
					for (String line = br.readLine(); line != null; line = br.readLine()) {
			            if(line.equals("1")||line.equals("2")||line.equals("3")) {
			            	path_info.append(line+" ");	
			            }
			            else {
			            	if(drawMap.number==0) {
			            		System.out.println("now drawMap.number="+drawMap.number);
			            		time_sets[drawMap.number][0] = "0";//The first line has an initial time of 0 and an end time of line
				            	time_sets[drawMap.number][1] = line;
			            		String[] content = new String[]{"C:\\Users\\35177\\Desktop\\upload\\Maze1.png", "2", time_sets[drawMap.number][0], time_sets[drawMap.number][1]};
			            		drawMap.method(content);
			            	}
			            	else {
			            		time_sets[drawMap.number][0] = time_sets[drawMap.number-1][1];
				            	time_sets[drawMap.number][1] = line;
				            	String direction = String.valueOf(path_info.charAt(2*drawMap.number-2));
				            	String[] content = new String[]{"C:\\Users\\35177\\Desktop\\upload\\Maze1.png", direction, time_sets[drawMap.number][0], time_sets[drawMap.number][1]};
				            	drawMap.method(content);
			            	}
			            }
			            
			        }
			        br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
			}
		}
	}

	@Override
	public void onFileDelete(File file) {
		// TODO Auto-generated method stub
		String compressedPath = file.getAbsolutePath();
		System.out.println("MODIFY：" + compressedPath);
	}

	@Override
	public void onStart(FileAlterationObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(FileAlterationObserver observer) {
		// TODO Auto-generated method stub
		
	}

}
