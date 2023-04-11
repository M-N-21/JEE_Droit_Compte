# JEE_Droit_Compte

Ce projet est une application Java EE de base qui utilise les technologies JSP, Servlets et JSTL. Elle est conçue pour être exécutée sur un serveur web JEE tel que Tomcat. Nous utilisons maven comme gestionnaire de dependances

## Arborescence des dossiers

Le projet est organisé en trois dossiers principaux :

* `src/main/webapp`: Contient les fichiers JSP et les fichiers statiques tels que les fichiers CSS et JavaScript.
* `src/main/java`: Contient les sources Java pour les Servlets.
  Ce dernier contient les packages suivants:
  - `com.groupeisi.controller`: Ici on a les servlets pour l'interaction avec les pages jsp
  - `com.groupeisi.entities`: Contient les entités qui sont dans la base de données
  - `com.groupeisi.hibernate`: Contient les configuration necessaire pour implémenter l'ORM hibernate. NB: c'est ici que ce trouve le nom de la BD
  - `com.groupeisi.dao`: Contient les interfaces et les classes d'implémentations (en general le CRUD pour chaque entité)
  Etant donné que c'est un projet web il n'est pas recommandé de manipuler des objets qui interagissent directement avec la base. De ce fait on ajouté deux packages     qui vont nous permettre de faire des copies des entités, des interfaces et des classes d'implémentations.
  - `com.groupeisi.dto`:  Identique à entities mais ne contient pas les annotations relatives à l'ORM
  - `com.groupeisi.service`: Identique à dao mais ne contient pas aussi les annotations relatives à l'ORM.
  Au niveau des views nous recupererons des objets de types dto et dans la servlet au moment de faire des operations dans la BD ces objets dto seront transformés en     entités


## Utilisation de JSTL

L'application utilise JSTL pour la manipulation des données dans les pages JSP. La dépendance pour JSTL est incluse dans le fichier pom.xml du projet.

## Construction du projet

Le projet utilise Maven comme système de gestion de build. Pour construire l'application, exécutez la commande suivante à la racine du projet : mvn clean package
Cela va construire l'application et créer le fichier WAR qui peut être déployé sur un serveur d'applications.

## Déploiement de l'application

Une fois que le WAR est construit, vous pouvez le déployer sur un serveur d'applications JEE. Consultez la documentation de votre serveur d'applications pour savoir comment déployer un fichier WAR.

Après le déploiement, vous pouvez accéder à l'application en utilisant l'URL suivante : http://localhost:8080/nomapp
Assurez-vous de remplacer `nomapp` par le nom du projet.

# Auteur
Ce projet a été développé par MN21.
