# 🌍 TravelSwipe - Application de suggestion de destinations

> Projet universitaire - Master MIAGE Lyon 1  
> Par : Abdellatif BENBAHA & Rafiq MAHROUG  
> 🔗 [GitHub Repository](https://github.com/LATIFBENBAHA/Travel_swipe_BA_MR.git).
pour le dossier frond-end angular : [GitHub Repository](https://github.com/LATIFBENBAHA/travelswipe-front-end.git).


---

## 🧠 Présentation

**TravelSwipe** est une application web qui permet aux utilisateurs de découvrir des destinations de voyage en fonction de leurs préférences d’activités (plage, ski, randonnée, etc.), grâce à une interface de type **swipe** (like/dislike). Une fois les activités préférées sélectionnées, l’application suggère des destinations correspondantes.

---

## 🛠️ Technologies utilisées

- **Frontend** : Angular
- **Backend** : Java Spring Boot
- **Base de données** : PostgreSQL
- **Architecture** : RESTful API
- **Outils** : Maven, Node.js, npm

---

## 📁 Structure du projet

### 🔙 Backend (`/src/main/java/com/travel/swipe`)

- `controller/` : gestion des endpoints REST (Activités, Destinations, Favoris, Utilisateurs)
- `model/` : entités JPA (Activite, Destination, User, FavorisActivite, etc.)
- `repository/` : interfaces Spring Data pour accéder à la base
- `service/` : logique métier
- `TravelSwipeApplication.java` : point d’entrée Spring Boot
- `resources/static/images/` : images des destinations
- `application.properties` : configuration Spring + PostgreSQL

### 🌐 Frontend Angular (`/src/app`)

- `components/` : composants comme la carte de swipe
- `pages/` : pages principales (Login, Home)
- `services/` : services Angular pour consommer l'API
- `models/` : interfaces TypeScript (User, Activite, Destination)
- `styles.css`, `app.component.*`, `routing.module.ts` : structure de l'application

---

## ⚙️ Installation et Exécution

### 1. 🔄 Cloner le projet
git clone https://github.com/LATIFBENBAHA/Travel_swipe_BA_MR.git
cd Travel_swipe_BA_MR
### 2. 🐘 Configurer PostgreSQL
psql -U postgres

CREATE DATABASE travelswipe;

CREATE USER admin WITH PASSWORD 'yourpassword';//vous devez changer le mot de pass dans application.properties 

GRANT ALL PRIVILEGES ON DATABASE travelswipe TO admin;

Importer les données :
'psql -U admin -d travelswipe -f data_travelswipe.sql' (Vous trouverez l'email et le mot de passe dans ce fichier. Vous pouvez les modifier, en ajouter d'autres, etc.)

### 3. 🔙 Lancer le backend Spring Boot
Depuis le dossier backend :

"mvn spring-boot:run"
📍 Accès backend : http://localhost:8080
### 4. 🌐 Lancer le frontend Angular
Aller dans le dossier frontend (cd travelswipe-frontend si séparé, sinon directement dans Travel_swipe_BA_MR si intégré), puis :
npm install
ng serve
📍 Accès frontend : http://localhost:4200.

#### 💡 Fonctionnalités de l'application
Connexion simplifiée d’un utilisateur

Swipe sur une série d’activités

Like/Dislike : enregistre les préférences utilisateur

À la fin du swipe :

Récupération des destinations associées aux activités likées

Affichage dynamique des destinations

Possibilité de recommencer une session
#### 🖼️ Images d’exemple

Les images sont accessibles dans src/main/resources/static/images/ :

plage-nice.jpg

ski-Chamonix.jpg

Randonnée-verdon.jpg

etc.

#### ✅ Exemple d’API utilisée
GET /activites : liste des activités

POST /favorisActivite/like?userId=1&activiteId=2 : liker une activité

GET /finales?userId=1 : destinations finales selon les likes

POST /users : inscription d’un utilisateur

POST /login : connexion d’un utilisateur

👤 Auteur
Abdellatif BENBAHA
Rafiq MAHROUG
🎓 Étudiant Master 1 MIAGE - Université Claude Bernard Lyon 1
