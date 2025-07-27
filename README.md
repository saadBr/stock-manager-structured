# 📦 Application de Gestion de Stock (Sans Programmation Orientée Objet)

Cette application est une version **non orientée objet** d'un système de gestion de stock simple développé en Java.

## 🧠 Description

L’application utilise **des tableaux parallèles** et des **méthodes statiques** pour gérer les produits d’une boutique. Chaque produit est représenté par sa position dans les tableaux `codes`, `noms`, `quantites` et `prix`.

## 🎯 Fonctionnalités

- Ajouter un produit
- Modifier un produit
- Supprimer un produit
- Afficher la liste des produits
- Rechercher un produit
- Calculer la valeur totale du stock

## 🧱 Structure technique

- Données stockées dans :
  - `int[] codes`
  - `String[] noms`
  - `int[] quantites`
  - `double[] prix`

- Interface en console avec menu interactif

## ⚙️ Exécution

```bash
javac Program.java
java Program
```

## 📌 Limites

- Pas de gestion par objets (`Produit`)
- Taille du stock limitée à 100 produits
- Difficulté à maintenir/étendre (ex: ajout de catégorie)

## 📁 Fichier principal

- `Program.java` dans le package `com.sp.apps.AppBoutique`
