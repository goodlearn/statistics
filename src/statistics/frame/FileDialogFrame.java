package statistics.frame;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

import javax.swing.JFrame;

import statistics.utils.StatisticsConstants;

public class FileDialogFrame extends JFrame{  

	 private FileDialog openDialog;// ���塰�򿪡��Ի���

	 
	 public FileDialogFrame() {
	 }
	 
	 public String openFile() {
		 openDialog = new FileDialog(this,StatisticsConstants.FileMenuOpenName, FileDialog.LOAD);
		 String filePath = null;//�ļ�·��
     	 String dirpath = null;//�ļ�Ŀ¼
     	 String fileName = null;//�ļ���
     	
         openDialog.setVisible(true);//�Ի���ɼ�
         
         dirpath = openDialog.getDirectory();//�ļ�Ŀ¼
         fileName = openDialog.getFile();//�ļ���
         
         if (dirpath == null || fileName == null)//�����ж�
             return null;
         File file = new File(dirpath, fileName);//�����ļ�
         filePath = file.getAbsolutePath();//�ļ�·��
         return filePath;
         
	 }
}
