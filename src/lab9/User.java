/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;
import java.time.LocalDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bassam
 */
public class User {
    private String userId;
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String status;
 public void hashPassword(){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[]hashBytes=digest.digest(password.getBytes());
            String hexString="";
            for(byte bytes:hashBytes){
                String hex=Integer.toHexString(0xff & bytes);
                if(hex.length()==1)hexString+="0";
                hexString+=hex;
            }
            password=hexString;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
