/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ca4;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ehn19
 */
public class DummyAirlineRestIntegrationTest {

    @Before
    public void setUp() {

    }

    @Test
    public void webpageIsRunning() {
        given().when().get("http://localhost:8080/Semesterprojekt").then().statusCode(200);
    }

    @Test
    public void webpageIsNotRunning2() {
        given().when().get("http://localhost:8080/SemesterprojektFail").then().statusCode(404);
       
    }
    
    @Test
    public void getFlightWithFromDateTickets()
    {
        expect().
                body("get(0).flightID", equalTo("2215-1483448400000")).
                when().
                get("/date/2017-01-03T08:00:00.000Z/tickets/2");
        
        
        
    }

//    @Test
//    public void getFlightWithFromDateTickets2()
//    {
//        when().
//                get("/date/{date}/tickets/{tickets}",2017-01-03,2).
//        then().statusCode(200).
//                body("flight.date", equalTo(2017-01-03),"flight.numberOfSeats", equalTo(2));
//    }
//    
//    @Test
//    public Reservation postReservationWithFlightIdPassengers()
//    {
//      List<Passenger> passengers = new ArrayList();  
//      Collection<Passenger> passengers;
//    } 
    
//    @Test
//    public void statusCode404()
//    {
//        given().when().get("/date/{date}/tickets/{tickets}\",2080-01-03,2").then().statusCode(404);
//    }
//    
//    @Test
//    public void statusCode200()
//    {
//        given().when().get("/date/{date}/tickets/{tickets}\",2080-01-03,2").then().statusCode(404);
//    }
}
