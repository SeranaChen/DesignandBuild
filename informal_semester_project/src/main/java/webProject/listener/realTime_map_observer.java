package webProject.listener;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import java.io.File;

public class realTime_map_observer {
	private FileAlterationMonitor monitor;

	public realTime_map_observer(long interval) {
		monitor = new FileAlterationMonitor(interval);
	}

	/**
	 * add the listener on the specified document folder
	 *
	 * @param path     文件路径
	 * @param listener 文件监听器
	 */
	public void monitor(String path, FileAlterationListener listener) {
		FileAlterationObserver observer = new FileAlterationObserver(new File(path));
		monitor.addObserver(observer);
		observer.addListener(listener);
	}

	public void stop() throws Exception {
		monitor.stop();
	}

	public void start() throws Exception {
		monitor.start();

	}
}
