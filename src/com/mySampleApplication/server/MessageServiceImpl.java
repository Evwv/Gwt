package com.mySampleApplication.server;

import com.google.gson.Gson;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.Book;
import com.mySampleApplication.client.Message;
import com.mySampleApplication.client.MessageService;

import java.io.*;

public class MessageServiceImpl extends RemoteServiceServlet
        implements MessageService {

    private static final long serialVersionUID = 1L;
    public Message getMessage(Book book) {
        try {
            Writer writer = new FileWriter("datebase.json");
            Gson gson = new Gson();
            gson.toJson(book,writer);
            Message message = new Message();
            message.setMessage(book.toString());
            return message;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Message();
    }

}
