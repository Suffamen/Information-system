/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.controllers;

import informationsystem.models.*;
import informationsystem.views.*;

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 * @author Марат
 */
public class Controller {
    private ArrayList<Notebook> notebooks;
    private JFrame frame;
    private NotebookListView notebooksView;
    private NoteListView notesView;

    public Controller() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("notebooks.bin"))) {
            notebooks = (ArrayList<Notebook>)in.readObject();
        } catch (IOException|ClassNotFoundException e) {}

        frame = new JFrame("NotSoSmartNote");
        JPanel mainPane = new JPanel();
        notebooksView = new NotebookListView();
        notebooksView.getList().setModel(new NotebookListModel(notebooks));
        notesView = new NoteListView();

        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.X_AXIS));
        mainPane.add(notebooksView);
        mainPane.add(notesView);

        frame.setContentPane(mainPane);
        setListeners();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

    public void setListeners() {
        notebooksView.getList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                notebookListSelectionChanged(e);
            }
        });

        notesView.getList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                noteListSelectionChanged(e);
            }
        });

        notesView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!notebooksView.getList().isSelectionEmpty()) {
                    String header = JOptionPane.showInputDialog(frame, "Write header of new note");
                    if (!header.isEmpty()) {
                        String text = JOptionPane.showInputDialog(frame, "Write text of new note");
                        notebooks.get(notebooksView.getList().getSelectedIndex()).addNote(new Note(header, text));
                        updateFile();
                        notesView.getList().setModel(
                                new NoteListModel(notebooks.get(notebooksView.getList().getSelectedIndex()).getNotes()));
                    }
                }
            }
        });

        notesView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!notesView.getList().isSelectionEmpty()) {
                    int response = JOptionPane.showConfirmDialog(frame, "Do you realy want to delete note?", "Deleting",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (response == 0) {
                        notebooks.get(notebooksView.getList().getSelectedIndex()).deleteNote(
                                notesView.getList().getSelectedIndex());
                        updateFile();
                        notesView.getList().setModel(
                                new NoteListModel(notebooks.get(notebooksView.getList().getSelectedIndex()).getNotes()));
                    }
                }
            }
        });
    }

    public void notebookListSelectionChanged(ListSelectionEvent e) {
        notesView.getList().setSelectedIndex(-1);
        notesView.getPreview().setText("");
        notesView.getList().setModel(new NoteListModel(
                notebooks.get(notebooksView.getList().getSelectedIndex()).getNotes()));
    }

    public void noteListSelectionChanged(ListSelectionEvent e) {
        if (!notesView.getList().isSelectionEmpty())
            notesView.getPreview().setText(getNoteText(
                notebooksView.getList().getSelectedIndex(), notesView.getList().getSelectedIndex()));
        //noteInfo.setText(getNoteDate(notebookList.getSelectedIndex(), noteList.getSelectedIndex()));
    }

    private void updateFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("notebooks.bin"))) {
            out.writeObject(notebooks);
        } catch (IOException e) {}
    }

    private String getNoteText(int indexOfNotebook, int indexOfNote) {
        return notebooks.get(indexOfNotebook).getNote(indexOfNote).getText();
    }

    private String getNoteDate(int indexOfNotebook, int indexOfNote) {
        return "Crated " + notebooks.get(indexOfNotebook).getNote(indexOfNote).getCreateDate() +
                "Last edited " + notebooks.get(indexOfNotebook).getNote(indexOfNote).getCreateDate();
    }

    private void sortByAlphabet() {
        notebooks.sort((notebook1, notebook2)
                -> Character.compare(notebook1.getName().charAt(0),
                notebook2.getName().charAt(0)));
    }

}
