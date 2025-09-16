package br.com.mariojp.figureeditor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import abstracts.CircleFactory;
import abstracts.RectangleFactory;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel(new CircleFactory());
            JMenuBar menuBar = new JMenuBar(); 
            JMenu menu = new JMenu("Desenhos"); //iniciando um menu
            
            JMenuItem circleItem = new JMenuItem("Círculo");
            circleItem.addActionListener(e -> panel.setShapeFactory(new CircleFactory()));

            JMenuItem rectItem = new JMenuItem("Retângulo");
            rectItem.addActionListener(e -> panel.setShapeFactory(new RectangleFactory())); 
           
            JMenuItem clearItem = new JMenuItem("Limpar Tudo");
            clearItem.addActionListener(e -> panel.clear());
            
            menu.add(circleItem);
            menu.add(rectItem);
            menu.addSeparator();
            menu.add(clearItem);
            menuBar.add(menu);
            frame.setJMenuBar(menuBar);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
