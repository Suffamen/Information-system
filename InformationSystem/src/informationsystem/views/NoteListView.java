package informationsystem.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by рм on 05.11.2016.
 */
public class NoteListView extends JPanel {
    private JScrollPane scroll;
    private JList noteList;
    private JButton addNoteButton;
    private JButton deleteNoteButton;
    private JButton editNoteButton;
    private JButton quickEditNodeButton;
    private JLabel noteLabel;
    private JTextArea preview;
    private JLabel previewLabel;
    private JScrollPane previewScroll;

    public NoteListView() {
        initComponents();
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        JPanel listPanel = new JPanel();
        JPanel previewPanel = new JPanel();
        GroupLayout listPanelLayout = new GroupLayout(listPanel);
        GroupLayout previewPanelLayout = new GroupLayout(previewPanel);
        listPanelLayout.setAutoCreateGaps(true);
        listPanelLayout.setAutoCreateContainerGaps(true);
        previewPanelLayout.setAutoCreateGaps(true);
        previewPanelLayout.setAutoCreateContainerGaps(true);
        listPanel.setLayout(listPanelLayout);
        previewPanel.setLayout(previewPanelLayout);

        noteLabel = new JLabel("Notes");
        noteLabel.setAlignmentX(LEFT_ALIGNMENT);
        scroll = new JScrollPane();
        noteList = new JList();
        scroll.setViewportView(noteList);
        addNoteButton = new JButton("Add");
        addNoteButton.setAlignmentX(LEFT_ALIGNMENT);
        editNoteButton = new JButton("Edit");
        editNoteButton.setAlignmentX(CENTER_ALIGNMENT);
        deleteNoteButton = new JButton("Delete");
        deleteNoteButton.setAlignmentX(RIGHT_ALIGNMENT);
        quickEditNodeButton = new JButton("Save");

        preview = new JTextArea();
        previewLabel = new JLabel("Preview");
        previewLabel.setAlignmentX(LEFT_ALIGNMENT);
        previewScroll = new JScrollPane();
        previewScroll.setViewportView(preview);

        quickEditNodeButton.setAlignmentX(LEFT_ALIGNMENT);
        quickEditNodeButton.setAlignmentY(BOTTOM_ALIGNMENT);
        quickEditNodeButton.setEnabled(false);

        listPanelLayout.setVerticalGroup(listPanelLayout.createSequentialGroup().addComponent(noteLabel).addComponent(scroll)
                .addGroup(listPanelLayout.createParallelGroup()
                        .addComponent(addNoteButton).addComponent(editNoteButton).addComponent(deleteNoteButton)));

        listPanelLayout.setHorizontalGroup(listPanelLayout.createParallelGroup().addComponent(noteLabel).addComponent(scroll)
                .addGroup(listPanelLayout.createSequentialGroup().addComponent(addNoteButton).addComponent(editNoteButton).addComponent(deleteNoteButton)));


        previewPanelLayout.setVerticalGroup(previewPanelLayout.createSequentialGroup()
                .addComponent(previewLabel).addComponent(previewScroll).addComponent(quickEditNodeButton));
        previewPanelLayout.setHorizontalGroup(previewPanelLayout.createParallelGroup()
                .addComponent(previewLabel).addComponent(previewScroll).addComponent(quickEditNodeButton));

        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(listPanel).addComponent(previewPanel));
        layout.setVerticalGroup(layout.createParallelGroup().addComponent(listPanel).addComponent(previewPanel));
    }

    public JList getList() {
        return noteList;
    }

    public JTextArea getPreview() {
        return preview;
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

    public JButton getQuickEditNodeButton() {
        return quickEditNodeButton;
    }
}
