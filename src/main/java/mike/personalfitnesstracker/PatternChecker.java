package mike.personalfitnesstracker;

public class PatternChecker {

    /**
     * isCorrectEmail - method that checks if the user's selected email corresponds to an appropriate email. Within
     * this program, an email must contain a local part followed by the '@' symbol. Additionally, the domain name and
     * top-level domain must be present.
     * @param: email - the user inputted email
     * @return: true if the email is allowed, false otherwise
     */
    public static boolean isCorrectEmail(String email) {
        return email.matches("[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,4}");
    }

    /**
     * isCorrectFirstName - method that checks if the user's selected first name corresponds to an appropriate first
     * name. Within this program, a first name must start with a capital letter and can contain any number of letters
     * after the first. Additionally, if a '-' or apostrophe is used, a character must follow.
     * @param: firstName - the user inputted first name
     * @return: true if the first name is allowed, false otherwise
     */
    public static boolean isCorrectFirstName(String firstName) {
        return firstName.matches("^[A-Z][a-zA-Z]*(['-][a-zA-Z]+)*$");
    }

    /**
     * isCorrectLastName - method that checks if the user's selected last name corresponds to an appropriate last
     * name. Within this program, a last name must start with a capital letter and can contain any number of letters
     * after the first.
     * @param: lastName - the user inputted last name
     * @return: true if the last name is allowed, false otherwise
     */
    public static boolean isCorrectLastName(String lastName) {
        return lastName.matches("^[A-Z][a-zA-Z]*[-']?$");
    }

    /**
     * isCorrectWeight - method that checks if the user's selected weight is correctly formatted as a decimal. Within
     * this program, a user's weight will be measured in pounds (Ibs.).
     * @param: weight - the user inputted weight
     * @return: true if the user's input is formated as a decimal number, false otherwise
     */
    public static boolean isCorrectWeight(String weight) {
        return weight.matches("^\\d*\\.?\\d{1,2}$");
    }

    /**
     * isValidPassword - method that checks if a valid password is set for the user's account.
     * ^ represents the start of the string
     * (?=.*[0-9]) represents a digit must occur at least once
     * (?=.*[a-z]) represents a lower case letter must occur at least once
     * (?=.*[A-Z]) represents an upper case letter that must occur at least once
     * (?=.*[@#$%^&-+=]) represents a special character that must occur at least once
     * (?=\S+$) does not allow any form of whitespace to occur within the string
     * .{8,20} represents a minimum of 8 characters and at most 20
     * $ represents the end of the string
     * @param: password - the user's inputted password
     * @return: true if the user's password is valid, false otherwise
     */
    public static boolean isValidPassword(String password) {

        //local variable that represents the regex being used
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&-+=])"
                + "(?=\\S+$).{8,20}$";

        //return results to user
        return password.matches(regex);
    }

    /**
     * isValidUsername - method that checks if the user's selected username corresponds to an appropriate username. Within
     * this program, a username must have a length between 6-30 characters. Additionally, a username is allowed to have
     * an '_' present.
     * @param: username - the user inputted username
     * @return: true if the username is allowed, false otherwise
     */
    public static boolean isValidUsername(String username) {
        return username.matches("^[A-Za-z]\\w{5,29}$");
    }

    /**
     * isValidFeet -
     * @param: height -
     * @return:
     */
    public static boolean isValidFeet (String feet) {

        return feet.matches("^[4-8]$");
    }

    /**
     * isValidFeet -
     * @param: height -
     * @return:
     */
    public static boolean isValidInches (String inches) {

        return inches.matches("^([0-9]|1[0-1])$");
    }

    /**
     * isValidAge - method that checks if the user's selected age corresponds to a valid integer number.
     * @param: age - the user's inputted age
     * @return: true if it is a valid int, false otherwise
     */
    public static boolean isValidAge (String age){
        return age.matches("^[0-9]{1,2}$");
    }

    /**
     * isValidDate - method that checks if the user's inputted date is a valid date. For this project, the format of
     * 'dd/mm/yyyy' will be used
     * @param: date - the user's inputted date
     * @return: true if it is a valid date, false otherwise
     */
    public static boolean isValidDate (String date){
        return date.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
    }
}
