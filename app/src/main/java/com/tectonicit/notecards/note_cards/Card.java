package com.tectonicit.notecards.note_cards;

/**
 * Created by Nicholas on 11/22/2015.
 */
class Card {
    String ideaTitle;
    String description;
    String pictureLocation;
    String cost;
    String lengthOfTimeLine;
    String authorFName;
    String authorLName;
    // Constructor
    public Card (){
        ideaTitle = "";
        description = "";
        pictureLocation = "";
        cost = "";
        lengthOfTimeLine = "";
        authorFName = "";
        authorLName = "";
    }
    public Card (String a,String b,String c,String d,String e,String f,String g){
        ideaTitle = a;
        description = b;
        pictureLocation = c;
        cost = d;
        lengthOfTimeLine = e;
        authorFName = f;
        authorLName = g;
    }
}