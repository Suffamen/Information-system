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
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

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

        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(label).addComponent(scroll)
                .addGroup(layout.createParallelGroup()
                        .addComponent(addNotebookButton).addComponent(editNotebookButton).addComponent(deleteNotebookButton)));

        layout.setHorizontalGroup(layout.createParallelGroup().addComponent(label).addComponent(scroll)
                .addGroup(layout.createSequentialGroup().addComponent(addNotebookButton).addComponent(editNotebookButton).addComponent(deleteNotebookButton)));

    }

    public JList getList() {
        return notebookList;
    }
}
