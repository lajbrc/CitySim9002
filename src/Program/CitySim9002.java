/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;
import java.util.*;
/**
 *
 * @author lajbrc_Jinrong Liu
 * 
 */
public class CitySim9002 {
    
    public static void main(String[] args){
		int seed = 0;
		if(new Validator().validateArguments(args)){
			seed = Integer.parseInt(args[0]);
			System.out.println("Welcome to CitySim! Your seed is "+seed+".");
		}
		else{
			System.out.println("Please enter one integer argument, seed");
			return;
		}
		
		Random rand = new Random(seed);
		for(int i=1; i<=5; i++){//5 visitors
			int vid = rand.nextInt(4)+1;
			String who = Visitor(vid);
			System.out.println("Visitor "+i+" is a "+who+".");
			int lid = rand.nextInt(4)+1;
			String likeornot = null;
			String where = null;
			while (lid != 5){
				where = Location(lid);
				likeornot = Preference(vid, lid);
				lid = rand.nextInt(5)+1;
				System.out.println("Visitor "+i+" is going to "+where+"!");
				System.out.println("Visitor "+i+" "+likeornot+" "+where+".");
			}
			System.out.println("Visitor "+i+" has left the city.");
			System.out.println("***");
		}
		
	}
	
	public static String[] Visitors = {"Student", "Professor", "BusinessPerson", "Blogger"};
	public static String[] Locations = {"The Cathedral of Learning", "Squirrel Hill", "The Point", "Downtown"};
	
	public static String Visitor(int n){
		if(n==1)
			return Visitors[0];
		if(n==2)
			return Visitors[1];
		if(n==3)
			return Visitors[2];
		else
			return Visitors[3];
	}
	
	public static String Location(int n){
		if(n==1)
			return Locations[0];
		if(n==2)
			return Locations[1];
		if(n==3)
			return Locations[2];
		else
			return Locations[3];
	}
	
	public static String Preference(int n, int m){
		if(n==1)//student
			if(m==1)
				return "did not like";
			else
				return "did like";
		if(n==2)//professor
			return "did like";
		if(n==3)//businessperson
			if(m==1||m==3)
				return "did not like";
			else
				return "did like";
		else//blogger
			return "did not like";
	}
     
}
