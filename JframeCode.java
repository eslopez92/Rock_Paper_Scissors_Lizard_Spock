/*
 Emilio Lopez
 CSCI 240
 Final Project Turned in on 12/4/2013
 The purpose of this applet is to create a game of rock, paper, lizard, spock using OOP, inheritance, and different styles of data structures
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JframeCode extends JFrame implements ActionListener
{
	  private static final long serialVerRound_NumberonUID = 1L;
	  static int Round_Number = 0;
	  static int p1_score = 0, p2_score = 0;
	  static int p1_or_p2 = 1;// checks to see if player 1 or player two has pressed the button and always starts with player 1.
	  static int p1_input, p2_input;//input of; rock (1), paper (2), scissors (3), lizard (4), or Spock (4)
	  
	  //for sub layouts in the main layout
	  JPanel nth = new JPanel();
	  JPanel sth = new JPanel();
	  JPanel est = new JPanel();
	  JPanel wst = new JPanel();
	  JPanel ctr = new JPanel();
	 
	  //Rules
	  JLabel P1 = new JLabel("   Player 1: " + p1_score + "     ");
	  JLabel P2 = new JLabel("   Player 2: " + p2_score + "     ");
	  JLabel RN = new JLabel("                                                                        "
		  		+ "                                                                 "
		  		+ "BEGIN!!!");//Round Number
	  JLabel Rules = new JLabel("<html>RULES: <br><br>"//use html to make a new line
	  		+ "<html>Scissors cuts Paper, <br><br>Paper covers Rock, <br><br>Rock Crushes Lizard, <br><br>Lizard poisons Spock,"
	  		+ "<html><br><br>Spock smashes Scissors, <br><br>Scissors decapitats Lizard, <br><br>Lizard eats Paper,"
	  		+ "<html><br><br>Paper disproves Spock, <br><br>Spock vaporizes Rock, <br><br>and as it always has, Rock Crushes Scissors.");
	  
	  //Buttonsds
	  JButton ROCK = new JButton("Rock");
	  JButton PAPER = new JButton("Paper");
	  JButton SCISSORS = new JButton("Scissors");
	  JButton LIZARD = new JButton("Lizard");
	  JButton SPOCK = new JButton("Spock");
	  JButton RESTART = new JButton("Restart");
	  
	  //getting the image icons
	  ImageIcon Rock = new ImageIcon("Rock.jpg");
	  ImageIcon Paper = new ImageIcon("Paper.jpg");
	  ImageIcon Scissors = new ImageIcon("Scissors.jpg");
	  ImageIcon Lizard = new ImageIcon("Lizard.jpg");
	  ImageIcon Spock = new ImageIcon("Spock.jpg");
	  
	  //Images  for each player
	  JLabel player_1_image = new JLabel();
	  JLabel player_2_image = new JLabel();
	  
	  
	  JLabel directions = new JLabel();
	  public static JLabel results = new JLabel();
	
	  public static void main(String args[])
	  {
	    new JframeCode().setVisible(true);
	  } // end main
	  
	  public JframeCode()
	  {
		  
		  super("ROCK, PAPER, SCISSORS, LIZARD, SPOCK!!");
		  nth.setLayout(new GridLayout(0,2));//for centering jlabel
		  wst.setLayout( new GridLayout( 2,0 )); //makes the player 1 and player
		  										 //2 have two lines
		  ctr.setLayout(new BorderLayout());
		  
		  //action listener for the buttons
		  ROCK.addActionListener(this);
		  PAPER.addActionListener(this);
		  SCISSORS.addActionListener(this);
		  LIZARD.addActionListener(this);
		  SPOCK.addActionListener(this);
		  RESTART.addActionListener(this);

		  setSize(1000,500);
		  //setResizable(false);
		  getContentPane().setBackground(Color.black);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  			//*********NOTRH**************
					nth.add(RN);
					nth.setBackground(Color.BLACK);
			add(nth, BorderLayout.NORTH);
			
					//*********SOUTH**************
			
				  	sth.add(ROCK);
				  	sth.add(PAPER);
				  	sth.add(SCISSORS);
				  	sth.add(LIZARD);
				  	sth.add(SPOCK);
				  	sth.add(RESTART);
				  	sth.setBackground(Color.BLACK);
				  	
				  	ROCK.setBackground(Color.DARK_GRAY);
				  	PAPER.setBackground(Color.WHITE);
				  	SCISSORS.setBackground(Color.YELLOW);
			  		LIZARD.setBackground(Color.GREEN);
			  		SPOCK.setBackground(Color.RED);
			  		RESTART.setBackground(Color.BLUE);
			  		
			  		ROCK.setForeground(Color.BLACK);
			  		PAPER.setForeground(Color.BLACK);
			  		SCISSORS.setForeground(Color.BLACK);
			  		LIZARD.setForeground(Color.BLACK);
			  		SPOCK.setForeground(Color.BLACK);
			  		RESTART.setForeground(Color.WHITE);
			  		
		  add(sth,BorderLayout.SOUTH);//all buttons are in pane and add pane to south
		
		  			//*********EAST**************
		  Rules.setForeground(Color.GREEN);
		  add(Rules, BorderLayout.EAST);
		  			//*********WEST**************
		  
		  			wst.add(P1);
		  			P1.setForeground(Color.WHITE);//white text
		  			wst.add(P2);
		  			P2.setForeground(Color.WHITE);//white text
		  			wst.setBackground(Color.BLACK);
		  add(wst, BorderLayout.WEST);
		  

		  			//*********CENTER**************		  
				RN.setForeground(Color.WHITE);//Round number to be white
				ctr.add(player_1_image,BorderLayout.WEST);//putting the image to the left
				ctr.add(player_2_image,BorderLayout.EAST);//putting the image to the right
				ctr.add(directions,BorderLayout.NORTH);
				ctr.add(results,BorderLayout.CENTER);
				directions.setText("                                       "
						+ "                                            Player 1, make your selection.");
		  add(ctr, BorderLayout.CENTER);		  
		  
	  }//end JframeCode()
	  
	  

	@Override
	public void actionPerformed(ActionEvent EVENT) //checks to see which button has been clicked
	{
		
		String button = EVENT.getActionCommand();
		int p1_or_p2_temp = 1;
		if(button.equals("Rock"))
		{
			
			int winner_number = -1;
			if(p1_or_p2 == 1)//player one's input
			{
				//clearing the screen for the new round
				player_1_image.setIcon(null);
				player_2_image.setIcon(null);
				results.setText(null);
				Round_Number++;
				RN.setText("                                                                        "
				  		+ "                                                                 "
				  		+ "Round: " + Round_Number);//Round Number
				
				directions.setText("                                       "
						+ "                                            Player 2, make your selection.");
				p1_input = 1;//player one's input will be rock (1).
				p1_or_p2 ++;//goes to the next player
			}
			else if(p1_or_p2 == 2)//if player two's input is done
			{
				p1_or_p2_temp = 2;
				p2_input = 1;//player two's input will be rock (1)
				p1_or_p2 = 1;//goes back to player one
				winner_number = AsciiCanvas.winner(p1_input, p2_input);
				directions.setText("                                       "
						+ "                                            Player 1, make your selection.");
			}
			
			if (winner_number == 0)
				System.out.println("It's a tie");
			else if (winner_number == 1)
			{
				p1_score++;
				P1.setText("   Player 1: " + p1_score + "     ");
				System.out.println("Player 1 wins this round.");
			}
			else if (winner_number == 2)
			{
				
				p2_score++;
				P2.setText("   Player 2: " + p2_score + "     ");
				System.out.println("Player 2 wins this round.");
			}
		}
		
		else if(button.equals("Paper"))
		{
			int winner_number = -1;
			if(p1_or_p2 == 1)//player one's input
			{
				//clearing the screen for the new round
				player_1_image.setIcon(null);
				player_2_image.setIcon(null);
				results.setText(null);
				Round_Number++;
				RN.setText("                                                                        "
				  		+ "                                                                 "
				  		+ "Round: " + Round_Number);//Round Number
				
				
				directions.setText("                                       "
						+ "                                            Player 2, make your selection.");
				p1_input = 2;//player one's input will be paper (2).
				p1_or_p2 ++;//goes to the next player
			}
			else if(p1_or_p2 == 2)//if player two's input is done
			{
				p1_or_p2_temp = 2;
				p2_input = 2;//player two's input will be paper (2)
				p1_or_p2 = 1;//goes back to player one
				winner_number = AsciiCanvas.winner(p1_input, p2_input);
				directions.setText("                                       "
						+ "                                            Player 1, make your selection.");
			}
			
			if (winner_number == 0)
				System.out.println("It's a tie");
			
			else if (winner_number == 1)
			{
				p1_score++;
				P1.setText("   Player 1: " + p1_score + "     ");
				System.out.println("Player 1 wins this round.");
			}
			
			else if (winner_number == 2)
			{
				p2_score++;
				P2.setText("   Player 2: " + p2_score + "     ");
				System.out.println("Player 2 wins this round.");
			}
										
			
		}
		
		else if(button.equals("Scissors"))
		{						
			int winner_number = -1;
			if(p1_or_p2 == 1)//player one's input
			{
				//clearing the screen for the new round
				player_1_image.setIcon(null);
				player_2_image.setIcon(null);
				results.setText(null);
				Round_Number++;
				RN.setText("                                                                        "
				  		+ "                                                                 "
				  		+ "Round: " + Round_Number);//Round Number
				directions.setText("                                       "
						+ "                                            Player 2, make your selection.");
				p1_input = 3;//player one's input will be scissors (3).
				p1_or_p2 ++;//goes to the next player
			}
			else if(p1_or_p2 == 2)//if player two's input is done
			{
				p1_or_p2_temp = 2;
				p2_input = 3;//player two's input will be scissors (3)
				p1_or_p2 = 1;//goes back to player one
				winner_number = AsciiCanvas.winner(p1_input, p2_input);
				directions.setText("                                       "
						+ "                                            Player 1, make your selection.");
			}
			
			if (winner_number == 0)
				System.out.println("It's a tie");

			else if (winner_number == 1)
			{
				p1_score++;
				P1.setText("   Player 1: " + p1_score + "     ");
				System.out.println("Player 1 wins this round.");
			}
			
			else if (winner_number == 2)
			{
				p2_score++;
				P2.setText("   Player 2: " + p2_score + "     ");
				System.out.println("Player 2 wins this round.");
			}
			
		}
		
		else if(button.equals("Lizard"))
		{
			int winner_number = -1;
			if(p1_or_p2 == 1)//player one's input
			{
				//clearing the screen for the new round
				player_1_image.setIcon(null);
				player_2_image.setIcon(null);
				results.setText(null);
				Round_Number++;
				RN.setText("                                                                        "
				  		+ "                                                                 "
				  		+ "Round: " + Round_Number);//Round Number
				
				directions.setText("                                       "
						+ "                                            Player 2, make your selection.");
				p1_input = 4;//player one's input will be Lizard (4).
				p1_or_p2 ++;//goes to the next player
			}
			else if(p1_or_p2 == 2)//if player two's input is done
			{
				p1_or_p2_temp = 2;
				p2_input = 4;//player two's input will be Lizard (4)
				p1_or_p2 = 1;//goes back to player one
				winner_number = AsciiCanvas.winner(p1_input, p2_input);
				directions.setText("                                       "
						+ "                                            Player 1, make your selection.");
			}
			
			if (winner_number == 0)
				System.out.println("It's a tie");
			
			else if (winner_number == 1)
			{
				p1_score++;
				P1.setText("   Player 1: " + p1_score + "     ");
				System.out.println("Player 1 wins this round.");
			}
			
			else if (winner_number == 2)
			{
				p2_score++;
				P2.setText("   Player 2: " + p2_score + "     ");
				System.out.println("Player 2 wins this round.");
			}
		}
		
		else if(button.equals("Spock"))
		{
			int winner_number = -1;
			if(p1_or_p2 == 1)//player one's input
			{
				//clearing the screen for the new round
				player_1_image.setIcon(null);
				player_2_image.setIcon(null);
				results.setText(null);
				Round_Number++;
				RN.setText("                                                                        "
				  		+ "                                                                 "
				  		+ "Round: " + Round_Number);//Round Number
				
				directions.setText("                                       "
						+ "                                            Player 2, make your selection.");
				p1_input = 5;//player one's input will be Spock (5).
				p1_or_p2 ++;//goes to the next player
			}
			else if(p1_or_p2 == 2)//if player two's input is done
			{
				p1_or_p2_temp = 2;
				p2_input = 5;//player two's input will be Spock (5)
				p1_or_p2 = 1;//goes back to player one
				winner_number = AsciiCanvas.winner(p1_input, p2_input);
				directions.setText("                                       "
						+ "                                            Player 1, make your selection.");
			}
			
			if (winner_number == 0)
				System.out.println("It's a tie");
			
			else if (winner_number == 1)
			{
				p1_score++;
				P1.setText("   Player 1: " + p1_score + "     ");
				System.out.println("Player 1 wins this round.");
			}
			
			else if (winner_number == 2)
			{
				p2_score++;
				P2.setText("   Player 2: " + p2_score + "     ");
				System.out.println("Player 2 wins this round.");
			}
		}
		
		else if(button.equals("Restart"))
		{
			Round_Number = 0;//resets the round number to be equal to zero
			RN.setText("                                                                        "
			  		+ "                                                                 "
			  		+ "Round: " + Round_Number);//Round Number display
			
			if(p1_score > p2_score)
				results.setText("                                                           Player 1 wins!!!!!!!!!!!!");
			
			if(p1_score < p2_score)
				results.setText("                                                           Player 2 wins!!!!!!!!!!!!");
			
			if(p1_score == p2_score)
				results.setText("                                                           It's a tie!!!!!!!!!!!!");
			
			p1_score = 0;
			P1.setText("   Player 1: " + p1_score + "     ");;//updates the score
			//results.setText(null);
			p2_score = 0;
			P2.setText("   Player 2: " + p2_score + "     ");;//updates the score
			System.out.println("'Restart' button has been clicked.");
			p1_or_p2_temp = 0;//to erase the pictures
		}
		
		if(p1_or_p2_temp == 2)//waits until the second button has been clicked
			{
				//printing out player 1's gesture based upon their input value
				if (p1_input == 1)
					player_1_image.setIcon(Rock);
				if (p1_input == 2)
					player_1_image.setIcon(Paper);
				if (p1_input == 3)
					player_1_image.setIcon(Scissors);
				if (p1_input == 4)
					player_1_image.setIcon(Lizard);
				if (p1_input == 5)
					player_1_image.setIcon(Spock);
				
				//printing out player 2's gesture based upon their input value
				if (p2_input == 1)
					player_2_image.setIcon(Rock);
				if (p2_input == 2)
					player_2_image.setIcon(Paper);
				if (p2_input == 3)
					player_2_image.setIcon(Scissors);
				if (p2_input == 4)
					player_2_image.setIcon(Lizard);
				if (p2_input == 5)
					player_2_image.setIcon(Spock);
			}//end if

		else if(p1_or_p2_temp == 0)//clearing the screen
			{
				player_1_image.setIcon(null);
				player_2_image.setIcon(null);
			}
		
		
			
			
	}//end action performed
}//end of the class definition
