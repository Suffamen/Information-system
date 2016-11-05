package informationsystem.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Павлов on 05.11.2016.
 */
public class NoteListModel extends AbstractListModel {
    private ArrayList<Note> notes;

    public NoteListModel(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public Note getElementAt(int index) {
        return notes.get(index);
    }

    @Override
    public int getSize() {
        return notes.size();
    }
}
