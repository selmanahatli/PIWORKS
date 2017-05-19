package PIWorks;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Data data = new Data();

        data.readFile("exhibitA-input.csv");
        data.print();
        data.findMax();
    }
}
