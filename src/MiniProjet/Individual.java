package MiniProjet;

import java.util.Random;

public class Individual implements Comparable{
    private char genes[]=new char[7];
    private int fitness;

    public Individual(){
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            genes[i] = (char) (random.nextInt(26) + 'A');
        }
    }

    public void calculateFitness(){
        fitness=0;
        String brj="BONJOUR";
        char ArrBrj[]=brj.toCharArray();
        for (int i=0;i<7;i++) {
            //System.out.println("brj.Array() : "+ArrBrj[i] + " Our Array : "+genes[i]);
            if(ArrBrj[i]==genes[i])
                fitness++;
        }
        //System.out.println("fitness == "+fitness);

    }

    public int getFitness() {
        return fitness;
    }

    public String getGenes() {
        return new String(genes);
    }

    public char[] ArrayOfGenes() {
        return genes;
    }
    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual)o;
        if(this.fitness>individual.fitness)
            return 1;
        else if (this.fitness<individual.fitness)
            return -1;
        else
            return 0;
    }
}
