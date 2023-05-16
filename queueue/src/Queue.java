import java.util.ArrayList;

public class Queue {
    public static void main(String[] args) {

        // Aanmaken van een queue met 5 taken
        ArrayList<Task> queue = new ArrayList<>();
        queue.add(new Task("Taak1", 5000));
        queue.add(new Task("Taak2", 6000));
        queue.add(new Task("Taak3", 100));
        queue.add(new Task("Taak4", 500));
        queue.add(new Task("Taak5", 300));

        // Aanmaken van een inventory, dit is een lijst met taken die op dit moment worden uitgevoerd
        ArrayList<Task> inventory = new ArrayList<>();

        // De verstreken tijd, dit is het aantal rondes dat de while loop heeft gedraaid
        int elapsedRound = 0;

        // Zolang de queue niet leeg is of de inventory niet leeg is, blijf de while loop draaien
        while (!queue.isEmpty() || !inventory.isEmpty()) {
            // Hierin wordt bijgehouden hoeveel taken er nog in de inventory passen
            int tasksToAdd = Math.max(0, 3 - inventory.size());
            // Voeg taken toe aan de inventory
            for (int i = 0; i < tasksToAdd; i++) {
                if (!queue.isEmpty()) {
                    inventory.add(queue.remove(0));
                }
            }

            // Dit is een lijst met taken die in deze ronde zijn afgerond
            ArrayList<Task> completedTasksInRound = new ArrayList<>();

            // Loop door alle taken in de inventory
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

            // Verhoog de verstreken tijd met 1
            elapsedRound++;
        }
    }
}