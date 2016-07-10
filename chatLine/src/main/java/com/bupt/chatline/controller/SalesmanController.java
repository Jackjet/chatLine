package com.bupt.chatline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.chatline.service.SalesmanDaoService;
import com.bupt.chatline.entity.Salesman;

@Controller
@RequestMapping("salesman")
public class SalesmanController {
	@Autowired
	private SalesmanDaoService salesmanDaoService;

	public SalesmanDaoService getSalesmanDaoService() {
		return salesmanDaoService;
	}

	public void setSalesmanDaoService(SalesmanDaoService salesmanDaoService) {
		this.salesmanDaoService = salesmanDaoService;
	}

    @RequestMapping("/")
	public String index(){
		return "salesman";
	}
    
    @RequestMapping("/logins")
	public String loginIndex(){
		return "logins";
	}
    
    @RequestMapping("/logins/authenticate")
	public @ResponseBody Boolean authenticate(@RequestParam(value="name", required=true)String name,@RequestParam(value="password", required=true)String psw){
		return salesmanDaoService.authenticate(name, psw);
	}

    @RequestMapping("/add")
	public @ResponseBody String add(
			@RequestParam(value="name", required=true)String name,
			@RequestParam(value="password", required=true)String password){
    	if(salesmanDaoService.findByName(name)!=null){
    		return "duplicateName";
    	}
    	return "success";
	}
    
    @RequestMapping("/delete")
	public @ResponseBody String delete(@RequestParam(value="id", required=true)int id){
    	salesmanDaoService.deleteById(id);
    	return "success";
	}
    
    
    @RequestMapping("/update")
	public @ResponseBody String update(@RequestParam(value="id", required=true)int id,
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="password", required=false)String password){
    	Salesman salesman = salesmanDaoService.findById(id);
    	if(name!=null)salesman.setName(name);
    	if(password!=null)salesman.setPassword(password);    	
    	if(salesmanDaoService.findByName(name)!=null){
    		return "duplicateName";
    	}
    	salesmanDaoService.save(salesman);
    	return "success";
	}
    
    @RequestMapping("/findAll")
	public @ResponseBody List<Salesman> findAll(){
    	List<Salesman> ls = salesmanDaoService.findAll();
    	for(Salesman s:ls){
    		s.setPassword(null);
    	}
    	return ls;
	}    
}

