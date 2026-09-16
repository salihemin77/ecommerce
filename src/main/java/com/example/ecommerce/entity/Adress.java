package com.example.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "adressline")
    private String adressline;
    @Column(name = "postalcode")
    private String postalcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adress() {
    }
    public Adress(String title, String city, String district, String adressline, String postalcode) {
        this.title = title;
        this.city = city;
        this.district = district;
        this.adressline = adressline;
        this.postalcode = postalcode;

    }

    public String getAdressline() {
        return adressline;
    }

    public void setAdressline(String adressline) {
        this.adressline = adressline;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "adressline='" + adressline + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", postalcode='" + postalcode + '\'' +
                '}';
    }





}
