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
import java.sql.SQLException;
import java.util.Vector;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class GoodsManagement extends JFrame implements ActionListener{

    private JLabel jLabel = new JLabel("商品管理");
    private JComboBox<String> jComboBox ;
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
    String[] o;


    public GoodsManagement(User user) {
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
        ResultSet rs = new Select().selgoodsclass();
        try {
            rs.last();
            int len =rs.getRow();
            o = new String[len+1];
            rs.beforeFirst();
            int i = 0;
            o[i] = "全部";
            i++;
            while(rs.next()){
                o[i] = rs.getString("Classification");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jComboBox = new JComboBox<String>(o);

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
        c.add("商品编号");
        c.add("商品名");
        c.add("商品类别");
        c.add("商品价格");
        c.add("商品库存");
        Vector r = new Vector();
        m = new MyTableModel(r,c);
        ResultSet rs = new Select().selgoods("");
        m.Updategoods(rs);
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
        new GoodsManagement(new User());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == slt){
            if(jComboBox.getSelectedItem().toString().trim() == o[0]){
                ResultSet rs = new Select().selgoods(jTextField.getText());
                m.Updategoods(rs);
                jTable.updateUI();
                jScrollPane.updateUI();
            }
            else {
                String fame = jComboBox.getSelectedItem().toString().trim();
                ResultSet rs = new Select().selgoods1(fame,jTextField.getText());
                m.Updategoods(rs);
                jTable.updateUI();
                jScrollPane.updateUI();
            }

        }else if(source == add){
            new AddGoods(jScrollPane,jTable,m,user);
        }else if(source == del){
            int row = jTable.getSelectedRow();
            String str = m.getValueAt(row,0).toString();
            int p = JOptionPane.showConfirmDialog(GoodsManagement.this,"删除该商品？","提示",JOptionPane.YES_NO_OPTION);
            if(p == JOptionPane.YES_OPTION) {
                boolean b = new Delete().delgoods(str);
                StringBuffer buffer = new StringBuffer();
                buffer.append("管理员：").append(user.getUserName()).append("  删除商品：").append(m.getValueAt(row,1));
                new Insert().Jwrite(buffer.toString());
                if(b){
                    UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                    UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                    JOptionPane.showMessageDialog(null,"删除成功","提示信息", PLAIN_MESSAGE);
                }
            }

            m.Updategoods(new Select().selgoods(""));
            jTable.updateUI();
            jScrollPane.updateUI();
        }
        else if(source == cag){
            int row = jTable.getSelectedRow();
            String str = m.getValueAt(row,0).toString();
            new ChangeGoods(jScrollPane,jTable,m,str);
        }
    }
}
