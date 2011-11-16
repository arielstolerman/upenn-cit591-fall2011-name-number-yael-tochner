package nameNumber;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    /**
     * 
     * @author yael Tochner
     *
     */
public class NameNumber {
	Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NameNumber().run();
	}

	void run() {
		String line;
		System.out.println("Program written by Yael Tochner.");
		do {
			System.out.print("Type something (*end* to quit): ");
			line = scanner.nextLine();
			line = numbersToWords(line);
			System.out.println(line);
		} while (!(line.equals("*end*")));
		System.out.println("Goodbye.");
	}


    // Replaces each sequence of digits in text with the corresponding English words.
	/**
	 * @param text 
	 */
    String numbersToWords(String text) {
        int n;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(text);
        while (m.find()) {
            n = Integer.parseInt(m.group());
            text = text.replaceFirst("\\d+", nameOf(n));
        }
        text = text.trim();
        return text;
    }


    /*Given any number in the range 0 to 9999, returns the word or words representing that number.
        Words in the string are separated by exactly one space;
        the returned string does not begin or end with a space.
     */
    String nameOf(int number) { //throws Exception {
        String answer = "";

        if (0 <= number && number <= 9) {
            answer =  nameOfDigit(number);

        } 
        else if (10 <= number && number <= 19) {
            answer =  nameOfTeens(number);

        }
        else if (20 <= number && number <= 99) {
            answer = nameOfTensDigit(number / 10);
            int unitsDigit = number % 10;
            if (unitsDigit != 0) {
                answer += " " + nameOfDigit(unitsDigit);
            }

        }
        else if (100 <= number && number <= 999) {
            int hundredsDigit = number / 100;
            answer = nameOfDigit(hundredsDigit) + " hundred";
            int restOfNumber1 = number % 100;
            if (restOfNumber1 != 0) {
                answer += " " + nameOf(restOfNumber1);
            }

        }
        else if (1000 <= number && number <= 9999) {
            int thousandsDigit = number / 1000;
            answer = nameOfDigit(thousandsDigit) + " thousand";
            int restOfNumber2 = number % 1000;
            if (restOfNumber2 != 0) {
                answer += " " + nameOf(restOfNumber2);
            }
        } else {
        	// if the number is < 0 or > 9999, leave it as digits
        	answer = "" + number;
        }

        return answer;
    }

    /*Given any number in the range 0 to 9, returns a single word representing that number 
        (zero through nine).
     */
    String nameOfDigit(int number) {
        String name = null;
        switch (number) {
        case 0: name = "zero";          break;
        case 1: name = "one";           break;
        case 2: name = "two";           break;
        case 3: name = "three";         break;
        case 4: name = "four";          break;
        case 5: name = "five";          break;
        case 6: name = "six";           break;
        case 7: name = "seven";         break;
        case 8: name = "eight";         break;
        case 9: name = "nine";          break;
        }
        return name;
    }

    /*Given any number in the range 1 to 9, returns a word representing that number of tens. 
         That is, this method returns one of the words ten, twenty, thirty, ..., ninety.
     */
    String nameOfTensDigit(int number) {
        String name = null;
        switch (number) {
        case 1: name = "ten";            break;
        case 2: name = "twenty";         break;
        case 3: name = "thirty";         break;
        case 4: name = "forty";          break;
        case 5: name = "fifty";          break;
        case 6: name = "sixty";          break;
        case 7: name = "seventy";        break;
        case 8: name = "eighty";         break;
        case 9: name = "ninety";         break;
        }
        return name;
    }

    /*Given any number in the range 10 to 19, returns a word representing that number. 
     * That is, this method returns one of the words ten, eleven, twelve, ..., nineteen.*/
    String nameOfTeens(int number) {
        String name = null;
        switch (number) {
        case 10: name = "ten";           break;
        case 11: name = "eleven";        break;
        case 12: name = "twelve";        break;
        case 13: name = "thirteen";      break;
        case 14: name = "fourteen";      break;
        case 15: name = "fifteen";       break;
        case 16: name = "sixteen";       break;
        case 17: name = "seventeen";     break;
        case 18: name = "eighteen";      break;
        case 19: name = "nineteen";      break;
        }
        return name;
    }
}
