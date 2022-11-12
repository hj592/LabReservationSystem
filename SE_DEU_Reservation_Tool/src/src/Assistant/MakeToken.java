package src.Assistant;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 토큰 생성 클래스
 * @author heejin
 */
public class MakeToken {
    String[][] tokenTable ;

    public MakeToken() {
        getTokenDb();
    }
    
    public String getToken(){ // 토큰 생성
        char[] token = new char[6];
        String key="";
        int tmp=0;        
        
        for (int i = 0 ; i < token.length ; i++){
            int type = (int)(Math.random()*3); //해당 위치 숫자/대문자/소문자 구분
            switch (type) {
            //숫자면 아스키코드48~57
                case 0:
                    tmp =ThreadLocalRandom.current().nextInt(48, 57);
                    break;
            //대문자면 아스키코드65~90사이의수
                case 1:
                    tmp = ThreadLocalRandom.current().nextInt(65, 90);
                    break;
                default:
                    //소문자면 아스키코드 97~122사이의수
                    tmp =ThreadLocalRandom.current().nextInt(97, 122);
                    break;
            }
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
        if(tokenTable.length!=1) 
            key = tokenTable[1][1];
        return key;
    }
    
    public String getDate(){
        String date="-";
        if(tokenTable.length!=1) 
            date = tokenTable[1][2];
        return date;
    }
    
    public boolean getExist(){
        boolean exist=true;
        if(tokenTable.length!=1) 
            exist=false;
        return exist;
    }
}
