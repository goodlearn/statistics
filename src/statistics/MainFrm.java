package statistics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import statistics.frame.CbAddFrame;
import statistics.frame.FileDialogFrame;
import statistics.frame.MclAddFrame;
import statistics.frame.MzhjAddFrame;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	

	/**
	 * Create the application.
	 */
	public MainFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setMainFrmStyleInit();//��������ʽ
		setMenuStyleInit();//��ʼ���˵���ʽ
		setContantStyleInit();//���������ʽ
		
		//���ӻ�����
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//����Jrame���
		this.setVisible(true);
		
	}
	
	//��������ʽ
		private void setMainFrmStyleInit() {
			setTitle("����ͳ��������");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
		
		}
		
		
		//�˵�������
		private void setMenuStyleInit() {
			//�˵���
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			menu1Init(menuBar);//�˵���1
			menu2Init(menuBar);//�˵���2
			
			
		;
		}
		
		//�˵���1
		private void menu1Init(JMenuBar menuBar) {
			//�˵���
			JMenu menu = new JMenu("�������ά��");
			menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
			menuBar.add(menu);
			
			
			//������ݼ��
			JMenu sheetCheckMenu = new JMenu("������ݼ��");
			sheetCheckMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
			menu.add(sheetCheckMenu);
			
			JMenuItem menuItemDailyCheck = new JMenuItem("����ͳ���ձ����");
			menuItemDailyCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileDialogFrame fileDialogFrame = new FileDialogFrame();
					System.out.println(fileDialogFrame.openFile());
				}
			});
			menuItemDailyCheck.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			sheetCheckMenu.add(menuItemDailyCheck);
			
			JMenuItem menuItemOtherCheck = new JMenuItem("��������");
			menuItemOtherCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			menuItemOtherCheck.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
			sheetCheckMenu.add(menuItemOtherCheck);
			
			//������ݵ���
			JMenu mnNewMenu = new JMenu("������ݵ���");
			mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
			menu.add(mnNewMenu);
			
			JMenuItem menuItem = new JMenuItem("����ͳ���ձ�����");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuItem);
			
			JMenuItem menuItem_2 = new JMenuItem("��������");
			menuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
			mnNewMenu.add(menuItem_2);
			
			
			
			//��ȫ�˳�
			JMenuItem menuItem_exit = new JMenuItem("��ȫ�˳�");
			menuItem_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    int result =JOptionPane.showConfirmDialog(null,"�Ƿ��˳�ϵͳ");
				    
				}
			});
			menuItem_exit.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
			menu.add(menuItem_exit);
		}
		private void menu2Init(JMenuBar menuBar) {
			//���ݲ���
			JMenu menu = new JMenu("���ݲ���");
			menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
			menuBar.add(menu);
			
			JMenu mnNewMenu = new JMenu("�������");
			mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
			menu.add(mnNewMenu);
			
			JMenuItem menuItem = new JMenuItem("��������������");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CbAddFrame addFrame = new CbAddFrame();
					addFrame.setVisible(true);
					table.add(addFrame);
				}
			});
			menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuItem);
			
			JMenuItem menuMclItem = new JMenuItem("ú�����������");
			menuMclItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MclAddFrame addFrame = new MclAddFrame();
					addFrame.setVisible(true);
					table.add(addFrame);
				}
			});
			menuMclItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuMclItem);
			
			JMenuItem menuMzhjItem = new JMenuItem("ú�ʻ����������");
			menuMzhjItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MzhjAddFrame addFrame = new MzhjAddFrame();
					addFrame.setVisible(true);
					table.add(addFrame);
				}
			});
			menuMzhjItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuMzhjItem);
			
			JMenuItem menuItem_2 = new JMenuItem("�������");
			menuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
			mnNewMenu.add(menuItem_2);
		}
		
		//���������ʽ
		private void setContantStyleInit() {
			contentPane = new JPanel();
			contentPane.setForeground(Color.BLUE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			
	        table = new JDesktopPane();		
			table.setBackground(Color.WHITE);
			contentPane.add(table);
		}

}
