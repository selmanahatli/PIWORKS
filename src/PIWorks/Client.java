package PIWorks;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Selman Ahatlı on 15.05.2017.
 */
public class Client {

    public int Client_Id;
    public Set<Integer> Distinct_Songs;

    public Client(int client_Id,int song_Id) {
        Client_Id = client_Id;

        Distinct_Songs = new TreeSet<Integer>();
        Distinct_Songs.add(song_Id);
    }
}
