import java.awt.Color;
// om standaard kleurcodes te importeren

import javax.swing.JFrame;
//dit is om de functies van deze package uit java te importeren

public class FirstGame {
	//hier begint de class van deze code

	public static void main(String[] args) {
		// dit is waar de hoofdtaken/main worden ingevoerd voor de applicatie
		JFrame obj = new JFrame();
		// voor de applicatie hebben we een scherm nodig, hier gebruiken we een functie uit JFrame om dit object te crearen, even genaamd obj hier
		
		Gameplay2 gameplay = new Gameplay2();
		// dit is een class die ik in een ander tabblad heb gemaakt en hier heb geprobeerd te koppelen aan main hier in de software Eclipse
		
		obj.setBounds(10, 10, 905, 700);
		// dit is om de omvang van het frame te bepalen
		obj.setBackground(Color.GRAY);
		// de achtergrond een kleur te geven
		obj.setResizable(false);
		// aan te geven of de gebruiker van de software de grote kan aanpassen van het frame. False om dat niet mogelijk te maken.
		obj.setVisible(true);
		// wel zo handig om het frame ook zichtbaar te maken aan de gebruiker
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mogelijkheid om het frame ook weer af te sluiten met een standaard sluitings optie
		
		obj.add(gameplay);
		//dit is weer die andere class waarin de code van het speelveld is verwerkt

	}
// einde van main waarin de taken zijn omschreven

}
//einde van de class                                                                                                                                                                                                                                                                                                                                                                                                                        