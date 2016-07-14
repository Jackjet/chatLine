package com.bupt.chatline.service.impl;


import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.bupt.chatline.mes.MesHolder;
import com.bupt.chatline.service.PhoneMesSendService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Service("phoneMesSendService")
public class PhoneMesSendServiceImpl implements PhoneMesSendService {

	private Client client = null;
	private WebResource webResource = null;
	@Override
	public boolean send(String phone, String content) {
		try{
			if(!MesHolder.pattern.matcher(phone).matches()){
				return false;
			}
			if(client == null){
				client = new Client();
//				client.addFilter(new HTTPBasicAuthFilter("api","key-5aa902877daf5d408ba1b242be35a7b5"));
				webResource = client.resource("http://sms-api.luosimao.com/v1/send.json");
			}
			MultivaluedMapImpl formData = new MultivaluedMapImpl();
			formData.add("mobile", phone);
			formData.add("message", content+"【Luosimao】");
			ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
					.post(ClientResponse.class,formData);
			String textentity = response.getEntity(String.class);
			JSONObject o = new JSONObject(textentity);
			if(o.getInt("error") == 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

}
