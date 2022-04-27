package com.senpiper.liv2train.CONTROLLER;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.senpiper.liv2train.BEAN.EnrollmentBean;
import com.senpiper.liv2train.SERVICE.EnrollmentServiceIMPL;

@RestController
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceIMPL service;
	
	@RequestMapping(value="/greeting",method=RequestMethod.GET)
	public String hi() {
		return "Welcome";
	}
	@RequestMapping(value="/enroll", method= RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String save(@Valid @RequestBody EnrollmentBean bean) {
		service.saveall(bean);
		return "Saved Successfully";
	}
	
	@RequestMapping(value="/allrecords", method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EnrollmentBean> findall(){
		List<EnrollmentBean> records = service.findall();
		return records;
	}
	
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity handleAllException(MethodArgumentNotValidException ex) {
		List<String> details = new ArrayList<>();
	    for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	      details.add(error.getDefaultMessage());
	    }
	    ErrorResponse error = new ErrorResponse("Validation Failed", details);
	    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

}
