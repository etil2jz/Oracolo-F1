package etil2jz.oracolo;

import com.formdev.flatlaf.FlatDarkLaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		logger.info("Démarrage de Oracolo F1 - Client");
		FlatDarkLaf.setup();
		SwingUtilities.invokeLater(LoginWindow::showUI);
	}
}
