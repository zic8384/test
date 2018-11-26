package Friend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JSplitPane splitPane_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnInsert;
	private JButton btnView;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JPanel panel_1;
	private JComboBox comSel;
	private JTextField tfSearch;
	private JButton btnSearch;
	FriendDBA dba = new FriendDBA();
	private JScrollPane scrollPane;
	private JTextArea taView;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(280);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_3());
			panel.add(getBtnInsert());
			panel.add(getBtnView());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
		}
		return panel;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setDividerLocation(370);
		}
		return splitPane_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC774\uB984");
			lblNewLabel.setBounds(34, 44, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC0DD\uC77C");
			lblNewLabel_1.setBounds(33, 73, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638");
			lblNewLabel_2.setBounds(33, 101, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC8FC\uC18C");
			lblNewLabel_3.setBounds(33, 130, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("추가");
			btnInsert.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
				FriendBean f = new FriendBean();
				f.setName(tfName.getText());
				f.setBirth(tfBirth.getText());
				f.setPhone(tfPhone.getText());
				f.setAddr(tfAddr.getText());
				dba.friendInsert(f);					
				}
			});
			btnInsert.setBounds(159, 190, 97, 23);
		}
		return btnInsert;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("전체보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<FriendBean> arr = dba.friendView();
					for(FriendBean f:arr) {						
						taView.append("이름 :"+f.getName()+"\n");
						taView.append("생일 :"+f.getBirth()+"\n");
						taView.append("전화번호 :"+f.getPhone()+"\n");
						taView.append("주소 :"+f.getAddr()+"\n\n");
					}
				}
			});
			btnView.setBounds(33, 190, 97, 23);
		}
		return btnView;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(107, 41, 116, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(107, 70, 116, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(107, 98, 116, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setBounds(107, 127, 116, 21);
			tfAddr.setColumns(10);
		}
		return tfAddr;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getComSel());
			panel_1.add(getTfSearch());
			panel_1.add(getBtnSearch());
		}
		return panel_1;
	}
	private JComboBox getComSel() {
		if (comSel == null) {
			comSel = new JComboBox();
			comSel.setModel(new DefaultComboBoxModel(new String[] {"선택하세요.", "이름", "주소"}));
			comSel.setBounds(9, 16, 90, 21);
		}
		return comSel;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(108, 16, 97, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {				
				
				public void actionPerformed(ActionEvent e) {
					taView.setText("");
					String str="";
					if(comSel.getSelectedIndex()==1) {
						str="name";						
					}else if(comSel.getSelectedIndex()==2) {
						str="addr";
					}else {
						tfSearch.setText("선택오류");
						return;
					}
					ArrayList<FriendBean> arr = dba.friendSearch(str, tfSearch.getText());
					for(FriendBean f:arr) {
						taView.append("번호 :"+f.getNum()+"\n");
						taView.append("이름 :"+f.getName()+"\n");
						taView.append("생일 :"+f.getBirth()+"\n");
						taView.append("전화번호 :"+f.getPhone()+"\n");
						taView.append("주소 :"+f.getAddr()+"\n\n");
					}
				}
			});
			btnSearch.setBounds(214, 15, 60, 23);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTaView());
		}
		return scrollPane;
	}
	private JTextArea getTaView() {
		if (taView == null) {
			taView = new JTextArea();
			taView.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		}
		return taView;
	}
}
