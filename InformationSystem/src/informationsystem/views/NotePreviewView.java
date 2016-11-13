package informationsystem.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Павлов on 13.11.2016.
 */
public class NotePreviewView extends JPanel{
    private JButton quickEditNodeButton;
    private JLabel noteLabel;
    private JTextArea preview;
    private JLabel previewLabel;
    private JScrollPane previewScroll;
    private JLabel dataLabel;

    public NotePreviewView() {
        initComponents();
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        noteLabel = new JLabel("Notes");
        quickEditNodeButton = new JButton("Save");
        preview = new JTextArea();
        previewLabel = new JLabel("Preview");
        previewScroll = new JScrollPane();
        previewScroll.setViewportView(preview);
        quickEditNodeButton.setEnabled(false);
        dataLabel = new JLabel("");
        dataLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 9));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(previewLabel).addComponent(previewScroll)
                .addGroup(layout.createParallelGroup().addComponent(quickEditNodeButton).addComponent(dataLabel)));
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(previewLabel).addComponent(previewScroll)
                .addGroup(layout.createSequentialGroup().addComponent(quickEditNodeButton).addComponent(dataLabel)));
    }

    public JTextArea getPreview() {
        return preview;
    }


    public JButton getQuickEditNodeButton() {
        return quickEditNodeButton;
    }

    public JLabel getDataLabel() {
        return dataLabel;
    }
}
