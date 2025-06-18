package gui;

import edu.memphis.ccrg.lida.framework.gui.panels.GuiPanelImpl;
import javax.swing.*;
import java.awt.*;

import modules.Environment;

public class GUIAction extends GuiPanelImpl {

    private final JLabel actionLabel = new JLabel("Current Action: ", SwingConstants.RIGHT);
    private final JLabel currentAction = new JLabel("", SwingConstants.RIGHT);
    private Environment env = new Environment();

    public GUIAction() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 100));
        panel.add(actionLabel);
        panel.add(currentAction);
        add(panel, BorderLayout.CENTER);

        new Timer(100, e -> currentAction.setText(env.getCurrentAction())).start();
    }
}
