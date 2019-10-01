package com.ccu.service;

import com.ccu.dao.Select;
import com.ccu.model.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;


public class Journal extends JFrame implements ActionListener {

    private JLabel jLabel = new JLabel("系统日志");
    private JButton add = new JButton("上一页");
    private JButton cag = new JButton("下一页");
    private JButton del = new JButton("跳转");
    private JTextField jTextField = new JTextField(15);
    private JTextArea jTextArea = new JTextArea();
    private JLabel jLabel1 = new JLabel("日期:");
    private JLabel jLabel2 = new JLabel("");
    private JLabel jLabel3 = new JLabel("总页数：");
    private JLabel jLabel4 = new JLabel("");
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    User user;
    int i=0;
    ArrayList<Jour> arr = new ArrayList<Jour>();


    public Journal() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.setSize(screenSize);
        this.add(jPanel1,BorderLayout.NORTH);
        this.add(jPanel2,BorderLayout.CENTER);
        this.add(jPanel3,BorderLayout.SOUTH);
        this.user = user;
        init();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void init()  {
        ResultSet rs = new Select().selJournal();
        try {
            while (rs.next()){
                arr.add(new Jour(rs.getString("JTime"),rs.getString("Content")));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        Font font = new Font("宋体",0,18);
        jLabel.setFont(new Font("微软雅黑",1,48));

        jPanel1.setLayout(new GridLayout(2,1,10,40));

        JPanel jPanel1_1 = new JPanel();
        jPanel1_1.add(jLabel);

        JPanel jPanel1_2 = new JPanel();
        jPanel1_2.setLayout(null);

        jPanel1.add(jPanel1_1);
        jPanel1.add(jPanel1_2);

        jPanel2.setLayout(null);
        jLabel1.setBounds(700,0,100,40);
        jLabel1.setFont(new Font("宋体",1,30));
        jLabel2.setBounds(800,0,900,40);
        jLabel2.setFont(new Font("宋体",1,30));
        jLabel3.setBounds(700,100,200,40);
        jLabel4.setBounds(820,100,300,40);
        jLabel3.setFont(new Font("宋体",1,30));
        jLabel4.setFont(new Font("宋体",1,30));
        jTextArea.setBounds(500,300,900,200);
        jTextArea.setFont(new Font("宋体",1,30));
        jTextArea.enable(false);
        jPanel2.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.add(jLabel4);
        jPanel2.add(jTextArea);

        jLabel2.setText(arr.get(i).getTime());
        jLabel4.setText(""+arr.size());
        jTextArea.setText(arr.get(i).getConnect());

        jPanel3.setLayout(null);
        jPanel3.setPreferredSize(new Dimension(1900,180));
        add.setBounds(600,0,100,40);
        add.setFont(font);
        add.addActionListener(this);
        jPanel3.add(add);
        jTextField.setBounds(800,0,100,40);
        jTextField.setFont(font);
        jPanel3.add(jTextField);
        del.setBounds(1000,0,100,40);
        del.setFont(font);
        del.addActionListener(this);
        jPanel3.add(del);
        cag.setBounds(1200,0,100,40);
        cag.setFont(font);
        cag.addActionListener(this);
        jPanel3.add(cag);

    }

    public static void main(String[] args) {
        new Journal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == add){
            try {
                if(i==0){
                    UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                    UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                    JOptionPane.showMessageDialog(null,"这是首页！","提示信息", PLAIN_MESSAGE);
                }
                else if(i>0){
                    i--;
                    jLabel2.setText(arr.get(i).getTime());
                    jLabel4.setText(""+arr.size());
                    jTextArea.setText(arr.get(i).getConnect());
                    jLabel2.updateUI();
                    jLabel4.updateUI();
                    jTextArea.updateUI();
                }
            }catch (Exception e2){
            }
        }else if(source == del){
            int t = Integer.parseInt(jTextField.getText());
            if(0<=t&&t<arr.size()){
                i=t;
                jLabel2.setText(arr.get(i).getTime());
                jLabel4.setText(""+arr.size());
                jTextArea.setText(arr.get(i).getConnect());
                jLabel2.updateUI();
                jLabel4.updateUI();
                jTextArea.updateUI();
            }
            else{
                UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                JOptionPane.showMessageDialog(null,"该页不存在！","提示信息", PLAIN_MESSAGE);
            }
        }
        else if(source == cag){
            try {
                if(i==arr.size()-1){
                    UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                    UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                    JOptionPane.showMessageDialog(null,"这是最后一页！","提示信息", PLAIN_MESSAGE);
                }
                else if(i<=arr.size()-2){
                    i++;
                    jLabel2.setText(arr.get(i).getTime());
                    jLabel4.setText(""+arr.size());
                    jTextArea.setText(arr.get(i).getConnect());
                    jLabel2.updateUI();
                    jLabel4.updateUI();
                    jTextArea.updateUI();
                }
            }catch (Exception e2){
            }
        }
    }
}

