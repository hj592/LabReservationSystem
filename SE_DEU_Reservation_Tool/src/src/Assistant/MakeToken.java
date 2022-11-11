/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Assistant;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heejin
 */
public class MakeToken {
    String[][] tokenTable ;

    public MakeToken() {
        System.out.println("토큰 생성자");
        getTokenDb();
    }
    
    
    
    public String getToken(){ // 토큰 생성
        char[] token = new char[6];
        String key="";
        int tmp=0;        
        
        for (int i = 0 ; i < token.length ; i++){
            int type = (int)(Math.random()*3); //해당 위치 숫자/대문자/소문자 구분
            if(type==0) //숫자면 아스키코드48~57
                tmp =ThreadLocalRandom.current().nextInt(48, 57); 
            else if(type==1)//대문자면 아스키코드65~90사이의수                
                tmp = ThreadLocalRandom.current().nextInt(65, 90);
            else //소문자면 아스키코드 97~122사이의수
                tmp =ThreadLocalRandom.current().nextInt(97, 122);
            token[i]=(char)tmp; //아스키코드 문자로
        }
        for (int i = 0 ; i < token.length ; i++)
            key+=token[i];     
        
        return key;
    }
    
    public void getTokenDb(){
        try {
            tokenTable =DB_CONNECTER.Exe_Qurey("SELECT * FROM Token");
        } catch (SQLException ex) {
            Logger.getLogger(MakeToken.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeToken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getKey(){
        String key="-";
        if(tokenTable.length==2) 
            key = tokenTable[1][1];
        return key;
    }
    
    public String getDate(){
        String date="-";
        if(tokenTable.length==2) 
            date = tokenTable[1][2];
        return date;
    }
    
    public boolean getExist(){
        boolean exist=true;
        if(tokenTable.length==2) 
            exist=false;
        return exist;
    }
}
