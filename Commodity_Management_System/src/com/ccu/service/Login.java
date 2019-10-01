package com.ccu.service;


import com.ccu.dao.Select;
import com.ccu.model.JTextFieldListener;
import com.ccu.model.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class Login extends JFrame implements ActionListener{
    private User user = new User();
    private JLabel jLabel1 = new JLabel("欢迎使用商品管理系统");
    private JLabel jLabel2 = new JLabel("用户名:");
    private JLabel jLabel3 = new JLabel("密码:");
    ImageIcon background = new ImageIcon("image/login.jpg");
    private JLabel back = new JLabel(background);

    private JTextField jTextField1 = new JTextField(25);
    private JPasswordField jPasswordField  = new JPasswordField(25);

    private JButton jButton1 = new JButton("登录",background);
    private JButton jButton2 = new JButton("取消",background);

    public Login(){
        this.setBounds(450,200,background.getIconWidth(),background.getIconHeight());
        this.setTitle("登录");
        this.setLayout(new GridLayout(4,1,20,20));
        back.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        //设置内容窗格透明
        JPanel image = (JPanel)this.getContentPane();
        image.setOpaque(false);
        init();
        //将背景图添加到分层网格最底层当作背景
        this.getLayeredPane().add(back,new Integer(Integer.MIN_VALUE));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void init(){
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        Font font = new Font("宋体", 1,18);

        jPanel2.setLayout(null);
        jPanel3.setLayout(null);
        jPanel4.setLayout(null);

        jLabel1.setFont(new Font("微软雅黑",Font.BOLD,24));

        jLabel2.setFont(font);
        jLabel2.setBounds(320,0,160,35);
        jTextField1.setFont(font);
        jTextField1.setBounds(400,0,250,35);
        jTextField1.setBorder(null);
        jTextField1.addFocusListener(new JTextFieldListener("请输入用户名",jTextField1));

        jLabel3.setFont(font);
        jLabel3.setBounds(320,0,160,35);
        jPasswordField.setFont(font);
        jPasswordField.setBounds(400,0,250,35);
        jPasswordField.setBorder(null);
        jPasswordField.addFocusListener(new JTextFieldListener("请输入密码",jPasswordField));

        jButton1.setFont(font);
        jButton1.setBounds(320,0,100,35);
        jButton1.addActionListener(this);
        jButton2.setFont(font);
        jButton2.setBounds(550,0,100,35);
        jButton2.addActionListener(this);

        //将文字显示到图片上方
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jButton2.setHorizontalTextPosition(SwingConstants.CENTER);

        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        jPanel4.setOpaque(false);

        jPanel1.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel2.add(jTextField1);
        jPanel3.add(jLabel3);
        jPanel3.add(jPasswordField);
        jPanel4.add(jButton1);
        jPanel4.add(jButton2);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jButton1){
            ResultSet rs = (new Select()).setlogin(jTextField1.getText(),jPasswordField.getText());
            UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
            try {
                if(rs.next()){
                    user.setUserName(rs.getString("UserName"));
                    user.setRank(rs.getInt("Rank"));
                    JOptionPane.showMessageDialog(null,"登录成功","提示信息", PLAIN_MESSAGE);
                    this.dispose();
                    if (rs.getInt("Rank")==2)new UserMenu(user);
                    else new Menu(user);
                }
                else{
                    JOptionPane.showMessageDialog(null,"账号密码错误","错误提示",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e1) {
                System.out.println(e1.toString());
            } catch (ParseException e1) {
                System.out.println(e1.toString());
            }
        }else if(source == jButton2){
            jTextField1.setText("");
            jPasswordField.setText("");
        }
    }
}