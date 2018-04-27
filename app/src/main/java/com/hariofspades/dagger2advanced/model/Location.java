package com.hariofspades.dagger2advanced.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Location {

  @SerializedName("street")
  @Expose
  private String street;

  @SerializedName("city")
  @Expose
  private String city;

  @SerializedName("state")
  @Expose
  private String state;

  @SerializedName("postcode")
  @Expose
  private String postcode;

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getPostcode() {
    return postcode;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("street", street)
        .append("city", city)
        .append("state", state)
        .append("postcode", postcode).toString();
  }
}
