/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.controllers;

import informationsystem.models.*;

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 * @author Марат
 */
public class NotebookListController implements ListSelectionListener {
    private ArrayList<Notebook> notebooks;
    private JList<Notebook> jList;


    public NotebookListController() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("notebooks.bin"))) {
            notebooks = (ArrayList<Notebook>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        sortByAlphabet();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void updateFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("notebooks.bin"))) {
            out.writeObject(notebooks);
        } catch (IOException e) {

        }
    }

    public String[] getArrayOfNotebookNames() {
        String[] result = new String[notebooks.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = notebooks.get(i).getName();
        }
        return result;
    }

    public String[] getArrayOfNoteHeaders(int indexOfNotebook) {
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

    public void sortByAlphabet() {
        notebooks.sort((notebook1, notebook2)
                -> Character.compare(notebook1.getName().charAt(0),
                notebook2.getName().charAt(0)));
    }

}
