package de.stattauto.fuhrpark.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // fuer getter und setter
@Entity
public class Auto implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	 private long id;
	private String status;
	 private String standort;
	 private String kennzeichen;
	 

	 
	public Auto(String status, String standort, String kennzeichen) {
		super();
		this.status = status;
		this.standort = standort;
		this.kennzeichen = kennzeichen;
	}
	


}
