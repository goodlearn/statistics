package statistics;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import statistics.excel.ReadExcel;
import statistics.utils.StatisticsConstants;

public class MainFrame {
	
	
	private Frame frame; // 定义窗体
    private MenuBar menuBar;// 定义菜单栏
    private TextArea textArea;
    private Menu menu;// 定义"文件"和"子菜单"菜单
    private MenuItem openItem, saveItem, closeItem;// 定义条目“退出”和“子条目”菜单项
    private FileDialog openDialog, saveDialog;// 定义“打开、保存”对话框
    private File file;//定义“打开、保存”对话框
    
    public MainFrame() {
    	init();
    }
    
    /* 图形用户界面组件初始化 */
    public void init() {
    	frame = new Frame(StatisticsConstants.MainFrameName);// 创建窗体对象
    	frame.setBounds(300, 100, 650, 600);// 设置窗体位置和大小

    	menuBar = new MenuBar();//  创建菜单栏
    	textArea = new TextArea();// 创建文本域

    	menu = new Menu(StatisticsConstants.FileMenuName);// 创建“文件”菜单

        openItem = new MenuItem(StatisticsConstants.FileMenuOpenName);// 创建“打开"菜单项
        saveItem = new MenuItem(StatisticsConstants.FileMenuSaveName);// 创建“保存"菜单项
        closeItem = new MenuItem(StatisticsConstants.FileMenuCloseName);// 创建“退出"菜单项

        menu.add(openItem);// 将“打开”菜单项添加到“文件”菜单上
        menu.add(saveItem);// 将“保存”菜单项添加到“文件”菜单上
        menu.add(closeItem);// 将“退出”菜单项添加到“文件”菜单上

        menuBar.add(menu);// 灏嗘枃浠舵坊鍔犲埌鑿滃崟鏍忎笂

        frame.setMenuBar(menuBar);// 灏嗘绐椾綋鐨勮彍鍗曟爮璁剧疆涓烘寚瀹氱殑鑿滃崟鏍忋��

        openDialog = new FileDialog(frame, StatisticsConstants.FileMenuOpenName, FileDialog.LOAD);
        saveDialog = new FileDialog(frame, StatisticsConstants.FileMenuSaveName, FileDialog.SAVE);

        frame.add(textArea);// 灏嗘枃鏈煙娣诲姞鍒扮獥浣撳唴
        mainEvent();// 鍔犺浇浜嬩欢澶勭悊

        frame.setVisible(true);// 璁剧疆绐椾綋鍙
    }

    //浜嬩欢鐩戝惉
    private void mainEvent() {
    	
    	//事件监听
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	String filePath = null;//文件路径
            	String dirpath = null;//文件目录
            	String fileName = null;//文件名
            	String showError = null;//错误信息
            	
                openDialog.setVisible(true);//对话框可见
                
                dirpath = openDialog.getDirectory();//文件目录
                fileName = openDialog.getFile();//文件名
                
                if (dirpath == null || fileName == null)//参数判断
                    return;
                else
                	textArea.setText(null);//重置显示
                file = new File(dirpath, fileName);//生成文件
                filePath = file.getAbsolutePath();//文件路径
                
                try {
                	ReadExcel readExcel = new ReadExcel();
                	showError = readExcel.readExcel(filePath);//是否有错误信息
                	if(null!=showError) {
                		textArea.append(showError + "\r\n");
                		return;
                	}
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        // 淇濆瓨鑿滃崟椤圭洃鍚�
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    saveDialog.setVisible(true);//鏄剧ず淇濆瓨鏂囦欢瀵硅瘽妗�
                    String dirpath = saveDialog.getDirectory();//鑾峰彇淇濆瓨鏂囦欢璺緞骞朵繚瀛樺埌瀛楃涓蹭腑銆�
                    String fileName = saveDialog.getFile();////鑾峰彇鎵撲繚瀛樻枃浠跺悕绉板苟淇濆瓨鍒板瓧绗︿覆涓�
                    
                    if (dirpath == null || fileName == null)//鍒ゆ柇璺緞鍜屾枃浠舵槸鍚︿负绌�
                        return;//绌烘搷浣�
                    else
                        file=new File(dirpath,fileName);//鏂囦欢涓嶄负绌猴紝鏂板缓涓�涓矾寰勫拰鍚嶇О
                }
                    try {
                        BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
                        
                        String text = textArea.getText();//鑾峰彇鏂囨湰鍐呭
                        bufw.write(text);//灏嗚幏鍙栨枃鏈唴瀹瑰啓鍏ュ埌瀛楃杈撳嚭娴�
                        
                        bufw.close();//鍏抽棴鏂囦欢
                    } catch (IOException e1) {
                        //鎶涘嚭IO寮傚父
                        e1.printStackTrace();
                    }
            }
        });
        
        // 閫�鍑鸿彍鍗曢」鐩戝惉
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // 绐椾綋鍏抽棴鐩戝惉
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }
}
