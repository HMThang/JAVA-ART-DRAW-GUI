package pack2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyPanel extends JPanel {
	public static final int NO_SHAPE = 0;
	public static final int RECTANGLE = 1;
	public static final int OVAL = 0;
	JPanel topPanel, leftPanel, centerPanel;
	JButton redButton, blueButton, clearButton;
	JRadioButton rectbutton, ovalbutton, fillbutton, outLineButton;
	private ArrayList<Point> points = new ArrayList<Point>();
	Color color;
	int shape;
	boolean isFill, started;

	MyPanel() {
		setLayout(new BorderLayout());
		color = Color.gray;
		shape = RECTANGLE;
		topPanel = new TopPanel();
		leftPanel = new LeftPanel();
		centerPanel = new CenterPanel();
		add(topPanel, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST);
		add(centerPanel);

	}

	class TopPanel extends JPanel {
		TopPanel() {
			redButton = new JButton("RED");
			redButton.setBackground(Color.red);
			redButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					color = Color.red;

				}
			});
			add(redButton);
			blueButton = new JButton("BLUE");
			blueButton.setBackground(Color.blue);
			blueButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					color = Color.blue;

				}
			});
			add(blueButton);
			rectbutton = new JRadioButton("RECTANGLE");
			rectbutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					shape = RECTANGLE;

				}
			});
			add(rectbutton);
			ovalbutton = new JRadioButton("OVAL");
			ovalbutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					shape = OVAL;

				}
			});
			add(ovalbutton);
			ButtonGroup group1 = new ButtonGroup();
			group1.add(rectbutton);
			group1.add(ovalbutton);
			fillbutton = new JRadioButton("fill");
			fillbutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					isFill = true;

				}
			});
			add(fillbutton);
			outLineButton = new JRadioButton("Out Line");
			outLineButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					isFill = false;

				}
			});
			add(outLineButton);
			ButtonGroup group2 = new ButtonGroup();
			group2.add(fillbutton);
			group2.add(outLineButton);
			setBackground(color.pink);
		}
	}

	class LeftPanel extends JPanel {
		LeftPanel() {
			clearButton = new JButton("Clear");
			clearButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					points = new ArrayList<Point>();
					centerPanel.repaint();

				}
			});
			add(clearButton);
			setBackground(color.pink);
		}
	}

	class CenterPanel extends JPanel {
		CenterPanel() {
			setBackground(color.yellow);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == MouseEvent.BUTTON1) {
						started = true;
						System.out.println("1");
					} else if (e.getButton() == MouseEvent.BUTTON3) {
						started = false;
					}
				}
			});
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					if (started) {
						points.add(new Point(e.getX(), e.getY(), isFill, color, shape));
						repaint();
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Point p : points) {
				g.setColor(p.color);
				switch (p.shape) {
				case RECTANGLE: {
					if (p.isFill) {
						g.fillRect(p.x, p.y, 20, 20);
					} else {
						g.drawRect(p.x, p.y, 20, 20);
					}
					break;
				}
				case OVAL: {
					if (p.isFill) {
						g.fillOval(p.x, p.y, 20, 20);
					} else {
						g.drawOval(p.x, p.y, 20, 20);
					}
					break;
				}
				}
			}
		}
	}

}
