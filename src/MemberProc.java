import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class MemberProc extends JFrame implements ActionListener {

	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail;
	JPasswordField pfPwd;
	JTextField tfYear, tfMonth, tfDate, tfTel1, tfTel2, tfTel3;
	JComboBox cbYear, cbMonth, cbDate;
	JRadioButton rbMan, rbWoman;
	JButton btnInsert, btnUpdate, btnDelete;

	Member_List mList;

	String birth;

	public MemberProc() {
		createUI();
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
	}

	public MemberProc(Member_List mList) {
		createUI();
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;
	}

	public MemberProc(String id, Member_List mList) {
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;

		System.out.println("id=" + id);

		MemberDAO dao = new MemberDAO();
		MemberDTO vMem = dao.getMemberDTO(id);
		viewData(vMem);
	}

	private void viewData(MemberDTO vMem) {

		String id = vMem.getId();
		String pwd = vMem.getPwd();
		String name = vMem.getName();
		String tel = vMem.getTel();
		String addr = vMem.getAddr();
		String birth = vMem.getBirth();
		String gender = vMem.getGender();
		String email = vMem.getEmail();

		tfId.setText(id);
		tfId.setEditable(false);
		pfPwd.setText("");
		tfName.setText(name);
		String[] tels = tel.split("-");
		tfTel1.setText(tels[0]);
		tfTel2.setText(tels[1]);
		tfTel3.setText(tels[2]);
		tfAddr.setText(addr);
		cbYear.setSelectedItem(birth);
		cbMonth.setSelectedItem(birth);
		cbDate.setSelectedItem(birth);
		if (gender.equals("³²")) {
			rbMan.setSelected(true);
		} else if (gender.equals("¿©")) {
			rbWoman.setSelected(true);
		}
		tfEmail.setText(email);
	}

	private void createUI() {
		this.setTitle("È¸¿øÁ¤º¸");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);

		tfId = new JTextField();
		tfId.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfId.setBounds(81, 7, 191, 21);
		contentPane.add(tfId);
		tfId.setColumns(10);

		pfPwd = new JPasswordField();
		pfPwd.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pfPwd.setColumns(10);
		pfPwd.setBounds(81, 38, 191, 21);
		contentPane.add(pfPwd);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label.setBounds(12, 41, 57, 15);
		contentPane.add(label);

		tfName = new JTextField();
		tfName.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfName.setColumns(10);
		tfName.setBounds(81, 69, 191, 21);
		contentPane.add(tfName);
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_1.setBounds(12, 72, 57, 15);
		contentPane.add(label_1);

		tfTel1 = new JTextField();
		tfTel1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfTel1.setColumns(10);
		tfTel1.setBounds(81, 100, 50, 21);
		contentPane.add(tfTel1);

		tfTel2 = new JTextField();
		tfTel2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfTel2.setColumns(10);
		tfTel2.setBounds(222, 100, 50, 21);
		contentPane.add(tfTel2);

		tfTel3 = new JTextField();
		tfTel3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfTel3.setColumns(10);
		tfTel3.setBounds(152, 100, 50, 21);
		contentPane.add(tfTel3);

		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_2.setBounds(12, 103, 57, 15);
		contentPane.add(label_2);

		tfAddr = new JTextField();
		tfAddr.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfAddr.setColumns(10);
		tfAddr.setBounds(81, 131, 191, 21);
		contentPane.add(tfAddr);

		JLabel label_3 = new JLabel("\uC8FC\uC18C");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_3.setBounds(12, 134, 57, 15);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\uC0DD\uC77C");
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_4.setBounds(12, 168, 57, 15);
		contentPane.add(label_4);

		JLabel lblNewLabel_1 = new JLabel("\uC77C");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(261, 168, 12, 15);
		contentPane.add(lblNewLabel_1);

		JLabel label_5 = new JLabel("\uC6D4");
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_5.setBounds(203, 168, 12, 15);
		contentPane.add(label_5);

		cbDate = new JComboBox<Integer>();
		cbDate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbDate.setBounds(217, 164, 43, 23);
		contentPane.add(cbDate);
		for (int i = 1; i <= 31; i++) {
			cbDate.addItem(i);
			Integer.toString(i);
		}

		cbMonth = new JComboBox<Integer>();
		cbMonth.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbMonth.setBounds(159, 164, 43, 23);
		contentPane.add(cbMonth);
		for (int i = 1; i <= 12; i++) {
			cbMonth.addItem(i);
			Integer.toString(i);
		}

		JLabel label_6 = new JLabel("\uB144");
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_6.setBounds(145, 168, 12, 15);
		contentPane.add(label_6);

		cbYear = new JComboBox<Integer>();
		cbYear.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbYear.setBounds(80, 164, 64, 23);
		contentPane.add(cbYear);
		for (int i = 2020; i >= 1950; i--) {
			cbYear.addItem(i);
			Integer.toString(i);
		}

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfEmail.setColumns(10);
		tfEmail.setBounds(80, 197, 191, 21);
		contentPane.add(tfEmail);

		JLabel label_7 = new JLabel("\uC131\uBCC4");
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_7.setBounds(12, 232, 57, 15);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("\uC774\uBA54\uC77C");
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label_8.setBounds(12, 200, 57, 15);
		contentPane.add(label_8);

		ButtonGroup group = new ButtonGroup();

		rbMan = new JRadioButton("\uB0A8");
		rbMan.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rbMan.setBounds(81, 230, 43, 23);
		group.add(rbMan);
		contentPane.add(rbMan);

		rbWoman = new JRadioButton("\uC5EC");
		rbWoman.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		rbWoman.setBounds(129, 230, 43, 23);
		group.add(rbWoman);
		contentPane.add(rbWoman);

		JPanel panel = new JPanel();
		panel.setBounds(0, 299, 284, 62);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnUpdate = new JButton("\uC218\uC815");
		panel.add(btnUpdate);
		btnUpdate.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));

		btnInsert = new JButton("\uAC00\uC785");
		panel.add(btnInsert);
		btnInsert.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));

		btnDelete = new JButton("\uC0AD\uC81C");
		btnDelete.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		panel.add(btnDelete);

		JLabel telLabel1 = new JLabel("-");
		telLabel1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		telLabel1.setBounds(139, 101, 5, 15);
		contentPane.add(telLabel1);

		JLabel telLabel2 = new JLabel("-");
		telLabel2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		telLabel2.setBounds(209, 101, 5, 15);
		contentPane.add(telLabel2);

		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);

		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {

		new MemberProc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert) {
			insertMember();
		} else if (e.getSource() == btnUpdate) {
			UpdateMember();
		} else if (e.getSource() == btnDelete) {
			int x = JOptionPane.showConfirmDialog(this, "Á¤¸» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?", "»èÁ¦", JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION) {
				deleteMember();
			} else {
				JOptionPane.showMessageDialog(this, "»èÁ¦¸¦ Ãë¼ÒÇÏ¿´½À´Ï´Ù.");
			}
		}
		mList.jTableRefresh();
	}

	private void deleteMember() {
		String id = tfId.getText();
		String pwd = pfPwd.getText();
		if (pwd.length() == 0) {

			JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä");
			return;
		}
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.deleteMember(id, pwd);

		if (ok) {
			JOptionPane.showMessageDialog(this, "»èÁ¦¿Ï·á");
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "»èÁ¦½ÇÆÐ");

		}

	}

	private void UpdateMember() {

		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.updateMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "¼öÁ¤µÇ¾ú½À´Ï´Ù.");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "¼öÁ¤½ÇÆÐ: °ªÀ» È®ÀÎÇÏ¼¼¿ä");
		}
	}

	private void insertMember() {

		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.insertMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "°ø¶õÀÌ ÀÖ½À´Ï´Ù.", "¿À·ù", JOptionPane.ERROR_MESSAGE);
		}
	}

	public MemberDTO getViewData() {

		MemberDTO dto = new MemberDTO();
		String id = tfId.getText();
		String pwd = pfPwd.getText();
		String name = tfName.getText();
		String tel1 = tfTel1.getText();
		String tel2 = tfTel2.getText();
		String tel3 = tfTel3.getText();
		String tel = tel1 + "-" + tel2 + "-" + tel3;
		String addr = tfAddr.getText();
		String birth1 = cbYear.getSelectedItem().toString();
		String birth2 = cbMonth.getSelectedItem().toString();
		String birth3 = cbDate.getSelectedItem().toString();
		String birth = birth1 + birth2 + birth3;
		String gender = "";
		if (rbMan.isSelected()) {
			gender = "³²";
		} else if (rbWoman.isSelected()) {
			gender = "¿©";
		}
		String email = tfEmail.getText();

		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setTel(tel);
		dto.setAddr(addr);
		dto.setBirth(birth);
		dto.setGender(gender);
		dto.setEmail(email);

		return dto;
	}
}