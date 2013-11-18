package gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class ImageButton extends JComponent {

	private static final long serialVersionUID = -5813502587935300303L;
	private final Image defaultIcon;
	private final Image hoverIcon;
	private final Image clickIcon;
	private Image activeIcon;
	private final Dimension dimension;

	public ImageButton(Image icon) {
		this(icon, icon, icon);
	}

	public ImageButton(Image defaultIcon, Image hoverIcon, Image clickIcon) {
		super();
		this.defaultIcon = defaultIcon;
		this.hoverIcon = hoverIcon;
		this.clickIcon = clickIcon;
		this.activeIcon = defaultIcon;
		this.dimension = determineDimension(defaultIcon, hoverIcon, clickIcon);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new ImageButtonMouseAdapter());
	}

	@Override
	protected void paintComponent(Graphics g) {
		setSize(this.dimension);
		Graphics2D graphics = (Graphics2D) g.create();
		graphics.drawImage(this.activeIcon, 0, 0, null);
		graphics.dispose();
		super.paintComponent(g);
	}

	@Override
	public Dimension getSize() {
		return this.dimension;
	}

	private Dimension determineDimension(Image... images) {
		int width = 0;
		int height = 0;
		for (Image image : images) {
			if (height < image.getHeight(null)) {
				height = image.getHeight(null);
			}
			if (width < image.getWidth(null)) {
				width = image.getWidth(null);
			}
		}
		return new Dimension(width, height);
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
	}

	private final class ImageButtonMouseAdapter extends MouseAdapter {

		private boolean stillPressed;

		public ImageButtonMouseAdapter() {
			super();
			this.stillPressed = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (this.stillPressed) {
				return;
			}
			ImageButton.this.activeIcon = ImageButton.this.hoverIcon;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (this.stillPressed) {
				return;
			}
			ImageButton.this.activeIcon = ImageButton.this.defaultIcon;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			this.stillPressed = true;
			ImageButton.this.activeIcon = ImageButton.this.clickIcon;
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			this.stillPressed = false;
			ImageButton.this.activeIcon = ImageButton.this.hoverIcon;
			repaint();
		}
	}
}