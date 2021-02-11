import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Abdulajevs_pica{
	static Scanner dati = new Scanner(System.in);
	
	public static void majas(){
		String uzvards, talrunis, adrese;
		
		JOptionPane.showMessageDialog(null, "Jūs izvēlaties piegādi uz māju.");
		uzvards = (JOptionPane.showInputDialog("Ievadiet savu uzvārdu: "));
		adrese = (JOptionPane.showInputDialog("Ievadiet savu adresi: "));
		do{
			talrunis = (JOptionPane.showInputDialog("Ievadiet savu tālruni: "));
		}while(talrunis.length()>8 || talrunis.length()<8);	
	}
	
	public static void uzvietas(){
		String uzvards, talrunis, adrese;
		
		JOptionPane.showMessageDialog(null, "Jūs izvēlaties piegādi uzvietas.");
		uzvards = (JOptionPane.showInputDialog("Ievadiet savu uzvārdu: "));
		do{
			talrunis = (JOptionPane.showInputDialog("Ievadiet savu tālruni: "));
		}while(talrunis.length()>8 || talrunis.length()<8);	
	}
	
	public static void pasutijums(){
		
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
				UIManager.put("OptionPane.yesButtonText", "Piegāde mājās");
				UIManager.put("OptionPane.noButtonText", "Piegāde uzvietas");
                int variants = JOptionPane.showConfirmDialog(null, "Kā velaties sāņēmt savu pasūtījumu?", "Piegāde", JOptionPane.YES_NO_OPTION);
                if (variants == JOptionPane.YES_OPTION){
                	majas();
                }if (variants == JOptionPane.NO_OPTION){
                	uzvietas();
                }
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
