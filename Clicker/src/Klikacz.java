import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Klikacz extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField outWynik;
	private JTextField outKredyty;
	private JTextField textKoszt;
	private JTextField textField;
	private JTextField textLvlClick;
	private JTextField textLvlTime;
	public Klikacz() {
		Score wynik = new Score();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Klikacz");
		getContentPane().setLayout(null);
		
		JButton btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wynik.dodajPunkt();
				outWynik.setText(""+wynik.podajWynik());
				outKredyty.setText(""+wynik.podajKredyty());
			}
		});
		btnClick.setBounds(10, 197, 414, 53);
		getContentPane().add(btnClick);
		
		outWynik = new JTextField();
		outWynik.setEditable(false);
		outWynik.setBounds(66, 14, 171, 20);
		getContentPane().add(outWynik);
		outWynik.setColumns(10);
		
		outKredyty = new JTextField();
		outKredyty.setEditable(false);
		outKredyty.setColumns(10);
		outKredyty.setBounds(66, 45, 171, 20);
		getContentPane().add(outKredyty);
		
		JLabel lblWynik = new JLabel("Wynik");
		lblWynik.setBounds(10, 14, 46, 14);
		getContentPane().add(lblWynik);
		
		JLabel lblKredyty = new JLabel("Kredyty");
		lblKredyty.setBounds(10, 45, 46, 14);
		getContentPane().add(lblKredyty);
		
		JButton btnUpgradeClick = new JButton("Upgrade");
		btnUpgradeClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wynik.ulepszenie();
				textKoszt.setText(""+wynik.podajKosztUlepszenia());
				outKredyty.setText(""+wynik.podajKredyty());
				textLvlClick.setText(""+(int)wynik.ulepszeniePoziom());
			}
		});
		btnUpgradeClick.setBounds(66, 76, 89, 23);
		getContentPane().add(btnUpgradeClick);
		
		textKoszt = new JTextField();
		textKoszt.setEditable(false);
		textKoszt.setBounds(161, 76, 76, 20);
		getContentPane().add(textKoszt);
		textKoszt.setColumns(10);
		textKoszt.setText(""+wynik.podajKosztUlepszenia());
		
		JButton btnUpgradeTime = new JButton("Upgrade");
		btnUpgradeTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wynik.ulepszeniePerSekunda();
				textKoszt.setText(""+wynik.podajKosztUlepszenia());
				outKredyty.setText(""+wynik.podajKredyty());
				textLvlTime.setText(""+(int)wynik.ulepszeniePoziomPerSekunda());
			}
		});
		btnUpgradeTime.setBounds(66, 110, 89, 23);
		getContentPane().add(btnUpgradeTime);
		
		textField = new JTextField();
		textField.setText("200.0");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(161, 111, 76, 20);
		getContentPane().add(textField);
		
		JLabel lbls = new JLabel("+1/s");
		lbls.setBounds(10, 111, 46, 14);
		getContentPane().add(lbls);
		
		JLabel lblclick = new JLabel("+1/Click");
		lblclick.setBounds(10, 77, 46, 14);
		getContentPane().add(lblclick);
		
		textLvlClick = new JTextField();
		textLvlClick.setEditable(false);
		textLvlClick.setBounds(66, 144, 171, 20);
		getContentPane().add(textLvlClick);
		textLvlClick.setColumns(10);
		
		textLvlTime = new JTextField();
		textLvlTime.setEditable(false);
		textLvlTime.setColumns(10);
		textLvlTime.setBounds(66, 169, 171, 20);
		getContentPane().add(textLvlTime);
		
		JLabel lblLvlClick = new JLabel("Lvl. Click");
		lblLvlClick.setBounds(10, 144, 57, 14);
		getContentPane().add(lblLvlClick);
		
		JLabel lblLvls = new JLabel("Lvl. /s");
		lblLvls.setBounds(10, 169, 46, 14);
		getContentPane().add(lblLvls);
		
		//Generowanie Timer() na samym koñcu, po wygenerowaniu reszty obiektów
		Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
            	wynik.dodajPunktPerSekunda();
            	outWynik.setText(""+wynik.podajWynik());
				outKredyty.setText(""+wynik.podajKredyty());
            }
        }, 0, 1000);

	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Klikacz gierka = new Klikacz();
		gierka.setSize(450, 350);
		gierka.setVisible(true);
	}
}
