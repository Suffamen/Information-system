package informationsystem.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by Павлов on 04.11.2016.
 */
public class MainView extends JFrame {

    public MainView() {

        notebookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            }
        });
        noteList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

            }
        });
        addNotebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editNotebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteNotebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("Form1");
        jf.setContentPane(new MainView().panel1);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

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

}
