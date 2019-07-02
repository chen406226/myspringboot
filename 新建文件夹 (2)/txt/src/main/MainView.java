package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import copy.TextEditBox;
import copy1.FontDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JToolBar;
public class MainView extends JFrame implements ActionListener,FocusListener, 
MouseListener,CaretListener,UndoableEditListener {

    private JPanel contentPane;
    private UndoManager manager; 
    /**
     * Create the frame.
     */
    private JComboBox com1,com2;// 字体、字号组合框  
    String filename;
    private int key, j,count;
    private JLabel lblStatus;
    private File file01,file02;
    private JFileChooser jfc;
    private JTextPane  jta[]=new JTextPane[20],jep;//JTextArea jt;
    private int close_i = 0,i = 0,k=0,TabNum;
    private JScrollPane jsp[]=new JScrollPane[20];
    private JTabbedPane tab1,tab;
    private JButton b3,b1,b6,button_1,button3,button9,button_2,button_3,button_4,button_5,button_7,button8,btn1,btn2;
    private JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,mnNew3,mnNew4,mnNew2,item,item1;
    private JToolBar toolBar;
    private JTextField tf_search;  
    private JButton button_next;  
    private JMenuItem menuItem_3;
    SimpleAttributeSet set=new SimpleAttributeSet();
    SimpleAttributeSet set1=new SimpleAttributeSet();
    int start,length,start1,length1;
    public MainView() {
        setTitle("多页面文本编辑器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 780, 509);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("文件");
        menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        menuBar.add(menu);

        mnNew2 = new JMenuItem("\u65B0\u5EFA");
        mnNew2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu.add(mnNew2);
        mnNew2.addActionListener(this);

        m1 = new JMenuItem("\u6253\u5F00");
        m1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu.add(m1);
        m1.addActionListener(this);

        m2 = new JMenuItem("\u4FDD\u5B58");
        m2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu.add(m2);
        m2.addActionListener(this);

        menuItem_3 = new JMenuItem("\u53E6\u5B58\u4E3A");
        menuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menuItem_3.addActionListener(this);
        menu.add(menuItem_3);

        mnNew3 = new JMenuItem("\u5173\u95ED\u5F53\u524D\u9875");
        mnNew3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu.add(mnNew3);

        item = new JMenuItem("\u5173\u95ED\u5168\u90E8\u9875");
        item.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu.add(item);
        item.addActionListener(this);
        mnNew3.addActionListener(this);

        JMenu mnNewMenu = new JMenu("编辑");
        mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        menuBar.add(mnNewMenu);

        m6 = new JMenuItem("\u64A4\u9500");
        m6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu.add(m6);
        m6.addActionListener(this);

        mnNew4 = new JMenuItem("\u526A\u5207");
        mnNew4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu.add(mnNew4);
        mnNew4.addActionListener(this);

        m3 = new JMenuItem("\u590D\u5236");
        m3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu.add(m3);
        m3.addActionListener(this);

        m4 = new JMenuItem("\u7C98\u8D34");
        m4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu.add(m4);
        m4.addActionListener(this);

        m7 = new JMenuItem("\u67E5\u627E");
        m7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu.add(m7);

        item1 = new JMenuItem("\u5168\u9009");
        item1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        item1.addActionListener(this);
        mnNewMenu.add(item1);m7.addActionListener(this);

        JMenu mnNewMenu_1 = new JMenu("格式");
        mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        menuBar.add(mnNewMenu_1);

        m8 = new JMenuItem("\u5B57\u4F53");
        m8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu_1.add(m8);
        m8.addActionListener(this);

        m9 = new JMenuItem("\u5B57\u4F53\u989C\u8272");
        m9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu_1.add(m9);
        m9.addActionListener(this);

        m10 = new JMenuItem("\u80CC\u666F\u989C\u8272");
        m10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        mnNewMenu_1.add(m10);

        JMenu menu_1 = new JMenu("\u5DE5\u5177");
        menu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        menuBar.add(menu_1);

        JMenuItem menuItem = new JMenuItem("\u5B57\u6570\u7EDF\u8BA1");
        menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu_1.add(menuItem);
        menuItem.addActionListener(new ActionListener() {//字数统计
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                 int count=0;  
                    for(int i=0;i<jep.getText().length();i++){  
                        if(!jep.getText().substring(i,i+1).equals(" ")){  
                            count++;  
                        }  
                    }  
                    JOptionPane.showMessageDialog(MainView.this, "文本框中一共有"+count+"个字符！"); 
            }
        });

        JMenuItem menuItem_1 = new JMenuItem("\u67E5\u627E");
        menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu_1.add(menuItem_1);

        menuItem_1.addActionListener(new ActionListener() {//查找
             public void actionPerformed(ActionEvent e) {
                    k=0;
                    new MessageJDialog();  
                    button_next.addActionListener(new ActionListener() {  
                        public void actionPerformed(ActionEvent e) {  
                            String str_search=tf_search.getText();  
                            int len = str_search.length();  
                            for (int i = key; i < jep.getText().length() - len + 1; i++) {  
                                String str_record = jep.getText().substring(i, i + len);  
                                if (str_record.equals(str_search)) {  
                                    key = i + 1;  
                                    jep.requestFocus();  
                                    jep.select(i, i + len);  
                                    return;  
                                }  
                            }  
                        }
                    });
             }
        });

        JMenuItem menuItem_2 = new JMenuItem("\u66FF\u6362");
        menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        menu_1.add(menuItem_2);
        menuItem_2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {  
                    String str_replace=JOptionPane.showInputDialog(MainView.this,  
                            "请输入你要替换的字符串:" );  
                    String str_replacelater=JOptionPane.showInputDialog(MainView.this,  
                            "请输入你要用来替换的内容:" );  
                    int len=str_replace.length();  
                    for(int i=0;i<jep.getText().length()-len+1;i++){  
                        String str_record=jep.getText().substring(i, i+len);  
                        if(str_record.equals(str_replace)){  
                            Document doc=jep.getDocument();
                            try {
                                doc.remove(i, len);
                                doc.insertString(i, str_replacelater,set);
                            } catch (BadLocationException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }


                        }  
                    }  
                }  
        });

        m10.addActionListener(this);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        ImageIcon image=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\save.gif");
        image.setImage(image.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image1=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\open.gif");
        image1.setImage(image1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image11=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\cut.gif");
        image11.setImage(image11.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image2=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\copy.gif");
        image2.setImage(image2.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image3=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\Font.png");
        image3.setImage(image3.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image4=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\FontColor.png");
        image4.setImage(image4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image5=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\加粗.png");
        image5.setImage(image5.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image6=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\new.gif");
        image6.setImage(image6.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image7=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\斜体.png");
        image7.setImage(image7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        ImageIcon image8=new ImageIcon("D:\\eclipse-workspace\\04107204刘聪\\下划线.png");
        image8.setImage(image8.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        TabNum=0;
        //jta=new JEditorPane[100]; 
        //jsp=new JScrollPane[100];

        for(int i=TabNum;i>0;i--)
        {   jta[TabNum-1]=new JTextPane();
            jsp[TabNum-1]=new JScrollPane(jta[TabNum-1]); 

            jta[TabNum-1].getDocument().addUndoableEditListener(manager);
            jta[TabNum-1].addCaretListener(this);
            jsp[TabNum-1].setViewportView(jta[TabNum-1]);
            if(TabNum!=0)
            {
                tab.addTab("无标题"+i,jsp[TabNum-1]);
            }               
        }

        tab = new JTabbedPane(JTabbedPane.TOP);
        tab.setBounds(24, 46, 693, 390);
        contentPane.add(tab);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  
        String[] fontsName = ge.getAvailableFontFamilyNames(); // 获得系统字体  

        String sizestr[] = { "12", "14", "16", "18", "20", "22" ,"24","26","28","30","32","34","36","38","40","42","44","46","48","50"
                ,"52","54","56","58","60","62","64","66","68","70"};  

        toolBar = new JToolBar();
        toolBar.setBounds(0, 0, 774, 25);
        contentPane.add(toolBar);

        b6 = new JButton((Icon) null);
        toolBar.add(b6);
        b6.setIcon(image6);

        b1 = new JButton();
        toolBar.add(b1);
        b1.setIcon(image1);

         b3 = new JButton();
         toolBar.add(b3);
         b3.setIcon(image);

         button3 = new JButton((Icon) null);
         toolBar.add(button3);
         button3.setIcon(image11);

         button9 = new JButton((Icon) null);
         toolBar.add(button9);
         button9.setIcon(image2);

         JButton button5 = new JButton((Icon) null);
         toolBar.add(button5);
         button5.setIcon(image5);
         button5.addActionListener(new ActionListener() {//加粗
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String fontname = (String)com1.getSelectedItem();//获得字体名  
                int size =Integer.parseInt((String)com2.getSelectedItem());  
                Font font = jep.getFont();
                int style = font.getStyle(); 
                style = style ^ 1;  
                jep.setFont(new Font(fontname, style, size));  
            } 
         });

         com1 = new JComboBox(fontsName);
         toolBar.add(com1);
         com2 = new JComboBox(sizestr);  
         toolBar.add(com2);
         com2.setEditable(true);
         com1.addActionListener(new ActionListener() {//设置字体
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
               String fontname = (String)com1.getSelectedItem();//获得字体名  
               Font font = jep.getFont();     //获得文本区的当前字体对象  
               int style = font.getStyle();      //获得字形  
               int size = Integer.parseInt((String)com2.getSelectedItem());   
               jep.setFont(new Font(fontname, style, size));  
            }
         });
         com2.addActionListener(new ActionListener() {//设置字号

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                    String fontname = (String)com1.getSelectedItem();//获得字体名  
                    int size = Integer.parseInt((String)com2.getSelectedItem());  
                    Font font = jep.getFont();     //获得文本区的当前字体对象  
                    int style = font.getStyle();      //获得字形  
                    jep.setFont(new Font(fontname, style, size));  
            } 
         });

         JButton button_7_1 = new JButton((Icon) null);
         toolBar.add(button_7_1);
         button_7_1.setIcon(image7);
         button_7_1.addActionListener(new ActionListener() {//斜体
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                 String fontname = (String)com1.getSelectedItem();//获得字体名  
                    Font font = jep.getFont();     //获得文本区的当前字体对象  
                    int style = font.getStyle();      //获得字形  
                    int size = font.getSize();  
                    style = style ^ 2;  
                    jep.setFont(new Font(fontname, style, size));  
            } 
         });

         btn1 = new JButton();
         toolBar.add(btn1);
         btn1.setFont(new Font("宋体", Font.PLAIN, 12));
         btn1.setText("A+");
         btn1.addActionListener(new ActionListener() {//增加字号
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                 String fontname = (String)com1.getSelectedItem();//获得字体名  
                 int size = Integer.parseInt((String)com2.getSelectedItem())+2;   
                 com2.setSelectedItem(String.valueOf(size));
                 Font font = jep.getFont();     //获得文本区的当前字体对象  
                 int style = font.getStyle();      //获得字形  
                 jep.setFont(new Font(fontname, style, size));  
            }
         });

         JButton btn2_1 = new JButton((Icon) null);
         toolBar.add(btn2_1);
         btn2_1.setText("A-");
         btn2_1.setFont(new Font("宋体", Font.PLAIN, 12));
         btn2_1.addActionListener(new ActionListener() {//减小字号
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String fontname = (String)com1.getSelectedItem();//获得字体名  
                int size = Integer.parseInt((String)com2.getSelectedItem())-2;
                com2.setSelectedItem(String.valueOf(size));
                Font font = jep.getFont();     //获得文本区的当前字体对象  
                int style = font.getStyle();      //获得字形  
                jep.setFont(new Font(fontname, style, size));  
            }
         });
         button8 = new JButton((Icon) null);
         toolBar.add(button8);
         button8.setIcon(image4);
         button8.addActionListener(this);
         button_7_1.addActionListener(this);
         button5.addActionListener(this);
         button9.addActionListener(this);
         button3.addActionListener(this);
         b3.addActionListener(this);
        b1.addActionListener(this);
        b6.addActionListener(this);

        manager=new UndoManager();

        tab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                p(e);
            }
            public void p(MouseEvent e) {
                for(int i=0;i<=TabNum;i++) {
                    Rectangle rect=tab.getBoundsAt(i);
                    if(rect.contains(e.getX(),e.getY())) {
                        count=i;
                    }
                }
            }
        });


    }
     public void actionPerformed(ActionEvent e) {
                   if(e.getSource()==b1||e.getSource()==m1) {//打开
                    jta[TabNum]=new JTextPane();
                    jta[TabNum].addFocusListener(this);        
                    jta[TabNum].getDocument().addUndoableEditListener(manager);
                    jta[TabNum].addCaretListener(this);    
                    // jta[TabNum].setLineWrap(true);

                    dakai(jta[TabNum]);
                    //TabNum++;
                    jsp[TabNum]=new JScrollPane(jta[TabNum],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
                    tab.addTab(filename,jta[TabNum]);

                    jep=jta[0];
                    tab.setVisible(true);
                    j=TabNum-1;
                   }else if(e.getSource()==b6||e.getSource()==mnNew2) {//新建
                       TabNum++;
                    jta[TabNum-1]=new JTextPane();
                    jta[TabNum-1].addFocusListener(this);
                    jsp[TabNum-1]=new JScrollPane(jta[TabNum-1],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);         
                    jta[TabNum-1].getDocument().addUndoableEditListener(manager);
                    jta[TabNum-1].addCaretListener(this);
                    //jta[TabNum-1].setLineWrap(true);
                    jsp[TabNum-1].setViewportView(jta[TabNum-1]);           
                    tab.addTab("无标题"+TabNum,jsp[TabNum-1]);
                    jep=jta[0];       
                    tab.setVisible(true);       
                    jta[TabNum-1].setFont(new Font((String) com1.getSelectedItem(),Font.PLAIN,Integer.parseInt((String)com2.getSelectedItem())));
                   }else if(e.getSource()==b3||e.getSource()==m2) {//保存
                       baocun(jep);
                   }else if(e.getSource()==menuItem_3){
                       lingcun(jep);
                   }else if(e.getSource()==mnNew3) {//关闭
                       close(jep);
                   }else if(e.getSource()==item) {//全部关闭
                       tab.setVisible(false);
                   }else if(e.getSource()==m3||e.getSource()==button9) {//复制
                       jep.copy();
                   }else if(e.getSource()==m4) {//粘贴
                       jep.paste();
                   }else if(e.getSource()==item1) {//全选
                       jep.selectAll();
                   }else if(e.getSource()==mnNew4||e.getSource()==button3) {//剪切
                       jep.cut();
                   }else if(e.getSource()==m8) {//设置文字
                       try {
                        wenzi(jep);
                    } catch (BadLocationException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                   }else if(e.getSource()==m6) {//撤销
                       Undo();
                   } else if(e.getSource()==m9||e.getSource()==button8) {
                       try {
                        color(jep);
                    } catch (BadLocationException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                   }else if(e.getSource()==m10) {
                       try {
                        backcolor(jep);
                    } catch (BadLocationException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                   }

     }
        public void wenzi(JTextPane jep2) throws BadLocationException
        {   
            FontDialog fdg = new FontDialog(this,"文字设置",true);
            start=jep2.getSelectionStart();
            length= jep2.getSelectionEnd()-start;
            String ss=jep2.getSelectedText();
            if(fdg.message==1)
            {  

            StyleConstants.setFontSize(set, Integer.parseInt(fdg.str02));
            StyleConstants.setFontFamily(set, fdg.str01);
            Document doc=jep2.getDocument();
            doc.remove(start, length);
            doc.insertString(start, ss, set);
            }   
        }
     public void backcolor(JTextPane jep2) throws BadLocationException {
         Color newColor=JColorChooser.showDialog(this,"文字颜色选择器",m9.getBackground());
            int start=jep2.getSelectionStart();
            int length= jep2.getSelectionEnd()-start;
            String ss=jep2.getSelectedText();
            StyleConstants.setBackground(set, newColor);
            Document doc=jep2.getDocument();
            doc.remove(start, length);
            doc.insertString(start, ss, set);
     }
     public void color(JTextPane jep2) throws BadLocationException {
            Color newColor=JColorChooser.showDialog(this,"文字颜色选择器",m9.getBackground());
            start1=jep2.getSelectionStart();
            length1= jep2.getSelectionEnd()-start1;
            String ss=jep2.getSelectedText();
            if(start1==start&&length==length1) {
                StyleConstants.setForeground(set, newColor);
                Document doc=jep2.getDocument();
                doc.remove(start, length);
                doc.insertString(start, ss, set);
            }else {
                Font font=jep2.getFont();
                StyleConstants.setFontFamily(set1, font.getFontName());
                StyleConstants.setFontSize(set1, font.getSize());
                StyleConstants.setForeground(set1, newColor);
                Document doc=jep2.getDocument();
                doc.remove(start, length);
                doc.insertString(start, ss, set1);
            }

     }
    private void dakai(JTextPane jta2)//打开
    {   
        jfc = new JFileChooser();
            int se = jfc.showOpenDialog(this);
            if(se==JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    file01=jfc.getSelectedFile();
                    filename =file01.getName();  
                    FileReader fr = new FileReader(file01);
                    BufferedReader rd = new BufferedReader(fr);
                    String s = null;
                    Byte []buf = new Byte[64];
                    String open = null;
                    while((s=rd.readLine())!=null)
                    {
                        jta2.replaceSelection(s+"\n");
                    }
                }
                catch(IOException exx)
                {
                    exx.printStackTrace();
                }

            }
    }
    private void lingcun(JTextPane jep2)//另存
    {
        jfc = new JFileChooser();
            int se = jfc.showSaveDialog(this);
            if(se==JFileChooser.APPROVE_OPTION)
            {
                try
                {
                    String sr_s = jfc.getSelectedFile().getAbsolutePath();
                    FileOutputStream fos = new FileOutputStream(new File(sr_s));
                    OutputStreamWriter osw = new OutputStreamWriter(fos);
                    String saveString=jep2.getText().replaceAll("\n","\r\n"); 
                    osw.write(saveString);
                    osw.flush();
                    osw.close();   
                }
                catch(IOException es)
                {
                    es.printStackTrace();
                }       
            }
    }
    private void baocun(JTextPane jep2)//保存
    {
            try
            {
                String sr_s = jfc.getSelectedFile().getAbsolutePath();
                FileOutputStream fos = new FileOutputStream(new File(sr_s));
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                String saveString=jep2.getText().replaceAll("\n","\r\n"); 
                osw.write(saveString);
                osw.flush();
                osw.close();   
            }
            catch(IOException es)
            {
                es.printStackTrace();
            }   
    }
    public void close(JTextPane jep2) {
           tab.remove(count);
    }
    private void Undo()
    {
        try
        {
            manager.undo();

        }
        catch(CannotRedoException e1)
        {

        }   
    }

    public static void main(String []args) {
        MainView v=new MainView();
        v.setVisible(true);
    }
    @Override
    public void undoableEditHappened(UndoableEditEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void caretUpdate(CaretEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void focusGained(FocusEvent et) {
        // TODO Auto-generated method stub
        if(et.getSource()==jta[0])
            jep=jta[0];
        if(et.getSource()==jta[1])
            jep=jta[1];
        if(et.getSource()==jta[2])
            jep=jta[2];
        if(et.getSource()==jta[3])
            jep=jta[3];
        if(et.getSource()==jta[4])
            jep=jta[4];         
        if(et.getSource()==jta[5])
            jep=jta[5];
        if(et.getSource()==jta[6])
            jep=jta[6];
        if(et.getSource()==jta[7])
            jep=jta[7];
        if(et.getSource()==jta[8])
            jep=jta[8];
        if(et.getSource()==jta[9])
            jep=jta[9];  
    }
    private class MessageJDialog extends JDialog {  
        private JLabel lable_tip;  
        private JPanel panel_next = new JPanel();  
        private JPanel panel_search = new JPanel();  
        private JPanel panel_tip = new JPanel();  

        public MessageJDialog() {  
            super(MainView.this, "查找");  
            this.setSize(300, 170);  
            this.setLocation(MainView.this.getX() + 200,  
                    MainView.this.getY() + 200);  
            getContentPane().setLayout(new GridLayout(3, 1));  
            //  
            ImageIcon imageIcon = new ImageIcon("img/search.png");  
            lable_tip = new JLabel("请输入你要查找的字符串：", imageIcon, JLabel.LEFT);  
            panel_tip.add(lable_tip);  
            getContentPane().add(panel_tip);  
            tf_search = new JTextField(20);  
            panel_search.add(tf_search);  
            getContentPane().add(panel_search);  
            button_next = new JButton("查找下一个");  
            panel_next.add(button_next);  
            getContentPane().add(panel_next);  
            this.setVisible(true);  
        }  
    }
    public void focusLost(FocusEvent arg0) {
        // TODO Auto-generated method stub

    }
}
