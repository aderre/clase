import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class JotaTablesMain extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    JotaTablesMain frame = new JotaTablesMain();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public JotaTablesMain() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	Object[][] datos = {
		{"Juan", new Integer(25), new Boolean(false)},
		{"Sonia", new Integer(33), new Boolean(true) },
		{"Pedro", new Integer(42), new Boolean(false)},
		};
		String[] columnNames = {"Nombre","Años","Apto",};
		 DefaultTableModel dtm= new DefaultTableModel(datos,columnNames);
		final JTable table = new JTable(dtm);
		// Agregar nueva columna
		String[] columnaNueva1= {"vago","diestro","normal",};
		dtm.addColumn("Tipo",columnaNueva1);
		// Agregar nueva fila
		Object[] newRow={"Maria",new Integer(55),new Boolean(false)};
		dtm.addRow(newRow);
		// Modificar celda especifica
		dtm.setValueAt("XXX", 3, 3); // Row/Col
		table.setPreferredScrollableViewportSize(new Dimension(250, 100));
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){System.exit(0);}
		});
		 
    }

}
