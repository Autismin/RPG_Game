package Paquete;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;

public class Ventana extends JFrame implements MouseListener {

	private static final int ANCHO = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int ALTO = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int ESCALA = 70;
	private static final int ANCHO_ESCALADO = ANCHO*ESCALA/100;
	private static final int ALTO_ESCALADO = ALTO*ESCALA/100;
	
	int monedas = 0;
	int mejora = 1;
	
	JPanel panel = new JPanel();
	JLabel etiqueta1 = new JLabel();
	JLabel etiqueta2 = new JLabel();
	JLabel etiqueta3 = new JLabel();
	
	public Ventana () {
		
		setSize(ANCHO_ESCALADO,ALTO_ESCALADO);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("RPG Game 1.0.1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Panel1();
	}

	private void Panel1 () {
		
		panel.setLayout(null);
		panel.setBackground(Color.black);
		this.getContentPane().add(panel);
		
		etiqueta1.setSize(ANCHO_ESCALADO/9,ALTO_ESCALADO/12);
		etiqueta1.setLocation(ANCHO_ESCALADO/2-ANCHO_ESCALADO/18,ALTO_ESCALADO-ALTO_ESCALADO/6);
		etiqueta1.setOpaque(true);
		etiqueta1.setBackground(Color.white);
		etiqueta1.setText("+1");
		etiqueta1.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		etiqueta1.setForeground(Color.black);
		etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta1.addMouseListener(this);
		panel.add(etiqueta1);
		
		etiqueta2.setSize(ANCHO_ESCALADO/12,ALTO_ESCALADO/16);
		etiqueta2.setLocation(ANCHO_ESCALADO*8/9,ALTO_ESCALADO/25);
		etiqueta2.setOpaque(true);
		etiqueta2.setBackground(Color.white);
		etiqueta2.setText(String.valueOf(monedas));
		etiqueta2.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		etiqueta2.setForeground(Color.black);
		etiqueta2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(etiqueta2);
		
		etiqueta3.setSize(ANCHO_ESCALADO/12,ALTO_ESCALADO/16);
		etiqueta3.setLocation(ANCHO_ESCALADO/40,ALTO_ESCALADO/25);
		etiqueta3.setOpaque(true);
		etiqueta3.setBackground(Color.white);
		etiqueta3.setText("+1/click");
		etiqueta3.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		etiqueta3.setForeground(Color.black);
		etiqueta3.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta3.addMouseListener(this);
		panel.add(etiqueta3);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	
	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
		panel.setBackground(Color.red);
		monedas = monedas + mejora;
		etiqueta2.setText(String.valueOf(monedas));
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		panel.setBackground(Color.black);
	}
}