import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class WebLoader extends JDialog {

    private final JPanel contentPanel = new JPanel();
    
    private JEditorPane editorPane;
    private JScrollPane scrollPane;
    private String ruta =  "http://www.iesmiguelherrero.com/";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	try {
	    WebLoader dialog = new WebLoader();
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setVisible(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Create the dialog.
     */
    public WebLoader() {
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
	gl_contentPanel.setHorizontalGroup(
		gl_contentPanel.createParallelGroup(Alignment.LEADING)
			.addGap(0, 432, Short.MAX_VALUE)
	);
	gl_contentPanel.setVerticalGroup(
		gl_contentPanel.createParallelGroup(Alignment.LEADING)
			.addGap(0, 223, Short.MAX_VALUE)
	);
	contentPanel.setLayout(gl_contentPanel);
	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	    }
	    {
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	}
	editorPane = new JEditorPane();
	editorPane.setEditable(false);
	try {
	    editorPane.setPage(new URL(ruta));
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	scrollPane = new JScrollPane();
	this.getContentPane().add(editorPane);
	
    }

}
