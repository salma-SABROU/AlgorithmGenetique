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

    public  void selection(){
        firstFitness=individuals.get(0);
        secondFitness=individuals.get(1);
        //System.out.println("first chromosone : "+Arrays.toString(firstFitness.getGenes())+" with fitness : "+firstFitness.getFitness());
        //System.out.println("second chromosone : "+Arrays.toString(secondFitness.getGenes())+" with fitness : "+secondFitness.getFitness());

    }

    public void sortPopulation(){
        Collections.sort(individuals,Collections.reverseOrder());
    }

    public  void crossover(){
        Random rnd=new Random();
        int pointCrossever=rnd.nextInt(5);
        pointCrossever++;
        //System.out.println("pointCrossever == "+pointCrossever);
        Individual individual1=new Individual();
        Individual individual2=new Individual();

        for (int i=0;i<individual2.getGenes().length;i++){
            individual1.getGenes()[i]=firstFitness.getGenes()[i];
            individual2.getGenes()[i]=secondFitness.getGenes()[i];
        }
       /* System.out.println("//////////////////////////////////////////////////////////////////////////");
        System.out.println("-------first chromosone : "+Arrays.toString(individual1.getGenes())+" with fitness : "+individual1.getFitness());
        System.out.println("-------second chromosone : "+Arrays.toString(individual2.getGenes())+" with fitness : "+individual2.getFitness());
        System.out.println("//////////////////////////////////////////////////////////////////////////");*/
        for (int i=0;i<pointCrossever;i++) {
            int tmp;
            tmp=individual1.getGenes()[i];
            individual1.getGenes()[i]=individual2.getGenes()[i];
            individual2.getGenes()[i]=tmp;
        }

        //System.out.println("-------new first chromosone : "+Arrays.toString(individual1.getGenes())+" with fitness : "+individual1.getFitness());
        individuals.set(individuals.size()-2,individual1);
        //System.out.println("-------new second chromosone : "+Arrays.toString(individual2.getGenes())+" with fitness : "+individual2.getFitness());
        individuals.set(individuals.size()-1,individual2);
    }

    public  void mutation(){
        Random rnd=new Random();
        int index=rnd.nextInt(6);
        if (individuals.get(individuals.size()-2).getGenes()[index]==1){
            individuals.get(individuals.size()-2).getGenes()[index]=0;
        }else{
            individuals.get(individuals.size()-2).getGenes()[index]=1;
        }
        index=rnd.nextInt(6);
        if (individuals.get(individuals.size()-1).getGenes()[index]==1){
            individuals.get(individuals.size()-1).getGenes()[index]=0;
        }else{
            individuals.get(individuals.size()-1).getGenes()[index]=1;
        }
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public Individual getBestFitnessInd(){
        return individuals.get(0);
    }
}
