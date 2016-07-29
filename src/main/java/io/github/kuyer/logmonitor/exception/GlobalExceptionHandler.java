package io.github.kuyer.logmonitor.exception;

import io.github.kuyer.logmonitor.model.BaseModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=HtmlException.class)
	public ModelAndView handleHtmlException(HttpServletRequest request, HtmlException e) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@ExceptionHandler(value=JsonException.class)
	@ResponseBody
	public BaseModel handleJsonException(HttpServletRequest request, JsonException e) {
		BaseModel model = new BaseModel();
		model.setCode("500");
		model.setDesc("throw a json exception.");
		return model;
	}

}
