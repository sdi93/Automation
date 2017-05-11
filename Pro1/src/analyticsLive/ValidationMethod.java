package analyticsLive;

public class ValidationMethod {
	
	public static boolean isValidString(String string) {
        if ( string == null || string.equals("") ) {
            return false;

        }
        return true;
    }

}
