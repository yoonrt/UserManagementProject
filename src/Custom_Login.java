import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.*;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class Custom_Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField idText;
	private JPasswordField pwText;
	private JButton loginBtn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Custom_Login frame = new Custom_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Custom_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 484, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Member Management");
		lblNewLabel.setBounds(0, 0, 484, 267);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Mincho", Font.PLAIN, 34));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("KOSEA");
		lblNewLabel_1.setBounds(0, 267, 484, 33);
		lblNewLabel_1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 297, 484, 164);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		idText = new JTextField();
		idText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		idText.setBounds(157, 60, 174, 21);
		panel_1.add(idText);
		idText.setColumns(10);

		pwText = new JPasswordField();
		pwText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pwText.setColumns(10);
		pwText.setBounds(157, 91, 174, 21);
		panel_1.add(pwText);

		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(100, 63, 45, 15);
		panel_1.add(lblNewLabel_2);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		label.setBounds(100, 94, 57, 15);
		panel_1.add(label);

		loginBtn = new JButton("LOGIN");
		loginBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		loginBtn.setBounds(195, 131, 97, 23);
		panel_1.add(loginBtn);
		loginBtn.addActionListener(this);

		JLabel lblNewLabel_3 = new JLabel("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(178, 10, 127, 21);
		panel_1.add(lblNewLabel_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			login();
		}
	}

	private void login() {
		String id = idText.getText().trim();

		String pw = pwText.getText().trim();

		if (id.length() == 0 || pw.length() == 0) {
			JOptionPane.showMessageDialog(this, "¾ÆÀÌµð ¶Ç´Â ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			return;
		}
		if (id.equals("Manager01") && pw.equals("1234")) {
			JOptionPane.showMessageDialog(this, "·Î±×ÀÎ ¼º°ø");
			Member_List mList = new Member_List();
			dispose();
			return;
		} else {
			JOptionPane.showMessageDialog(this, "·Î±×ÀÎ ½ÇÆÐ");
		}
	}
}
