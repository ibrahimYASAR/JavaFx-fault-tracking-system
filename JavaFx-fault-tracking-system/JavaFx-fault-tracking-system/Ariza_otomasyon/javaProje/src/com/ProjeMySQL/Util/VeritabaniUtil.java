package com.ProjeMySQL.Util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
public class VeritabaniUtil {


	static Connection connection =null;
	
	
	public static Connection Baglan() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projem","root","mysql");
			return connection;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return null;
		}
		
		
	}
	public static String LoginSifre(String icerik) {
		try {
			MessageDigest MD=MessageDigest.getInstance("MD5");
			byte[] sifreli= MD.digest(icerik.getBytes());
			BigInteger no=new BigInteger(1,sifreli);
			String ichas=no.toString(16);
			while (ichas.length()<32) {
				ichas="0"+ichas;
				
				
			}
			return ichas;
		} 
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
}
