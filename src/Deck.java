
import java.util.Random;
public class Deck {
    
    private static String[] roomCards;
    private static String[] suspectCards;
    private static String[] weaponCards;
    private static String[] confidentialCards;
    
    //initializes cards
    Deck()
    {
        roomCards = new String[9];
        roomCards[0] = "Conservatory";
        roomCards[1] = "Library";
        roomCards[2] = "Study";
        roomCards[3] = "Ballroom";
        roomCards[4] = "Billiard Room";
        roomCards[5] = "Hall";
        roomCards[6] = "Kitchen";
        roomCards[7] = "Dining Room";
        roomCards[8] = "Lounge";
        
        suspectCards = new String[6];
        suspectCards[0] = "Mrs Scarlet";
        suspectCards[1] = "Prof Plumb";
        suspectCards[2] = "Mrs Peacock";
        suspectCards[3] = "Mr Green";
        suspectCards[4] = "Mrs White";
        suspectCards[5] = "Col Mustard";
        
        weaponCards = new String[6];
        weaponCards[0] = "Knife";
        weaponCards[1] = "Rope";
        weaponCards[2] = "Wrench";
        weaponCards[3] = "Candle Stick";
        weaponCards[4] = "Revolver";
        weaponCards[5] = "Lead Pipe";
    }
    
    String[] getRoomCards()
    {
        return roomCards;
    }
    
    String getRoomCard(int i)
    {
        return roomCards[i];
    }
    
    void removeRoomCard(int index)
    {
        roomCards[index] = "null";
    }
    
    String[] getSuspectCards()
    {
        return suspectCards;
    }
    
    String getSuspectCard(int i)
    {
        return suspectCards[i];
    }
    
    void removeSuspectCard(int index)
    {
        suspectCards[index] = "null";
    }
    
    String[] getWeaponCards()
    {
        return weaponCards;
    }
    
    String getWeaponCard(int i)
    {
        return weaponCards[i];
    }
    
    void removeWeaponCard(int index)
    {
        weaponCards[index] = "null";
    }
    
    //picks one of each type of card for the confidential folder, removes cards from deck
    void setConfidentialCards()
    {
        Random rand = new Random();
        confidentialCards = new String[3];
        int x = rand.nextInt(9);
        int y = rand.nextInt(6);
        int z = rand.nextInt(6);
        confidentialCards[0] = roomCards[x];
        roomCards[x] = "null";
        confidentialCards[1] = suspectCards[y];
        suspectCards[y] = "null";
        confidentialCards[2] = weaponCards[z];
        weaponCards[3] = "null";
    }
    
    String[] getConfidentialCards()
    {
        return confidentialCards;
    }
    
    String getConfidentialCard(int i)
    {
        return confidentialCards[i];
    }
    
    
}