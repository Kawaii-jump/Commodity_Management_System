package com.ccu.service;

import com.ccu.dao.Delete;
import com.ccu.dao.Insert;
import com.ccu.dao.Select;
import com.ccu.model.MyTableModel;
import com.ccu.model.User;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;
import java.util.Vector;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class UserManagement extends JFrame implements ActionListener{

    private JLabel jLabel = new JLabel("用户管理");
    private JComboBox<String> jComboBox ;
    private JTable jTable ;
    private JScrollPane jScrollPane;
    private MyTableModel m;
    private JButton slt = new JButton("查询");
    private JButton add = new JButton("添加");
    private JButton cag = new JButton("修改");
    private JButton del = new JButton("删除");
    private JTextField jTextField = new JTextField(15);
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    User user;
    String[] o1 = {"全部","用户","管理员"};
    String[] o2 = {"全部","用户"};


    public UserManagement(User user) {
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

    public void init(){
        Font font = new Font("宋体",0,18);
        jLabel.setFont(new Font("微软雅黑",1,48));
        if(user.getRank()==0) {
            jComboBox = new JComboBox<String>(o1);
        }else if(user.getRank()==1) {
            jComboBox = new JComboBox<String>(o2);
        }
        jPanel1.setLayout(new GridLayout(2,1,10,40));

        JPanel jPanel1_1 = new JPanel();
        jPanel1_1.add(jLabel);

        JPanel jPanel1_2 = new JPanel();
        jPanel1_2.setLayout(null);
        jComboBox.setBounds(580,0,150,40);
        jPanel1_2.add(jComboBox);
        jComboBox.setFont(font);
        jTextField.setBounds(780,0,400,40);
        jTextField.setFont(new Font("宋体",0,28));
        jPanel1_2.add(jTextField);
        slt.setBounds(1230,0,100,40);
        slt.setFont(font);
        jPanel1_2.add(slt);
        slt.addActionListener(this);

        jPanel1.add(jPanel1_1);
        jPanel1.add(jPanel1_2);

        jPanel2.setLayout(null);
        table();
        jPanel2.add(jScrollPane);

        jPanel3.setLayout(null);
        jPanel3.setPreferredSize(new Dimension(1900,180));
        add.setBounds(600,0,100,40);
        add.setFont(font);
        add.addActionListener(this);
        jPanel3.add(add);
        del.setBounds(800,0,100,40);
        del.setFont(font);
        del.addActionListener(this);
        jPanel3.add(del);
        cag.setBounds(1000,0,100,40);
        cag.setFont(font);
        cag.addActionListener(this);
        jPanel3.add(cag);

    }

    public void table() {
        Vector<String> c = new Vector<String>();
        Vector r = new Vector();
        c.add("用户编号");
        c.add("用户名");
        c.add("密码");
        c.add("用户等级");
        c.add("电话");
        ResultSet rs = new Select().seluser(user.getRank(),jTextField.getText());

        m = new MyTableModel(r,c);
        m.Update(rs);
        jTable = new JTable(m);

        jTable.setRowHeight(28);
        jTable.setFont(new Font("宋体",0,18));
        jTable.setSelectionBackground(Color.DARK_GRAY);
        jTable.setSelectionForeground(Color.WHITE);
        jTable.setGridColor(Color.GRAY);

        //设置JTable文字居中
        DefaultTableCellRenderer d = new DefaultTableCellRenderer();
        d.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class,d);


        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setFont(new Font("宋体",1,18));
        jTableHeader.setForeground(Color.PINK);
        jTableHeader.setReorderingAllowed(false);

        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(150,0,1600,600);
        jScrollPane.setOpaque(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == slt){
            if(jComboBox.getSelectedItem().toString().trim() == o1[0]){
                ResultSet rs = new Select().seluser(user.getRank(),jTextField.getText());
                m.Update(rs);
                jTable.updateUI();
                jScrollPane.updateUI();
            }
            else if(jComboBox.getSelectedItem().toString().trim() == o1[1]){
                ResultSet rs = new Select().seluser1(2,jTextField.getText());
                m.Update(rs);
                jTable.updateUI();
                jScrollPane.updateUI();
            }else if(jComboBox.getSelectedItem().toString().trim() == o1[2]){
                ResultSet rs = new Select().seluser1(1,jTextField.getText());
                m.Update(rs);
                jTable.updateUI();
                jScrollPane.updateUI();
            }
        }
        else if(source == add){
            new AddUser(jScrollPane,jTable,m,user);
        }
        else if(source == del){
            int row = jTable.getSelectedRow();
            int num = (int) m.getValueAt(row,0);
            boolean b = new Delete().deluser(num);
            StringBuffer buffer = new StringBuffer();
            buffer.append("管理员").append(user.getUserName()).append("  删除用户：").append(m.getValueAt(row,1));
            new Insert().Jwrite(buffer.toString());
            if(b){
                UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                JOptionPane.showMessageDialog(null,"删除成功","提示信息", PLAIN_MESSAGE);
            }
            m.Update(new Select().seluser(user.getRank(),jTextField.getText()));
            jTable.updateUI();
            jScrollPane.updateUI();
        }
        else if(source == cag){
            int row = jTable.getSelectedRow();
            int num = (int) m.getValueAt(row,0);
            new ChangeUser(jScrollPane,jTable,m,user,num);
        }
    }
//    public static void main(String[] args) {
//        new UserManagement();
//    }
}
