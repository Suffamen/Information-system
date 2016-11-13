package informationsystem;

import informationsystem.controllers.Controller;

import java.io.*;

import informationsystem.models.*;
import informationsystem.views.*;

import javax.swing.*;
import java.util.*;

/**
 * @author Марат
 */
public class InformationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Notebook nb1 = new Notebook("Блокнот 1");
        nb1.addNote(new Note("Заметка 1", "Текст заметки 1"));
        nb1.addNote(new Note("Заметка 2", "Текст заметки 2"));
        nb1.addNote(new Note("Заметка 3", "Текст заметки 3"));
        nb1.addNote(new Note("Заметка 4", "Текст заметки 4"));
        nb1.addNote(new Note("Заметка 5", "Текст заметки 5"));
        nb1.addNote(new Note("Заметка 6", "Текст заметки 6"));
        Notebook nb2 = new Notebook("Блокнот 2");
        nb2.addNote(new Note("Заметка 7", "Текст заметки 7"));
        nb2.addNote(new Note("Заметка 8", "Текст заметки 8"));
        nb2.addNote(new Note("Заметка 9", "Текст заметки 9"));
        nb2.addNote(new Note("Заметка 10", "Текст заметки 10"));
        nb2.addNote(new Note("Заметка 11", "Текст заметки 11"));
        nb2.addNote(new Note("Заметка 12", "Текст заметки 12"));
        Notebook nb3 = new Notebook("Блокнот 3");
        nb3.addNote(new Note("Заметка 13", "Текст заметки 13"));
        nb3.addNote(new Note("Заметка 14", "Текст заметки 14"));
        nb3.addNote(new Note("Заметка 15", "Текст заметки 15"));
        nb3.addNote(new Note("Заметка 16", "Текст заметки 16"));
        nb3.addNote(new Note("Заметка 17", "Текст заметки 17"));
        nb3.addNote(new Note("Заметка 18", "Текст заметки 18"));

        ArrayList<Notebook> notebooks = new ArrayList<>();
        notebooks.add(nb1);
        notebooks.add(nb2);
        notebooks.add(nb3);

        try (ObjectOutputStream in =
                     new ObjectOutputStream(new FileOutputStream("notebooks1.bin"))) {
            in.writeObject(notebooks);
        } catch (IOException e) {
        }

        Controller controller = new Controller();
    }

}
