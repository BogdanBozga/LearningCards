package com.fun;

import com.gui.Main;
import com.gui.Standards;
import com.gui.WelcomeWindow;
import com.mysql.cj.jdbc.StatementImpl;

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


    public void  insertNewCardInDB(String deckName,String frontText,String backText, String frontImage, String backImage){

        try {
            int deckID=-1;
            Statement myInsertStatement = myConn.createStatement();

            String sql = "SELECT ID FROM Deck WHERE deckName='"+deckName+"'";



            ResultSet rs = myInsertStatement.executeQuery(sql);
            if(rs.next()) {
                deckID = rs.getInt("ID");
            }
            if(deckID == -1){
                //something went wrong
            }else{
                insertNewCardInDB(deckID,frontText,backText,frontImage,backImage);
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
                    " values ('"+ deckID + "', '" + frontText + "', '" + backText+ "', '" + frontImageLocation + "', '" + backImageLocation + "')";
            myInsertStatement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void insertNewDeckInDB(String deckName){
        try {

            Statement mySelectStatement = myConn.createStatement();


            String sqle = "SELECT deckName FROM Deck";


            ResultSet rs = mySelectStatement.executeQuery(sqle);


            boolean exist = false;
            while (rs.next()) {
                String name = rs.getString("deckName");
                if(name.compareTo(deckName)==0)
                    exist = true;
            }
            mySelectStatement.close();

            if(!exist) {

            Statement myInsertStatementInsert = myConn.createStatement();

                String sql = "INSERT INTO Deck " +
                        "(deckName)" +
                        " VALUES ('" + deckName + "')";

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
                    int cid = rsc.getInt("cardID");
                    if(frontI == null && backI == null) {
                        Card cardN = new Card(frontT, backT);
                        cardN.setID(cid);
                        cards.add(cardN);
                    }else{
                        Card card = new Card(frontT, frontI, backT,  backI);
                        card.setID(cid);
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

    void updateCardsNumber(int updatedCardsNumber,String name){
        try {
            Statement updateStatement = myConn.createStatement();

            String sql = "UPDATE Deck SET cardsNumber=" + String.valueOf(updatedCardsNumber) + " WHERE deckName ='"+name+"'";
            updateStatement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public void deleteCardsDeck(int deckID){
        try{
            Statement myDeleteCardsStatement = myConn.createStatement();
            String sql = "DELETE FROM Card WHERE deckID = '"+deckID +"'";
            myDeleteCardsStatement.executeUpdate(sql);
            myDeleteCardsStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteCard(int cardID_){
        try{
            Statement myDeleteCardsStatement = myConn.createStatement();
            String sql = "DELETE FROM Card WHERE cardID = '"+cardID_ +"'";
            myDeleteCardsStatement.executeUpdate(sql);
            myDeleteCardsStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void deleteDeck(String deckName){
        int deckID = getDeckID(deckName);
        deleteCardsDeck(deckID);
        try {
            Statement myDeleteDeckStatement = myConn.createStatement();
            String sql = "DELETE FROM Deck WHERE ID = '"+deckID +"'";
            myDeleteDeckStatement.executeUpdate(sql);
            myDeleteDeckStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getDeckID(String name){
        int ID=-1;
        try {
            Statement getStatement = myConn.createStatement();
            String sql = "SELECT ID FROM Deck WHERE deckName ='" + name +"'";
            ResultSet rs = getStatement.executeQuery(sql);
            while (rs.next()) {
                ID = rs.getInt("ID");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ID;
    }


    public List<Card> getCards(int id){
        List<Card> cards = new ArrayList<>();
        try {
            Statement myStatement = myConn.createStatement();
            String sqlc = "SELECT * FROM Card WHERE deckID='"+id+"'";
            ResultSet rsc=myStatement.executeQuery(sqlc);
            while (rsc.next()){
                String frontT = rsc.getString("frontText");
                String backT = rsc.getString("backText");
                String frontI = rsc.getString("frontImage");
                String backI = rsc.getString("backImage");
                int cid = rsc.getInt("cardID");
                if(frontI == null && backI == null) {
                    Card cardN = new Card(frontT, backT);
                    cardN.setID(cid);
                    cards.add(cardN);
                }else{
                    Card card = new Card(frontT, frontI, backT, backI);
                    card.setID(cid);
                    cards.add(card);
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cards;
    }


    int getUserID(String userName){
        int userID = -1;
        try {
            Statement getStatement = myConn.createStatement();
            String sql = "SELECT userID FROM User WHERE UserName ='" + userName +"'";
            ResultSet rs = getStatement.executeQuery(sql);
            while (rs.next()) {
                userID = rs.getInt("userID");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userID;
    }


    int getReadCount(int cardID){
        int readCount = -1;
        try {
            Statement getStatement = myConn.createStatement();
            String sql = "SELECT readCount FROM UserStatsCard WHERE cardID ='" + String.valueOf(cardID) +"'";
            ResultSet rs = getStatement.executeQuery(sql);
            while (rs.next()) {
                readCount = rs.getInt("readCount");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return readCount;
    }


    public void increaseReadingCount(int cardID_){
        String userName = Main.welcomeWindow.getUserName();
        boolean exist = false;
        int userID_ = getUserID(userName);
        try{
            Statement mySelectStatement = myConn.createStatement();
            String sqls ="SELECT * FROM UserStatsCard WHERE userID =" + userID_ +" AND cardID="+cardID_;
            ResultSet res = mySelectStatement.executeQuery(sqls);
            while (res.next()) {
                exist = true;
            }
            mySelectStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        if(!exist) {
            try {
                Statement insertStatement = myConn.createStatement();
                String sql = "INSERT INTO UserStatsCard " +
                        "(userId, cardID, readCount)" +
                        " VALUES (" + userID_ + ", " + cardID_ +", 1" + ")";
                insertStatement.executeUpdate(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                Statement updateStatement = myConn.createStatement();

                int userID = getUserID(userName);
                String sql = "UPDATE UserStatsCard SET readCount=" + (getReadCount(cardID_) + 1) + " WHERE cardID ='" + cardID_ + "' AND userID='" + userID + "'";
                updateStatement.executeUpdate(sql);
                updateStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void insertUser(String userName_){
        try{
            Statement insertStatement = myConn.createStatement();
            String sql = "INSERT IGNORE INTO User "+
                    "(userName)"+
                    " VALUES ('" + userName_ + "')";
            insertStatement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


