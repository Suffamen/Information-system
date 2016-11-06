package informationsystem.views;

import javax.swing.*;

/**
 * Created by рм on 05.11.2016.
 */
public class NoteListView extends JPanel {
    private JScrollPane scroll;
    private JList noteList;
    private JButton addNoteButton;
    private JButton deleteNoteButton;
    private JButton editNoteButton;
    private JLabel noteLabel;
    private JTextArea preview;
    private JLabel previewLabel;
    private JScrollPane previewScroll;

    public NoteListView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel listPanel = new JPanel();
        JPanel previewPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        previewPanel.setLayout(new BoxLayout(previewPanel, BoxLayout.Y_AXIS));

        noteLabel = new JLabel("Notes");
        noteLabel.setAlignmentX(LEFT_ALIGNMENT);
        scroll = new JScrollPane();
        noteList = new JList();
        scroll.setViewportView(noteList);
        addNoteButton = new JButton("Add");
        addNoteButton.setAlignmentX(LEFT_ALIGNMENT);
        editNoteButton = new JButton("Edit");
        editNoteButton.setAlignmentX(LEFT_ALIGNMENT);
        deleteNoteButton = new JButton("Delete");
        deleteNoteButton.setAlignmentX(LEFT_ALIGNMENT);
        preview = new JTextArea();
        previewLabel = new JLabel("Preview");
        previewLabel.setAlignmentX(LEFT_ALIGNMENT);
        previewScroll = new JScrollPane();
        previewScroll.setViewportView(preview);

        listPanel.add(noteLabel);
        listPanel.add(scroll);
        listPanel.add(addNoteButton);
        listPanel.add(editNoteButton);
        listPanel.add(deleteNoteButton);
        previewPanel.add(previewLabel);
        previewPanel.add(previewScroll);
        add(listPanel);
        add(previewPanel);
    }

    public JList getList() {
        return noteList;
    }

    public JTextArea getPreview() {
        return preview;
    }

    public JButton getAddButton() { return addNoteButton; }

    public JButton getEditButton() { return editNoteButton; }

    public JButton getDeleteButton() { return deleteNoteButton; }
}
