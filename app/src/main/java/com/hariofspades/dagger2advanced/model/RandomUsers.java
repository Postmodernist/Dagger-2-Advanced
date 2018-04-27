package com.hariofspades.dagger2advanced.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RandomUsers {

  @SerializedName("results")
  @Expose
  private List<Result> results;

  @SerializedName("info")
  @Expose
  private Info info;

  public List<Result> getResults() {
    return results;
  }

  public Info getInfo() {
    return info;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("results", results)
        .append("info", info)
        .toString();
  }

}
