package com.mySampleApplication.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mySampleApplication.client.Book;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("datebase.json")) {
            List<Book> books = new ArrayList<>();
            Book book = new Book(1,"Elizarov Evgeny","History",1800,"11.11.11","24.12.2018");
            Book book1 = new Book(2,"Smirnov Igor","Java 8",800,"11.10.10","24.12.2018");
            Book book2 = new Book(3,"Minaev Pavel","C++ 11",100,"09.09.09","24.12.2018");
            books.add(book);
            books.add(book1);
            books.add(book2);
            Gson gson = new GsonBuilder().create();
            gson.toJson(books,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reader reader = new Reader();
        reader.readJ();
    }

    public Book readJ()  {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("datebase.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();

        Book newbook = gson.fromJson(bufferedReader,Book.class);
        return newbook;
    }
}
