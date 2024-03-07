package GUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import sql.PTXTDataBase;
import java.awt.Toolkit;

public class rider extends JFrame {

	private JPanel contentPane;
	private final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rider frame = new rider();
					frame.setLocationRelativeTo(null);
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
	public rider() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(rider.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		setResizable(false);
		this.setLocationRelativeTo(null);
		setTitle("骑手界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 753, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\u529F\u80FD");
		mnNewMenu.setForeground(Color.BLUE);
		mnNewMenu.setFont(new Font("华文楷体", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);

		JMenuItem rider_menuItem = new JMenuItem("\u9A91\u624B\u63A5\u5355");
		rider_menuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		rider_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchOrder so = new SearchOrder();
				desktopPane.add(so);
				so.setVisible(true);

			}
		});
		mnNewMenu.add(rider_menuItem);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u6392\u884C\u699C");
		mntmNewMenuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rank r = new rank();
				desktopPane.add(r);
				r.setVisible(true);

			}
		});

		JMenu menu_1 = new JMenu("\u66F4\u591A");
		menu_1.setForeground(Color.BLUE);
		menu_1.setFont(new Font("华文楷体", Font.PLAIN, 25));
		menuBar.add(menu_1);
		

		JMenuItem person_menuItem = new JMenuItem("\u6211\u7684");
		person_menuItem.setFont(new Font("华文楷体", Font.PLAIN, 20));
		menu_1.add(person_menuItem);
		person_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				my m = new my();
				desktopPane.add(m);
				m.setVisible(true);
			}
		});

		
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		desktopPane.setBackground(SystemColor.activeCaptionBorder);
		desktopPane.setBounds(0, 0, 747, 671);
		contentPane.add(desktopPane);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel
				.setIcon(new ImageIcon(rider.class.getResource("/images/timg.jpg")));
		lblNewLabel.setBounds(0, 0, 747, 661);
		desktopPane.add(lblNewLabel);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

}
