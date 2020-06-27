package com.anitha.demorest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("product")
public class ProductResource {
	private ProductDao x=ProductDao.getInstance();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> list(){
		System.out.println("anitha");
		return x.listAll();
	}

}
