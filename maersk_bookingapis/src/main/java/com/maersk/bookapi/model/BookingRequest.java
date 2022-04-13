package com.maersk.bookapi.model;

import java.io.Serializable;

import lombok.*;

@Data
@Getter
@Setter
public class BookingRequest implements Serializable{

   private static final long serialVersionUID = 1L;

   private String containerSize;
   private String containerType;
   private String origin;
   private String destination;
   private String quantity;

}
