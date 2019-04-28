import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {

        for(int i = 0; i < 1000; i++) {

            FarmSim sim = new FarmSim();
            sim.initJourney();
            sim.outputDataFile(sim.getJourney());
        }
    }
}