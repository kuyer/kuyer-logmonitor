package io.github.kuyer.logmonitor;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMonitor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private volatile String logFilePath;
	private volatile long lastReadSize = 0l;
	private volatile boolean isRunning = false;
	
	private boolean flag = true;
	RandomAccessFile raf = null;
	
	public LogMonitor() {
		init();
	}

	private void init() {
		logger.info("init log monitor.");
		logFilePath = "D:/mylog.txt";
		
		try {
			raf = new RandomAccessFile(logFilePath, "r");
		} catch (Exception e) {
			logger.error("open log file error. logFilePath={}", e, logFilePath);
		}
		if(null == raf) {
			flag = false;
		}
	}
	
	public LogMonitor monitor() {
		while(flag) {
			if(isRunning) {
				continue;
			}
			isRunning = true;
			long fileLength = -1l;
			try {
				fileLength = raf.length();
			} catch (Exception e) {
				logger.error("get log file length error. logFilePath={}", e, logFilePath);
			}
			if(fileLength <= 0l) {
				isRunning = false;
				continue;
			}
			if(lastReadSize == fileLength) {
				isRunning = false;
				continue;
			}
			if(fileLength < lastReadSize) {
				lastReadSize = 0l;
			}
			String content = null;
			try {
				raf.seek(lastReadSize);
				StringBuilder sb = new StringBuilder();
				String tmp = "";
				while((tmp = raf.readLine())!= null) {
					String str = new String(tmp.getBytes("ISO8859-1"), "UTF-8");
					if(null != str) {
						sb.append(str);
					}
				}
				if(null != sb) {
					content = sb.toString();
				}
			} catch (Exception e) {
				logger.error("read log content error. logFilePath={}", e, logFilePath);
			}
			if(null != content) {
				logger.info("read: "+content);
			}
			if(lastReadSize < fileLength) {
				lastReadSize = fileLength;
			}
			isRunning = false;
		}
		return this;
	}
	
	public void close() {
		if(null != raf) {
			try {
				raf.close();
			} catch (IOException e) {
				logger.error("close log file error. logFilePath={}", e, logFilePath);
			}
		}
	}

	public static void mainx(String[] args) {
		new LogMonitor().monitor().close();
	}

}
