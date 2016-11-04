/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem;

import informationsystem.controllers.NotebookListController;

import java.io.*;

import informationsystem.models.*;

import java.util.*;

/**
 * @author Марат
 */
public class InformationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Notebook> notebooks = new ArrayList<>();

        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("Eggs", "Buy some eggs to breakfast"));
        notes.add(new Note("Laundry", "Wash clothes at Tuesday"));
        notes.add(new Note("Cleaning", "Monday: Dad\n"
                + "Tuesday: Mom\nWednesday: Ann\nThursday: Me\nFriday: Mom"));
        notebooks.add(new Notebook("Home", notes));

        notes = new ArrayList<>();
        notes.add(new Note("Boss checking", "Work harder at 3p.m."));
        notes.add(new Note("Fridge", "Eat Pete's dinner"));
        notebooks.add(new Notebook("Work", notes));

        notes = new ArrayList<>();
        notes.add(new Note("Saturday", "Go to concert at 10p.m."));
        notes.add(new Note("Sunday", "Chilling at home"));
        notebooks.add(new Notebook("Holidays", notes));

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("notebooks.bin"))) {
            out.writeObject(notebooks);
        } catch (IOException e) {

        }

        NotebookListController controller = new NotebookListController();
        System.out.println(Arrays.toString(controller.getArrayOfNotebookNames()));
    }

}
