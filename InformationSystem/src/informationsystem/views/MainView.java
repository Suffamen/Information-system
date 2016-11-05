package informationsystem.views;

import informationsystem.controllers.Controller;
import informationsystem.models.Note;
import informationsystem.models.Notebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by Павлов on 04.11.2016.
 */
public class MainView extends JFrame {
    static Controller controller;

    public MainView() {

    }


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


        JFrame jf = new JFrame("Form1");
        controller = new Controller(jf);
        jf.setContentPane(controller.getPanel1());
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}