import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class FarmSim {

    int farmId;
    int customerId;
    String journey = "";

    FarmSim() {

        farmId = (int)(Math.random() * 8999 + 1000);//(int)(Math.round((Math.random() * 8999) + 1000));
        customerId = (int)(Math.random() * 8999 + 1000);//(int)(Math.round((Math.random() * 8999) + 1000));
    }

    FarmSim(int frmId , int custmerId) {

        farmId = frmId;
        customerId = custmerId;
    }

    private void truck(int journeyTime) {

        int randSeed = (int)(Math.random() * 100);
        journeyTime = (int)(Math.random() * 20 + journeyTime);
        String out = "";

        if(randSeed >= 90) {

            out += ", BreakDown";
            journeyTime += (int)(Math.random() * 60 + 60);
        }
        if(randSeed <= 10) {

            out += ", TempFailure";
        }

        out = "T" + journeyTime + out + "\n";
    }

    public void initJourney() {

        journey += "start\n";
        journey += "FarmID: \"" + farmId + "\"\n";
        journey += "Shipped: \"Farm\"\n";
        truck(180);
        journey += "Arrived: \"Co-Op\"\n";
        journey += "Time: \"10080\"\n";
        journey += "Shipped: \"Co-Op\"\n";
        truck(720);
        journey += "Arrived: \"Distributor\"\n";
        journey += "Time: \"10080\"\n";
        journey += "Shipped: \"Distributor\"\n";
        truck(180);
        journey += "Arrived: \"GenericStore\"\n";
        journey += "Time: \"10080\"\n";
        journey += "Bought: \"" + customerId + "\"\n";
        journey += "end\n";
    }

    public String getJourney() {

        return journey;
    }

    public void outputDataFile(String data) throws IOException {

        File file = new File("./ProductData.hackathon");
        FileWriter out = new FileWriter(file, true);
        out.append(journey);
        out.close();
    }
}
