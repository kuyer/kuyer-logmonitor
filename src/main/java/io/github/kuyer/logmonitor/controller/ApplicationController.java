package io.github.kuyer.logmonitor.controller;

import io.github.kuyer.logmonitor.model.ApplicationModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	@RequestMapping(value="/applications/get", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<ApplicationModel> getApplications() {
		List<ApplicationModel> list = new ArrayList<ApplicationModel>();
		
		List<String> logPaths = new ArrayList<String>();
		logPaths.add("/var/log/user-service/access.log");
		logPaths.add("/var/log/user-service/application.log");
		ApplicationModel am = new ApplicationModel();
		am.setIp("192.168.56.101");
		am.setPort(8081);
		am.setName("user-service");
		am.setAlias("用户服务");
		am.setVersion("1.0.12");
		am.setLogPaths(logPaths);
		list.add(am);
		
		logPaths = new ArrayList<String>();
		logPaths.add("/var/log/order-service/access.log");
		logPaths.add("/var/log/order-service/application.log");
		am = new ApplicationModel();
		am.setIp("192.168.56.102");
		am.setPort(8080);
		am.setName("order-service");
		am.setAlias("订单服务");
		am.setVersion("3.0.12");
		am.setLogPaths(logPaths);
		list.add(am);
		
		return list;
	}

}
