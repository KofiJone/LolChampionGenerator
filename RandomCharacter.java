import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RandomCharacter {
	List<String> champions;
	String champion;

	public List<String> getList() {
		return this.champions;
	}

	public void setChampion(String a) {
		this.champion = a; 
	}
	
	public void randomize() {
		Random random = new Random();
		this.champion = champions.get( (random.nextInt(138) + 1));
	}

	public void forgeList() {
		List<String> list = new LinkedList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader("champs.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.champions = list;
	}

	public void printList() {
		int i = 0;
		String element = champions.get(i);
		while (element != null) {
			System.out.println(element);
			System.out.print(" + ");
			i += 1;
			if (i >= 138) {
				break;
			}
			element = champions.get(i);
		}
	}
	
	
	public static void main(String[] args) {
		RandomCharacter a = new RandomCharacter();
		a.forgeList();
		//a.printList();

		// Creating the frame
		JFrame frame = new JFrame("Random Character League of Legends");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 1));
		frame.setSize(200, 200);

		// button
		JButton button = new JButton("Go Random");
		button.setSize(50, 100);
		button.addActionListener(e -> {
		JFrame newFrame = new JFrame("Your Champion is:");
		newFrame.setSize(100, 100);
		JLabel newLabel = new JLabel();
		a.randomize();
		newLabel.setText(a.champion);
		
		newFrame.add(BorderLayout.WEST, newLabel);
		newFrame.setVisible(true);
		});

		// Creating panels and
		JPanel panel = new JPanel();
		JPanel panelBottom = new JPanel();
		JPanel filler = new JPanel();

		JLabel label = new JLabel("Your Random Character: ");
		JLabel champName = new JLabel();
		
		filler.setBackground(Color.cyan);
		panel.setBackground(Color.cyan);
		panelBottom.setLayout(new GridLayout(2, 1));

		panel.add(label);
		panel.add(champName);
		panelBottom.add((filler));
		panelBottom.add(button);

		// adding to the frame
		frame.add(panel);
		frame.add(panelBottom);

		// alles visible
		frame.setVisible(true);

	}
}
