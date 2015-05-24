package view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import model.Controller;

@ManagedBean
@RequestScoped
public class AppBean {
	private String ip;
	private String port;
	private String response = "N/A";
	
	@Inject
	Controller controller;
	
	@PostConstruct
	public void start(){
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ip = request.getRemoteAddr();
		
	}
	
	
	
	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	public String getIp() {
		return ip;
	}
	public void setIp(String ipAddress) {
		this.ip= ipAddress;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}

	public void submitTest(){
		System.out.println("Submit......");
		System.out.println(ip);
		System.out.println(port);
		response = controller.dnatTest(port, ip);
	}
}
