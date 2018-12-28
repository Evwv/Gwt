package com.mySampleApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface MessageServiceAsync {
    void getMessage(Book book, AsyncCallback<Message> async);


}
