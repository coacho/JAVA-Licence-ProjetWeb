# Liste des classes:
  
  - Position
    - PositionInterface
  #
  - Map
    - MapCreate
    - MapEvenement
  #
  - Joueur
    - JoueurGenerer
    - JoueurInterface
  #
  - Monstre
    - MonstreGenere
    - MonstreInterface
  #
  - Ecran
    - EcranMap
    - EcranTexte
  #
  - Equipement
    - EquipementGenerer
    - EquipementInterface
  #
  - Manette 
  
  - RpgMain

  - Inventaire (pas intégrer à Ecran, à compléter)
  
  - Magasin (pas intégrer à Ecran, + à compléter)
  
  - Combat (pas intégrer à Ecran, + à compléter)
  
  - TexteGrille (pas intégrer à Ecran, + à compléter)
 #

 # Règles du jeu

 Le jeu ne fonctionne pas encore à proprement parler, je compte le terminé plus tard.

 Le joueur (i) apparait en bas à droite d'une map de taille (x,y)  et doit se rendre en haut à gauche.
 
 Sur son chemin il peut croiser, 
  - des monstres (m) ce qui déclenche un combat
  - le joueur récupère dans son inventaire le loot des montres tué en combat (fonction pas encore implenté)
  - des magasins (S) qui permet de récupèrer de l'équipement (fonction pas encore implenté)
  - des obtacles (x) infranchissable par le joueur et les monstre

## Controle :
  - flèche directionnel du clavier
  - touche Entrer (ne fait rien pour l'instant)

  Astuces : _le Joueur peux sortir de la map s'il se retrouve bloqué par les obstacles générer aléatoirement._
#
  # Modélisation
