package ISIS.Code.Panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JLabel;
import javax.swing.event.EventListenerList;

import ISIS.Code.Class.DiamondGrid;
import ISIS.Code.Class.MainClass;
import ISIS.Code.Class.PanelAvatarChooser;
import ISIS.Code.Frame.MainFrame;

/**
 * 
 * @author ISIS
 */
public class PanelBienvenido extends javax.swing.JPanel {

	/**
	 * Creates new form PanelBienvenido
	 */
	public PanelBienvenido() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonSeven2 = new org.edisoncor.gui.button.ButtonSeven();
		buttonSeven3 = new org.edisoncor.gui.button.ButtonSeven();
		jLabel1 = new javax.swing.JLabel();
		labelNombre = new JLabel();

		setPreferredSize(new java.awt.Dimension(800, 600));
		setLayout(null);

		buttonSeven2.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven2.setText("Tutorial");
		add(buttonSeven2);
		buttonSeven2.setBounds(330, 480, 116, 35);
		buttonSeven2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				fireActionEvent(new ActionEvent(this, 0, "Tutorial"));

			}
		});

		buttonSeven3.setBackground(new java.awt.Color(0, 0, 255));
		buttonSeven3.setText("A jugar!");
		add(buttonSeven3);
		buttonSeven3.setBounds(610, 480, 116, 35);
		buttonSeven3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				fireActionEvent(new ActionEvent(this, 0, "NextPanel"));
				MainFrame.transicion.addPanel(diamond);
				MainFrame.transicion.derecha();

			}
		});
		labelNombre.setText(MainFrame.mayorSelectionPanel.getNombreAlcalde());
		// labelNombre.setText("Selecciona un Mapa");
		labelNombre.setFont(new java.awt.Font("Arial", 1, 34)); // NOI18N
		labelNombre.setForeground(new java.awt.Color(255, 255, 255));

		add(labelNombre);

		labelNombre.setBounds(290, 120, 150, 29);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/ISIS/Resource/Backgrounds/BackWelcome.png"))); // NOI18N
		add(jLabel1);
		jLabel1.setBounds(0, -20, 800, 600);
	}// </editor-fold>//GEN-END:initComponents

	public void addActionListener(ActionListener listener) {
		eventListenerList.add(ActionListener.class, listener);
	}

	public void removeActionListener(ActionListener listener) {
		eventListenerList.remove(ActionListener.class, listener);
	}

	public ActionListener[] getActionListeners() {
		return eventListenerList.getListeners(ActionListener.class);
	}

	private void fireActionEvent(ActionEvent evt) {
		ActionListener[] actionListeners = getActionListeners();

		for (ActionListener actionListener : actionListeners) {
			actionListener.actionPerformed(evt);
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables

	private org.edisoncor.gui.button.ButtonSeven buttonSeven2;
	private org.edisoncor.gui.button.ButtonSeven buttonSeven3;
	private javax.swing.JLabel jLabel1;
	private JLabel labelNombre;
	private EventListenerList eventListenerList = new EventListenerList();
	private GamePanel game = new GamePanel();
	private DiamondGrid diamond = new DiamondGrid();
	// End of variables declaration//GEN-END:variables
}
