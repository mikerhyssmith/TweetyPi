package com.TweetyPi.PyTwitter.UserInterface;

public class TextProcessor {
	
	private String headline;
	private String formattedHeadline = "";
	private int characterLimit;
	
	
	public TextProcessor(String headline, int characterLimit){
		this.headline = headline;
		this.characterLimit = characterLimit;
		
		
	}
	
	public String getFormattedHeadline(){
		
		String[] splitStr = headline.split("\\s+");
		String currentLine = "";
		formattedHeadline = formattedHeadline + splitStr[0];
		currentLine = currentLine + formattedHeadline;
		for(int i =1; i < splitStr.length; i ++){
			String tempLine = currentLine + splitStr[i];
			
			if(tempLine.length() < characterLimit-1){
				formattedHeadline = formattedHeadline + " " + splitStr[i];
				currentLine = tempLine;
				
			}else{
				tempLine = "";
				String newLine = System.getProperty("line.separator");
				formattedHeadline = formattedHeadline + newLine + splitStr[i];
				currentLine = splitStr[i];

			}
		}
		
		
		return formattedHeadline;
	}
	
	public static void main(String[] args){
		String testString = ("Hello My Name Is Mike how are you today potato pie etc cake");
		TextProcessor tp = new TextProcessor(testString,44);
		String returned = tp.getFormattedHeadline();
		System.out.println(returned);
	}

}
