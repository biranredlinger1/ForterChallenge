package UniqueNamesCounter;

import java.util.HashMap;
import java.util.HashSet;

public class CountNames {
    HashMap<String, HashSet<String>> names=null;

    public int countUniqueNames(String billFirstName, String billLastName, String shipFirstName, String shipLastName, String billNameOnCard) {
        int UniqueNames = 1;
        billFirstName = billFirstName.toLowerCase();//to support case sensitive
        billLastName = billLastName.toLowerCase();
        shipFirstName = shipFirstName.toLowerCase();
        shipLastName = shipLastName.toLowerCase();
        billNameOnCard = billNameOnCard.toLowerCase();
        names = KeyValuesParser.Parse("names.csv");//parsing from nicknames file
        String BillFname = billFirstName.split("\\s+")[0];//get rid of middle names
        String ShipFname = shipFirstName.split("\\s+")[0];//get rid of middle names
        String[] splited = billNameOnCard.split("\\s+");//array that contains the first and last billNameOnCard
        String NameOnCardFirstParameter;//contains the first parameter in billNameOnCard(first or last name)
        String NameOnCardSecParameter;//contains the second parameter in billNameOnCard(first or last name)
        if (splited.length == 3) {//the billNameOnCard contains a middle name
            NameOnCardFirstParameter = splited[0];
            NameOnCardSecParameter = splited[2];
        } else {
            NameOnCardFirstParameter = splited[0];
            NameOnCardSecParameter = splited[1];
        }
        if (!SameFname(BillFname, ShipFname) || !SameLname(billLastName, shipLastName)) //Compares bill name and ship name
            UniqueNames++;
        //Checks if the "NameOnCard" is unique,supports last name before first name
        if (!(SameFname(NameOnCardFirstParameter, BillFname) && SameLname(NameOnCardSecParameter, billLastName))
                && !(SameFname(NameOnCardFirstParameter, ShipFname) && SameLname(NameOnCardSecParameter, shipLastName))
                && !(SameFname(NameOnCardSecParameter, BillFname) && SameLname(NameOnCardFirstParameter, billLastName))
                && !(SameFname(NameOnCardSecParameter, ShipFname) && SameLname(NameOnCardFirstParameter, shipLastName)))
            UniqueNames++;
        return UniqueNames;
    }

    public boolean SameFname(String f1, String f2) {//Compares first names(Supports typos and nickname)
        HashSet<String> values1 = new HashSet<String>();
        HashSet<String> values2 = new HashSet<String>();
        if (f1.equals(f2))
            return true;
        if (LevenshteinDistance.LDistance(f1, f2) <= 1)//if its typo(very similar names)
            return true;
        values1 = names.get(f1);
        values2 = names.get(f2);
        if (values1 != null && values2 != null)
            if (values1.contains(f2) || values2.contains(f1))//If one is the nickname of the other
                return true;
        return false;
    }

    public boolean SameLname(String l1, String l2) {//Compares last names(Supports typos)
        if (l1.equals(l2))
            return true;
        if (LevenshteinDistance.LDistance(l1, l2) <= 1)//if its typo(very similar names)
            return true;
        return false;
    }
}
