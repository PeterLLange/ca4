///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package REST;
//
//import com.google.gson.Gson;
//import com.mycompany.ca4.Flight;
//import java.util.List;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.UriInfo;
//
//@Path("flightinfo")
//public class RESTFlight
//{
//    FlightFacade flightFacade = new FlightFacade();
//    @Context
//    private UriInfo context;
//
//    public RESTFlight()
//    {
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getFlightsWithFromDateTickets()
//    {
//        List<Flight> flights = flightFacade.getAllFlights();
//        return new Gson().toJson(flights);
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getFlightsWithFromToDateTickets()
//    {
//        throw new UnsupportedOperationException();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public void postReservationWithFlightIdPassengers(String content)
//    {
//    }
//}
