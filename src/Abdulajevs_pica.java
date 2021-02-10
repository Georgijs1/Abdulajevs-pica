import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Abdulajevs_pica{
	static Scanner dati = new Scanner(System.in);
	
	public static void majas(){
		
	}
	
	public static void uzvietas(){
		
	}
	
	public static void saglabat(){
		
	}
	
	public static void izvadit(){
		
	}
	
	public static void main(String[] args){
		String izvele;
		{
			izvele = JOptionPane.showInputDialog("1 - Veikt pasūtījumu | 2 - Saglabāt Jūsu pasūtījumu | 3 - Apskatīt Jūsu pasūtījumu |  x - Apturēt programmu");
			izvele = izvele.toLowerCase();
			switch(izvele){
			
			case "1":
				
			break;
			
			case "2":
				saglabat();
			break;
			
			case "3":
				izvadit();
			break;
			
			case "x":
				JOptionPane.showMessageDialog(null, "Programma tiek apturēta!", "Brīdinājums!", JOptionPane.WARNING_MESSAGE);
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Darbība nepastāv!", "Kļūda!", JOptionPane.ERROR_MESSAGE);
			break;
			}
			
		}while(!izvele.equals("x"));
		dati.close();
	}
}
