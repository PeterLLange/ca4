/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.mycompany.ca4.Airline;
import httpcall.httpcall;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
public class All {

  @Context
  private UriInfo context;

  /**
   * Creates a new instance of A
   */
  public All() {
  }

  /**
   * Retrieves representation of an instance of rest.All
   * @return an instance of java.lang.String
   */

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getText() {
    return " {\"message\" : \"result for all\"}";
  }

  
    @GET
    @Path("Getairplane/{from}/{date}/{tickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetAirline(String from,String date,String tickets) throws Exception
    {
        return new Gson().toJson(httpcall.GetAirport("api/flightinfo/"+from+"/"+date+"/"+tickets));
    }
    public static void main(String[] args) {
      try {
          new All().GetAirline("CPH", "2017-01-03T00:00:00.000Z", "1");
      } catch (Exception ex) {
          Logger.getLogger(All.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    
}
