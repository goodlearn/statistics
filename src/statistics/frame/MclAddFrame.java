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

public class MclAddFrame extends JInternalFrame {


	/**
	 * Create the frame.
	 */
	public MclAddFrame() {
		init();
	}

	private JTextArea bookDescTxt;
	
	private JTextField idTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


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
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
					.addGap(20))
		);
		
		JLabel lblNewLabel = new JLabel("\u4F4E\u8D286#\u7164\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5907\u6CE8\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("3#\u50A8\u7164\u4ED3\uFF1A");
		
		bookDescTxt = new JTextArea();
		
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
		
		JLabel label = new JLabel("2#\u50A8\u7164\u4ED3\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("8#\u50A8\u7164\u4ED3\uFF1A");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("1#\u50A8\u7164\u4ED3\uFF1A");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("7#\u50A8\u7164\u4ED3\uFF1A");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_7 = new JLabel("\u65E5\u671F\uFF1A");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel label_5 = new JLabel("4#\u7164\uFF1A");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_8 = new JLabel("\u4F4E\u8D286#\u7164\uFF1A");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addComponent(button_1)
					.addGap(18)
					.addComponent(button_2)
					.addGap(453))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(label_6))
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(idTxt)
						.addComponent(priceTxt, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addGap(72))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_7)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_8)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addComponent(label_3))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(27)
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(16))
		);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);

		//设置文本域边框
	    bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
				
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
		String bookDesc=this.bookDescTxt.getText();
		
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
		this.bookDescTxt.setText("");
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

