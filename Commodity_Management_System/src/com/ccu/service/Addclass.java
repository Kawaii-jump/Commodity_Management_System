package com.ccu.service;

import com.ccu.dao.Insert;
import com.ccu.dao.Select;
import com.ccu.model.JTextFieldListener;
import com.ccu.model.MyTableModel;
import com.ccu.model.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class Addclass extends JFrame implements ActionListener {

    Font font = new Font("宋体",0,18);

    private JLabel jLabel1 = new JLabel("类别编号:");
    private JLabel jLabel2 = new JLabel("类别名:");


    private JTextField jTextField1 = new JTextField(15);
    private JTextField jTextField2 = new JTextField(15);

    private JButton jButton1 = new JButton("添加");
    private JButton jButton2 = new JButton("重置");
    private JTable jTable;
    private JScrollPane jScrollPane;
    private MyTableModel m;
    private User user;

    public Addclass(JScrollPane j,JTable jTable,MyTableModel m,User user){
        this.setBounds(700,110,500,650);
        this.setTitle("添加类别");
        this.setFont(font);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.jScrollPane = j;
        this.jTable = jTable;
        this.user = user;
        this.m=m;
        init();
        this.setVisible(true);
    }

    public void init(){

        jLabel1.setBounds(40,20,100,40);
        jLabel2.setBounds(40,120,100,40);

        jLabel1.setFont(font);
        jLabel2.setFont(font);

        this.add(jLabel1);
        this.add(jLabel2);

        jTextField1.setBounds(180,20,250,40);
        jTextField2.setBounds(180,120,250,40);

        jTextField1.addFocusListener(new JTextFieldListener("请输入类别编号",jTextField1));
        jTextField2.addFocusListener(new JTextFieldListener("请输入类别名",jTextField2));

        jTextField1.setFont(font);
        jTextField2.setFont(font);

        this.add(jTextField1);
        this.add(jTextField2);

        jButton1.setBounds(110,530,100,40);
        jButton2.setBounds(280,530,100,40);

        jButton1.setFont(font);
        jButton2.setFont(font);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);

        this.add(jButton1);
        this.add(jButton2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jButton1){
            boolean b = new Insert().inclass(jTextField1.getText(),jTextField2.getText());
            StringBuffer buffer = new StringBuffer();
            buffer.append("用户").append(user.getUserName()).append("  添加商品类别：").append(jTextField2.getText());
            new Insert().Jwrite(buffer.toString());
            if(b){
                UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                JOptionPane.showMessageDialog(null,"添加成功","提示信息", PLAIN_MESSAGE);
            }
            this.dispose();
            m.UpdategoodsClass(new Select().selgoodsclass());
            jTable.updateUI();
            jScrollPane.updateUI();
        }
        else if (source == jButton2){
            jTextField1.setText("请输入类别编号");
            jTextField2.setText("请输入类别名");
        }
    }
}

