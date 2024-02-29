import java.util.*;
class MorseCodeTrans
{
	public static String textToMorse(String text)throws Exception
	{
		int i;
		String morseCode="";
		for(i=0;i<text.length();i++)
		{
			char cha= Character.toUpperCase(text.charAt(i));
			String morseChar= charToMorse(cha);
			if(morseChar !=null)
			{
				morseCode =morseCode+morseChar+" ";
			}
			else
			{
				morseCode=morseCode+" ";
			}
		}
		return morseCode;
	}
	private static String charToMorse(char ch)throws Exception
	{
		switch(ch)
		{
			case 'A': return ".-";
			case 'B': return "-...";
           		case 'C': return "-.-.";
            		case 'D': return "-..";
            		case 'E': return ".";
            		case 'F': return "..-.";
            		case 'G': return "--.";
            		case 'H': return "....";
            		case 'I': return "..";
            		case 'J': return ".---";
            		case 'K': return "-.-";
            		case 'L': return ".-..";
            		case 'M': return "--";
            		case 'N': return "-.";
            		case 'O': return "---";
            		case 'P': return ".--.";
            		case 'Q': return "--.-";
            		case 'R': return ".-.";
            		case 'S': return "...";
            		case 'T': return "-";
            		case 'U': return "..-";
            		case 'V': return "...-";
            		case 'W': return ".--";
            		case 'X': return "-..-";
            		case 'Y': return "-.--";
            		case 'Z': return "--..";
            		case '1': return ".----";
            		case '2': return "..---";
            		case '3': return "...--";
            		case '4': return "....-";
            		case '5': return ".....";
            		case '6': return "-....";
            		case '7': return "--...";
            		case '8': return "---..";
            		case '9': return "----.";
            		case '0': return "-----";
            		case '.': return ".-.-.-";
            		case ',': return "--..--";
            		case '?': return "..--..";
            		case ' ': return "/";
            		default: return null;	
		}
	}
	public static String morseToText(String morseCode)throws Exception
	{
		String text="";
		String[] morseWords= morseCode.split("  ");
		for(String morseWord : morseWords)
		{
			String[] morseChars=morseWord.split(" ");
			for(String morseChar : morseChars)
			{
				char textChar= morseToChar(morseChar);
				text= text+textChar;
			}
			text=text+" ";
		}
		return text.trim();
	}
	private static char morseToChar(String morseCh)throws Exception
	{
		switch(morseCh)
		{
			case ".-": return 'A';
            		case "-...": return 'B';
            		case "-.-.": return 'C';
            		case "-..": return 'D';
            		case ".": return 'E';
            		case "..-.": return 'F';
            		case "--.": return 'G';
            		case "....": return 'H';
            		case "..": return 'I';
            		case ".---": return 'J';
            		case "-.-": return 'K';
            		case ".-..": return 'L';
            		case "--": return 'M';
            		case "-.": return 'N';
            		case "---": return 'O';
            		case ".--.": return 'P';
            		case "--.-": return 'Q';
            		case ".-.": return 'R';
            		case "...": return 'S';
            		case "-": return 'T';
            		case "..-": return 'U';
            		case "...-": return 'V';
            		case ".--": return 'W';
            		case "-..-": return 'X';
            		case "-.--": return 'Y';
            		case "--..": return 'Z';
            		case ".----": return '1';
            		case "..---": return '2';
            		case "...--": return '3';
            		case "....-": return '4';
            		case ".....": return '5';
            		case "-....": return '6';
            		case "--...": return '7';
            		case "---..": return '8';
            		case "----.": return '9';
            		case "-----": return '0';
            		case ".-.-.-": return '.';
            		case "--..--": return ',';
            		case "..--..": return '?';
            		case "/": return ' ';
            		default: return '\0';
		}
	}
	public static void main(String args[])throws Exception
	{
		Scanner s= new Scanner(System.in);
		System.out.println("Morse Code Translator");
		System.out.println("1.Text to Morse Code:");
		System.out.println("2.Morse Code to Text:");
		System.out.println("Your choice(1,2):");
		int ch=s.nextInt();
		s.nextLine();
		switch(ch)
		{
			case 1:
				System.out.print("Enter the Text: ");
				String t= s.nextLine();
				String mresult=textToMorse(t);
				System.out.println("Morse Code: "+mresult);
				break;
			case 2:
				System.out.print("Enter the Morse Code: ");
				String m=s.nextLine();
				String tresult=morseToText(m);
				System.out.println("Text: "+tresult);
				break;
			default:
				System.out.println("Invalid Choice...Choice either 1 or 2.");
		}
	}
}