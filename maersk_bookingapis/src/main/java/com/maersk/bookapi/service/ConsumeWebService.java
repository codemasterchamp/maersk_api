package com.maersk.bookapi.service;

import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ConsumeWebService {
   
   @Autowired
   RestTemplate restTemplate;

   @Value("${maesrk.bookings.checkavailable.endpoint}")
   private String maesrkEndpint;

   public boolean checkAvailability() {
        String responString = getAvailability();
        HashMap<String, Boolean> result = null;
        if(responString != null) {
            result = new ObjectMapper().readValue(responString, HashMap.class);    
            if(result.get("available")) {
                return true;
            }
        }
    return false;   
   }

   public String getAvailability() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      return restTemplate.exchange(maesrkEndpint, HttpMethod.GET, entity, String.class).getBody();
   }
}