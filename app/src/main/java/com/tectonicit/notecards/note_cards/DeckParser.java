package com.tectonicit.notecards.note_cards;

/**
 * Created by Nicholas on 11/22/2015.
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Get the ith card from the deck and return its author: deck.deckArray.get(i).authorFName
class DeckParser{
    int numberOfCards;
    ArrayList<Card> deckArray = new ArrayList<Card>();
    //constructor
    void DeckParser(){
        numberOfCards = 0;
    }
    //Methods
    void readFile(String fileName){
        //fileName = "tester.csv";	//for debugging purposes
        File csvFile = new File(fileName);

        if(csvFile.exists() && !csvFile.isDirectory()){}
        else{System.out.println("Error: File doesn't exist!");}

        try {

            Scanner sc = new Scanner(csvFile);

            while (sc.hasNextLine()) {
                String line = sc.next();		//Take in line
                String[] t = line.split(",");	//t for tokens
                Card aNewCard = new Card();		//Create card for storage
                if (t.length == 7){				//Store if correct length
                    deckArray.add(new Card(t[0],t[1],t[2],t[3],t[4],t[5],t[6]));
                }
                else{
                    System.out.println("Error: Only" + t.length + "tokens!");
                }
                numberOfCards++;
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
