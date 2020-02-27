package Paquete;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.SwingConstants;

public class Ventana extends JFrame implements MouseListener {

	private static final int ANCHO = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int ALTO = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final int ESCALA = 70;
	private static final int ANCHO_ESCALADO = ANCHO*ESCALA/100;
	private static final int ALTO_ESCALADO = ALTO*ESCALA/100;
	
	int monedas = 0;
	int mejora = 1;
	int costeMejora = 25;
	
	JPanel panel = new JPanel();
	JLabel sumarPuntos = new JLabel();
	JLabel dinero = new JLabel();
	JLabel mejoraDinero = new JLabel();
	JLabel costeUpgrade = new JLabel();
	
	public Ventana () {
		
		setSize(ANCHO_ESCALADO,ALTO_ESCALADO);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("RPG Game 1.0.2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Panel1();
	}

	private void Panel1 () {
		
		panel.setLayout(null);
		panel.setBackground(Color.black);
		this.getContentPane().add(panel);
		
		sumarPuntos.setSize(ANCHO_ESCALADO/9,ALTO_ESCALADO/12);
		sumarPuntos.setLocation(ANCHO_ESCALADO/2-ANCHO_ESCALADO/18,ALTO_ESCALADO-ALTO_ESCALADO/6);
		sumarPuntos.setOpaque(true);
		sumarPuntos.setBackground(Color.white);
		sumarPuntos.setText("+"+mejora);
		sumarPuntos.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		sumarPuntos.setForeground(Color.black);
		sumarPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		sumarPuntos.addMouseListener(this);
		panel.add(sumarPuntos);
		
		dinero.setSize(ANCHO_ESCALADO/12,ALTO_ESCALADO/16);
		dinero.setLocation(ANCHO_ESCALADO*8/9,ALTO_ESCALADO/25);
		dinero.setOpaque(true);
		dinero.setBackground(Color.white);
		dinero.setText(String.valueOf(monedas));
		dinero.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		dinero.setForeground(Color.black);
		dinero.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(dinero);
		
		mejoraDinero.setSize(ANCHO_ESCALADO/12,ALTO_ESCALADO/16);
		mejoraDinero.setLocation(ANCHO_ESCALADO/40,ALTO_ESCALADO/25);
		mejoraDinero.setOpaque(true);
		mejoraDinero.setBackground(Color.white);
		mejoraDinero.setText("+1/click");
		mejoraDinero.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		mejoraDinero.setForeground(Color.black);
		mejoraDinero.setHorizontalAlignment(SwingConstants.CENTER);
		mejoraDinero.addMouseListener(this);
		panel.add(mejoraDinero);
		
		costeUpgrade.setSize(ANCHO_ESCALADO/12,ALTO_ESCALADO/16);
		costeUpgrade.setLocation(ANCHO_ESCALADO/40,ALTO_ESCALADO/9);
		costeUpgrade.setOpaque(true);
		costeUpgrade.setBackground(Color.white);
		costeUpgrade.setText(String.valueOf(costeMejora));
		costeUpgrade.setFont(new Font("unispace",0,ANCHO_ESCALADO/80));
		costeUpgrade.setForeground(Color.black);
		costeUpgrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(costeUpgrade);
		
	}
	
	public void actDinero(int mod) {
		
		monedas = monedas + mod;
		dinero.setText(String.valueOf(monedas));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getComponent().equals(sumarPuntos)) {
			
			panel.setBackground(Color.red);
	        actDinero(mejora);
		}
	
		if (e.getComponent().equals(mejoraDinero) && monedas>=costeMejora) {
			
			actDinero(-costeMejora);
			mejora++;
			sumarPuntos.setText("+"+mejora);
			Random r = new Random();
			costeMejora = costeMejora+r.nextInt(costeMejora);
			costeUpgrade.setText(String.valueOf(costeMejora));
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		panel.setBackground(Color.black);
	}
}