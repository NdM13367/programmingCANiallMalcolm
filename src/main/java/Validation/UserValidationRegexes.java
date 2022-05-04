package Validation;

public class UserValidationRegexes
{
    public boolean checkTrainID(String trainID)
    {
        String trainIDRegex = "";

        if(!trainID.matches(trainIDRegex) || trainID.length() < 2)
        {
            System.out.println("The Train must be at least 2 characters followed by two number e.g RE14.");
            return false;
        }

        return true;
    }
}
