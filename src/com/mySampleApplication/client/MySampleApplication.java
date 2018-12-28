package com.mySampleApplication.client;

import com.google.gson.Gson;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication  implements EntryPoint {
    private MessageServiceAsync messageService =
            GWT.create(MessageService.class);
    private List<Book> books = new LinkedList<>();
    private class MessageCallBack implements AsyncCallback<Message> {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert("Unable to obtain server response: " + caught.getMessage());
        }
        @Override
        public void onSuccess(Message result) {
            Window.alert(result.getMessage());
        }
    }


    public void onModuleLoad() {

        CellTable<Book> cellTableOfAddress = new CellTable<Book>();
        SimplePager simplePager = new SimplePager(SimplePager.TextLocation.CENTER,false,true);
        simplePager.setDisplay(cellTableOfAddress);
        simplePager.setPageSize(8);
        cellTableOfAddress.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);

        TextColumn<Book> columnId = new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return String.valueOf(object.getId());
            }
        };
        cellTableOfAddress.addColumn(columnId, "Id");

        TextColumn<Book> columnNameBook = new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getName();
            }
        };
        cellTableOfAddress.addColumn(columnNameBook, "Name book");

        TextColumn<Book> columnNameAuthor = new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getNameAuthor();
            }
        };
        cellTableOfAddress.addColumn(columnNameAuthor, "Name of Author");

        TextColumn<Book> columnCountPages = new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return String.valueOf(object.getCountPages());
            }
        };
        cellTableOfAddress.addColumn(columnCountPages, "Count pages");

        TextColumn<Book> columnDateCreate = new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getDateCreation();
            }
        };
        cellTableOfAddress.addColumn(columnDateCreate, "Date of creating");

        TextColumn<Book> columnDateAdd = new TextColumn<Book>() {
            @Override
            public String getValue(Book object) {
                return object.getDateAddBd();
            }
        };
        cellTableOfAddress.addColumn(columnDateAdd, "Date of adding");
        TextBox id = new TextBox();
        id.setWidth("130");
        TextBox nameBook = new TextBox();
        nameBook.setWidth("130");
        TextBox nameAuthor = new TextBox();
        nameAuthor.setWidth("130");
        TextBox countPages = new TextBox();
        countPages.setWidth("130");
        TextBox dateWriting = new TextBox();
        dateWriting.setWidth("130");
        TextBox dateAdding = new TextBox();
        dateAdding.setWidth("130");
        Button addBook = new Button("Add book");
        addBook.setStyleName("button");
        final ListDataProvider<Book> dataProvider = new ListDataProvider<>();
        dataProvider.addDataDisplay(cellTableOfAddress);
        List<Book> addresses = new ArrayList<>();

        Book book = new  Book(1,"Minaev Pavel","C++ 11",100,"09.09.09","24.12.2018");
        dataProvider.getList().add(book);
        cellTableOfAddress.setRowCount(addresses.size(), true);
        cellTableOfAddress.setRowData(0, addresses);
        cellTableOfAddress.setStyleName("table");

        addBook.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
               Book book = new Book(Integer.parseInt(id.getText()),nameAuthor.getText(),nameBook.getText(),Integer.parseInt(countPages.getText()),dateWriting.getText(),dateAdding.getText());
               addresses.add(book);
               dataProvider.getList().add(book);
               dataProvider.refresh();
            }
        });
        Button deleteBook = new Button("Delete book");
        deleteBook.setStyleName("button");
        VerticalPanel vp = new VerticalPanel();
        vp.setBorderWidth(1);
        vp.add(cellTableOfAddress);
        RootPanel.get("gwtContainer").add(vp);
        RootPanel.get("addButton").add(addBook);
        RootPanel.get("deleteButton").add(deleteBook);
        RootPanel.get("id").add(id);
        RootPanel.get("nameAuthor").add(nameAuthor);
        RootPanel.get("nameBook").add(nameBook);
        RootPanel.get("countPages").add(countPages);
        RootPanel.get("dateWriting").add(dateWriting);
        RootPanel.get("dateAdding").add(dateAdding);
    }

}
