/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationsystem.views;
import javax.swing.*;
/**
 *
 * @author Марат
 */
public class Frame extends JFrame{
    public Frame() {
        super();
        this.setSize(770,500);
        this.getContentPane().setLayout(null);
        this.add(getLeftList(), null);
        this.add(getRightList(), null);
        this.add(getTextArea(), null);
        this.setTitle("Information System");
    }
    
    private JList getLeftList() {
        JList jlist = new JList();
        jlist.setBounds(10, 20, 200, 300);
        return jlist;
    }
    
    private JList getRightList() {
        JList jlist = new JList();
        jlist.setBounds(230, 20, 200, 300);
        return jlist;
    }
    
    private JTextArea getTextArea() {
        JTextArea area = new JTextArea();
        area.setBounds(450, 20, 300, 300);
        return area;
    }
}
