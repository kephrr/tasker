package dev.tasker.data.fixtures;

import dev.tasker.data.entities.Task;
import dev.tasker.data.enums.EtatTask;
import dev.tasker.data.repositories.IPersonRepository;
import dev.tasker.data.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
//@Component
@Order(1)
public class TaskFixtures implements CommandLineRunner {
    private final ITaskRepository taskRepository;
    private final IPersonRepository personRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] libelles = {
                "Idées de projets","Courses","Liste des Téléphones que je veux"
                ,"Objectifs 2024", "Entrainement Muscu","Entrainement basket"
                ,"Objectifs 2023", "Song Spotify","WHAT IF",
                "Réunion d'équipe","Liste de courses","Idée de projet",
                "Rendez-vous chez le médecin","Plan de voyage","Tâches ménagères",
                "Idée de recette","Objectifs de fitness","Anniversaire de Marie",
                "Lecture en cours"
        };
        String[] contenu = {
                "On pourrait commencer par une petite application web qui permettrait de gérer les tâches qu'on veut faire au quotidient",
                "-Deux sachets de lait Nido\n-Un pai\n-Deux pains au lait de 150\n-Deux oeufs",
                "iPhone 13 Pro (800€ max) ou Samsung S20 (incroyable)",
                "-Transformation physique\n-Nouvelle langue\n-Sortir un manga",
                "Pour un programme de musculation intermédiaire ciblant les bras et les pectoraux, vous pourriez inclure les exercices suivants :\n" +
                        "\n" +
                        "Développé couché : 4 séries de 8-12 répétitions\n" +
                        "Tractions prises larges : 4 séries de 10-20 répétitions\n" +
                        "Rowing à un bras avec haltère : 3 séries de 10-15 répétitions\n" +
                        "Dips : 3 séries de 8-12 répétitions\n" +
                        "Élévations latérales : 3 séries de 12-15 répétitions\n" +
                        "As",
                "Finission sous l'arceau, catch and shoot, pull up jumper",
                "Je l'ai déjà tous accomplis", "Rowjay & La Fève - Double F","...",
                "Contenu :** La réunion d'équipe hebdomadaire aura lieu demain à 10h00 dans la salle de conférence. Veuillez préparer vos rapports d'avancement.",
                "Acheter du lait, des œufs, du pain, des fruits, des légumes, du fromage et du café pour la semaine.",
                "Développer une application mobile pour aider les utilisateurs à suivre leurs habitudes de lecture et à découvrir de nouveaux livres.",
                "Rendez-vous chez le Dr. Dupont le 15 septembre à 14h30 pour un contrôle annuel.",
                "Préparer un itinéraire pour le voyage à Paris : visiter la Tour Eiffel, le Louvre, et faire une croisière sur la Seine.",
                "Nettoyer la maison, faire la lessive, arroser les plantes et sortir les poubelles ce week-end.",
                "Essayer une nouvelle recette de lasagnes végétariennes avec des épinards, des champignons et de la ricotta.",
                "Courir 5 km trois fois par semaine, faire des exercices de musculation deux fois par semaine et pratiquer le yoga le dimanche.",
                "Organiser une fête surprise pour l'anniversaire de Marie le 20 septembre. Inviter ses amis et préparer un gâteau au chocolat.",
                "Lire \"Le Petit Prince\" de Antoine de Saint-Exupéry. Noter les citations inspirantes et les réflexions personnelles.\n"
        };

        for (int i = 0; i < libelles.length; i++) {
            taskRepository.save(Task.builder()
                    .title(libelles[i])
                    .description(contenu[i])
                    .user(personRepository.findById(i%4!=0?1L:2L).orElse(null))
                    .etat(i%3==0? EtatTask.InProgress:EtatTask.Plannified)
                    .build()
            );
        }
    }
}
