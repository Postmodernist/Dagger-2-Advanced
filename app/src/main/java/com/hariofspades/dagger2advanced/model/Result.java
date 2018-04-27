package com.hariofspades.dagger2advanced.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Result {

  @SerializedName("gender")
  @Expose
  private String gender;

  @SerializedName("name")
  @Expose
  private Name name;

  @SerializedName("location")
  @Expose
  private Location location;

  @SerializedName("email")
  @Expose
  private String email;

  @SerializedName("login")
  @Expose
  private Login login;

  @SerializedName("dob")
  @Expose
  private String dob;

  @SerializedName("registered")
  @Expose
  private String registered;

  @SerializedName("phone")
  @Expose
  private String phone;

  @SerializedName("cell")
  @Expose
  private String cell;

  @SerializedName("id")
  @Expose
  private Id id;

  @SerializedName("picture")
  @Expose
  private Picture picture;

  @SerializedName("nat")
  @Expose
  private String nat;

  public String getGender() {
    return gender;
  }

  public Name getName() {
    return name;
  }

  public Location getLocation() {
    return location;
  }

  public String getEmail() {
    return email;
  }

  public Login getLogin() {
    return login;
  }

  public String getDob() {
    return dob;
  }

  public String getRegistered() {
    return registered;
  }

  public String getPhone() {
    return phone;
  }

  public String getCell() {
    return cell;
  }

  public Id getId() {
    return id;
  }

  public Picture getPicture() {
    return picture;
  }

  public String getNat() {
    return nat;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("gender", gender)
        .append("name", name)
        .append("location", location)
        .append("email", email)
        .append("login", login)
        .append("dob", dob)
        .append("registered", registered)
        .append("phone", phone)
        .append("cell", cell)
        .append("id", id)
        .append("picture", picture)
        .append("nat", nat).toString();
  }
}
