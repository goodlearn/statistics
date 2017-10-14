package statistics.frame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import statistics.utils.CasUtils;

public class MzhjAddFrame extends JInternalFrame {


	/**
	 * Create the frame.
	 */
	public MzhjAddFrame() {
		init();
	}
	
	private JTextField idTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;


	/**
	 * Create the frame.
	 */
	public void init() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u65E5\u62A5\u6570\u636E");
		setBounds(100, 100, 766, 487);
		
		JPanel panel_1 = new JPanel();//表单操作
		panel_1.setBorder(new TitledBorder(null, "添加", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("3#");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5185\u8499\u53E4\u5927\u5510\u56FD\u9645\u514B\u4EC0\u514B\u817E\u7164\u5236\u5929\u7136\u6C14\u6709\u9650\u8D23\u4EFB\u516C\u53F8");
		
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		button_1.setIcon(new ImageIcon(MclAddFrame.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u6E05\u7A7A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		button_2.setIcon(new ImageIcon(MclAddFrame.class.getResource("/images/delete.png")));
		
		JLabel label = new JLabel("5#");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("4#");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_7 = new JLabel("\u65E5\u671F\uFF1A");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel label_5 = new JLabel("1#");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_8 = new JLabel("2#");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5580\u5587\u6C81\u65D7\u6DA6\u751F\u7164\u70AD\u7269\u6D41\u6709\u9650\u516C\u53F8");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5927\u5510\u5185\u8499\u53E4\u591A\u4F26\u7164\u5316\u5DE5\u6709\u9650\u516C\u53F8");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5185\u8499\u53E4\u6052\u901A\u94C1\u8DEF\u4E13\u7EBF\u8FD0\u7EF4\u6709\u9650\u516C\u53F8");
		
		JLabel label_9 = new JLabel("\u5185\u8499\u53E4\u534E\u5B81\u70ED\u7535\u6709\u9650\u8D23\u4EFB\u516C\u53F8");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(6)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(8)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addGap(40)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
									.addGap(70)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
									.addGap(70)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(button_1)
											.addGap(18)
											.addComponent(button_2)))
									.addGap(70)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(261, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_7)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5))))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label)))))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(3)
								.addComponent(label_8))
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_4)
							.addGap(29)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_9)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);
				
		this.fillBookType("search");
		this.fillBookType("modify");
		//this.fillTable(new Book());
	}
	


	/**
	 * 图书修改事件处理
	 * @param evt
	 */	
	private void bookUpdateActionPerformed(ActionEvent evt) {
		String id=this.idTxt.getText();
		if(CasUtils.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的内容");
			return;
		}
		
		String bookName=null;
		String author=null;
		String price=this.priceTxt.getText();
		String bookDesc=null;
		
		if(CasUtils.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		
		if(CasUtils.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者名称不能为空");
			return;
		}
		
		if(CasUtils.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书价格名称不能为空");
			return;
		}
		
		String sex="";
		
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.priceTxt.setText("");
	}

	/**
	 * 初始化下拉框
	 * @param type 下拉框类型
	 */
	private void fillBookType(String type){
	}
	
	/**
	 * 初始化表格
	 * @param book
	 */
	private void fillTable(){
	}
}