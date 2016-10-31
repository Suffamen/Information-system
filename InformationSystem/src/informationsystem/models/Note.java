/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.models;
import java.io.Serializable;
/**
 * @author Марат
 */
public class Note implements Serializable{
    private String header;
    private String text;

    public Note(String h, String t) {
        header = h;
        text = t;
    }

    public Note(String h) {
        header = h;
        text = "";
    }

    public void setHeader(String newHeader) {
        header = newHeader;
    }

    public void setText(String newText) {
        text = newText;
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }
}