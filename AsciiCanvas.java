

import javax.swing.JTextArea;
import javax.swing.text.TextAction;

import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


@SuppressWarnings("serial")
public class AsciiCanvas extends JframeCode {
	
	
	static String[] arr = new String[100];//array of strings called arr with size of 100
	static int p1_total = 0, p2_total = 0;
	
	public static int winner(int p1_input, int p2_input)//prints or gets the frame
	{
				
		int winnernumber;
		String descript;
		
					//2D array of who wins the round
		int [][] winnerarray =
			{        
							//player 2
			
			             // r,p,s,l,sp	
		           /*rock*/{0,2,1,1,2},
/*player 1*/      /*paper*/{1,0,2,2,1},
		       /*scissors*/{2,1,0,1,2},
		         /*lizard*/{2,1,2,0,1},
		          /*spock*/{1,2,1,2,0}
			};//end array def
		
				//2D array of strings for the outcome of the round
		String [][] description =
			{
/*p1 r*/ {"          Player 1's Rock ties Player 2's Rock.\n","          Player 2's Paper beats *covers* Player 1's Rock.\n","          Player 1's Rock beats *crushes* Player 2's Scissors.\n","          Player 1's Rock beats *crushes* Player 2's Lizard.\n","          Player 2's Spock beats *vaporizes* Player 1's Rock.\n"},
/*p1 p*/ {"          Player 1's paper beats *covers* Player 2's Rock.\n","          Player 2's Paper ties Player 1's Paper.\n","          Player 2's Scissors beats *cuts* Player 1's Paper.\n","          Player 2's Lizard beats *eats* Player 1's Paper.\n","          Player 1's paper beats *disproves* Player 2's Spock.\n"},
/*p1 s*/ {"          Player 2's Rock beats *Crushes* Player 1's Scissors.\n","          Player 1's Scissors beats *cuts* Player 2's Paper.\n","          Player 2's Scissors ties Player 1's Scissors.\n","          Player 1's Scissors beats *decapitates* Player 2's Lizard.\n","          Player 2's Spock beats *smashes* Player 1's Scissors.\n"},
/*p1 l*/ {"          Player 2's Rock beats *crushes* Player 1's Lizard.\n","          Player 1's Lizard beats *eats* Player 2's Paper.\n","          Player 2's Scissors beats *decapitates* Player 1's Lizard.\n","          Player 2's Lizard ties Player 1's Lizard.\n","          Player 1's Lizard beats *poisons* Player 2's Spock.\n"},
/*p1 sp*/{"          Player 1's Spock beats *vaporizes* Payer 2's Rock.\n","          Player 2's Paper beats *disproves* Player 1's Spock.\n","          Player 1's Spock beats *crushes* Player 2's Scissors.\n","          Player 2's Lizard beats *poisens* Player 1's Spock.\n","          Player 2's Spock ties Player 1's Spock.\n"}
			};
		
		winnernumber = winnerarray[p1_input - 1 ][p2_input -1];//determines the winner based off which array element is which
		descript = description [p1_input - 1][p2_input - 1];
		results.setText(descript);
		return winnernumber;
	}//end winner function
}//end class def