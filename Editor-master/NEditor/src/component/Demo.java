package component;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Demo extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Demo frm = new Demo();
	// ����һ���˵���
	static MenuBar menubar = new MenuBar();
	// ����һ������ʽ�˵��������"�ļ�"
	static Menu menu1 = new Menu("�ļ�");
	// ����һ������ʽ�˵��������"����"
	static Menu menu2 = new Menu("����");
	// ����һ���˵����������"��"
	static MenuItem item1 = new MenuItem("��");
	// ����һ���˵����������"����"
	static MenuItem item2 = new MenuItem("����");
	// ����һ���˵����������"��������"
	static MenuItem item3 = new MenuItem("��������");

	// FileDialog ����ʾһ���Ի��򴰿ڣ��û����Դ���ѡ���ļ���
	static FileDialog dia1 = new FileDialog(frm, "��");
	// FileDialog.SAVE�˳���ֵָʾ�ļ��Ի��򴰿ڵ������ǲ���Ҫд����ļ���
	static FileDialog dia2 = new FileDialog(frm, "����", FileDialog.SAVE);
	// ����һ���ı���
	static TextArea txa = new TextArea();
	// ����һ�������¼�����
	static WinLis wlis = new WinLis();

	public static void main(String agrs[]) {
		// ����Frame��title
		frm.setTitle("С���±�@�����09��4��");

		/* ������ʽ�˵�menu1��menu2��ӵ��˵����� */
		menubar.add(menu1);
		menubar.add(menu2);

		/* ���˵�item1��item2��ӵ�����ʽ�˵�menu1�У����˵�item3��ӵ�����ʽ�˵�menu2�� */
		menu1.add(item1);
		menu1.add(item2);
		menu2.add(item3);

		/* Ϊitem1��item2��item3���ָ���Ķ������������ԴӴ˲˵�����ն����¼� */
		item1.addActionListener(frm);
		item2.addActionListener(frm);
		item3.addActionListener(frm);

		// ���ı�ȥtxa��ӵ�Frame��
		frm.add(txa);
		// ���˴���Ĳ˵�������Ϊָ����menubar�˵�����
		frm.setMenuBar(menubar);
		// ����Frame����Ĵ�С��800��650
		frm.setSize(800, 650);
		// ��ʾ���
		frm.setVisible(true);
		/* Ϊ�����Ӵ����¼� */
		frm.addWindowListener(wlis);
		frm.addWindowListener(wlis);
	}

	/* �����¼���ʵ�֣��ڹرմ��ڵ�ͬʱ�ر����г��� */
	static class WinLis extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			frm.dispose();
		}

	}

	public void actionPerformed(ActionEvent e) {
		// ��ȡ��ǰ����Ĳ˵�����getSource()����������� Event �Ķ���
		MenuItem item = (MenuItem) e.getSource();
		if (item == item1) {
			dia1.setVisible(true);
			/* getDirectory()��ȡdia1�Ի����Ŀ¼��getFile()��ȡdia1�Ի����ѡ���ļ� */
			String fname = dia1.getDirectory() + dia1.getFile();
			try {
				// ����һ���ļ������ֽ���
				FileInputStream fi = new FileInputStream(fname);
				/* fi.available()������һ�ζԴ����������õķ������Բ��������شӴ���������ȡ�����������Ĺ���ʣ���ֽ��� */
				byte ba[] = new byte[fi.available()];
				// �Ӵ��������н����ba.length���ֽڵ����ݶ��뵽һ��byte������
				fi.read(ba);
				// ��ֵ�����ı�����(new String(ba)���ַ�ת�����ַ���).
				txa.setText(new String(ba));
				// �ر�������
				fi.close();
			} catch (IOException ioe) {
			}
			;
		}
		if (item == item2) {
			dia2.setVisible(true);
			// getDirectory()��ȡdia2�Ի����Ŀ¼
			String fname2 = dia2.getDirectory();
			// dia2.getFile()���dia2�Ի����е�ѡ���ļ�����Ϊ��ƴ���Ϻ�׺.txt
			File file = new File(dia2.getFile() + ".txt");
			// ����ı����е�����
			String s = txa.getText();

			try {
				// ����һ���ı�д���ַ��������FIleWriter����д���ַ��ļ��ı����
				BufferedWriter out = new BufferedWriter(new FileWriter(fname2
						+ file));
				// д��
				out.write(s);
				// �ر���
				out.close();

			} catch (Exception ioe) {
				ioe.printStackTrace();
			}

		}
	}

}

// ����ѡ����������ˣ��¼�����Ҳ�����ˣ�������Ҫʵ��ʲô���ܣ��Լ����żӰɣ�
