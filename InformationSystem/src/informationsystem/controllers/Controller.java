/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.controllers;

import informationsystem.models.*;

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

    private JPanel panel1;
    private JList notebookList;
    private JButton addNotebookButton;
    private JButton deleteNotebookButton;
    private JButton editNotebookButton;
    private JList noteList;
    private JTextArea previewNote;
    private JButton addNoteButton;
    private JButton deleteNoteButton;
    private JButton editNoteButton;
    private JLabel leftSpacer;
    private JLabel rightSpacer;
    private JLabel bottomSpacer;
    private JLabel notebookLabel;
    private JLabel noteLabel;
    private JLabel previewLabel;
    private JLabel noteInfo;


    public Controller(JFrame jf) {
        $$$setupUI$$$();
        setNotebooks();
        setListeners();
        notebookList.setModel(new NotebookListModel(notebooks));
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setListeners() {
        notebookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                notebookListSelectionChanged(e);
            }
        });
        noteList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                noteListSelectionChanged(e);
            }
        });
    }

    public void notebookListSelectionChanged(ListSelectionEvent e) {
        noteList.setModel(new NoteListModel(notebooks.get(notebookList.getSelectedIndex()).getNotes()));
    }

    public void noteListSelectionChanged(ListSelectionEvent e) {
        previewNote.setText(getNoteText(notebookList.getSelectedIndex(), noteList.getSelectedIndex()));
        noteInfo.setText(getNoteDate(notebookList.getSelectedIndex(), noteList.getSelectedIndex()));
    }

    private void setNotebooks() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("notebooks.bin"))) {
            notebooks = (ArrayList<Notebook>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {

        }
        sortByAlphabet();
    }

    private void updateFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("notebooks.bin"))) {
            out.writeObject(notebooks);
        } catch (IOException e) {

        }
    }

    private String[] getArrayOfNotebookNames() {
        String[] result = new String[notebooks.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = notebooks.get(i).getName();
        }
        return result;
    }

    private String[] getArrayOfNoteHeaders(int indexOfNotebook) {
        String[] result =
                new String[notebooks.get(indexOfNotebook).getNoteCount()];

        for (int i = 0; i < result.length; i++) {
            result[i] = notebooks.get(indexOfNotebook).getNote(i).getHeader();
        }

        return result;
    }

    private void $$$setupUI$$$() {

        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 9, new Insets(0, 0, 0, 0), -1, -1));
        addNotebookButton = new JButton();
        addNotebookButton.setText("Add");
        panel1.add(addNotebookButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteNotebookButton = new JButton();
        deleteNotebookButton.setText("Delete");
        panel1.add(deleteNotebookButton, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editNotebookButton = new JButton();
        editNotebookButton.setText("Edit");
        panel1.add(editNotebookButton, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addNoteButton = new JButton();
        addNoteButton.setText("Add");
        panel1.add(addNoteButton, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteNoteButton = new JButton();
        deleteNoteButton.setText("Delete");
        panel1.add(deleteNoteButton, new com.intellij.uiDesigner.core.GridConstraints(2, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editNoteButton = new JButton();
        editNoteButton.setText("Edit");
        panel1.add(editNoteButton, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        notebookLabel = new JLabel();
        notebookLabel.setText("Notebooks");
        panel1.add(notebookLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noteLabel = new JLabel();
        noteLabel.setText("Notes");
        panel1.add(noteLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        previewLabel = new JLabel();
        previewLabel.setText("Preview");
        panel1.add(previewLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leftSpacer = new JLabel();
        leftSpacer.setText(" ");
        panel1.add(leftSpacer, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rightSpacer = new JLabel();
        rightSpacer.setText(" ");
        panel1.add(rightSpacer, new com.intellij.uiDesigner.core.GridConstraints(1, 8, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bottomSpacer = new JLabel();
        bottomSpacer.setFont(new Font(bottomSpacer.getFont().getName(), bottomSpacer.getFont().getStyle(), 3));
        bottomSpacer.setText(" ");
        panel1.add(bottomSpacer, new com.intellij.uiDesigner.core.GridConstraints(3, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        noteList = new JList();
        scrollPane1.setViewportView(noteList);
        final JScrollPane scrollPane2 = new JScrollPane();
        panel1.add(scrollPane2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        notebookList = new JList();
        scrollPane2.setViewportView(notebookList);
        final JScrollPane scrollPane3 = new JScrollPane();
        panel1.add(scrollPane3, new com.intellij.uiDesigner.core.GridConstraints(1, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        previewNote = new JTextArea();
        scrollPane3.setViewportView(previewNote);
        noteInfo = new JLabel();
        noteInfo.setText("");
        panel1.add(noteInfo, new com.intellij.uiDesigner.core.GridConstraints(2, 7, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        /**
         * @noinspection ALL
         */
    }

    public JComponent $$$getRootComponent$$$() {
        return panel1;
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
