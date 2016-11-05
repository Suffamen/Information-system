/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.models;

import javax.swing.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Марат
 */
public class Note implements Serializable {
    private String header;
    private String text;
    private Date lastEdited;
    private Date created;

    public Note(String h, String t) {
        header = h;
        text = t;
        created = new Date(System.currentTimeMillis());
        lastEdited = created;
    }

    public Note(String h) {
        header = h;
        text = "";
        created = new Date(System.currentTimeMillis());
        lastEdited = created;
    }

    public void setHeader(String newHeader) {
        header = newHeader;
        lastEdited = new Date(System.currentTimeMillis());
    }

    public void setText(String newText) {
        text = newText;
        lastEdited = new Date(System.currentTimeMillis());
    }

    public String getCreateDate() {
        return created.toString();
    }

    public String getEditedData(){
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
}