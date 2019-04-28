package com.company;
import static java.lang.System.*;
import java.util.Scanner;

public class Main {

    static boolean doing = true;

    public void runSim() {
        FarmSimulator sim = new FarmSimulator();
        out.println(sim);
    }

    public static void main(String[] args) {
        /*Scanner linesin = new Scanner(in);
        while(doing) {
            out.println("Press \"1\" to create a new scenario. Press \"2\" to exit.");
            int go = linesin.nextInt();
            if(go == 2) {
                doing = false;
                exit(1);
            } else if(go == 1) {
                Main runner = new Main();
                runner.runSim();
            } else {
                out.println("Please input a valid response.");
            }
        }*/
        Scanner scans = new Scanner(in);
        out.println("Press enter to start.");
        String unneeded = scans.nextLine();
        Blockchain go = new Blockchain();
        for(int i = 0; i < 5; i++) {
            Blockchain.Block[] blockyboi = go.map.get((go.map.keySet().toArray())[i]);
            for(int b = 0; b < 5; b++) {
                out.println("Sender: " + blockyboi[b].sender);
                out.println("Receiver: " + blockyboi[b].receiver);
                out.println("Safe Temp The Whole Trip?: " + blockyboi[b].safeTemp);
                out.println("Journey Time: " + blockyboi[b].journeyTime + " days.");
                out.println("Hash: " + (int)Math.round((Math.random() * 10000) + 1));
                boolean contam = !blockyboi[b].safeTemp;
                out.println("Did temperature contamination occur here?: " + contam + "\n");
            }
        }
    }
}

\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
package com.company;
import java.util.LinkedHashMap;

public class Blockchain {

    int[] farms = {2139, 4345, 1396, 9284, 3820};
    int[] bins = {2901, 3000};
    int[] cooperatives = {3024, 1044};
    int[] distributors = {2900, 1982};
    int[] rDistributors = {1999, 4810};
    int[] retailers = {1902, 2992, 4803, 6949, 9883};

    LinkedHashMap<Integer, Block[]> map = new LinkedHashMap<Integer, Block[]>();

    class Block
    {
        public int sender;
        public int receiver;
        public int journeyTime;
        public boolean safeTemp;
    }

    public Blockchain()
    {

        for(int i = 0; i < 5; i++) {
            Block[] blocks = new Block[5];
            int lastReceiver = farms[i];
            for (int b = 0; b < 5; b++) {
                blocks[b] = new Block();
                switch (b) {
                    case 0:
                        blocks[b].receiver = getRandomFromArray(bins);
                        break;
                    case 1:
                        blocks[b].receiver = getRandomFromArray(cooperatives);
                        break;
                    case 2:
                        blocks[b].receiver = getRandomFromArray(distributors);
                        break;
                    case 3:
                        blocks[b].receiver = getRandomFromArray(rDistributors);
                        break;
                    case 4:
                        blocks[b].receiver = getRandomFromArray(retailers);
                        break;
                }

                blocks[b].sender = lastReceiver;
                lastReceiver = blocks[b].receiver;
                blocks[b].journeyTime = (int)Math.round((Math.random() * 1.5) + 0.5);
                int error = (int)Math.round(Math.random() * 100);
                if(error >= 95) {
                    blocks[b].safeTemp = false;
                } else {
                    blocks[b].safeTemp = true;
                }
            }
            map.put(i, blocks);
        }
    }
    public int getRandomFromArray(int[] awry)
    {
        int randInt = (int)Math.round(Math.random() * (awry.length - 1));
        return awry[randInt];
    }
}
