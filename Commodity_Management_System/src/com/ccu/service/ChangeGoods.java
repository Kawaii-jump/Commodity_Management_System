package com.ccu.service;

import com.ccu.dao.Insert;
import com.ccu.dao.Select;
import com.ccu.dao.Update;
import com.ccu.model.JTextFieldListener;
import com.ccu.model.MyTableModel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class ChangeGoods extends JFrame implements ActionListener {

    Font font = new Font("宋体",0,18);

    private JLabel jLabel1 = new JLabel("商品编号:");
    private JLabel jLabel2 = new JLabel("商品名:");
    private JLabel jLabel3 = new JLabel("商品类别:");
    private JLabel jLabel4 = new JLabel("商品价格:");
    private JLabel jLabel5 = new JLabel("商品库存:");


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
    String str ;
    String[] o;
    Integer[] g;

    public ChangeGoods(JScrollPane j,JTable jTable,MyTableModel m,String GoodsId){
        this.setBounds(700,110,500,650);
        this.setTitle("添加商品");
        this.setFont(font);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.jScrollPane = j;
        this.jTable = jTable;
        this.str = GoodsId;
        this.m=m;
        init();
        this.setVisible(true);
    }

    public void init(){
        ResultSet rs = new Select().selgoodsclass();
        try {
            rs.last();
            int len =rs.getRow();
            o = new String[len];
            g = new Integer[len];
            rs.beforeFirst();
            int i = 0;
            while(rs.next()){
                g[i] = rs.getInt("ClassificationNum");
                o[i] = rs.getString("Classification");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jComboBox = new JComboBox<String>(o);
        jLabel1.setBounds(40,20,100,40);
        jLabel2.setBounds(40,120,100,40);
        jLabel3.setBounds(40,220,100,40);
        jLabel4.setBounds(40,320,100,40);
        jLabel5.setBounds(40,420,100,40);


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
        jComboBox.setBounds(180,220,250,40);
        jTextField3.setBounds(180,320,250,40);
        jTextField5.setBounds(180,420,250,40);

        jTextField1.addFocusListener(new JTextFieldListener("请输入商品编号",jTextField1));
        jTextField2.addFocusListener(new JTextFieldListener("请输入商品名",jTextField2));
        jTextField3.addFocusListener(new JTextFieldListener("请输入商品价格",jTextField3));
        jTextField5.addFocusListener(new JTextFieldListener("请输入商品库存",jTextField5));

        jTextField1.setText(str);
        jTextField1.setEditable(false);

        jTextField1.setFont(font);
        jTextField2.setFont(font);
        jTextField3.setFont(font);
        jTextField5.setFont(font);
        jComboBox.setFont(font);

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
            for(int i=0;i<o.length;i++){
                if (jComboBox.getSelectedItem().toString().trim().equals(o[i])){
                    boolean b = new Update().upgoods(jTextField1.getText(),jTextField2.getText(),g[i].toString(),Double.valueOf(jTextField3.getText()),Integer.parseInt(jTextField5.getText()));
                    if(b){
                        UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                        UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                        JOptionPane.showMessageDialog(null,"添加成功","提示信息", PLAIN_MESSAGE);
                    }
                }
            }
            this.dispose();
            m.Updategoods(new Select().selgoods(""));
            jTable.updateUI();
            jScrollPane.updateUI();
        }
        else if (source == jButton2){
            jTextField2.setText("请输入商品名");
            jTextField3.setText("请输入商品价格");
            jTextField5.setText("请输入商品库存");
        }
    }
}
