/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import httpcall.httpcall;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author LouiseB
 */
@Path("allFlights")
public class AllFlights
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AllFlights
     */
    public AllFlights()
    {
    }


  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getText() {
    return " {\"message\" : \"result for all\"}";
  }

  
    @GET
    @Path("getairplane/{from}/{date}/{tickets}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String GetAirline(@PathParam("from")String from, @PathParam("date") String date, @PathParam("tickets")String tickets)
    {
        try
        {
            return new Gson().toJson(httpcall.GetAirport("api/flightinfo/"+from+"/"+date+"/"+tickets));
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
}
