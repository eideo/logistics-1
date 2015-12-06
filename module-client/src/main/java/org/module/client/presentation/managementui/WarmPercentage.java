package org.module.client.presentation.managementui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.module.client.businesslogic.managementbl.WarehouseConfigController;
import org.module.client.businesslogicservice.managementBLservice.WarehouseConfigBLService;
import org.module.client.vo.WarehouseConfigVO;

public class WarmPercentage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField borderline;
	private JTextField size;

	private WarehouseConfigBLService controller = new WarehouseConfigController();
	private JButton save;
	private JTextField tranCenterID;
	private JComboBox qusPicker;

	private JLabel state;
	private JTextField currentBorderline;
	private String[] arrayOfQus;
	
	public WarmPercentage() {
		this.arrayOfQus = this.controller.getQus();
		init();
		addListeners();
		this.refresh();
	}	
	
	
	
	private void init(){
		
		
		JLabel label = new JLabel("中转中心");
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("警戒比例");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		borderline = new JTextField();
		borderline.setColumns(10);
		
		save = new JButton("保存");
		save.setFont(new Font("楷体", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("分区大小");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		size = new JTextField();
		size.setColumns(10);
		
		JLabel label_3 = new JLabel("选择分区");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		
		tranCenterID = new JTextField();
		
		tranCenterID.setEditable(false);
		tranCenterID.setColumns(10);
		
		qusPicker = new JComboBox(arrayOfQus);
		qusPicker.setEditable(true);
		
		state = new JLabel("state");
		state.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel current = new JLabel("当前比例");
		current.setFont(new Font("楷体", Font.PLAIN, 15));
		
		currentBorderline = new JTextField();
		currentBorderline.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(205)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(tranCenterID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(qusPicker, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(current, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(currentBorderline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(borderline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(193)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(state, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(tranCenterID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(qusPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(current, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentBorderline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(borderline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(save, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

		
	}
	
	
	public void addListeners(){
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.update(qusPicker.getSelectedItem().toString(), 
						size.getText(), 
						borderline.getText());
			}
		});
		
		
	}
	
	private  void refresh(){
		WarehouseConfigVO  warehoseConfigVO  = this.controller.find();
		if(warehoseConfigVO != null){
			this.tranCenterID.setText(warehoseConfigVO.getWarehouseOfWhichTranCenter());
			Object selectedItem = this.qusPicker.getSelectedItem();
			if(selectedItem == null){
				
			}else{
				 String qu = selectedItem.toString();
				 this.currentBorderline.setText(	this.controller.calculateCurrentBorderLine(	qu)	);
				 this.size.setText(this.controller.getQuSize(qu));
				 this.borderline.setText(this.controller.getBorderLine(qu));
			}
			
		}
		
		
	}
}
