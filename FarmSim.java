import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class FarmSim {

    int farmId;
    int customerId;
    String journey = "";
    String colorId;

    FarmSim() {

        farmId = (int)(Math.random() * 8999 + 1000);//(int)(Math.round((Math.random() * 8999) + 1000));
        customerId = (int)(Math.random() * 8999 + 1000);//(int)(Math.round((Math.random() * 8999) + 1000));
        colorId = randColors();
    }

    FarmSim(int frmId , int custmerId, String colorI) {

        farmId = frmId;
        customerId = custmerId;
        colorId = colorI;
    }

    private String randColors() {

        String out = "";

        int randNum = (int)(Math.random() * 5);
        
        switch(randNum) {

            case 0:
                out += "red";
                break;
            case 1:
                out += "purple";
                break;
            case 2: 
                out += "blue";
                break;
            case 3:
                out += "green";
                break;
            case 4: 
                out += "yellow";
                break;
            case 5:     
                out += "orange";
                break;
        }
        for(int i = 0; i < 5; i++) {

            randNum = (int)(Math.random() * 5);

            switch(randNum) {

                case 0:
                    out += ",red";
                    break;
                case 1:
                    out += ",purple";
                    break;
                case 2: 
                    out += ",blue";
                    break;
                case 3:
                    out += ",green";
                    break;
                case 4: 
                    out += ",yellow";
                    break;
                case 5:     
                    out += ",orange";
                    break;
            }
        }

        return out;
    }

    private String truck(int journeyTime) {

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

        out = "Transport:(" + journeyTime + out + ")\n";
        return out;
    }

    public void initJourney() {

        journey += "start\n";
        journey += "ColorID:(" +colorId + ")\n";
        journey += "FarmID:(" + farmId + ")\n";
        journey += "Shipped:(Farm)\n";
        journey += truck(180);
        journey += "Arrived:(Co-Op)\n";
        journey += "Time:(10080)\n";
        journey += "Shipped:(Co-Op)\n";
        journey += truck(720);
        journey += "Arrived:(Distributor)\n";
        journey += "Time:(10080(\n";
        journey += "Shipped:(Distributor)\n";
        journey += truck(180);
        journey += "Arrived:(GenericStore)\n";
        journey += "Time:(10080)\n";
        journey += "Bought:(" + customerId + ")\n";
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
