package REST;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import RESTException.FlightException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import httpcall.httpcall;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
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
    public String getAirline(@PathParam("from")String from, @PathParam("date") String date, @PathParam("tickets")String tickets) throws RuntimeException, NotFoundException, FlightException
    {
        System.out.println("Breakpoint");
        try
        {
            String temp = httpcall.GetAirport("api/flightinfo/"+from+"/"+date+"/"+tickets);
            System.out.println(temp);
            JsonElement tempjson;
            tempjson = new JsonParser().parse(temp);
            String newtemp = new Gson().toJson(tempjson);
             
            System.out.println(newtemp);
            if(newtemp == null)
            {
                throw new FlightException();
            }
            return newtemp;
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @GET
    @Path("getairplane/{from}/{to}/{date}/{tickets}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String getAirlineWithDestination(@PathParam("from")String from, @PathParam("to") String to, @PathParam("date") String date, @PathParam("tickets")String tickets)
    {
        try
        {
            String temp = httpcall.GetAirport("api/flightinfo/" + from +"/" + to + "/" + date + "/" +tickets);
            System.out.println(temp);
            JsonElement tempjson;
            tempjson = new JsonParser().parse(temp);
            String newtemp = new Gson().toJson(tempjson);
             
            System.out.println(newtemp);
            if(newtemp == null)
            {
                throw new FlightException();
            }
            return newtemp;
        } catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        return null;
    }
    
}
