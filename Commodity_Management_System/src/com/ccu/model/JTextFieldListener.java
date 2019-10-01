package com.ccu.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JTextFieldListener implements FocusListener {

    private String hint;
    private JTextField jTextField;

    public JTextFieldListener(String hint, JTextField jTextField) {
        this.hint = hint;
        this.jTextField = jTextField;
        jTextField.setText(hint);
        jTextField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        String temp = jTextField.getText();
        if(temp.equals(hint)){
            jTextField.setText("");
            jTextField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        String temp = jTextField.getText();
        if(temp.equals("")){
            jTextField.setText(hint);
            jTextField.setForeground(Color.GRAY);
        }
    }
}
