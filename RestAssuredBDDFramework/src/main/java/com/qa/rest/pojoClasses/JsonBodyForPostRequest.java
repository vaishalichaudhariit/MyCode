package com.qa.rest.pojoClasses;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"first_name",
"last_name",
"avatar",
"createdAt"
})
public class JsonBodyForPostRequest {

@JsonProperty("id")
public Integer id;
@JsonProperty("first_name")
public String firstName;
@JsonProperty("last_name")
public String lastName;
@JsonProperty("avatar")
public String avatar;
@JsonProperty("createdAt")
public String createdAt;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public JsonBodyForPostRequest() {
}

/**
* 
* @param id
* @param lastName
* @param createdAt
* @param avatar
* @param firstName
*/
public JsonBodyForPostRequest(Integer id, String firstName, String lastName, String avatar, String createdAt) {
super();
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.avatar = avatar;
this.createdAt = createdAt;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
