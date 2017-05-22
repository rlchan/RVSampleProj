package rvTestApi;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;


public class Book {

@SerializedName("userId")
@Expose
  private String userId;
@SerializedName("id")
@Expose
  private String id;

@SerializedName("title")
@Expose
  private String title;

@SerializedName("body")
@Expose
  private String body;
  
  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  
  public String getuserId() {
      return userId;
  }

  public void setuserId(String userId) {
      this.userId = userId;
  }
  
  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getBody() {
      return body;
  }

  public void setBody(String body) {
      this.body = body;
  }

  
}
