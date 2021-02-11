import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Abdulajevs_pica{
	static DecimalFormat df = new DecimalFormat("#.##");
	static Scanner dati = new Scanner(System.in);
	
	public static void majas() throws Exception{
		String uzvards, talrunis, adrese;
		double attalums=0, piegadesmaksa=0, izmeracena=0, tipacena=0;
		
		JOptionPane.showMessageDialog(null, "Jūs izvēlaties piegādi uz māju.");
		uzvards = (JOptionPane.showInputDialog("Ievadiet savu uzvārdu: "));
		adrese = (JOptionPane.showInputDialog("Ievadiet savu adresi: "));
		
		do{
			talrunis = (JOptionPane.showInputDialog("Ievadiet savu tālruni: "));
		}while(talrunis.length()>8 || talrunis.length()<8);	
		
		UIManager.put("OptionPane.yesButtonText", "Attālums > 4 km");
		UIManager.put("OptionPane.noButtonText", "Attālums < 4 km");
        int variants = JOptionPane.showConfirmDialog(null, "Kāda attāluma atrodas Jūsu māja no mūsu picērijas?", "Piegāde", JOptionPane.YES_NO_OPTION);
        
        	if(variants == JOptionPane.YES_OPTION){
        		piegadesmaksa = 2.50;
        	}if(variants == JOptionPane.NO_OPTION){
        		piegadesmaksa = 1.50;
        	}
        
        int picastips = JOptionPane.showOptionDialog(new JFrame(), "Kāda izmēra picu Jūs vēlaties piegādāties?", "Picas izmērs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Ananāsu", "Peperoni", "Sēņu", "Veģetārā"}, JOptionPane.YES_OPTION);

        	if(picastips==JOptionPane.YES_OPTION){
        		tipacena=5.50;
        	}else if(picastips==JOptionPane.NO_OPTION){
        		tipacena=5.00;
        	}else if(picastips==JOptionPane.OK_OPTION){
        		tipacena=4.50;
        	}else if(picastips==JOptionPane.CANCEL_OPTION){
        		tipacena=4.00;
        	}
        
        int izmers = JOptionPane.showOptionDialog(new JFrame(), "Kāda izmēra picu Jūs vēlaties piegādāties?", "Picas izmērs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"25cm", "30cm", "50cm"}, JOptionPane.YES_OPTION);
        	
        	if(izmers==JOptionPane.YES_OPTION){
        		izmeracena = tipacena * 0.2;
        	}else if(izmers==JOptionPane.NO_OPTION){
        		izmeracena = tipacena * 0.4;
        	}else if(izmers==JOptionPane.OK_OPTION){
        		izmeracena = tipacena * 0.6;
        	}   
        
			try{
			
				FileWriter fw = new FileWriter("Pasutijums.txt", true);
				PrintWriter raksta = new PrintWriter(fw);
				
				raksta.println("Info par klientu: ");
				raksta.println("Klienta vārds: "+uzvards);
				raksta.println("Klienta adrese: "+adrese);
				raksta.println("Attālums no picērijas: "+attalums);
				raksta.println("Klienta tālrunis: "+talrunis);
				raksta.println("Jūsu piegādes maksa būs: "+df.format(piegadesmaksa)+" euro");
				raksta.println("Jūsu picas izmērs: "+izmers);
				raksta.println("Cēna par izmēru: ");
			
				JOptionPane.showMessageDialog(null, "Jūsu pasūtījums tiek saņemts!");
				raksta.close();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Kļūme ierakstot failā", "Kļūme!", JOptionPane.ERROR_MESSAGE);	
		}
	}	
	
	public static void uzvietas(){
		String uzvards, talrunis, adrese;
		
		JOptionPane.showMessageDialog(null, "Jūs izvēlaties piegādi uzvietas.");
		uzvards = (JOptionPane.showInputDialog("Ievadiet savu uzvārdu: "));
		do{
			talrunis = (JOptionPane.showInputDialog("Ievadiet savu tālruni: "));
		}while(talrunis.length()>8 || talrunis.length()<8);	
	}
	
	public static void izvadit(){
		
	}
	
	public static void main(String[] args) throws Exception{
		String izvele;
		
		{
			izvele = JOptionPane.showInputDialog("1 - Veikt pasūtījumu | 2 - Apskatīt Jūsu pasūtījumu |  x - Apturēt programmu");
			izvele = izvele.toLowerCase();
			switch(izvele){
			
			case "1":
				UIManager.put("OptionPane.yesButtonText", "Piegāde mājās");
				UIManager.put("OptionPane.noButtonText", "Piegāde uzvietas");
                int variants = JOptionPane.showConfirmDialog(null, "Kā velaties sāņēmt savu pasūtījumu?", "Piegāde", JOptionPane.YES_NO_OPTION);
                if(variants == JOptionPane.YES_OPTION){
                	majas();
                }if(variants == JOptionPane.NO_OPTION){
                	uzvietas();
                }
			break;
			
			case "2":
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
