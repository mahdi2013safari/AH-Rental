package com.example.mahdi.ah_rental.Home;

public class Home {

    private int id;
    private int image;
    private String price, proparty, bathroom, capacity, address, date;

    public Home(int id, int image, String price, String proparty, String bathroom, String capacity, String address, String date) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.proparty = proparty;
        this.bathroom = bathroom;
        this.capacity = capacity;
        this.address = address;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProparty() {
        return proparty;
    }

    public void setProparty(String proparty) {
        this.proparty = proparty;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
