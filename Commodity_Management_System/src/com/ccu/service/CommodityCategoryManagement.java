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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class CommodityCategoryManagement extends JFrame implements ActionListener {

    private JLabel jLabel = new JLabel("商品类别管理");
    private JTable jTable ;
    private JScrollPane jScrollPane;
    private JButton slt = new JButton("查询");
    private JButton add = new JButton("添加");
    private JButton cag = new JButton("修改");
    private JButton del = new JButton("删除");
    private JTextField jTextField = new JTextField(15);
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private MyTableModel m;
    User user;


    public CommodityCategoryManagement(User user) {
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

        jPanel1.setLayout(new GridLayout(2,1,10,40));

        JPanel jPanel1_1 = new JPanel();
        jPanel1_1.add(jLabel);

        JPanel jPanel1_2 = new JPanel();
        jPanel1_2.setLayout(null);
        jTextField.setBounds(780,0,400,40);
        jTextField.setFont(new Font("宋体",0,28));
        jPanel1_2.add(jTextField);
        slt.setBounds(1230,0,100,40);
        slt.setFont(font);
        slt.addActionListener(this);
        jPanel1_2.add(slt);

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

    public void table(){
        Vector<String> c = new Vector<String>();
        c.add("商品类别编号");
        c.add("商品类别名");
        Vector r = new Vector();
        m = new MyTableModel(r,c);
        m.UpdategoodsClass(new Select().selgoodsclass());
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
    }
    public static void main(String[] args) {
        new CommodityCategoryManagement(new User());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == slt){
            ResultSet rs = new Select().selclass(jTextField.getText());
            m.UpdategoodsClass(rs);
            jTable.updateUI();
            jScrollPane.updateUI();
        }else if(source == add){
            new Addclass(jScrollPane,jTable,m,user);
        }else if(source == del){
            int row = jTable.getSelectedRow();
            UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
            UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
            int p = JOptionPane.showConfirmDialog(CommodityCategoryManagement.this,"删除会同时删除该类别的商品！","提示",JOptionPane.YES_NO_OPTION);
            if(p == JOptionPane.YES_OPTION) {
                String str = m.getValueAt(row,0).toString();
                boolean b = new Delete().delclass(str);
                StringBuffer buffer = new StringBuffer();
                buffer.append("管理员：").append(user.getUserName()).append("  删除商品类别：").append(m.getValueAt(row,1));
                new Insert().Jwrite(buffer.toString());
                if(b){
                    JOptionPane.showMessageDialog(null,"删除成功","提示信息", PLAIN_MESSAGE);
                }
                m.UpdategoodsClass(new Select().selgoodsclass());
                jTable.updateUI();
                jScrollPane.updateUI();
            }
            else{

            }
        }
        else if(source == cag){
            int row = jTable.getSelectedRow();
            String str = m.getValueAt(row,0).toString();
            new ChangeClass(jScrollPane,jTable,m,str);
        }
    }
}
