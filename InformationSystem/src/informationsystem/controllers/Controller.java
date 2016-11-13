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
    private NotePreviewView notesPreviewView;

    public Controller() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("notebooks1.bin"))) {
            notebooks = (ArrayList<Notebook>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }

        frame = new JFrame("NotSoSmartNote");
        JPanel mainPane = new JPanel();
        notebooksView = new NotebookListView();
        notebooksView.getList().setModel(new NotebookListModel(notebooks));
        notesView = new NoteListView();
        notesPreviewView = new NotePreviewView();

        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.X_AXIS));
        mainPane.add(notebooksView);
        mainPane.add(notesView);
        mainPane.add(notesPreviewView);

        frame.setContentPane(mainPane);
        setListeners();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setSize(1000, 400);
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

        notesPreviewView.getPreview().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (notesPreviewView.getPreview().hasFocus())
                    notesPreviewView.getQuickEditNodeButton().setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (notesPreviewView.getPreview().hasFocus())
                    notesPreviewView.getQuickEditNodeButton().setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (notesPreviewView.getPreview().hasFocus())
                    notesPreviewView.getQuickEditNodeButton().setEnabled(true);
            }
        });

        notesPreviewView.getQuickEditNodeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notebooks.get(notebooksView.getList().getSelectedIndex()).getNote(notesView.getList().getSelectedIndex())
                        .setText(notesPreviewView.getPreview().getText());
                notesPreviewView.getQuickEditNodeButton().setEnabled(false);
                updateFile();
            }
        });
    }


    public void notebookListSelectionChanged(ListSelectionEvent e) {
        notesView.getList().setSelectedIndex(-1);
        notesPreviewView.getPreview().setText("");
        notesView.getList().setModel(new NoteListModel(
                notebooks.get(notebooksView.getList().getSelectedIndex()).getNotes()));
    }

    public void noteListSelectionChanged(ListSelectionEvent e) {
        if (!notesView.getList().isSelectionEmpty())
            notesPreviewView.getPreview().setText(getNoteText(
                    notebooksView.getList().getSelectedIndex(), notesView.getList().getSelectedIndex()));
        notesPreviewView.getDataLabel().setText(getNoteDate(notebooksView.getList().getSelectedIndex(), notesView.getList().getSelectedIndex()));
    }

    private void updateFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("notebooks.bin"))) {
            out.writeObject(notebooks);
        } catch (IOException e) {
        }
    }

    private String getNoteText(int indexOfNotebook, int indexOfNote) {
        return notebooks.get(indexOfNotebook).getNote(indexOfNote).getText();
    }

    private String getNoteDate(int indexOfNotebook, int indexOfNote) {
        return "<html>Created " + notebooks.get(indexOfNotebook).getNote(indexOfNote).getCreateDate() + "<br>" +
                "Last edited " + notebooks.get(indexOfNotebook).getNote(indexOfNote).getEditDate() + "</html>";
    }

    private void sortByAlphabet() {
        notebooks.sort((notebook1, notebook2)
                -> Character.compare(notebook1.getName().charAt(0),
                notebook2.getName().charAt(0)));
    }

}
