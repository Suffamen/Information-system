package informationsystem.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by рм on 05.11.2016.
 */
public class NotebookListView extends JPanel {
    private JScrollPane scroll;
    private JList notebookList;
    private JButton addNotebookButton;
    private JButton deleteNotebookButton;
    private JButton editNotebookButton;
    private JLabel label;

    public NotebookListView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        label = new JLabel("Notebooks");
        label.setAlignmentX(LEFT_ALIGNMENT);
        addNotebookButton = new JButton("Add");
        addNotebookButton.setAlignmentX(LEFT_ALIGNMENT);
        deleteNotebookButton = new JButton("Delete");
        deleteNotebookButton.setAlignmentX(LEFT_ALIGNMENT);
        editNotebookButton = new JButton("Edit");
        editNotebookButton.setAlignmentX(LEFT_ALIGNMENT);
        scroll = new JScrollPane();
        notebookList = new JList();
        scroll.setViewportView(notebookList);

        add(label);
        add(scroll);
        add(addNotebookButton);
        add(editNotebookButton);
        add(deleteNotebookButton);
    }

    public JList getList() {
        return notebookList;
    }
}
