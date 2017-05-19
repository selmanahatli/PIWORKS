package PIWorks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Selman Ahatlı on 15.05.2017.
 */
public class Data {

    public ArrayList<Client> Clients;
    public ArrayList<Distinct> Distincs;

    public Data() {

        Clients = new ArrayList<Client>();
        Distincs = new ArrayList<Distinct>();
    }

    public void readFile(String fileName) throws IOException {

        int index;

        String Play_Id;
        int Song_Id;
        int Client_Id;
        String Date;

        String splitLine = "\t";
        String splitPlay_Ts = " ";

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();

        while (((line = br.readLine()) != null)) {
            String[] temp = line.split(splitLine);

            Play_Id = temp[0];
            Song_Id = Integer.parseInt(temp[1]);
            Client_Id = Integer.parseInt(temp[2]);
            String[] Play_Ts = temp[3].split(splitPlay_Ts);

            Date = Play_Ts[0];

            if (Date.compareTo("10/08/2016") == 0) {
                for (index = 0; index < Clients.size(); ++index) {
                    if (Client_Id == Clients.get(index).Client_Id) {
                        break;
                    }
                }

                if (index == Clients.size()) {
                    Clients.add(new Client(Client_Id, Song_Id));
                } else {
                    Clients.get(index).Distinct_Songs.add(Song_Id);
                }
            }
        }
        br.close();

        for (int i = 0; i < Clients.size(); ++i) {
            for (index = 0; index < Distincs.size(); ++index) {
                if (Clients.get(i).Distinct_Songs.size() == Distincs.get(index).Distinct_Song)
                    break;
            }

            if (index == Distincs.size())
                Distincs.add(new Distinct(Clients.get(i).Distinct_Songs.size()));
            else
                Distincs.get(index).Client_Count++;
        }
    }

    public void print() {

        System.out.print("DISTINCT_PLAY_COUNT - ");
        System.out.println("CLIENT_COUNT");

        for (int i = 0; i < Distincs.size(); ++i) {
            System.out.print(Distincs.get(i).Distinct_Song);
            System.out.print(" - ");
            System.out.println(Distincs.get(i).Client_Count);
        }
    }

    public void findMax() {
        Distinct max = new Distinct(0);

        for (int i = 0; i < Distincs.size(); ++i) {
            if (Distincs.get(i).Distinct_Song > max.Distinct_Song)
                max = Distincs.get(i);
        }

        System.out.println("Max = " + max.Distinct_Song);
    }
}
