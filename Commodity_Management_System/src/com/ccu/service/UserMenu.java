package com.ccu.service;

import com.ccu.model.Goods;
import com.ccu.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMenu extends JFrame {

    Font font = new Font("宋体", 1,18);

    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JPanel newpanel = new JPanel();
    private JLabel jLabel = new JLabel("商品管理系统");

    ImageIcon img1 = new ImageIcon("image/7.png");
    ImageIcon img2 = new ImageIcon("image/8.png");

    private JLabel back1 = new JLabel(img1);
    private JLabel back2 = new JLabel(img2);

    private JLabel jLabel1 = new JLabel("     下单商品");
    private JLabel jLabel2 = new JLabel("      订单详情");

    private JLabel mas = new JLabel("当前时间:");
    private JLabel time ;
    User user;

    public UserMenu(User user) throws ParseException {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        jLabel.setFont(new Font("微软雅黑",1,48));
        this.setSize(screenSize.width,screenSize.height);
        this.user = user;
        init();
        this.add(jPanel1,BorderLayout.NORTH);
        this.add(newpanel,BorderLayout.CENTER);
        this.add(jPanel3,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void init() throws ParseException {
        jPanel1.add(jLabel);
        newpanel.setLayout(null);
        newpanel.add(jPanel2);
        jPanel2.setBounds(500,300,900,200);
        jPanel2.setLayout(new GridLayout(2,2,500,10));

        back1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new OrderGoods(user);
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
                new OrderDetails(user);
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

        jPanel2.add(back1);
        jPanel2.add(back2);

        jLabel1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new OrderGoods(user);
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
                new OrderDetails(user);
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

        jLabel1.setFont(font);
        jLabel2.setFont(font);

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
                        Thread.sleep(1000);
                        time.updateUI();
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
        new UserMenu(new User());
    }
}

