//Aemen Hussain- Group 4

package group4;
import stdlib.*;
import java.util.regex.*;


public class XMLToken {


private final String XMLToken; 

public XMLToken(String token){
	this.XMLToken= token;
}

public boolean isTag() {
	
if ( XMLToken.indexOf("<") == 0 && XMLToken.indexOf('>') == XMLToken.length() -1){
	if (XMLToken.substring(1,2).matches("[a-zA-Z0-9/-]+") && XMLToken.substring(XMLToken.length()-2,XMLToken.length()-1).matches("[a-zA-Z0-9/-]+")){
		if (XMLToken.substring(2,XMLToken.length()-2).matches("[a-zA-Z0-9-]+"))  {return true;}
		else {return false;}}
	else {return false;}}
else{return false;}}

		
public boolean isWord(){

	if ((XMLToken.charAt(0) != '<' && XMLToken.charAt(XMLToken.length() -1) != '>') || XMLToken.charAt(XMLToken.length() -2) =='/') {return true;}
	else{return false;}
}

public boolean isClosingTag(){
	if (XMLToken.indexOf("/")==1 && XMLToken.indexOf("<")==0) {return true;}
	else	{return false;}
}

public boolean isOpeningTag(){
	if (XMLToken.indexOf("/")!=1 && XMLToken.indexOf("<")==0 && XMLToken.indexOf("/")!=(XMLToken.length()-2))	{return true;}
	else 	{return false;}
}

public String tagName(){
	if ( XMLToken.indexOf("<") == 0 && XMLToken.indexOf('>') == XMLToken.length() -1){
	if (XMLToken.indexOf("/")==1 && XMLToken.indexOf("<")==0) {return XMLToken.substring(2,XMLToken.length()-1);}
	else{String NameTag=XMLToken.substring(1,XMLToken.length()-1);
	return (NameTag);}}
	
	else return (String)XMLToken;
	}
}
