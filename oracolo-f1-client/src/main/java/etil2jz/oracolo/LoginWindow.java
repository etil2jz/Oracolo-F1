package etil2jz.oracolo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class LoginWindow {
	private static final Logger logger = LogManager.getLogger(LoginWindow.class);

	private static final JFrame frame = new JFrame();
	private static final JPanel panel = new JPanel(new GridBagLayout());
	private static final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

	private static final JLabel usernameLabel = new JLabel("Nom d'utilisateur :");
	private static final JTextField usernameField = new JTextField();
	private static final JLabel passwordLabel = new JLabel("Mot de passe :");
	private static final JPasswordField passwordField = new JPasswordField();
	private static final JButton connectButton = new JButton("Se connecter");
	private static final JButton registerButton = new JButton("S'inscrire");

	public static void showUI() {
		frame.setTitle("Oracolo F1 - Connexion");
		frame.setSize(400, 180);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(usernameLabel, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 1.0;
		panel.add(usernameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.weightx = 0;
		panel.add(passwordLabel, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 1.0;
		panel.add(passwordField, gbc);

		registerButton.addActionListener(e -> authenticate(true));
		connectButton.addActionListener(e -> authenticate(false));

		buttonPanel.add(registerButton);
		buttonPanel.add(connectButton);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		panel.add(buttonPanel, gbc);

		frame.setContentPane(panel);
		frame.setVisible(true);
		logger.debug("Affichage fenêtre LoginWindow");
	}

	private static void authenticate(boolean registerAction) {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());


		if (username.isBlank() || password.isBlank()) {
			JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs avant de continuer.", "Champs invalides", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (registerAction) {
			if (ApiClient.register(username, password)) {
				// Accéder à la fenêtre principale
			} else {
				JOptionPane.showMessageDialog(frame, "Le nom d'utilisateur existe déjà.", "Échec de l'inscription", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			if (ApiClient.login(username, password)) {
				// Accéder à la fenêtre principale
			} else {
				JOptionPane.showMessageDialog(frame, "Le nom d'utilisateur ou le mot de passe est incorrect.", "Échec de la connexion", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
