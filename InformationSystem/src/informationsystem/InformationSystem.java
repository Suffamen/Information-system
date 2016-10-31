/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem;
import informationsystem.controllers.NoteController;
import java.io.*;
import informationsystem.models.*;
import java.util.*;
/**
 *
 * @author Марат
 */
public class InformationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Notebook> notebooks = new ArrayList<>();
        ArrayList<Notebook> anotherList;
        Notebook book;
        for (int i = 0; i < 3; i++) {
            book = new Notebook("Notebook "+i);
            notebooks.add(book);
        }
        
        NoteController controller = new NoteController();
        System.out.println(Arrays.toString(controller.getArrayOfNotebooksNames()));
    }
    
}
