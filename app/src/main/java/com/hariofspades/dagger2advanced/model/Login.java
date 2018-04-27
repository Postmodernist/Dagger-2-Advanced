package com.hariofspades.dagger2advanced.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Login {

  @SerializedName("username")
  @Expose
  private String username;

  @SerializedName("password")
  @Expose
  private String password;

  @SerializedName("salt")
  @Expose
  private String salt;

  @SerializedName("md5")
  @Expose
  private String md5;

  @SerializedName("sha1")
  @Expose
  private String sha1;

  @SerializedName("sha256")
  @Expose
  private String sha256;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getSalt() {
    return salt;
  }

  public String getMd5() {
    return md5;
  }

  public String getSha1() {
    return sha1;
  }

  public String getSha256() {
    return sha256;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("username", username)
        .append("password", password)
        .append("salt", salt)
        .append("md5", md5)
        .append("sha1", sha1)
        .append("sha256", sha256)
        .toString();
  }
}
