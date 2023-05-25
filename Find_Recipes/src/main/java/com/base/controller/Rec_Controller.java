package com.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.base.dao.Res_Dao;
import com.base.model.Res_Data;


@Controller
public class Rec_Controller {

	@Autowired
	private Res_Dao res_Dao;
	
	
	@RequestMapping("/home")
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	
	
	@RequestMapping("/addnew")
	public ModelAndView insertForm(){
		return new ModelAndView("insertData","rec_data",new Res_Data());
	}
	
	
	@RequestMapping(value="/insertData", method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Res_Data rec_data){
		System.out.println(rec_data);
		
		res_Dao.insert(rec_data);
		
		return new ModelAndView("home");
	}
	
	
	@RequestMapping(value="/viewAll")
	public ModelAndView viewData(HttpSession session,HttpServletRequest request){
		session=request.getSession();
		
		List<Res_Data> list= res_Dao.viewAll();
		
		session.setAttribute("data", list);
		
		return new ModelAndView("viewAll");
	}
		
}
