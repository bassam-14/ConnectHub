/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bassam
 */
public class PasswordHash {
     public String hashPassword(String pass){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[]hashBytes=digest.digest(pass.getBytes());
            String hexString="";
            for(byte bytes:hashBytes){
                String hex=Integer.toHexString(0xff & bytes);
                if(hex.length()==1)hexString+="0";
                hexString+=hex;
            }
           String password=hexString;
           return password;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
 }
}
