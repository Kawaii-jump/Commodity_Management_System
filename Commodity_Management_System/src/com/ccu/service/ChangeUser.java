package com.ccu.service;

import com.ccu.dao.Select;
import com.ccu.dao.Update;
import com.ccu.model.JTextFieldListener;
import com.ccu.model.MyTableModel;
import com.ccu.model.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class ChangeUser extends JFrame implements ActionListener {

    Font font = new Font("宋体",0,18);

    private JLabel jLabel1 = new JLabel("用户编号:");
    private JLabel jLabel2 = new JLabel("用户名:");
    private JLabel jLabel3 = new JLabel("密码:");
    private JLabel jLabel4 = new JLabel("等级:");
    private JLabel jLabel5 = new JLabel("电话:");

    private String[] o1 = {"用户","管理员"};
    private String[] o2 = {"用户"};

    private JTextField jTextField1 = new JTextField(15);
    private JTextField jTextField2 = new JTextField(15);
    private JTextField jTextField3 = new JTextField(15);
    private JComboBox<String> jComboBox ;
    private JTextField jTextField5 = new JTextField(15);

    private JButton jButton1 = new JButton("添加");
    private JButton jButton2 = new JButton("重置");
    private JTable jTable;
    private JScrollPane jScrollPane;
    private MyTableModel m;
    int num;
    User user;

    public ChangeUser(JScrollPane j,JTable jTable,MyTableModel m,User user,int num){
        this.setBounds(700,110,500,650);
        this.setTitle("添加人员");
        this.setFont(font);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.user = user;
        this.jScrollPane = j;
        this.jTable = jTable;
        this.m=m;
        this.num = num;
        init();
        this.setVisible(true);
    }

    public void init(){
        if(user.getRank()==0){
            jComboBox = new JComboBox<String>(o1);
        }else {
            jComboBox = new JComboBox<String>(o2);
        }
        jLabel1.setBounds(40,20,100,40);
        jLabel2.setBounds(40,120,80,40);
        jLabel3.setBounds(40,220,80,40);
        jLabel4.setBounds(40,320,80,40);
        jLabel5.setBounds(40,420,80,40);


        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jLabel5);

        jTextField1.setBounds(180,20,250,40);
        jTextField2.setBounds(180,120,250,40);
        jTextField3.setBounds(180,220,250,40);
        jComboBox.setBounds(180,320,250,40);
        jTextField5.setBounds(180,420,250,40);

        jTextField1.addFocusListener(new JTextFieldListener("请输入用户编号",jTextField1));
        jTextField2.addFocusListener(new JTextFieldListener("请输入用户名",jTextField2));
        jTextField3.addFocusListener(new JTextFieldListener("请输入用户密码",jTextField3));
        jTextField5.addFocusListener(new JTextFieldListener("请输入用户电话",jTextField5));

        jTextField1.setFont(font);
        jTextField2.setFont(font);
        jTextField3.setFont(font);
        jTextField5.setFont(font);
        jComboBox.setFont(font);

        jTextField1.setText(Integer.toString(num));
        jTextField1.setEditable(false);

        this.add(jTextField1);
        this.add(jTextField2);
        this.add(jTextField3);
        this.add(jTextField5);
        this.add(jComboBox);

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
            if (jComboBox.getSelectedItem().toString().trim().equals("管理员")){
                int rank = 1;
                boolean b = new Update().UpUser(num,jTextField2.getText(),jTextField3.getText(),rank,jTextField5.getText());
                if(b){
                    UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                    UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                    JOptionPane.showMessageDialog(null,"添加成功","提示信息", PLAIN_MESSAGE);
                }
            }else{
                int rank = 2;
                boolean b = new Update().UpUser(num,jTextField2.getText(),jTextField3.getText(),rank,jTextField5.getText());
                if(b){
                    UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                    UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                    JOptionPane.showMessageDialog(null,"修改成功","提示信息", PLAIN_MESSAGE);
                }

            }
            this.dispose();
            m.Update(new Select().seluser(user.getRank(),""));
            jTable.updateUI();
            jScrollPane.updateUI();
        }
        else if (source == jButton2){
            jTextField2.setText("请输入用户名");
            jTextField3.setText("请输入用户密码");
            jTextField5.setText("请输入用户电话");
        }
    }
}
