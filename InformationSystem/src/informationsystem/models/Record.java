/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.models;

/**
 *
 * @author Марат
 */
public class Record {
    private String header;
    private String text;
    
    public Record(String h, String t) {
        header = h;
        text = t;
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