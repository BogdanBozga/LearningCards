package com.fun;

import com.gui.Main;
import com.gui.Standards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

    Connection myConn;



    /*
    Card table
    Deck table
    User table
    UserStarsCard table
     */


    public DbConnection(){
        try {
            myConn = DriverManager.getConnection(Standards.databaseUrl+Standards.databaseName,Standards.databaseUser,Standards.databasePassword);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void  insertNewCardInDB(int deckID,String frontText,String backText){

        try {
            Statement myInsertStatement = myConn.createStatement();

            String sql = "insert into Card "+
                        "(deckID, frontText, backText)"+
                        " values ('"+ deckID + "','" + frontText + "','" + backText+"')";
            myInsertStatement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void  insertNewCardInDB(String deckName,String frontText,String backText){

        try {
            int deckID=-1;

            Statement myInsertStatement = myConn.createStatement();


//            Statement myInsertStatement = myConn.createStatement();

            String sql = "SELECT ID FROM Deck WHERE deckName='"+deckName+"'";



//            String sql = "insert into testTable "+
//                    "(deckID, frontText, backText)"+
//                    " values ("+ deckID + "," + frontText + "," + backText+")";
            ResultSet rs = myInsertStatement.executeQuery(sql);
            if(rs.next()) {
                deckID = rs.getInt("ID");
            }
            if(deckID == -1){
                //something went wrong
            }else{
                insertNewCardInDB(deckID,frontText,backText);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void  insertNewCardInDB(int deckID,String frontText,String backText, String frontImageLocation, String backImageLocation){
        try {
            Statement myInsertStatement = myConn.createStatement();

            String sql = "insert into Card "+
                    "(deckID, frontText, backText, frontImage, BackImage)"+
                    " values ("+ deckID + "," + frontText + "," + backText+ "," + frontImageLocation + "," + backImageLocation + ")";
            myInsertStatement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void insertNewDeckInDB(String deckName){
        try {

            Statement myInsertStatement = myConn.createStatement();


            String sqle = "SELECT deckName FROM Deck";


            ResultSet rs = myInsertStatement.executeQuery(sqle);
            boolean exist = false;
            while (rs.next()) {
                String name = rs.getString("deckName");
                if(name.compareTo(deckName)==0)
                    exist = true;
            }


            if(!exist) {

            Statement myInsertStatementInsert = myConn.createStatement();

                String sql = "INSERT INTO Deck " +
                        "(deckName, creatingDate)" +
                        " VALUES ('" + deckName + "',CURDATE())";

//                System.out.println(sql);
                myInsertStatementInsert.executeUpdate(sql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<String> getDeckList(){
        List decksList = new ArrayList();

        try {

            Statement myInsertStatement = myConn.createStatement();


            String sql = "SELECT deckName,cardsNumber FROM Deck";


            ResultSet rs = myInsertStatement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("deckName");
                int number = rs.getInt("cardsNumber");
                decksList.add(name);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return decksList;
    }


    public void initializeDeckDict() {
//        Main.deckDict
        try {
            Statement myInsertStatement = myConn.createStatement();
            Statement myStatement2 = myConn.createStatement();

            String sql = "SELECT ID,deckName,cardsNumber FROM Deck";


            ResultSet rs = myInsertStatement.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("deckName");
                int id = rs.getInt("ID");
                int nrc = rs.getInt("cardsNumber");
                List<Card> cards = new ArrayList<>();


                String sqlc = "SELECT * FROM Card WHERE deckID='"+id+"'";
                ResultSet rsc=myStatement2.executeQuery(sqlc);
                while (rsc.next()){
                    String frontT = rsc.getString("frontText");
                    String backT = rsc.getString("backText");
                    String frontI = rsc.getString("frontImage");
                    String backI = rsc.getString("backImage");

                    if(frontI == null && backI == null) {
                        Card cardN = new Card(frontT, backT);
                        cards.add(cardN);
                    }else{
                        Card card = new Card(frontT, backT, frontI, backI);
                        cards.add(card);
                    }

                }
                Deck deck = new Deck(name,cards,nrc);
                Main.deckDict.put(name,deck);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


//    public int getNumberCards(String name){
//        int cardNr=0;
//        try {
//            Statement myStatement = myConn.createStatement();
//
//
//            String sql = "SELECT cardsNumber FROM Deck WHERE deckName='"+name+"'";
//            cardNr = myStatement.executeQuery(sql).getInt("cardsNumber");
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return cardNr;
//    }

//    public void increaseCardsNumber(String name){
//
//        try {
//            Statement updateStatement = myConn.createStatement();
//            int updatedCardsNumber = getNumberCards(name)+1;
//
//            String sql = "UPDATE Deck SET cardsNumber=" + String.valueOf(updatedCardsNumber) + " WHERE deckName ='"+name+"'";
//            updateStatement.executeUpdate(sql);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    void updateCardsNumber(int updatedCardsNumber,String name){
        try {
            Statement updateStatement = myConn.createStatement();

            String sql = "UPDATE Deck SET cardsNumber=" + String.valueOf(updatedCardsNumber) + " WHERE deckName ='"+name+"'";
            updateStatement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteDeck(){

//        DELETE FROM `Deck` WHERE `Deck`.`ID` = 18

    }
}


