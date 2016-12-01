/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpcall;

import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Emil
 */
public class httpcall {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static ArrayList<String> urls = null;

    public httpcall() {
        urls = new ArrayList<>();
        urls.add("http://airline-plaul.rhcloud.com/");
        //urls.add("http://46.101.239.114/DummyAirlinenew-1.0/");
    }

    // HTTP GET request
    public static String GetAirport(String paremeter) throws Exception {
        // api/flightinfo/CPH/2017-01-03T00:00:00.000Z/1
        if (urls == null) {
            new httpcall();
        }
        StringBuffer response = new StringBuffer();
        for (String url : urls) {
            try {
                
            

            URL obj = new URL(url+paremeter);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url +paremeter);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        return response.toString();
    }
    // HTTP GET request
//    private static String sendGet() throws Exception {
//
//        String url = "http://www.google.com/search?q=mkyong";
//
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        // optional default is GET
//        con.setRequestMethod("GET");
//
//        //add request header
//        con.setRequestProperty("User-Agent", USER_AGENT);
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//
//        //print result
//        System.out.println(response.toString());
//        return response.toString();
//    }
    // HTTP POST request

    private static String sendPost(String paremeter, JsonObject flight) throws Exception {

        String url = "http://airline-plaul.rhcloud.com/" + paremeter;
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(flight.getAsString());
        wr.flush();
        wr.close();
        flight.getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject().getAsJsonObject();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + flight.getAsString());
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return response.toString();
    }
}
