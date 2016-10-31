/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.controllers;
import informationsystem.models.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Марат
 */
public class NoteController {
    private ArrayList<Notebook> notebooks;
    
    @SuppressWarnings("unchecked")
    public NoteController() {
        try (ObjectInputStream in = 
        new ObjectInputStream(new FileInputStream("notebooks.bin"))) {
            notebooks = (ArrayList<Notebook>)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }
    
    public void updateFile() {
        try (ObjectOutputStream out = 
        new ObjectOutputStream(new FileOutputStream("notebooks.bin"))) {
            out.writeObject(notebooks);
        } catch (IOException e) {
            
        }
    }
    
    public String[] getArrayOfNotebooksNames() {
        String[] result = new String[notebooks.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = notebooks.get(i).getName();
        }
        return result;
    }
    
    public String[] getArrayOfNotesHeaders(int indexOfNotebook) {
        String[] result = 
                new String[notebooks.get(indexOfNotebook).getNoteCount()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = notebooks.get(indexOfNotebook).getNote(i).getHeader();
        }
        
        return result;
    }
    
    public String getNoteText(int indexOfNotebook, int indexOfNote) {
        return notebooks.get(indexOfNotebook).getNote(indexOfNote).getText();
    }
}
