package informationsystem.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Павлов on 05.11.2016.
 */
public class NotebookListModel extends AbstractListModel {
    private ArrayList<Notebook> notebooks;

    public NotebookListModel(ArrayList<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    @Override
    public Notebook getElementAt(int index) {
        return notebooks.get(index);
    }

    @Override
    public int getSize() {
        return notebooks.size();
    }
}
