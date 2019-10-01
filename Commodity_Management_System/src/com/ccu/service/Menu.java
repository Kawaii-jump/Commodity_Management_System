package com.ccu.service;

import com.ccu.model.User;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;

public class Menu extends JFrame{

    Font font = new Font("宋体", 1,18);

    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JPanel newpanel = new JPanel();
    private JLabel jLabel = new JLabel("商品管理系统");

    ImageIcon img1 = new ImageIcon("image/1.png");
    ImageIcon img2 = new ImageIcon("image/2.png");
    ImageIcon img3 = new ImageIcon("image/4.png");
    ImageIcon img4 = new ImageIcon("image/3.png");
    ImageIcon img5 = new ImageIcon("image/5.png");

    private JLabel back1 = new JLabel(img1);
    private JLabel back2 = new JLabel(img2);
    private JLabel back3 = new JLabel(img3);
    private JLabel back4 = new JLabel(img4);
    private JLabel back5 = new JLabel(img5);

    private JLabel jLabel1 = new JLabel("   用户管理");
    private JLabel jLabel2 = new JLabel("   商品管理");
    private JLabel jLabel3 = new JLabel("  商品类别管理");
    private JLabel jLabel4 = new JLabel("   订单管理");
    private JLabel jLabel5 = new JLabel("   系统日志");

    private JLabel mas = new JLabel("当前时间:");
    private JLabel time ;

    public Menu(User user) throws ParseException {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        jLabel.setFont(new Font("微软雅黑",1,48));
        this.setSize(screenSize.width,screenSize.height-40);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                UIManager.put("OptionPane.buttonFont",new FontUIResource(new Font("宋体",1,18)));
                UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("宋体",1,18)));
                int p = JOptionPane.showConfirmDialog(Menu.this,"是否退出？","提示",JOptionPane.YES_NO_OPTION);
                if(p == JOptionPane.YES_OPTION) {
                    super.windowClosing(e);
                }
                else{

                }
            }

        });
        init(user);
        this.add(jPanel1,BorderLayout.NORTH);
        this.add(newpanel,BorderLayout.CENTER);
        this.add(jPanel3,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void init(User user) throws ParseException {
        //jPanel1.setLayout(null);
        jPanel1.setBounds(0,0,1900,60);
        jLabel.setBounds(400,10,1000,50);
        jPanel1.add(jLabel);
        newpanel.setLayout(null);
        newpanel.add(jPanel2);
        jPanel2.setBounds(500,300,900,200);
        jPanel2.setLayout(new GridLayout(2,5,40,10));

        jPanel2.add(back1);
        jPanel2.add(back2);
        jPanel2.add(back3);
        jPanel2.add(back4);
        jPanel2.add(back5);
        back1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new UserManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        back2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GoodsManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        back3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CommodityCategoryManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        back4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new OrderManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        back5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Journal();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        jPanel2.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.add(jLabel4);
        jPanel2.add(jLabel5);
        jLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new UserManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        jLabel2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GoodsManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        jLabel3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CommodityCategoryManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        jLabel4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new OrderManagement(user);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        jLabel5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Journal();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);

        mas.setFont(font);
        time=new JLabel(showTime());
        time.setFont(font);
        jPanel3.add(mas);
        jPanel3.add(time);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        time.setText(showTime());

                        time.updateUI();
                        Thread.sleep(1000);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public String showTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d = new Date();
        String s = sdf.format(d);
        return s;
    }

    public static void main(String[] args) throws ParseException {
        new Menu(new User());
    }

}

