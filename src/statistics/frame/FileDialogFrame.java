package statistics.frame;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

import javax.swing.JFrame;

import statistics.utils.StatisticsConstants;

public class FileDialogFrame extends JFrame{  

	 private FileDialog openDialog;// 定义“打开”对话框

	 
	 public FileDialogFrame() {
	 }
	 
	 public String openFile() {
		 openDialog = new FileDialog(this,StatisticsConstants.FileMenuOpenName, FileDialog.LOAD);
		 String filePath = null;//文件路径
     	 String dirpath = null;//文件目录
     	 String fileName = null;//文件名
     	
         openDialog.setVisible(true);//对话框可见
         
         dirpath = openDialog.getDirectory();//文件目录
         fileName = openDialog.getFile();//文件名
         
         if (dirpath == null || fileName == null)//参数判断
             return null;
         File file = new File(dirpath, fileName);//生成文件
         filePath = file.getAbsolutePath();//文件路径
         return filePath;
         
	 }
}
