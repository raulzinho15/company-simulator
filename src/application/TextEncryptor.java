package application;

public class TextEncryptor {

	private String text;
	
	private StringBuilder sb;

	public TextEncryptor(String text) {
		this.text = text;
	}
	
	public String encrypt() {
		String encryption = "";
		sb = new StringBuilder(text);
		for (int i = 0;i<sb.length();i++) {
			String character = Character.toString(sb.charAt(i));
			if (character.equals("q")) encryption += "E";
			else if (character.equals("Q")) encryption += "e";
			else if (character.equals("w")) encryption += "R";
			else if (character.equals("W")) encryption += "r";
			else if (character.equals("e")) encryption += "T";
			else if (character.equals("E")) encryption += "t";
			else if (character.equals("r")) encryption += "Y";
			else if (character.equals("R")) encryption += "y";
			else if (character.equals("t")) encryption += "U";
			else if (character.equals("T")) encryption += "u";
			else if (character.equals("y")) encryption += "I";
			else if (character.equals("Y")) encryption += "i";
			else if (character.equals("u")) encryption += "O";
			else if (character.equals("U")) encryption += "o";
			else if (character.equals("i")) encryption += "P";
			else if (character.equals("I")) encryption += "p";
			else if (character.equals("o")) encryption += "A";
			else if (character.equals("O")) encryption += "a";
			else if (character.equals("p")) encryption += "S";
			else if (character.equals("P")) encryption += "s";
			else if (character.equals("a")) encryption += "D";
			else if (character.equals("A")) encryption += "d";
			else if (character.equals("s")) encryption += "F";
			else if (character.equals("S")) encryption += "f";
			else if (character.equals("d")) encryption += "G";
			else if (character.equals("D")) encryption += "g";
			else if (character.equals("f")) encryption += "H";
			else if (character.equals("F")) encryption += "h";
			else if (character.equals("g")) encryption += "J";
			else if (character.equals("G")) encryption += "j";
			else if (character.equals("h")) encryption += "K";
			else if (character.equals("H")) encryption += "k";
			else if (character.equals("j")) encryption += "L";
			else if (character.equals("J")) encryption += "l";
			else if (character.equals("k")) encryption += "Z";
			else if (character.equals("K")) encryption += "z";
			else if (character.equals("l")) encryption += "X";
			else if (character.equals("L")) encryption += "x";
			else if (character.equals("z")) encryption += "C";
			else if (character.equals("Z")) encryption += "c";
			else if (character.equals("x")) encryption += "V";
			else if (character.equals("X")) encryption += "v";
			else if (character.equals("c")) encryption += "1";
			else if (character.equals("C")) encryption += "2";
			else if (character.equals("v")) encryption += "3";
			else if (character.equals("V")) encryption += "4";
			else if (character.equals("b")) encryption += "5";
			else if (character.equals("B")) encryption += "6";
			else if (character.equals("n")) encryption += "7";
			else if (character.equals("N")) encryption += "8";
			else if (character.equals("m")) encryption += "9";
			else if (character.equals("M")) encryption += "0";
			else if (character.equals("1")) encryption += ",";
			else if (character.equals("2")) encryption += ".";
			else if (character.equals("3")) encryption += "%";
			else if (character.equals("4")) encryption += "^";
			else if (character.equals("5")) encryption += "&";
			else if (character.equals("6")) encryption += "*";
			else if (character.equals("7")) encryption += "(";
			else if (character.equals("8")) encryption += ")";
			else if (character.equals("9")) encryption += "!";
			else if (character.equals("0")) encryption += "@";
			else if (character.equals(".")) encryption += "#";
			else if (character.equals(",")) encryption += "$";
			else if (character.equals("!")) encryption += "B";
			else if (character.equals("@")) encryption += "b";
			else if (character.equals("#")) encryption += "N";
			else if (character.equals("$")) encryption += "n";
			else if (character.equals("%")) encryption += "M";
			else if (character.equals("^")) encryption += "m";
			else if (character.equals("&")) encryption += "Q";
			else if (character.equals("*")) encryption += "q";
			else if (character.equals("(")) encryption += "W";
			else if (character.equals(")")) encryption += "w";
			else encryption += character;
		}
		this.text = encryption;
		return text;
	}
	
	public String encrypt(int times) {
		for (int i=0;i<times;i++) {
			encrypt();
		}
		return text;
	}
	
	public String decrypt() {
		String decryption = "";
		if (text != null) {
			sb = new StringBuilder(text);
			for (int i = 0;i<sb.length();i++) {
				String character = Character.toString(sb.charAt(i));
				if (character.equals("E")) decryption += "q";
				else if (character.equals("e")) decryption += "Q";
				else if (character.equals("R")) decryption += "w";
				else if (character.equals("r")) decryption += "W";
				else if (character.equals("T")) decryption += "e";
				else if (character.equals("t")) decryption += "E";
				else if (character.equals("Y")) decryption += "r";
				else if (character.equals("y")) decryption += "R";
				else if (character.equals("U")) decryption += "t";
				else if (character.equals("u")) decryption += "T";
				else if (character.equals("I")) decryption += "y";
				else if (character.equals("i")) decryption += "Y";
				else if (character.equals("O")) decryption += "u";
				else if (character.equals("o")) decryption += "U";
				else if (character.equals("P")) decryption += "i";
				else if (character.equals("p")) decryption += "I";
				else if (character.equals("A")) decryption += "o";
				else if (character.equals("a")) decryption += "O";
				else if (character.equals("S")) decryption += "p";
				else if (character.equals("s")) decryption += "P";
				else if (character.equals("D")) decryption += "a";
				else if (character.equals("d")) decryption += "A";
				else if (character.equals("F")) decryption += "s";
				else if (character.equals("f")) decryption += "S";
				else if (character.equals("G")) decryption += "d";
				else if (character.equals("g")) decryption += "D";
				else if (character.equals("H")) decryption += "f";
				else if (character.equals("h")) decryption += "F";
				else if (character.equals("J")) decryption += "g";
				else if (character.equals("j")) decryption += "G";
				else if (character.equals("K")) decryption += "h";
				else if (character.equals("k")) decryption += "H";
				else if (character.equals("L")) decryption += "j";
				else if (character.equals("l")) decryption += "J";
				else if (character.equals("Z")) decryption += "k";
				else if (character.equals("z")) decryption += "K";
				else if (character.equals("X")) decryption += "l";
				else if (character.equals("x")) decryption += "L";
				else if (character.equals("C")) decryption += "z";
				else if (character.equals("c")) decryption += "Z";
				else if (character.equals("V")) decryption += "x";
				else if (character.equals("v")) decryption += "X";
				else if (character.equals("1")) decryption += "c";
				else if (character.equals("2")) decryption += "C";
				else if (character.equals("3")) decryption += "v";
				else if (character.equals("4")) decryption += "V";
				else if (character.equals("5")) decryption += "b";
				else if (character.equals("6")) decryption += "B";
				else if (character.equals("7")) decryption += "n";
				else if (character.equals("8")) decryption += "N";
				else if (character.equals("9")) decryption += "m";
				else if (character.equals("0")) decryption += "M";
				else if (character.equals(",")) decryption += "1";
				else if (character.equals(".")) decryption += "2";
				else if (character.equals("%")) decryption += "3";
				else if (character.equals("^")) decryption += "4";
				else if (character.equals("&")) decryption += "5";
				else if (character.equals("*")) decryption += "6";
				else if (character.equals("(")) decryption += "7";
				else if (character.equals(")")) decryption += "8";
				else if (character.equals("!")) decryption += "9";
				else if (character.equals("@")) decryption += "0";
				else if (character.equals("#")) decryption += ".";
				else if (character.equals("$")) decryption += ",";
				else if (character.equals("B")) decryption += "!";
				else if (character.equals("b")) decryption += "@";
				else if (character.equals("N")) decryption += "#";
				else if (character.equals("n")) decryption += "$";
				else if (character.equals("M")) decryption += "%";
				else if (character.equals("m")) decryption += "^";
				else if (character.equals("Q")) decryption += "&";
				else if (character.equals("q")) decryption += "*";
				else if (character.equals("W")) decryption += "(";
				else if (character.equals("w")) decryption += ")";
				else decryption += character;
			}
			this.text = decryption;
			return text;
		} else return null;
	}
	
	public String decrypt(int times) {
		for (int i=0;i<times;i++) {
			decrypt();
		}
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
