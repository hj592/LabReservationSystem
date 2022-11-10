/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Assistant;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author heejin
 */
public class MakeToken {
    public static String getToken(){
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
}
