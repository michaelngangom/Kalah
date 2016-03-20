package com.kalaha.prod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameGUI extends JFrame {
	public GameGUI(final GameEngine kalaha) {

		game = kalaha;
		initComponents();
	}

	private void initComponents() {
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jButton17 = new javax.swing.JButton();
		jButton18 = new javax.swing.JButton();
		jButton19 = new javax.swing.JButton();
		jButton20 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		input = new JTextField();
		input2 = new JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		Container pane = getContentPane();
		// BoxLayout layout = new BoxLayout(pane,BoxLayout.LINE_AXIS);
		pane.setLayout(new BorderLayout());
		pane.setSize(950, 700);

		jButton1.setLocation(850, 50);
		jButton1.setSize(100, 50);
		jButton1.setForeground(Color.red);
		pane.add(jButton1);

		jButton2.setLocation(700, 50);
		jButton2.setSize(100, 50);
		jButton2.setForeground(Color.red);
		pane.add(jButton2);

		jButton3.setLocation(550, 50);
		jButton3.setSize(100, 50);
		jButton3.setForeground(Color.red);
		pane.add(jButton3);

		jButton4.setLocation(400, 50);
		jButton4.setSize(100, 50);
		jButton4.setForeground(Color.red);
		pane.add(jButton4);

		jButton5.setLocation(250, 50);
		jButton5.setSize(100, 50);
		jButton5.setForeground(Color.red);
		pane.add(jButton5);

		jButton6.setLocation(100, 50);
		jButton6.setSize(100, 50);
		jButton6.setForeground(Color.red);
		pane.add(jButton6);

		jButton7.setLocation(25, 120);
		jButton7.setSize(100, 50);

		pane.add(jButton7);

		jButton8.setLocation(100, 200);
		jButton8.setSize(100, 50);
		jButton8.setForeground(Color.blue);
		pane.add(jButton8);

		jButton9.setLocation(250, 200);
		jButton9.setSize(100, 50);
		jButton9.setForeground(Color.blue);
		pane.add(jButton9);

		jButton10.setLocation(400, 200);
		jButton10.setSize(100, 50);
		jButton10.setForeground(Color.blue);
		pane.add(jButton10);

		jButton11.setLocation(550, 200);
		jButton11.setSize(100, 50);
		jButton11.setForeground(Color.blue);
		pane.add(jButton11);

		jButton12.setLocation(700, 200);
		jButton12.setSize(100, 50);
		jButton12.setForeground(Color.blue);
		pane.add(jButton12);

		jButton13.setLocation(850, 200);
		jButton13.setSize(100, 50);
		jButton13.setForeground(Color.blue);
		pane.add(jButton13);

		jButton14.setLocation(925, 120);
		jButton14.setSize(100, 50);
		pane.add(jButton14);

		jButton15.setLocation(325, 300);
		jButton15.setSize(100, 50);
		pane.add(jButton15);

		jButton16.setLocation(450, 300);
		jButton16.setSize(100, 50);
		pane.add(jButton16);

		jButton17.setLocation(575, 300);
		jButton17.setSize(100, 50);
		pane.add(jButton17);

		jButton18.setLocation(325, 300);
		jButton18.setSize(100, 50);
		pane.add(jButton18);

		jButton19.setLocation(575, 300);
		jButton19.setSize(100, 50);
		pane.add(jButton19);

		jButton20.setLocation(650, 345);
		jButton20.setSize(100, 50);
		pane.add(jButton20);

		pane.add(new JScrollPane(jTextArea1), BorderLayout.SOUTH);

		input.setLocation(350, 350);
		input.setSize(300, 25);
		pane.add(input);

		input2.setLocation(350, 350);
		input2.setSize(300, 25);
		input2.setVisible(false);
		pane.add(input2);

		input.setVisible(false);
		jButton15.setVisible(false);
		jButton16.setVisible(false);
		jButton17.setVisible(false);
		jButton18.setVisible(false);
		jButton19.setVisible(false);
		jButton20.setVisible(false);

		closeChoiceDialog();
		setVisible(true);
		setTitle("The ultimate game of Kalaha!");
		this.setMinimumSize(new Dimension(1100, 610));

		jButton1.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("0");

			}
		});

		jButton2.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("1");

			}
		});

		jButton3.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("2");

			}
		});

		jButton4.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("3");

			}
		});

		jButton5.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("4");

			}
		});

		jButton6.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("5");

			}
		});

		jButton8.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("7");

			}
		});

		jButton9.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("8");

			}
		});

		jButton10.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("9");

			}
		});

		jButton11.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("10");

			}
		});

		jButton12.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("11");

			}
		});

		jButton13.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

				game.inputHoleChoice("12");

			}
		});

		jButton15.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {
				game.inputLevel("1");
			}
		});

		jButton16.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {
				game.inputLevel("2");
			}
		});

		jButton17.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {
				game.inputLevel("3");
			}
		});

		jButton18.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {
				game.inputStartFirstChoice("y");
			}
		});

		jButton19.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {
				game.inputStartFirstChoice("n");
			}
		});

		jButton20.addMouseListener(new ButtonClick() {
			public void mouseClicked(MouseEvent e) {

			}

		});

		pack();
	}

	private String getStonesFromBoard(int hole_number) {
		String stones = null;

		stones = "" + game.currentPosition.gameBoard[hole_number];

		return stones;
	}

	/**
	 * add text to the buttons. The text is the stones in the corresponding hole
	 * on the board.
	 */
	public void addTextToButtons() {

		jButton1.setText(getStonesFromBoard(0));

		jButton2.setText(getStonesFromBoard(1));

		jButton3.setText(getStonesFromBoard(2));

		jButton4.setText(getStonesFromBoard(3));

		jButton5.setText(getStonesFromBoard(4));

		jButton6.setText(getStonesFromBoard(5));
		jButton7.setText(getStonesFromBoard(6));
		jButton8.setText(getStonesFromBoard(7));
		jButton9.setText(getStonesFromBoard(8));
		jButton10.setText(getStonesFromBoard(9));
		jButton11.setText(getStonesFromBoard(10));
		jButton12.setText(getStonesFromBoard(11));
		jButton13.setText(getStonesFromBoard(12));
		jButton14.setText(getStonesFromBoard(13));
	}

	/**
	 * refreshes the text in the buttons. Used after every valid move to show
	 * the new Position of the board
	 */
	public void refresh() {
		addTextToButtons();
	}

	/**
	 * Shows the buttons for the difficulty choice
	 */
	public void openLevelDialog() {

		jButton15.setText("Easy");
		jButton16.setText("Medium");
		jButton17.setText("Hard");
		jButton15.setVisible(true);
		jButton16.setVisible(true);
		jButton17.setVisible(true);
	}

	/**
	 * Shows the buttons for the who-will-start first choice
	 */
	public void openChoiceDialog() {

		jButton18.setText("YES");
		jButton19.setText("NO");
		jButton18.setVisible(true);
		jButton19.setVisible(true);
	}

	//
	// public void openConnectDialog() {
	// input.setVisible(true);
	// jButton20.setText("Connect !!!");
	// jButton20.setVisible(true);
	// }

	/**
	 * closes the buttons that are used in the choices and the connection. hides
	 * the text field as well
	 */
	public void closeChoiceDialog() {
		jButton15.setVisible(false);
		jButton16.setVisible(false);
		jButton17.setVisible(false);
		jButton18.setVisible(false);
		jButton19.setVisible(false);
		// jButton20.setVisible(false);
		input.setVisible(false);
	}

	private JButton jButton1;
	private JButton jButton10;
	private JButton jButton11;
	private JButton jButton12;
	private JButton jButton13;
	private JButton jButton14;
	private JButton jButton15;
	private JButton jButton16;
	private JButton jButton17;
	private JButton jButton18;
	private JButton jButton19;
	private JButton jButton2;
	private JButton jButton20;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JButton jButton7;
	private JButton jButton8;
	private JButton jButton9;
	private JFrame jFrame1;
	private JScrollPane jScrollPane1;
	public JTextArea jTextArea1;
	private JTextField input, input2;
	GameEngine game;

	// class for mouse events

	class ButtonClick implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
}
