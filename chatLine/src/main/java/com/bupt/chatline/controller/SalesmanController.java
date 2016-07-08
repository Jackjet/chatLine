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
    
    @RequestMapping("/login")
	public @ResponseBody Boolean login(@RequestParam(value="id", required=true)String id,@RequestParam(value="password", required=true)String psw){
		return salesmanDaoService.authenticate(id, psw);
	}

    @RequestMapping("/add")
	public @ResponseBody String add(
			@RequestParam(value="name", required=true)String name,
			@RequestParam(value="password", required=true)String password){
    	if(salesmanDaoService.findByName(name)!=null){
    		return "duplicateName";
    	}
    	Salesman salesman = new Salesman(name,password);
    	salesmanDaoService.save(salesman);
    	return "success";
	}
    
    @RequestMapping("/delete")
	public @ResponseBody Boolean delete(@RequestParam(value="id", required=true)int id){
    	salesmanDaoService.deleteById(id);
    	return true;
	}
    
    
    @RequestMapping("/update")
	public @ResponseBody Boolean update(@RequestParam(value="id", required=true)int id,
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="password", required=false)String password){
    	Salesman salesman = salesmanDaoService.findById(id);
    	if(name!=null)salesman.setName(name);
    	if(password!=null)salesman.setPassword(password);
    	salesmanDaoService.update(salesman);
    	return true;
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
