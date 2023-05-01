package MiniProjet;

import java.util.*;

public class Population {
    List<Individual> individuals=new ArrayList<>();
    Individual firstFitness;
    Individual secondFitness;

    public void intialaizePopulation(){
        for(int i=0;i<20;i++){
            individuals.add(new Individual());
        }
    }

    public void calculateIndividualFitness(){
        for(int i=0;i<20;i++){
            individuals.get(i).calculateFitness();
        }
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public void sortPopulation(){
        Collections.sort(individuals,Collections.reverseOrder());
    }

    public  void selection(){
        firstFitness=individuals.get(0);
        secondFitness=individuals.get(1);
        /*System.out.println("*******************************************************************************************");
        System.out.println("first chromosone : "+firstFitness.getGenes()+" with fitness : "+firstFitness.getFitness());
        System.out.println("second chromosone : "+secondFitness.getGenes()+" with fitness : "+secondFitness.getFitness());*/

    }

    public  void crossover(){
        Random rnd=new Random();
        int pointCrossever=rnd.nextInt(5);
        pointCrossever++;
        System.out.println("pointCrossever == "+pointCrossever);

        Individual individual1=new Individual();
        Individual individual2=new Individual();

        for (int i=0;i<individual2.ArrayOfGenes().length;i++){
            individual1.ArrayOfGenes()[i]=firstFitness.ArrayOfGenes()[i];
            individual2.ArrayOfGenes()[i]=secondFitness.ArrayOfGenes()[i];
        }
        /*System.out.println("//////////////////////////////////////////////////////////////////////////");
        System.out.println("-------first chromosone : "+ individual1.getGenes()+" with fitness : "+individual1.getFitness());
        System.out.println("-------second chromosone : "+individual2.getGenes()+" with fitness : "+individual2.getFitness());
        System.out.println("//////////////////////////////////////////////////////////////////////////");*/

        for (int i=0;i<pointCrossever;i++) {
            char tmp;
            tmp=individual1.ArrayOfGenes()[i];
            individual1.ArrayOfGenes()[i]=individual2.ArrayOfGenes()[i];
            individual2.ArrayOfGenes()[i]=tmp;
        }

        //System.out.println("-------new first chromosone : "+Arrays.toString(individual1.ArrayOfGenes())+" with fitness : "+individual1.getFitness());
        individuals.set(individuals.size()-2,individual1);
        //System.out.println("-------new second chromosone : "+Arrays.toString(individual2.ArrayOfGenes())+" with fitness : "+individual2.getFitness());
        individuals.set(individuals.size()-1,individual2);
    }

    public  void mutation(){
        Random rnd=new Random();
        int index=rnd.nextInt(6);
        String brj="BONJOUR";
        char ArrBrj[]=brj.toCharArray();
        Random random = new Random();
        if (individuals.get(individuals.size()-2).ArrayOfGenes()[index]!=ArrBrj[index]){
            individuals.get(individuals.size()-2).ArrayOfGenes()[index]=(char) (random.nextInt(26) + 'A');
            //individuals.get(individuals.size()-2).ArrayOfGenes()[index]=ArrBrj[index];
        }
        //System.out.println("chromo for : "+index+" : "+individuals.get(individuals.size()-2).getGenes());
        index=rnd.nextInt(6);
        if (individuals.get(individuals.size()-1).ArrayOfGenes()[index]!=ArrBrj[index]){
            individuals.get(individuals.size()-1).ArrayOfGenes()[index]=(char) (random.nextInt(26) + 'A');
            //individuals.get(individuals.size()-1).ArrayOfGenes()[index]=ArrBrj[index];
        }
        //System.out.println("chromo for : "+index+" : "+individuals.get(individuals.size()-1).getGenes());
    }

    public Individual getBestFitnessInd(){
        return individuals.get(0);
    }
}
