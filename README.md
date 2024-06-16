# Minecraft EA base project

Base template project of the Java smart controller and regulation application for Minecraft.

This is a Java/Maven project made with IntelliJ for the CNet course.

Le project se scruture en 4 package:
- Core: pour la gestion des DataPoint
- Field: Pour la comunication avec ModBus
- Database: Pour la gestion du database
- SmartControle: pour la gestion de la Factory
  
En plus dans le MinecraftController les différents connecteurs (champ, base de données...) sont initialisés, le pooling aussi et le CSV vient lu.
## Core
### Gestion des DataBase:
Une hiérarchie de classes est définie pour gérer les dataPoint génériques (DataPoint) et spécialisés (BooleanDataPoint et FloatDataPoint). Chaque point de données est identifié par une étiquette et peut être marqué comme entrée ou sortie. Les classes utilisent une Map pour garder la trace des DataPoints par étiquette et prennent en charge la mise à jour automatique via la base de données, le champ et les connecteurs web lorsque la valeur d'un point de données est modifiée.
### CSVParser
La classe CSVParser de Java lit un fichier CSV (ModbusMap.csv) qui spécifie les DtaPoints pour la communication Modbus. Elle utilise Utility.fileParser() pour obtenir un BufferedReader, puis analyse chaque ligne du fichier pour créer des instances FloatRegister ou BooleanRegister en fonction du type de données spécifié ("F" pour float, "B" pour boolean). Il gère les exceptions d'E/S.
## Field
### Classe ModBusAcessor
La classe `ModbusAccessor` implémente un singleton pour gérer la communication avec les appareils Modbus via TCP en utilisant la bibliothèque `modbus4j`. Elle configure une connexion Modbus avec une adresse IP, un port et un identifiant Slave spécifiés. La classe offre des méthodes pour lire et écrire des valeurs booléennes et Float à partir des coil et des registres de holding  de l'appareil Modbus. Elle utilise `BaseLocator` pour localiser des données spécifiques et gère les exceptions de transport et les réponses incorrectes, en imprimant des messages d'erreur pour le débogage.
### Gestion des ModBusRegister
Une hiérarchie de classes est définit pour gérer les registres Modbus pour les données booléennes (BooleanRegister) et float (FloatRegister). Chaque registre est associé à un DataPoint correspondant (BooleanDataPoint ou FloatDataPoint) et utilise ModbusAccessor pour lire et écrire des données via le protocole Modbus. La classe ModbusRegister fournit des méthodes pour gérer la Map des registres et permet la lecture et l'écriture des registres via les méthodes abstraites read() et write() mises en œuvre dans les sous-classes.
### FieldConnector
La classe FieldConnector gère la communication entre les DataPoint et les appareils de terrain via le protocole Modbus. Elle met en œuvre le modèle de conception Singleton pour garantir une instance unique de l'objet FieldConnector dans l'application. La méthode pushToField(DataPoint dp) vérifie si le point de données est marqué comme sortie ou entré et envoie la valeur actuelle du DataPoint à l'appareil de terrain associé en utilisant les registres Modbus correspondants.
### PoolTsk 
La classe PollTask étend TimerTask et surcharge la méthode run() en appelant la méthode statique poll() de ModbusRegister. Cette méthode est utilisée pour interroger périodiquement les registres Modbus, en collectant et en mettant à jour les données des appareils connectés.
## Database
### DataBase Connector:
La classe `DataBaseConnector` implémente un singleton pour gérer la connexion avec le "dataBase remote". Voici un résumé de son fonctionnement :
  **Singleton** : La classe utilise le modèle de singleton, assurant qu'une seule instance de `DataBaseConnector` est créée.
  **Initialize** : La méthode `initialize` configure les détails de la connexion à la base de données, y compris le protocole, le nom d'hôte,  bucket et token d'authentification.
  **Communication avec la base de données** : La méthode privée `pushToDatabase` envoie des données d'un `DataPoint` à la dataBaseRemote via une requête HTTP POST.
- **Notification de nouvelles valeurs** : implémente la méthode `oneNewValue` de l'interface `DataPointListener`, qui appelle `pushToDatabase` lorsqu'une nouvelle valeur est disponible.
En résumé, `DataBaseConnector` gère l'envoi de points de données au "dataBase remote" en utilisant HTTP.
## SmartController
La classe `SmartControl` gère le contrôle intelligent du système énergétique dans Minecraft Electrical Age. 

### Fonctionnement principal :
  **Connexion initiale** :
  - Configure la connexion Modbus avec l'IP, le port et l'ID de le slave spécifiés.
  - Il analyse le fichier CSV pour créer les DataPoint nécessaires.

  **Contrôle intelligent de la puissance** :
  - Il lit différents DataPoint 
  - Il calcule la consommation totale d'énergie et la production totale à partir de sources renouvelables.
  - Détermine le déficit de puissance et ajuste la production de charbon en conséquence.
  - Surveille la tension du réseau et ajuste la production pour maintenir une tension stable.
  - Gère l'état de charge de la batterie, en augmentant ou en diminuant la production pour maintenir le niveau de charge optimal.
  - Il ajuste les sources d'énergie renouvelable (solaire et éolienne) en fonction des conditions météorologiques.
  - Elle adapte la production de l'usine en fonction du niveau de la batterie afin d'optimiser l'utilisation de l'énergie disponible.
    
Cette classe met en œuvre une série de logiques de contrôle pour assurer un équilibre efficace entre la production et la consommation d'énergie, en maintenant la stabilité du système électrique dans Minecraft Electrical Age.
