package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")
public class Service {

    @GET
    @POST
    public void log(String echo) {
        System.out.println("Received: " + echo);
    }

}
