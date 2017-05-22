package Controller;

/**
 * Created by Tolda on 18-05-2017.
 */
public class ErrorHandler
{

    //Nichlas: validation if phone number contains anything other than Int values
    public static boolean IsAValidNumber(String phoneNumber)
    {
        try
        {
            Integer.parseInt(phoneNumber);
            System.out.println("Valid PhoneNumber");

            return false;
        }
        catch(Exception e)
        {
            System.out.println("inValid PhoneNumber");
            return true;
        }
    }

    //Nichlas: validation if name contains a integer
    public static boolean IsAValidName(String name)
    {
        boolean containsNumber = false;
        char chars[] = name.toCharArray(); //transform String to char array

        for (int i = 0; i < chars.length; i++) //for loop loops through char array
        {
            if(Character.isDigit(chars[i])) //checks if chars[i] is a number
            {
                System.out.println("Contains a number");
                return true;
            }
        }
        return  containsNumber;
    }


}
