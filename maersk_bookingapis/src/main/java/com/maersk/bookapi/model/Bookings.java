package com.maersk.bookapi.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "bookings")
@EqualsAndHashCode
@Data
public class Bookings implements Serializable {

   @Id
   @GeneratedValue(generator = "uuid2")
   @GenericGenerator(name="uuid2", strategy="uuid2")
   @Column(name ="id", unique=true)
   private Long id;
   
   @Column(name ="container_size")
   @Size(min=20, max=40)
   private Integer containerSize;

   @Column(name ="container_type")
   @Enumerated(EnumType.STRING)
   private ContainerType containerType;

   @Column(name ="origin")
   @Size(min=5, max=20)
   private String origin;

   @Column(name ="destination")
   @Size(min=5, max=20)
   private String destination;

   @Column(name ="quantity")
   @Size(min=1, max=100)
   private String quantity;

   @Column(name ="timestamp")
   private ZonedDateTime timestamp;

}
