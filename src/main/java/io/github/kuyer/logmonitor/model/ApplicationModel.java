package io.github.kuyer.logmonitor.model;

import java.io.Serializable;
import java.util.List;

/**
 * 应用信息
 * @author rory.zhang
 */
public class ApplicationModel implements Serializable {

	private static final long serialVersionUID = 8616596991057707856L;
	/** IP地址 **/
	private String ip;
	/** 端口 **/
	private Integer port;
	/** 应用名 **/
	private String name;
	/** 应用别名（非必须） **/
	private String alias;
	/** 版本号 **/
	private String version;
	/** 日志文件所在地址（非必须） **/
	private List<String> logPaths;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<String> getLogPaths() {
		return logPaths;
	}
	public void setLogPaths(List<String> logPaths) {
		this.logPaths = logPaths;
	}

}
