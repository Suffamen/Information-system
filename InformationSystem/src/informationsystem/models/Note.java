/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.models;

import javax.swing.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.UUID.randomUUID;

/**
 * @author Марат
 */
public class Note implements Serializable {
    private String header;
    private String text;
    private String lastEdited;
    private String created;
    private int id;

    public Note(String header, String text) {
        this.header = header;
        this.text = text;
        created = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime());
        lastEdited = created;
        id = createID();
    }

    public int getID() {
        return id;
    }

    public Note(String header) {
        this.header = header;
        text = "";
        created = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime());
        lastEdited = created;
        id = createID();
    }

    public void setHeader(String newHeader) {
        header = newHeader;
        lastEdited = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime());
    }

    public void setText(String newText) {
        text = newText;
        lastEdited = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy").format(Calendar.getInstance().getTime());
    }

    public String getCreateDate() {
        return created.toString();
    }

    public String getEditDate() {
        return lastEdited.toString();
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return getHeader();
    }

    private static int idCounter = 0;

    public static synchronized int createID() {
        return idCounter++;
    }
}