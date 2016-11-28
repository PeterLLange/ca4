///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.ca4;
//
//import static io.restassured.RestAssured.given;
//import java.util.ArrayList;
//import java.util.List;
//import static org.hamcrest.CoreMatchers.equalTo;
//import org.junit.Before;
//import org.junit.Test;
//
//public class DummyAirlineRestIntegrationTest
//{
//
//    @Before
//    public void setUp()
//    {
//
//    }
//
//    @Test
//    public void webpageIsRunning()
//    {
//        given().when().get("http://localhost:8080/Semesterprojekt").then().statusCode(200);
//    }
//
//    @Test
//    public void webpageIsNotRunning()
//    {
//        given().when().get("http://localhost:8080/SemesterprojektFail").then().statusCode(404);
//
//    }
//
//    @Test
//    public void webpageIsRunning2()
//    {
//        given().when().get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2").then().statusCode(200);
//
//    }
//
//    @Test
//    public void statusCode200FlightID()
//    {
//        List<String> flightID = new ArrayList();
//        flightID.add("2215-1483448400000");
//        flightID.add("2217-1483480800000");
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.flightID", equalTo(flightID));
//    }
//
//    @Test
//    public void statusCode200NumberOfSeats()
//    {
//
//        List<Integer> numberOfSeats = new ArrayList();
//        numberOfSeats.add(2);
//        numberOfSeats.add(2);
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.numberOfSeats", equalTo(numberOfSeats));
//    }
//
//    @Test
//    public void statusCode400NumberOfSeats()
//    {
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/1000")
//                .then().statusCode(400);
//    }
//
//    @Test
//    public void statusCode200Date()
//    {
//
//        List<String> date = new ArrayList();
//        date.add("2017-01-03T08:00:00.000Z");
//        date.add("2017-01-03T17:00:00.000Z");
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.date", equalTo(date));
//    }
//
//    @Test
//    public void statusCode400Date()
//    {
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00555555500:00.000Z/2")
//                .then().statusCode(400);
//    }
//
//    @Test
//    public void statusCode200TravelTime()
//    {
//
//        List<Integer> travelTime = new ArrayList();
//        travelTime.add(60);
//        travelTime.add(90);
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.traveltime", equalTo(travelTime));
//    }
//
//    @Test
//    public void statusCode200Origin()
//    {
//
//        List<String> origin = new ArrayList();
//        origin.add("SXF");
//        origin.add("SXF");
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.origin", equalTo(origin));
//    }
//
//    @Test
//    public void statusCode400Origin()
//    {
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/LOUISE/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(400);
//    }
//
//    @Test
//    public void statusCode200Destination()
//    {
//
//        List<String> destination = new ArrayList();
//        destination.add("CPH");
//        destination.add("CPH");
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.destination", equalTo(destination));
//    }
//
//    @Test
//    public void statusCode200FlightNumber()
//    {
//
//        List<String> flightNumber = new ArrayList();
//        flightNumber.add("COL2215");
//        flightNumber.add("COL2217");
//
//        given()
//                .contentType("application/json")
//                .when()
//                .get("http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2")
//                .then().statusCode(200)
//                .body("flights.flightNumber", equalTo(flightNumber));
//    }
//
//}
