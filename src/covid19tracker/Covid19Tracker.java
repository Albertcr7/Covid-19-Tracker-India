/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Albert
 */
public class Covid19Tracker {
    
   

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws org.json.simple.parser.ParseException
     */
    //private static HttpURLConnection connection;
    
    
       
    
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {

        try {
            Covid19Tracker.covid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void covid() throws Exception {
        String url = "https://corona.lmao.ninja/v2/countries/IN";
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        //con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in ;
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        if(responseCode > 200){
            in = new BufferedReader(
                new InputStreamReader(con.getErrorStream()));
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        }else{
                        in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        }
            
        //print in String
        System.out.println(response.toString());
        
        
        
        //JSON response

        JSONObject jobj  = new JSONObject(response.toString());
        JSONObject cobj = jobj.getJSONObject("countryInfo");
        System.out.println("*************************************************************************************************************************");
        System.out.println("\t\t\tresult after Reading JSON Response");
        System.out.println("*************************************************************************************************************************");
        System.out.println("Country- " + jobj.getString("country"));
        System.out.println("cases- " + jobj.getInt("cases"));
        System.out.println("todayCases- " + jobj.getInt("todayCases"));
        System.out.println("deaths- " + jobj.getInt("deaths"));
        System.out.println("todayDeaths- " + jobj.getInt("todayDeaths"));
        System.out.println("recovered- " + jobj.getInt("recovered"));
        System.out.println("active- " + jobj.getInt("active"));
        System.out.println("critical- " + jobj.getInt("critical"));
        System.out.println("casesPerOneMillion- " + jobj.getInt("casesPerOneMillion"));
        System.out.println("deathsPerOneMillion- " + jobj.getInt("deathsPerOneMillion"));
        System.out.println("tests- " + jobj.getInt("tests"));
        System.out.println("testsPerOneMillion- " + jobj.getInt("testsPerOneMillion"));
        System.out.println("population- " + jobj.getNumber("population"));
        System.out.println("continent- " + jobj.getString("continent"));
        System.out.println("activePerOneMillion- " + jobj.getInt("activePerOneMillion"));
        System.out.println("recoveredPerOneMillion- " + jobj.getInt("recoveredPerOneMillion"));
        System.out.println("_id- " + cobj.getInt("_id"));
        System.out.println("lat- " + cobj.getInt("lat"));
        System.out.println("long- " + cobj.getInt("long"));
        System.out.println("iso2- " + cobj.getString("iso2"));
        System.out.println("iso3- " + cobj.getString("iso3"));
        

    }
}
