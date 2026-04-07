public class ProblemSet {

	public static void main(String args[]) {
        validateMultipleEmails("tom@school.com, jerry@gmail.com, wrongemail");
	}
public static String validateEmail(String email) {

	int atPos = email.indexOf("@");
        if (atPos == -1) {
            return "Invalid";
		}

	int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        if (count > 1) {
            return "Invalid";
        }

	String local = email.substring(0, atPos);
    String domain = email.substring(atPos + 1);

	if (atPos == 0 || atPos == email.length() - 1) {
            return "Invalid";
        }

	if (local.contains(" ") || domain.contains(" ")) {
            return "Invalid";
        }
	
	if (local.length() < 1 || local.length() > 64) {
            return "Invalid";
	    }

	if (domain.indexOf(".") == -1) {
            return "Invalid";
        }

	int dotPos = domain.lastIndexOf(".");
        String end = domain.substring(dotPos + 1);
        if (end.length() < 2 || end.length() > 6) {
            return "Invalid";
        }

        return "Valid";
    }

	public static String validateEmailAdvanced(String email) {
        email = email.trim();

        if (email.endsWith("@gmail")) {
            email = email + ".com";
        }
        if (email.endsWith("@school")) {
            email = email + ".com";
        }

        return validateEmail(email);
    }

	public static void validateMultipleEmails(String emails) {
        String[] array = emails.split(",");

        for (int i = 0; i < array.length; i++) {
            String e = array[i].trim();
            String res = validateEmailAdvanced(e);
            System.out.println(e + " -> " + res);
        }
    }
}
