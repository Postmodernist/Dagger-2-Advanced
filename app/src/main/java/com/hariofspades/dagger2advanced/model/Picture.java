package com.hariofspades.dagger2advanced.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Picture {

  @SerializedName("large")
  @Expose
  private String large;

  @SerializedName("medium")
  @Expose
  private String medium;

  @SerializedName("thumbnail")
  @Expose
  private String thumbnail;

  public String getLarge() {
    return large;
  }

  public String getMedium() {
    return medium;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("large", large)
        .append("medium", medium)
        .append("thumbnail", thumbnail)
        .toString();
  }
}
