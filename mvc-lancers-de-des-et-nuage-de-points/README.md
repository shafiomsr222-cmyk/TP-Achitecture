# SAE 3.02 -- Classification : MVC et Nuage de points dynamique

L'objectif de ce TP est de se familiariser avec le paquetage  [javafx.scene.chart](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/package-summary.html) qui sera utile pour votre SAÉ.
C'est aussi l'occasion de s'exercer de nouveau dans l'application du patron architectural MVC.
Vous devez réaliser une application qui permet de visualiser des fréquences de tirage de dés.

Voici par exemple à quoi devrait ressembler votre application.

![Exemple](doc/demo.mp4)

Vous pouvez d'ores et déjà lancer l'application avec la commande javafx:run pour vous assurer que tout fonctionne correctement,
Pour le moment, elle devrait afficher une fenêtre avec deux axes et un seul point ainsi qu'un bouton *Lancer* inopérant.

## Modèle observable et vues observatrices
Pour commencer, on va implémenter la partie modèle, qui va simuler des lancers de dé.
On souhaite simplement pouvoir lancer un dé à 10 faces et enregistrer le nombre fois qu'on a obtenu chaque score.
Comme lors du précédent TP, votre modèle devra permettre à des vues de l'observer et vos vues s'y être donc abonnées en tant qu'observatrices.
N'oubliez pas de faire en sorte que le modèle notifie ses observateurs après chaque lancer.
Note : on ne vous demande pas de vous occuper de la vue graphique à ce stade, ça viendra plus tard dans la partie nommée *La tête dans les nuages*

## Tests
Assurez-vous qu'on retrouve bien le nombre total de lancers lorsqu'on cumule le nombre de fois qu'apparaît chacune des faces.

## Contrôleur
On s'intéresse à présent au contrôleur.
Dans le sous-paquetage *view*, se trouve la classe *NuageDePoints* qui permettra de visualiser les résultats des lancers de dés.
Une large partie du code est déjà fournie, on y reviendra ensuite.
Focalisons-nous sur le bouton *Lancer* instancié dans le constructeur.
Pour l'instant, on souhaite tout simplement que lors d'un clic sur ce bouton, un dé soit lancé côté modèle.
Pas de paquetage ni de classe dédiée ici, une lambda sur le bouton présent dans la classe de la vue fera l'affaire (voir les TP précédents si vous avez oublié).

## Une vue texte
La classe *VueTerminal* est une vue, faîtes en sorte qu'elle s'abonne au modèle pour être prévenue de ces changements.
Implémentez ensuite un comportement ultra basique qui consiste à écrire sur la sortie standard le résultat lorsqu'un nouveau lancer de dé a été effectué dans le modèle.
À cette étape, vous pouvez donc vérifier que l'appui sur le bouton provoque bien le lancer d'un nouveau dé.
La vue graphique ne le reflète pas pour le moment, on va maintenant s'en occuper.

## La tête dans les nuages
Analysons un peu le code fourni dans cette classe dans la perspective de gérer ensuite la mise à jour de cette vue.
Conseil : Avoir votre classe *NuageDePoints* sur une partie de l'écran et ce texte sur l'autre.

On a eu recours à la classe [javafx.scene.chart.ScatterChart<X,Y>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/ScatterChart.html), ici en attribut, c'est un composant qui représente le nuage en lui-même.
Pour instancier ce nuage, dans la méthode *creerNuage*, on a fourni à la création deux [NumberAxis](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/NumberAxis.html)), renseignées par leur nom, leurs bornes leur unité.

On n'ajoute pas des points directement au nuage mais à une « série » ([XYChart.Series<X,Y>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/XYChart.Series.html)).
Une série est un ensemble de points ([XYChart.Data](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/XYChart.Data.html)) qui seront tous représentés et légendés d'une même manière.
Dans la méthode *remplirSerie*, on voit qu'un point de coordonnées (7,1),  correspondant à un 7 obtenu sur un lancer, est instancié et ajouté via *getData().add(...)*.
La série est-elle même ajoutée au nuage de la même manière.

Faîtes maintenant évolué ce code de manière à ce que la vue graphique se mette à jour après chaque lancer.
On se contentera ici d'une solution où tout nouveau lancer se traduira par le retracé de l'ensemble des points du nuage.

## Chargement d'une nouvelle série
On souhaite comparer les résultats de lancers de dés effectués à la main avec ceux issus de l'application.

![Ajout d'une 2ème série avec les données chargées](doc/2eme-serie.mp4)

Des résultats de lancers à la main ont déjà été récoltés dans un fichier CSV présent ici dans le répertoire resources.
Revoyez votre modèle pour qu'il ne contienne pas uniquement les données des lancers dans l'application mais aussi celles que l'on va charger.
Ajoutez ensuite les méthodes pour charger un fichier de ce format.
Lorsque les données seront chargées, la vue les présentera dans une nouvelle série distincte.


## Nuage stylé
On va maintenant changer le style des points de notre nuage en employant ceux décrits dans la feuille de style css fournie dans le répetoire *main/java/resources*.
```css
.chart-symbol.series0 {
    -fx-background-color: #4CAF50; /* Vert */
    -fx-shape: "M2,0 L5,4 L8,0 L10,0 L10,2 L6,5 L10,8 L10,10 L8,10 L5,6 L2,10 L0,10 L0,8 L4,5 L0,2 L0,0 Z"; /* croix */
    -fx-padding : 5px
}

.chart-symbol.series1 {
    -fx-background-color: #2196F3; /* Bleu */
    -fx-shape: "M 0 0 A 1 1 0 0 0 2 0 A 1 1 0 0 0 0 0 Z"; /* cercle */
    -fx-padding : 5px
}
```
Ce fichier décrit le style qu'on va donner à chaque série de points ajoutée au nuage.
Si une valeur n'est pas renseigné, c'est la valeur par défaut qui sera prise en compte.
Ici, le style décrit des croix vertes pour la série 0 et des cercles bleus pour la série 1.

Dans votre vue graphique, vous pouvez charger ce style via l'instruction suivante sur la scène :
```java
		sc.getStylesheets().add("scatterchart-styles.css");
```
Voici ce que vous devriez obtenir :
![Ajout d'une 2ème série avec les données chargées](doc/style.mp4)

Remarque pour la SAÉ : ici, on définit des styles à l'avance dans le fichier et il s'agira d'ajouter comme 1ère série dans le nuage celle pour laquelle on veut le style *.chart-symbol.series0*.
Ça n'est pas très pratique mais nous n'avons pas trouvé de méthode plus paramétrable qui reste simple.

## Survol
Un graphique est souvent une synthèse et on peut avoir envie d'une version plus détaillée des données.
Ici on souhaite que lorsqu'on survole un point, une phrase s'affiche en bas de l'application sous la forme suivante :
*Le 6 a été obtenu 4 fois.*

![Survol](doc/survol.mp4)


Pour y parvenir, on peut pour chaque point du graphique l'action a effectuée lorsqu'on entre dans sa forme et lorsqu'on en sort.
```java
point.getNode().setOnMouseEntered((event) -> ...));
point.getNode().setOnMouseExited((event) -> ...);
```

Attention, comme ces comportements sont associés aux points, si on redessine ces points suite à de nouveaux lancers ou à un nouveau chargement, il faudra penser à les redéfinir.

## Vers l'infini et l'au-delà
Lorsque les données représentées dépassent l'échelle des axes du graphique, il faut penser à dynamiquement redimensionner l'ensemble.
Pour éviter que les données ne soient plus visibles sur le nuage quand elles dépassent l'échelle initiale, on peut utiliser la méthode *[setAutoRanging](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/Axis.html#setAutoRanging-boolean-)* sur les axes.
