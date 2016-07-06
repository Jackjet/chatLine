package com.bupt.chatline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.chatline.dao.SalesmanDao;
import com.bupt.chatline.entity.Salesman;

@Controller
@RequestMapping("salesman")
public class SalesmanController {
	@Autowired
	private SalesmanDao salesmanDao;

	public SalesmanDao getSalesmanDao() {
		return salesmanDao;
	}

	public void setSalesmanDao(SalesmanDao salesmanDao) {
		this.salesmanDao = salesmanDao;
	}

    @RequestMapping("/")
	public String index(){
		return "salesman";
	}
    
    @RequestMapping("/login")
	public @ResponseBody Boolean login(@RequestParam(value="id", required=true)String id,@RequestParam(value="password", required=true)String psw){
		return salesmanDao.authenticate(id, psw);
	}

    @RequestMapping("/add")
	public @ResponseBody String add(
			@RequestParam(value="name", required=true)String name,
			@RequestParam(value="password", required=true)String password){
    	if(salesmanDao.findByName(name)!=null){
    		return "duplicateName";
    	}
    	Salesman salesman = new Salesman(name,password);
    	salesmanDao.save(salesman);
    	return "success";
	}
    
    @RequestMapping("/delete")
	public @ResponseBody Boolean delete(@RequestParam(value="id", required=true)int id){
    	salesmanDao.deleteById(id);
    	return true;
	}
    
    
    @RequestMapping("/update")
	public @ResponseBody Boolean update(@RequestParam(value="id", required=true)int id,
			@RequestParam(value="name", required=false)String name,
			@RequestParam(value="password", required=false)String password){
    	Salesman salesman = salesmanDao.findById(id);
    	if(name!=null)salesman.setName(name);
    	if(password!=null)salesman.setPassword(password);
    	salesmanDao.update(salesman);
    	return true;
	}
    
    @RequestMapping("/findAll")
	public @ResponseBody List<Salesman> findAll(){
    	List<Salesman> ls = salesmanDao.findAll();
    	for(Salesman s:ls){
    		s.setPassword(null);
    	}
    	return ls;
	}    
}
