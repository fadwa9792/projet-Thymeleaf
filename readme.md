# 🏥 Gestion des Rendez-vous Médicaux (Spring Boot-Thymeleaf)

##  Description

Cette application permet de gérer les rendez-vous entre patients et médecins dans une clinique.


---

## ⚙️ Technologies utilisées

* ☕ Java 17
* 🌱 Spring Boot
* 🗄️ Spring Data JPA
* 🐬 MySQL
* 🔧 Maven
* 📬 Postman (tests API)

---

##  Structure du projet

![text](screens/img0.png)



---


## 🔗 Tests avec Postman
### ➤ Créer un rendez-vous

```http
POST /api/rdv/create/{patientId}/{medecinId}
```

![text](screens/creer%20rdv.png)
---

### ➤ Valider un rendez-vous

```http
PUT /api/rdv/valider/{id}
```
![text](screens/valider%20rdv.png)
---

### ➤ Annuler un rendez-vous

```http
PUT /api/rdv/annuler/{id}
```
![text](screens/annuler%20rdv.png)
---

### ➤ Marquer comme absent (No-Show)

```http
PUT /api/rdv/absent/{id}
```
![text](screens/mettre%20absent.png)
---

### ➤ filtrer par spécialité

```http
GET /api/rdv/specialite/{specialite}
```
![text](screens/filtre%20specialite.png)
---

### ➤ filtrer par statut

```http
GET /api/rdv/statut/{statut}
```
![text](screens/statut.png)
---

### ➤ filtrer par date

```http
GET /api/rdv/date?d1=...&d2=...
```
![text](screens/FILTRE%20PAR%20DATE.png)
---

## 📊 Statistiques

### ✔ Taux de No-Show

```http
GET /api/rdv/stats/noshow
```

👉 Interprétation :

> 50% des patients ne se présentent pas à leur rendez-vous.

![text](screens/show.png)



---

### ✔ Statistiques par spécialité

```http
GET /api/rdv/stats/specialite
```
![text](screens/STATISTIQUES%20PAR%20SPECIALITE.png)
---

### ✔ Statistiques par mois

```http
GET /api/rdv/stats/mois
```
![text](screens/STATISTIQUES%20PAR%20MOIS.png)
---





---


## 👨‍💻 Auteur

BOUKARNAOOUI Fadwa


---
