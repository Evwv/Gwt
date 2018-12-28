package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Date;

public class Book implements IsSerializable {
    private int id;
    private String nameAuthor;
    private String name;
    private int countPages;
    private String dateCreation;
    private String dateAddBd;

    public Book(int id, String nameAuthor, String name, int countPages, String dateCreation, String dateAddBd) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.name = name;
        this.countPages = countPages;
        this.dateCreation = dateCreation;
        this.dateAddBd = dateAddBd;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateAddBd() {
        return dateAddBd;
    }

    public void setDateAddBd(String dateAddBd) {
        this.dateAddBd = dateAddBd;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", name='" + name + '\'' +
                ", countPages=" + countPages +
                ", dateCreation='" + dateCreation + '\'' +
                ", dateAddBd='" + dateAddBd + '\'' +
                '}';
    }
}
