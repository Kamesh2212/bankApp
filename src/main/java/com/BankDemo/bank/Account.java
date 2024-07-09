package com.BankDemo.bank;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("balance")
	private Long balance;

	@JsonProperty("accType")
    @Enumerated(EnumType.STRING)
	public AccTypeEnum accType;

	public enum AccTypeEnum {
	    SAVINGS("savings"),
	    
	    CURRENT("current"),
	    
	    VIP("vip");

	    private String value;

	    AccTypeEnum(String value) {
	      this.value = value;
	    }

	    @Override
	    @JsonValue
	    public String toString() {
	      return String.valueOf(value);
	    }

	    @JsonCreator
	    public static AccTypeEnum fromValue(String text) {
	        if (text == null) {
	            throw new IllegalArgumentException("Inappropriate AccType: " + text);
	        }
	        for (AccTypeEnum b : AccTypeEnum.values()) {
	            if (b.value.equalsIgnoreCase(text)) {
	                return b;
	            }
	        }
	        throw new IllegalArgumentException("Inappropriate AccType: " + text);
	    }
	  }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	public AccTypeEnum getAccType() {
		return accType;
	}

	public void setAccType(AccTypeEnum accType) {
		this.accType = accType;
	}


}

