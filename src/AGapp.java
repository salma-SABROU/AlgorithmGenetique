import java.util.Arrays;
import java.util.Random;

public class AGapp {
    private static final int MAX_ITERATION=50;
    private static final int MAX_FITNESS=10;
    public static void main(String[] args) {
        Population population=new Population();
        population.intialaizePopulation();
        population.calculateIndividualFitness();
        population.sortPopulation();
        System.out.println("-- chromosone : "+Arrays.toString(population.getBestFitnessInd().getGenes())+" fitness : "+population.getBestFitnessInd().getFitness());

        int iteration=0;
        while (iteration<MAX_ITERATION && population.getBestFitnessInd().getFitness()<MAX_FITNESS){
            population.selection();
            System.out.println("*******************************************************");
            population.crossover();
            Random rnd=new Random();
            if(rnd.nextInt(101)<50)
                population.mutation();

            population.calculateIndividualFitness();
            population.sortPopulation();
            System.out.println("-- chromosone : "+Arrays.toString(population.getBestFitnessInd().getGenes())+" fitness : "+population.getBestFitnessInd().getFitness());
            iteration++;
        }
    }
}
