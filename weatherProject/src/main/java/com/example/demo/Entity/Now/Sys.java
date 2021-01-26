
package com.example.demo.Entity.Now;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "country",
    "sunrise",
    "sunset"
})
public class Sys {

    @JsonProperty("message")
    private Double message;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private long sunrise;
    @JsonProperty("sunset")
    private long sunset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("message")
    public Double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Double message) {
        this.message = message;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("sunrise")
    public long getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(long sunrise) {
        this.sunrise = sunrise*1000;
    }

    @JsonProperty("sunset")
    public long getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(long sunset) { this.sunset = sunset*1000;}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Sys{" +
                "message=" + message +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
