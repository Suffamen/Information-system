
package informationsystem.models;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Марат
 */
public class Notebook {
    private String name;
    private LinkedList<Note> notes;

    public Notebook(String name) {
        this.name = name;
        notes = new LinkedList<>();
    }

    public Notebook(String name, LinkedList<Note> notes) {
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

    public LinkedList<Note> getNotes() {
        return notes;
    }

    public Note getNode(String name) {
        for (Note note : notes)
            if (note.getHeader() == name)
                return note;
        return null;
    }

    public Note getNode(int index) {
        return notes.get(index);
    }

    public void setNotes(LinkedList<Note> notes) {
        this.notes = notes;
        sortByAlphabet();
    }

    public void addNotes(LinkedList<Note> nodes) {
        nodes.addAll(nodes);
        sortByAlphabet();
    }

    public void setNode(String name, Note newNote) {
        getNode(name).setHeader(newNote.getHeader());
        getNode(newNote.getHeader()).setText(newNote.getText());
        sortByAlphabet();
    }

    public void setNode(int index, Note newNote) {
        getNode(index).setHeader(newNote.getHeader());
        getNode(index).setText(newNote.getText());
        sortByAlphabet();
    }

    public void deleteNote(String name) {
        notes.remove(getNode(name));
    }

    public void deleteNode(int index) {
//        if (index < 0 || index > notes.size())
//            throw new IndexOutOfBoundsException();
        notes.remove(index);
    }

    public void addNote(Note note) {
        notes.add(note);
        sortByAlphabet();
    }

    public void sortByAlphabet() {
        notes.sort((note1, note2) -> Character.compare(note1.getHeader().charAt(0), note2.getHeader().charAt(0)));
    }

    public void sortByTextSize() {
        notes.sort((note1, note2) -> Integer.compare(note1.getText().length(), note2.getText().length()));
    }

    public int getNoteCount() {
        return notes.size();
    }

}
