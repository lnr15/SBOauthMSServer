package com.example.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipTo {
	
	@JsonProperty("address")
	Address AddressObject;

	// Getter Methods

	public Address getAddress() {
		return AddressObject;
	}

	// Setter Methods

	public void setAddress(Address addressObject) {
		this.AddressObject = addressObject;
	}
}
