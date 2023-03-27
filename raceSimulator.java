//Vincent Wong
//To create a race and display a visual that correlates to player and distance
//03/08/2023

import java.util.*;
import java.io.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Variables
    String begin, line = "", end = "", winner = "";
    String player1 = "", player2 = "", player3 = "", player4 = "";
    int distance1 = 0, distance2 = 0, distance3 = 0, distance4 = 0, totalDistance = 0, time = 1;
    String tally1, tally2, tally3, tally4;
    double run;
    DecimalFormat df = new DecimalFormat("##.00");

    System.out.print("\033[H\033[2J");
    System.out.flush(); // Clear Screen

    // Begin Program
    System.out.print("Welcome to Race Simulator\n");
    System.out.print("Type and enter any 'key' to begin: ");
    begin = input.next();
    System.out.print("\033[H\033[2J");
    System.out.flush();

    try { // Countdown Sequence
      for (int x = 0; x < 3; x++) {
        System.out.println("\t\t\t" + (3 - x));
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
      System.out.println("\t\t\tBEGIN!\n");
    }

    catch (InterruptedException e) {
      System.out.print("could not sleep");
    }

    try {
      FileReader fr = new FileReader("Mario Kart.txt"); // Declare file reader
      BufferedReader reader = new BufferedReader(fr); // Declare the file being read
      line = reader.readLine(); // Read First Line

      while (line != null && !end.equalsIgnoreCase("N")) { // Start System
        totalDistance = Integer.parseInt(line); // Distance
        player1 = reader.readLine(); // Player1
        player2 = reader.readLine(); // Player2
        player3 = reader.readLine(); // Player3
        player4 = reader.readLine(); // Player4
        end = "";

        // Distance of Race Stated
        System.out.println("Race Distance: " + totalDistance + "\n");

        // Begin Race
        while (distance1 < totalDistance && distance2 < totalDistance && distance3 < totalDistance && distance4 < totalDistance) {

          distance1 += (int) (11 * Math.random() + 5); // Random Distance
          distance2 += (int) (11 * Math.random() + 5); // Random Distance
          distance3 += (int) (11 * Math.random() + 5); // Random Distance
          distance4 += (int) (11 * Math.random() + 5); // Random Distance
          System.out.println("<><><><><><><><><><><><><><><><><>\n\nTime: " + time + "\n"); // Display Time

          // Determine how many meters is equal to one dash
          run = Math.round(totalDistance / 20) + 1; // Negates decimals

          // Reset to Default Race Visuals
          tally1 = "|                    |";
          tally2 = "|                    |";
          tally3 = "|                    |";
          tally4 = "|                    |";

          // Replace spaces with dashes with an X in order to show distance
          for (int i = 0; i < Math.floor((distance1 / run)); i++) {
            tally1 = tally1.replaceFirst(" ", "-");
          }
          tally1 = tally1.replaceFirst(" ", "X");

          for (int j = 0; j < Math.floor((distance2 / run)); j++) {
            tally2 = tally2.replaceFirst(" ", "-");
          }
          tally2 = tally2.replaceFirst(" ", "X");
          for (int k = 0; k < Math.floor((distance3 / run)); k++) {
            tally3 = tally3.replaceFirst(" ", "-");
          }
          tally3 = tally3.replaceFirst(" ", "X");
          for (int l = 0; l < Math.floor((distance4 / run)); l++) {
            tally4 = tally4.replaceFirst(" ", "-");
          }
          tally4 = tally4.replaceFirst(" ", "X");

          // Exactly race distance display
          if (distance1 == totalDistance) {
            tally1 = "|--------------------X";
          }
          if (distance2 == totalDistance) {
            tally2 = "|--------------------X";
          }
          if (distance3 == totalDistance) {
            tally3 = "|--------------------X";
          }
          if (distance4 == totalDistance) {
            tally4 = "|--------------------X";
          }

          // Over race distance display
          if (distance1 > totalDistance) {
            tally1 = "|--------------------|X";
          }
          if (distance2 > totalDistance) {
            tally2 = "|--------------------|X";
          }
          if (distance3 > totalDistance) {
            tally3 = "|--------------------|X";
          }
          if (distance4 > totalDistance) {
            tally4 = "|--------------------|X";
          }

          System.out.print(player1 + "\t\t\t" + distance1 + "m\n\n" + tally1 + "\n\n" + player2 + "\t" + distance2
              + "m\n\n" + tally2 + "\n\n" + player3 + "\t\t\t" + distance3 + "m\n\n" + tally3 + "\n\n" + player4
              + "\t\t" + distance4 + "m\n\n" + tally4 + "\n\n"); // Print Each Racer

          try {
            Thread.sleep(1000); // Pause inbetween each second of race
          } catch (InterruptedException e) {
            System.out.print("could not sleep");
          }

          time++; // Add Time
        } // End Race

        // Determine winner
        if (distance1 > distance2 && distance1 > distance3 && distance1 > distance4) {
          winner = player1;
        } else if (distance2 > distance1 && distance2 > distance3 && distance2 > distance4) {
          winner = player2;
        } else if (distance3 > distance1 && distance3 > distance2 && distance3 > distance4) {
          winner = player3;
        } else if (distance4 > distance1 && distance4 > distance2 && distance4 > distance3) {
          winner = player4;
        }

        // Determine ties
        if (distance1 == distance2 && distance1 > distance3 && distance1 > distance4 && distance2 > distance3
            && distance2 > distance4) {
          winner = "Tie between " + player1 + " and " + player2 + "!";
        } else if (distance1 == distance3 && distance1 > distance2 && distance1 > distance4 && distance3 > distance2
            && distance3 > distance4) {
          winner = "Tie between " + player1 + " and " + player3 + "!";
        } else if (distance1 == distance4 && distance1 > distance2 && distance1 > distance3 && distance4 > distance2
            && distance4 > distance3) {
          winner = "Tie between " + player1 + " and " + player4 + "!";
        } else if (distance2 == distance3 && distance2 > distance1 && distance2 > distance4 && distance3 > distance4
            && distance3 > distance1) {
          winner = "Tie between " + player2 + " and " + player3 + "!";
        } else if (distance2 == distance4 && distance2 > distance3 && distance2 > distance1 && distance4 > distance3
            && distance4 > distance1) {
          winner = "Tie between " + player2 + " and " + player4 + "!";
        } else if (distance3 == distance4 && distance3 > distance1 && distance3 > distance2 && distance4 > distance3
            && distance4 > distance1) {
          winner = "Tie between " + player3 + " and " + player4 + "!";
        }

        // Announce Winner
        System.out.print("The winner is: " + winner + "\n\n");

        try { // Average Velocities
          FileWriter fw = new FileWriter("averageReport.txt", true);
          PrintWriter pw = new PrintWriter(fw);
          pw.print("AVERAGE VELOCITIES\n");
          pw.println(player1 + ": v = " + df.format(((double) distance1 / (double) time)) + " m/s");
          pw.println(player2 + ": v = " + df.format(((double) distance2 / (double) time)) + " m/s");
          pw.println(player3 + ": v = " + df.format(((double) distance3 / (double) time)) + " m/s");
          pw.print(player4 + ": v = " + df.format(((double) distance4 / (double) time)) + " m/s\n\n");
          pw.close();
        }

        catch (IOException e) {
          System.out.print("File could not write");
        }

        // Reset All Values to Beginning
        time = 1;
        distance1 = 0;
        distance2 = 0;
        distance3 = 0;
        distance4 = 0;
        line = reader.readLine(); // Read Distance Line
        // Asks user to continue to the next race or quit
        while (!end.equalsIgnoreCase("N") && !end.equalsIgnoreCase("Y") && line != null) {
          System.out.print("Would you like to continue to the next race? (Y/N): ");
          end = input.next();
        }

      } // End Entire System
      
      reader.close(); //Close Reader
      
    } // Declare File Reader End
    catch (IOException e) {
      System.out.print("System could not read");
    }

    // Program End Message
    if (line == null) {
      System.out.print("\nSorry there are no more races today!\n\nThank you for watching Race Simulator, come again!");
    }

    else {
      System.out.print("\nThank you for watching Race Simulator, come again!");
    }

    input.close();
  }//
}//