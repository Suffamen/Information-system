package informationsystem.controllers;

import informationsystem.models.Notebook;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by Павлов on 04.11.2016.
 */
public class NoteListController implements ListSelectionListener {
    private JList<Notebook> jList;
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
