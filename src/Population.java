public class Population {

    Individual[] population;

    public Population(int size, boolean setBool) {
        population = new Individual[size];
         if(setBool) {
            for (int i = 0; i < populationSize(); i++) {
                Individual individual = new Individual();
                individual.generateIndividual();
                saveIndividual(i, individual);
            }
        }
    }
    public void saveIndividual(int index, Individual individual) {
        population[index] = individual;
    }
    
    public Individual getIndividual(int index) {
        return population[index];
    }
    //iterate through population to find fittest
    public Individual getFittest() {
        Individual fittest = population[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return population.length;
    }
}