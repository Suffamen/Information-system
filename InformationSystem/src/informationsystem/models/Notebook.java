
package informationsystem.models;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.Serializable;
import javax.swing.AbstractListModel;

/**
 * @author Марат
 */
public class Notebook extends AbstractListModel implements Serializable  {
    private String name;
    private ArrayList<Note> notes;

    public Notebook(String name) {
        this.name = name;
        notes = new ArrayList<>();
    }

    @Override
    public Object getElementAt(int index) {
        return notes.get(index);
    }

    @Override
    public int getSize() {
        return notes.size();
    }

    public Notebook(String name, ArrayList<Note> notes) {
        this.name = name;
        this.notes = notes;
        sortByAlphabet();
    }

//    public Notebook(String name, Note... notes) {
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public Note getNote(String name) {
        for (Note note : notes)
            if (note.getHeader() == name)
                return note;
        return null;
    }

    public Note getNote(int index) {
        return notes.get(index);
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
        sortByAlphabet();
    }

    public void addNotes(ArrayList<Note> notes) {
        this.notes.addAll(notes);
        sortByAlphabet();
    }

    public void setNote(String name, Note newNote) {
        getNote(name).setHeader(newNote.getHeader());
        getNote(newNote.getHeader()).setText(newNote.getText());
        sortByAlphabet();
    }

    public void setNote(int index, Note newNote) {
        getNote(index).setHeader(newNote.getHeader());
        getNote(index).setText(newNote.getText());
        sortByAlphabet();
    }

    public void deleteNote(String name) {
        notes.remove(getNote(name));
    }

    public void deleteNote(int index) {
//        if (index < 0 || index > notes.size())
//            throw new IndexOutOfBoundsException();
        notes.remove(index);
    }

    public void addNote(Note note) {
        notes.add(note);
        sortByAlphabet();
    }

    public void sortByAlphabet() {
        notes.sort((note1, note2)
                -> Character.compare(note1.getHeader().charAt(0),
                note2.getHeader().charAt(0)));
    }

    public void sortByTextSize() {
        notes.sort((note1, note2)
                -> Integer.compare(note1.getText().length(),
                note2.getText().length()));
    }

    public int getNoteCount() {
        return notes.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
