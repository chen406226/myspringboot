package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;   //Date needed
import java.text.SimpleDateFormat;
import java.io.*;
import javax.swing.event.*;
import sun.audio.*;
public class FontDialog extends JDialog implements ActionListener,ItemListener
{   static final int OK=1,NO=0;public int message=-1;
    private JButton OK_but,NO_but;
    private Choice cho01,cho02,cho03,cho04;
    public String str01,str02;
    public FontDialog(JFrame f,String str,boolean b)
    {
        super(f,str,b);
        Container cont = getContentPane();

        Font []font  = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        String []fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
        cho01 = new Choice();
        for(int i = fontNames.length-1;i>=0;i--)
        {
           cho01.add(fontNames[i]);
        }
        cho02 = new Choice();
        cho02.setEnabled(true);
        for(int s = 10;s<73;s=s+2)
        {
          cho02.add(Integer.toString(s));
        }
        cho02.select(5);

        cho01.addItemListener(this);
        cho02.addItemListener(this);

        cont.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel jll = new JLabel("字体",JLabel.LEFT);
        cont.add(jll);
        cont.add(cho01);
        jll = new JLabel("大小",JLabel.LEFT);
        cont.add(jll);cont.add(cho02);

        //str01 = cho01.getItem(cho01.getSelectedIndex());
        //str02 = cho02.getItem(cho02.getSelectedIndex());

        OK_but=new JButton("确定");
        OK_but.addActionListener(this);
        NO_but=new JButton("取消");
        NO_but.addActionListener(this);

        cont.add(OK_but);
        cont.add(NO_but);
        //setSize(380,120);
        setBounds(400,200,380,120);
        setResizable(false); 
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource()==OK_but)
        {
            message=OK;
            setVisible(false);
        }

        if(ev.getSource()==NO_but)
        {   message=NO;
            setVisible(false);
            setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        }
    }
    public void itemStateChanged(ItemEvent e)
    {
        str01 = cho01.getItem(cho01.getSelectedIndex());
        str02 = cho02.getItem(cho02.getSelectedIndex());
    }
}
