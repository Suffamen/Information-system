package informationsystem.views;

import informationsystem.models.NoteListModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by рм on 05.11.2016.
 */
public class NoteListView extends JPanel implements SetModelable{
    private JScrollPane scroll;
    private JList noteList;
    private JButton addNoteButton;
    private JButton deleteNoteButton;
    private JButton editNoteButton;
    private JLabel noteLabel;

    public NoteListView() {
        initComponents();
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        noteLabel = new JLabel("Notes");
        scroll = new JScrollPane();
        noteList = new JList();
        scroll.setViewportView(noteList);
        addNoteButton = new JButton("Add");
        editNoteButton = new JButton("Edit");
        deleteNoteButton = new JButton("Delete");

        layout.setVerticalGroup( layout.createSequentialGroup().addComponent(noteLabel).addComponent(scroll)
                .addGroup( layout.createParallelGroup()
                        .addComponent(addNoteButton).addComponent(editNoteButton).addComponent(deleteNoteButton)));

        layout.setHorizontalGroup( layout.createParallelGroup().addComponent(noteLabel).addComponent(scroll)
                .addGroup( layout.createSequentialGroup().addComponent(addNoteButton).addComponent(editNoteButton).addComponent(deleteNoteButton)));



    }

    public JList getList() {
        return noteList;
    }

    public JButton getAddButton() {
        return addNoteButton;
    }

    public JButton getEditButton() {
        return editNoteButton;
    }

    public JButton getDeleteButton() {
        return deleteNoteButton;
    }

    @Override
    public void setModel(Object noteListModel) {
        noteList.setModel((NoteListModel)noteListModel);
    }
}
