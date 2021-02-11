import java.io.BufferedReader;
import java.io.FileReader;
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
		String uzvards, talrunis, adrese, teksts;
		double piegadesmaksa=0, izmeracena=0, tipacena=0, mercescena=0, summa;
		
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
        
        int picastips = JOptionPane.showOptionDialog(new JFrame(), "Kāda izmēra picu Jūs vēlaties piegādāties?", "Picas izmērs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        		null, new Object[] {"Ananāsu", "Peperoni", "Sēņu"}, JOptionPane.YES_OPTION);

        	if(picastips==JOptionPane.YES_OPTION){
        		tipacena=tipacena + 5.50;
        	}else if(picastips==JOptionPane.NO_OPTION){
        		tipacena=tipacena + 5.00;
        	}else if(picastips==JOptionPane.CANCEL_OPTION){
        		tipacena=tipacena + 4.00;
        	}
        
        int izmers = JOptionPane.showOptionDialog(new JFrame(), "Kāda izmēra picu Jūs vēlaties piegādāties?", "Picas izmērs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        		null, new Object[] {"30cm", "50cm"}, JOptionPane.YES_OPTION);
        	
        	if(izmers==JOptionPane.YES_OPTION){
        		izmeracena = tipacena * 0.4 + izmeracena;
        	}else if(izmers==JOptionPane.NO_OPTION){
        		izmeracena = tipacena * 0.6 + izmeracena;
        	}
        	
        	int merce = JOptionPane.showOptionDialog(new JFrame(), "Vai velaties piegādāties papildus mērci?", "Papildus mērce", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
            		null, new Object[] {"Ketčups", "Majonēze"}, JOptionPane.YES_OPTION);
        	
        	if(izmers==JOptionPane.YES_OPTION){
        		mercescena = mercescena + 0.60;
        	}else if(izmers==JOptionPane.NO_OPTION){
        		mercescena = mercescena + 0.80;
        	}
        	
        	summa=tipacena+izmeracena+mercescena+piegadesmaksa;
        			
			try{
			
				FileWriter fw = new FileWriter("Pasutijums.txt", true);
				PrintWriter raksta = new PrintWriter(fw);
				
				raksta.println("");
				raksta.println("Info par klientu: ");
				raksta.println("Klienta uzvārds: "+uzvards);
				raksta.println("Klienta adrese: "+adrese);
				raksta.println("Klienta tālrunis: "+talrunis);
				raksta.println("");
				raksta.println("Jūsu rēķins: ");
				raksta.println("Jūsu picas cena: "+tipacena);
				raksta.println("Сena par Jūsu izvēlēto picas izmēru izmēru: "+izmeracena);
				raksta.println("Jūsu mērces cena: "+mercescena);
				raksta.println("Jūsu piegādes maksa būs: "+df.format(piegadesmaksa)+" euro");
				raksta.println("Cena kopā: "+df.format(summa)+" eiro");	
			
				JOptionPane.showMessageDialog(null, "Jūsu pasūtījums tiek saņemts veiksmīgi!", "Paldies par pasūtījumu!", JOptionPane.WARNING_MESSAGE);
				raksta.close();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Kļūme ierakstot failā", "Kļūme!", JOptionPane.ERROR_MESSAGE);	
		}
			
			UIManager.put("OptionPane.yesButtonText", "Jā");
			UIManager.put("OptionPane.noButtonText", "Nē");
	        int apskatit = JOptionPane.showConfirmDialog(null, "Vai velaties apskatīties Jūsu pasūtījumu?", "Pasūtījums", JOptionPane.YES_NO_OPTION);  
	        
	        	if(apskatit== JOptionPane.YES_OPTION){
	        		try{
	    				
	    				FileReader fr = new FileReader("Pasutijums.txt");
	    				BufferedReader lasa = new BufferedReader(fr);
	    				
	    				while((teksts=lasa.readLine())!=null){
	    					System.out.println(teksts);
	    				}
	    				lasa.close();
	    				
	    			}catch(Exception e){
	    				JOptionPane.showMessageDialog(null, "Kļūme nolasot failu!", "Kļūme!", JOptionPane.ERROR_MESSAGE);
	    			}
	        		JOptionPane.showMessageDialog(null, "Paldies par Jūsu pasūtījumu!");
	        		UIManager.put("OptionPane.yesButtonText", "Labi");
	    			UIManager.put("OptionPane.noButtonText", "Slikti");
	        		int novertet = JOptionPane.showConfirmDialog(null, "Kā Jūs novērtēsiet mūsu apkalpošanu?", "Vērtēšana", JOptionPane.YES_NO_OPTION);  
	        		if(novertet==JOptionPane.YES_OPTION){
	        			JOptionPane.showMessageDialog(null, "Paldies par atsauksmi!");
	        		}if(novertet==JOptionPane.NO_OPTION){
	        			JOptionPane.showInputDialog("Kas tieši Jums nepatika?");	        	
	        			JOptionPane.showMessageDialog(null, "Labi, mēģināsim šo problemu risināt!");
	        		}
	        	
	        	}if(apskatit == JOptionPane.NO_OPTION){
	        		JOptionPane.showMessageDialog(null, "Paldies par Jūsu pasūtījumu!");
	        		UIManager.put("OptionPane.yesButtonText", "Labi");
	    			UIManager.put("OptionPane.noButtonText", "Slikti");
	        		int novertet = JOptionPane.showConfirmDialog(null, "Kā Jūs novērtēsiet mūsu apkalpošanu?", "Vērtēšana", JOptionPane.YES_NO_OPTION);  
	        		if(novertet==JOptionPane.YES_OPTION){
	        			JOptionPane.showMessageDialog(null, "Paldies par atsauksmi!");
	        		}if(novertet==JOptionPane.NO_OPTION){
	        			JOptionPane.showInputDialog("Kas tieši Jums nepatika?");	 
	        			JOptionPane.showMessageDialog(null, "Labi, mēģināsim šo problemu risināt!");
	        		}
	        	}  
	}
	
	public static void uzvietas() throws Exception{
		String uzvards, talrunis, teksts;
		double izmeracena=0, tipacena=0, mercescena=0, summa;
		
		JOptionPane.showMessageDialog(null, "Jūs izvēlaties piegādi uz vietas, picerījā.");
		uzvards = (JOptionPane.showInputDialog("Ievadiet savu uzvārdu: "));
		
		do{
			talrunis = (JOptionPane.showInputDialog("Ievadiet savu tālruni: "));
		}while(talrunis.length()>8 || talrunis.length()<8);	
        
		int picastips = JOptionPane.showOptionDialog(new JFrame(), "Kāda izmēra picu Jūs vēlaties piegādāties?", "Picas izmērs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        		null, new Object[] {"Ananāsu", "Peperoni", "Sēņu"}, JOptionPane.YES_OPTION);

        	if(picastips==JOptionPane.YES_OPTION){
        		tipacena=tipacena + 5.50;
        	}else if(picastips==JOptionPane.NO_OPTION){
        		tipacena=tipacena + 5.00;
        	}else if(picastips==JOptionPane.CANCEL_OPTION){
        		tipacena=tipacena + 4.00;
        	}
        
        int izmers = JOptionPane.showOptionDialog(new JFrame(), "Kāda izmēra picu Jūs vēlaties piegādāties?", "Picas izmērs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        		null, new Object[] {"30cm", "50cm"}, JOptionPane.YES_OPTION);
        	
        	if(izmers==JOptionPane.YES_OPTION){
        		izmeracena = tipacena * 0.4 + izmeracena;
        	}else if(izmers==JOptionPane.NO_OPTION){
        		izmeracena = tipacena * 0.6 + izmeracena;
        	}
        	
        	int merce = JOptionPane.showOptionDialog(new JFrame(), "Vai velaties piegādāties papildus mērci?", "Papildus mērce", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
            		null, new Object[] {"Ketčups", "Majonēze"}, JOptionPane.YES_OPTION);
        	
        	if(izmers==JOptionPane.YES_OPTION){
        		mercescena = mercescena + 0.60;
        	}else if(izmers==JOptionPane.NO_OPTION){
        		mercescena = mercescena + 0.80;
        	}
        	
        	summa=tipacena+izmeracena+mercescena;
        			
			try{
			
				FileWriter fw = new FileWriter("Pasutijums.txt", true);
				PrintWriter raksta = new PrintWriter(fw);
				
				raksta.println("");
				raksta.println("Info par klientu: ");
				raksta.println("Klienta uzvārds: "+uzvards);
				raksta.println("Klienta tālrunis: "+talrunis);
				raksta.println("");
				raksta.println("Jūsu rēķins: ");
				raksta.println("Jūsu picas cena: "+tipacena);
				raksta.println("Сena par Jūsu izvēlēto picas izmēru izmēru: "+izmeracena);
				raksta.println("Jūsu mērces cena: "+mercescena);
				raksta.println("Cena kopā: "+summa+" eiro");	
			
				JOptionPane.showMessageDialog(null, "Jūsu pasūtījums tiek saņemts veiksmīgi!", "Paldies par pasūtījumu!", JOptionPane.WARNING_MESSAGE);
				raksta.close();
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Kļūme ierakstot failā", "Kļūme!", JOptionPane.ERROR_MESSAGE);	
		}
			
			UIManager.put("OptionPane.yesButtonText", "Jā");
			UIManager.put("OptionPane.noButtonText", "Nē");
	        int apskatit = JOptionPane.showConfirmDialog(null, "Vai velaties apskatīties Jūsu pasūtījumu?", "Pasūtījums", JOptionPane.YES_NO_OPTION);  
	        
	        	if(apskatit==JOptionPane.YES_OPTION){
	        	
	        		try{
	    				
	    				FileReader fr = new FileReader("Pasutijums.txt");
	    				BufferedReader lasa = new BufferedReader(fr);
	    				
	    				while((teksts=lasa.readLine())!=null){
	    					System.out.println(teksts);
	    				}
	    				lasa.close();
	    				
	    			}catch(Exception e){
	    				JOptionPane.showMessageDialog(null, "Kļūme nolasot failu!", "Kļūme!", JOptionPane.ERROR_MESSAGE);
	    			}
	        		JOptionPane.showMessageDialog(null, "Paldies par Jūsu pasūtījumu!");
	        		UIManager.put("OptionPane.yesButtonText", "Labi");
	    			UIManager.put("OptionPane.noButtonText", "Slikti");
	        		int novertet = JOptionPane.showConfirmDialog(null, "Kā Jūs novērtēsiet mūsu apkalpošanu?", "Vērtēšana", JOptionPane.YES_NO_OPTION);  
	        		if(novertet==JOptionPane.YES_OPTION){
	        			JOptionPane.showMessageDialog(null, "Paldies par atsauksmi!");
	        		}if(novertet==JOptionPane.NO_OPTION){
	        			JOptionPane.showMessageDialog(null, "Kas tieši Jums nepatika?", "Jautājums", JOptionPane.QUESTION_MESSAGE);
	        			JOptionPane.showMessageDialog(null, "Labi, mēģināsim šo problemu risināt!");
	        		}

	        	}if(apskatit == JOptionPane.NO_OPTION){
	        		JOptionPane.showMessageDialog(null, "Paldies par Jūsu pasūtījumu!");
	        		UIManager.put("OptionPane.yesButtonText", "Labi");
	    			UIManager.put("OptionPane.noButtonText", "Slikti");
	        		int novertet = JOptionPane.showConfirmDialog(null, "Kā Jūs novērtēsiet mūsu apkalpošanu?", "Vērtēšana", JOptionPane.YES_NO_OPTION);  
	        		if(novertet==JOptionPane.YES_OPTION){
	        			JOptionPane.showMessageDialog(null, "Paldies par atsauksmi!");
	        		}if(novertet==JOptionPane.NO_OPTION){
	        			JOptionPane.showInputDialog("Kas tieši Jums nepatika?");	 
	        			JOptionPane.showMessageDialog(null, "Labi, mēģināsim šo problemu risināt!");
	        		}
	        	}
        	}
	
	public static void main(String[] args) throws Exception{
		String izvele;
		
		{
			izvele = JOptionPane.showInputDialog("1 - Veikt pasūtījumu | x - Apturēt programmu");
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