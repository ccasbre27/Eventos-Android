package com.nansoft.msp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Carlos on 24/08/2015.
 */
public class Event implements Serializable
{
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("price")
    private String price;

    @SerializedName("pictureurl")
    private String pictureURL;

    @SerializedName("idcountry")
    private String idCountry;

    @SerializedName("email")
    private String email;

    @SerializedName("phonenumber")
    private String phoneNumber;

    @SerializedName("hour")
    private String hour;

    @SerializedName("status")
    private boolean status;

    @SerializedName("date")
    private String date;

    public Event(String id, String name, String description, double latitude, double longitude, String price, String pictureURL, String idCountry, String email, String phoneNumber, String hour, boolean status, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.pictureURL = pictureURL;
        this.idCountry = idCountry;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hour = hour;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPictureURL() {
        if (pictureURL == null)
        {
            return "n/a";
        }
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = "Sin definir";
        try {

            fecha = myFormat.format(fromUser.parse(date.substring(0,10)));
        } catch (ParseException e) {

        }
        return fecha;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
