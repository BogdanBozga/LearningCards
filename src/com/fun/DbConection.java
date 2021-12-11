package com.fun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class DbConection {

    Connection myConn;

    String dbName = "LearningCardsDataBase";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";


    /*
    Card table
    Deck table
    User table
    UserStarsCard table
     */


    DbConection(){
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");

            Statement myStmt = myConn.createStatement();



//        String sql = "insert into testTable "+
//                    "(Nume, Prenume, Ani)"+
//                    " values ('Gigel', 'David', '12')";
//        myStmt.executeUpdate(sql);
//
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM testTable");

            while(myRs.next()){
                System.out.println(myRs.getString("Nume")+ " "+myRs.getString("Prenume"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void  insertNewCardInDB(int deckID,String frontText,String backText){

        try {
            Statement myInsertStatement = myConn.createStatement();

            String sql = "insert into testTable "+
                        "(deckID, frontText, backText)"+
                        " values ("+ deckID + "," + frontText + "," + backText+")";
            myInsertStatement.executeUpdate(sql);
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

            String sql = "insert into Deck "+
                    "(deckName, creatingDate)"+
                    " values ("+deckName+ ",CURDATE())";

            myInsertStatement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}


