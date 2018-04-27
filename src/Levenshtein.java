import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Levenshtein {


	private static double LevQWERTY(String s1, String s2) {
		
		   int i=0, j=0, dlugoscS1, dlugoscS2;
		   double kosztZamiany=0;
		   double odlegloscEdycyjna[][];

		   dlugoscS1 = s1.length();
		   dlugoscS2 = s2.length();
		   
		   Map<Character, String> znakiSasiadujace = new HashMap<Character, String>();
		   		   
		   znakiSasiadujace.put( 'q', "w");
		   znakiSasiadujace.put( 'w', "qe");
		   znakiSasiadujace.put( 'e', "wr");
		   znakiSasiadujace.put( 'r', "et");
		   znakiSasiadujace.put( 't', "ry");
		   znakiSasiadujace.put( 'y', "tu");
		   znakiSasiadujace.put( 'u', "yi");
		   znakiSasiadujace.put( 'i', "uo");
		   znakiSasiadujace.put( 'o', "p");
		   
		   znakiSasiadujace.put( 'a', "s");
		   znakiSasiadujace.put( 's', "ad");
		   znakiSasiadujace.put( 'd', "sf");
		   znakiSasiadujace.put( 'f', "dg");
		   znakiSasiadujace.put( 'g', "fh");
		   znakiSasiadujace.put( 'h', "gj");
		   znakiSasiadujace.put( 'j', "hk");
		   znakiSasiadujace.put( 'k', "jl");
		   znakiSasiadujace.put( 'l', "k");
		   
		   znakiSasiadujace.put( 'z', "x");
		   znakiSasiadujace.put( 'x', "zc");
		   znakiSasiadujace.put( 'c', "xv");
		   znakiSasiadujace.put( 'v', "cb");
		   znakiSasiadujace.put( 'b', "vn");
		   znakiSasiadujace.put( 'n', "bm");
		   znakiSasiadujace.put( 'm', "n");
		  

	    odlegloscEdycyjna = new double [dlugoscS1+1][dlugoscS2+1];
		   
		// uzupe³niamy pierwszy wiersz i pierwsz¹ kolumnê
		   for (i=0; i<=dlugoscS1; i++)
		      odlegloscEdycyjna[i][0] = i;
		   for (j=1; j<=dlugoscS2; j++)
		      odlegloscEdycyjna[0][j] = j;
		   
		// sprawdzamy poszczególne znaki
		   for (i=1; i<=dlugoscS1; i++)
		   {
		      for (j=1; j<=dlugoscS2; j++)
		      { 
		    	  			        
		           if (s1.charAt(i-1) == s2.charAt(j-1))
		              kosztZamiany = 0;
		           else 
		           {
		        	   if (znakiSasiadujace.get(s2.charAt(j - 1)).contains(String.valueOf(s1.charAt(i - 1))))
		        		  kosztZamiany = 0.5;
		        	 
		        	  else
		        		  kosztZamiany = 1;
		           }
		           odlegloscEdycyjna[i][j] = Math.min(odlegloscEdycyjna[i-1][j] + 1,    //usuniecie znaku
		                        Math.min(odlegloscEdycyjna[i][j-1] + 1,      // dodanie znaku
		                             odlegloscEdycyjna[i-1][j-1] + kosztZamiany));   //zamiana znaku
		      }
		   }

		   return odlegloscEdycyjna[dlugoscS1][dlugoscS2];
		}
		

		public static void main(String[] args) {
		    String s1, s2;

		    
	        Scanner odczyt = new Scanner (System.in);
	        

	        System.out.println("Podaj pierwszy ci¹g znaków. ");
	        s1 = odczyt.nextLine(); 

	        System.out.println("Podaj drugi ci¹g znaków. ");
	        s2 = odczyt.nextLine();

	        System.out.println("Wa¿ona odleg³oœæ Levenshteina miêdzy napisami wynosi: " +  LevQWERTY(s1, s2));
	        
	        odczyt.close();
		}
}