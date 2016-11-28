/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import httpcall.httpcall;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author plaul1
 */
@Path("all")

public class All {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of A
   */
  public All() {
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getText() {
    return " {\"message\" : \"result for all\"}";
  }

  
    @GET
    @Path("getairplane/{from}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetAirline(String from,String date,String tickets) throws Exception
    {
        return new Gson().toJson(httpcall.GetAirport("api/flightinfo/"+from+"/"+date+"/"+tickets));
    }

    
    
}
