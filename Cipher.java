import javax.swing.*; // Buttons etc.
import java.awt.*; // for Layouts
import java.awt.event.*; // for ActionListener
import java.io.*; // for Files
import javax.swing.JOptionPane; // for ShowMessage
import java.util.Date;

class Cipher{
	public static void main(String arg[]){
		CipherGUI cipherGUI = new CipherGUI();
		cipherGUI.go();

		//Mixer mixer = new Mixer();
		//System.out.println(mixer.go("066144152134219156144143121065208157065193165148219145143", 3));

		DeMixer dEmixer = new DeMixer();
		//System.out.println(dEmixer.go("025189235130184194254141156154246054144076163115196162131", 3));

		/*CipherText cipherText = new CipherText();
		System.out.println(cipherText.go("!!hello I am Ruslan", "!o0"));

		DeCipherText deCipherText = new DeCipherText();
		System.out.println(deCipherText.go("066144152134219156144143121065208157065193165148219145143", "!o0"));
		*/
	}
}

class CipherGUI implements ActionListener {
		JFrame MSGframe;
		JFrame frame00;
		JPanel panel00;
		JPanel panel01;
		JPanel panel02;
		JPanel panel03;
		JLabel label00;
		JTextArea textArea00;
		JScrollPane scroller00;
		JLabel label01;
		JTextArea textArea01;
		JScrollPane scroller01;
		JLabel label02;
		JLabel label03;
		JLabel label04;
		JTextArea textArea02;
		JScrollPane scroller02;
		JButton button00;
		JButton button01;
		JButton button02;
		JButton button03;
		JButton button04;
		JTextField textField00;
		JTextField textField01;
	public void go() {
		MSGframe = new JFrame("Info message");
		frame00 = new JFrame("CIPHER");
		frame00.setSize(600,350);
		frame00.setResizable(false);
		frame00.setVisible(true);
		//frame00.setLocationRelativeTo(null);
		frame00.setLocation(500, 100);
		frame00.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel00 = new JPanel();
		frame00.getContentPane().add(BorderLayout.NORTH, panel00);
		panel00.setBackground(Color.GRAY);

		panel01 = new JPanel();
		frame00.getContentPane().add(BorderLayout.CENTER, panel01);
		panel01.setBackground(Color.GREEN);

		panel02 = new JPanel();
		frame00.getContentPane().add(BorderLayout.SOUTH, panel02);
		panel02.setBackground(Color.RED);

		panel03 = new JPanel();
		frame00.getContentPane().add(BorderLayout.EAST, panel03);
		panel03.setBackground(Color.YELLOW);

		panel00.setLayout(new BoxLayout(panel00, BoxLayout.Y_AXIS));

		label00 = new JLabel("SOURCE TEXT");
		panel00.add(label00);
		label00.setAlignmentX(Component.CENTER_ALIGNMENT);

		textArea00 = new JTextArea(5, 50);
		panel00.add(textArea00);
		textArea00.setBackground(Color.LIGHT_GRAY);
		textArea00.setLineWrap(true);

		scroller00 = new JScrollPane(textArea00);
		scroller00.getVerticalScrollBar().setBackground(Color.LIGHT_GRAY);
		scroller00.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel00.add(scroller00);
		
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.Y_AXIS));

		label01 = new JLabel("KEY");
		panel01.add(label01);
		label01.setAlignmentX(Component.CENTER_ALIGNMENT);

		textArea01 = new JTextArea(3, 50);
		panel01.add(textArea01);
		textArea01.setBackground(Color.WHITE);
		textArea01.setLineWrap(true);

		scroller01 = new JScrollPane(textArea01);
		scroller01.getVerticalScrollBar().setBackground(Color.WHITE);
		scroller01.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel01.add(scroller01);

		label02 = new JLabel("RESULT TEXT");
		panel01.add(label02);
		label02.setAlignmentX(Component.CENTER_ALIGNMENT);

		textArea02 = new JTextArea(5, 50);
		panel01.add(textArea02);
		textArea02.setBackground(Color.LIGHT_GRAY);
		textArea02.setLineWrap(true);

		scroller02 = new JScrollPane(textArea02);
		scroller02.getVerticalScrollBar().setBackground(Color.LIGHT_GRAY);
		scroller02.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel01.add(scroller02);

		button00= new JButton("CIPHER");
		panel02.add(button00);
		button00.addActionListener(this);

		button01= new JButton("DeCIPHER");
		panel02.add(button01);
		button01.addActionListener(this);

		button02= new JButton("CLEAR");
		panel02.add(button02);
		button02.addActionListener(this);

		button03= new JButton("CLEAR ALL");
		panel02.add(button03);
		button03.addActionListener(this);

		button04= new JButton("SAVE");
		panel02.add(button04);
		button04.addActionListener(this);

		panel03.setLayout(new BoxLayout(panel03, BoxLayout.Y_AXIS));

		panel03.add(Box.createRigidArea(new Dimension(0,10)));

		label03 = new JLabel("Block size:");
		panel03.add(label03);

		textField00 = new JTextField();
		panel03.add(textField00);
		textField00.setText("3");
		textField00.setBackground(Color.WHITE);

		label04 = new JLabel("Mix rounds:");
		panel03.add(label04);

		textField01 = new JTextField();
		panel03.add(textField01);
		textField01.setText("2");
		textField01.setBackground(Color.WHITE);

		panel03.add(Box.createRigidArea(new Dimension(0,100)));

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == button00) {
			//System.out.println("00");
			CipherText cipherText = new CipherText();
			Mixer mixer = new Mixer();
			textArea02.setText(cipherText.go(textArea00.getText(), textArea01.getText(), Integer.parseInt(textField00.getText()) ));
			textArea02.setText(mixer.go(textArea02.getText(), Integer.parseInt(textField01.getText())));
		}
		if (event.getSource() == button01) {
			//System.out.println("01");
			DeMixer dEmixer = new DeMixer();
			DeCipherText deCipherText = new DeCipherText();
			textArea02.setText(dEmixer.go(textArea00.getText(), Integer.parseInt(textField01.getText())));
			textArea02.setText(deCipherText.go(textArea02.getText(), textArea01.getText(), Integer.parseInt(textField00.getText()) ));
		}
		if (event.getSource() == button02) {
			//System.out.println("02");
			textArea00.setText(null);
			textArea02.setText(null);
		}
		if (event.getSource() == button03) {
			//System.out.println("03");
			textArea00.setText(null);
			textArea01.setText(null);
			textArea02.setText(null);
		}
		if (event.getSource() == button04) {
			try {
				Date now = new Date();
				File dir = new File("saved_files");
				dir.mkdir();
				
				String formate_now = now.toString();  
					formate_now = formate_now.replace(':', '-');
				FileWriter writer = new FileWriter(dir+"/"+formate_now+".txt",true);
				writer.write("SOURCE TEXT:\n");
				writer.write(textArea00.getText()+"\n\n");
				writer.write("KEY:\n");
				writer.write(textArea01.getText()+"\n\n");
				writer.write("RESULT TEXT:\n");
				writer.write(textArea02.getText()+"\n\n\n\n");
				writer.close();
				JOptionPane.showMessageDialog(MSGframe,"Text has been written.");
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}


class CipherText{
		private char text_ch;
		private char key_ch;
		private int ciph_int;
		private String ciph_symb = "";
		private String ciph_str = "";
		private int x, y = 0;

	String go(String text, String key, Integer block_size){
		for(x = 0; x < text.length(); x = x + 1) {
			text_ch = text.charAt(x);
			key_ch = key.charAt(y);
			ciph_int = text_ch + key_ch;

			if (y == key.length()-1) y = 0; 
				else y = y + 1;
		
			ciph_symb = String.valueOf(ciph_int);
			while(ciph_symb.length()%block_size != 0){
				ciph_symb ="0" + ciph_symb;
			}


			ciph_str = ciph_str + ciph_symb;
		
			//System.out.println("text_ch is:" + text_ch);
			//System.out.println("key_ch is:" + key_ch);	
			//System.out.println("ciph_symb is:" + ciph_symb);
		}
	return ciph_str;
	}
}

class DeCipherText{
		private char text_ch;
		private char key_ch;
		private int ciph_int;
		private String ciph_symb = "";
		private String text = "";
		private int x, y = 0;

	String go(String ciph_text, String key, Integer block_size){
		for(x = 0; x < ciph_text.length(); x = x + block_size) {
	
			ciph_symb = ciph_text.substring(x, x + block_size);
			ciph_int = Integer.parseInt(ciph_symb);
			key_ch = key.charAt(y);

			if (y == key.length()-1) y = 0; 
				else y = y + 1;

			text = text + Character.toString(ciph_int - key_ch);
		}
	return text;
	}
}

class Mixer {
	private String result;
	private int x;

	String go(String cipher_text, int rounds){
	while (rounds > 0) {
	result = "";
		for(x = 0; x < cipher_text.length(); x = x + 2) {
			result = result + cipher_text.charAt(x);
		}
		for(x = 1; x < cipher_text.length(); x = x + 2) {
			result = result + cipher_text.charAt(x);
		}
	cipher_text = result;
	rounds = rounds - 1;
	}
		
		//System.out.println(cipher_text);
		//System.out.println(result_1);
		//System.out.println(result_2);
		//System.out.println(result);

		return result;	
	}
}

class DeMixer {
	private String result;
	private int x, y;

	String go(String mixed_cipher_text, int rounds){
	while (rounds > 0) {
	result = "";
		if (mixed_cipher_text.length()%2 == 0) y = (mixed_cipher_text.length())/2;
			else y = (mixed_cipher_text.length()+1)/2;
		for(x = 0; x < y; x = x + 1) {
			result = result + mixed_cipher_text.charAt(x);
			if ((x+y) < mixed_cipher_text.length()) result = result + mixed_cipher_text.charAt(x + y);
		}
	mixed_cipher_text = result;
	rounds = rounds - 1;
	}
		
		//System.out.println(mixed_cipher_text.length());
		//System.out.println(y);
		//System.out.println(result_2);
		//System.out.println(result);

		return result;	
	}
}