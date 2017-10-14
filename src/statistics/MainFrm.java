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

		setMainFrmStyleInit();//主窗体样式
		setMenuStyleInit();//初始化菜单样式
		setContantStyleInit();//内容面板样式
		
		//可视化界面
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//设置Jrame最大化
		this.setVisible(true);
		
	}
	
	//主窗体样式
		private void setMainFrmStyleInit() {
			setTitle("数据统计主界面");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
		
		}
		
		
		//菜单栏设置
		private void setMenuStyleInit() {
			//菜单栏
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			menu1Init(menuBar);//菜单项1
			menu2Init(menuBar);//菜单项2
			
			
		;
		}
		
		//菜单项1
		private void menu1Init(JMenuBar menuBar) {
			//菜单项
			JMenu menu = new JMenu("表格数据维护");
			menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
			menuBar.add(menu);
			
			
			//表格数据检查
			JMenu sheetCheckMenu = new JMenu("表格数据检查");
			sheetCheckMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
			menu.add(sheetCheckMenu);
			
			JMenuItem menuItemDailyCheck = new JMenuItem("生产统计日报检查");
			menuItemDailyCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileDialogFrame fileDialogFrame = new FileDialogFrame();
					System.out.println(fileDialogFrame.openFile());
				}
			});
			menuItemDailyCheck.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			sheetCheckMenu.add(menuItemDailyCheck);
			
			JMenuItem menuItemOtherCheck = new JMenuItem("其它导入");
			menuItemOtherCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			menuItemOtherCheck.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
			sheetCheckMenu.add(menuItemOtherCheck);
			
			//表格数据导入
			JMenu mnNewMenu = new JMenu("表格数据导入");
			mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
			menu.add(mnNewMenu);
			
			JMenuItem menuItem = new JMenuItem("生产统计日报导入");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuItem);
			
			JMenuItem menuItem_2 = new JMenuItem("其它导入");
			menuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
			mnNewMenu.add(menuItem_2);
			
			
			
			//安全退出
			JMenuItem menuItem_exit = new JMenuItem("安全退出");
			menuItem_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    int result =JOptionPane.showConfirmDialog(null,"是否退出系统");
				    
				}
			});
			menuItem_exit.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
			menu.add(menuItem_exit);
		}
		private void menu2Init(JMenuBar menuBar) {
			//数据操作
			JMenu menu = new JMenu("数据操作");
			menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
			menuBar.add(menu);
			
			JMenu mnNewMenu = new JMenu("添加数据");
			mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
			menu.add(mnNewMenu);
			
			JMenuItem menuItem = new JMenuItem("生产类别数据添加");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CbAddFrame addFrame = new CbAddFrame();
					addFrame.setVisible(true);
					table.add(addFrame);
				}
			});
			menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuItem);
			
			JMenuItem menuMclItem = new JMenuItem("煤储量数据添加");
			menuMclItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MclAddFrame addFrame = new MclAddFrame();
					addFrame.setVisible(true);
					table.add(addFrame);
				}
			});
			menuMclItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuMclItem);
			
			JMenuItem menuMzhjItem = new JMenuItem("煤质化验数据添加");
			menuMzhjItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MzhjAddFrame addFrame = new MzhjAddFrame();
					addFrame.setVisible(true);
					table.add(addFrame);
				}
			});
			menuMzhjItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
			mnNewMenu.add(menuMzhjItem);
			
			JMenuItem menuItem_2 = new JMenuItem("其它添加");
			menuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
			mnNewMenu.add(menuItem_2);
		}
		
		//内容面板样式
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
