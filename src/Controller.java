package com.anitha.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("human")
public class Controller {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Human getHuman() {
		System.out.println("anitha");
		Human h=new Human();
		h.setName("anu");
		h.setId(1);
		h.setPoints(10);
		
		return h;
	}
	

}
