import java.util.ArrayList;

public class Queue {
    public static void main(String[] args) {

        ArrayList<Task> inventory = new ArrayList<>(); // Aanmaken van een inventory, dit is een lijst met taken die op dit moment worden uitgevoerd
        ArrayList<Task> completedTasksInRound = new ArrayList<>(); // Dit is een lijst met taken die in deze ronde zijn afgerond

        ArrayList<Task> queue = new ArrayList<>(); // Aanmaken van een queue met 5 taken
        queue.add(new Task("Taak 1", 5000));
        queue.add(new Task("Taak 2", 6000));
        queue.add(new Task("Taak 3", 100));
        queue.add(new Task("Taak 4", 500));
        queue.add(new Task("Taak 5", 300));

        int elapsedRound = 0; // De verstreken tijd, dit is het aantal rondes dat de while loop heeft gedraaid

        // !queue.isEmpty() zodat de while loop blijft runnen zolang er nog taken in de queue zitten,
        // !inventory.isEmpty() zodat de while loop blijft runnen zolang er nog taken in de inventory zitten
        while (!queue.isEmpty() || !inventory.isEmpty()) {
            int tasksToAdd = Math.max(0, 3 - inventory.size());
            // Voeg taken toe aan de inventory
            for (int i = 0; i < tasksToAdd; i++) {
                if (!queue.isEmpty()) {
                    inventory.add(queue.remove(0));
                }
            }

            for (Task task : inventory) {
                // Als de verstreken tijd groter of gelijk is aan de tijd van de taak, dan is de taak afgerond
                if (elapsedRound >= task.getTime()) {
                    System.out.println(task.getName() + " duurt is afgerond.");
                    completedTasksInRound.add(task);
                }
            }

            // Verwijder alle taken die in deze ronde zijn afgerond uit de inventory
            for (Task completedTask : completedTasksInRound) {
                inventory.remove(completedTask);
            }

            elapsedRound++;
        }
    }
}