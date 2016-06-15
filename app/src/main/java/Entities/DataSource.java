package Entities;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * Dummy class whos only purpose is to provide hardcoded application data
 * 
 * The data consists of:
 *  - 20 teams, teachers and students mixed
 */
public class DataSource
{
    private ArrayList<Team> teams;
    private ArrayList<Game> games;

    /**---------------------------------------------------------------------------------------------
     * Class constructor
     * @param context
     */
    public DataSource(Context context) {
        final int nbTeams = 20;
        ArrayList<Person> people = new ArrayList<Person>();

        Random alea = new Random();

        // from generatedata.com
        people.add(new Teacher("Adria", "Holt", "Info"));
        people.add(new Teacher("Kasper", "Booth", "Info"));
        people.add(new Teacher("Samuel", "Leach", "Info"));
        people.add(new Teacher("Colton", "Camacho", "Info"));
        people.add(new Teacher("Chiquita", "Armstrong", "Info"));
        people.add(new Teacher("Travis", "Carver", "Info"));
        people.add(new Teacher("Brendan", "Shannon", "Info"));
        people.add(new Teacher("Irene", "Hayden", "Info"));
        people.add(new Teacher("Kadeem", "Travis", "Info"));
        people.add(new Teacher("Raya", "Burgess", "Info"));
        people.add(new Teacher("Marvin", "Patterson", "Info"));
        people.add(new Teacher("Barbara", "Williams", "Info"));
        people.add(new Teacher("Jada", "Joyce", "Info"));
        people.add(new Teacher("Anastasia", "Bean", "Poly"));
        people.add(new Teacher("Branden", "Ware", "Poly"));
        people.add(new Teacher("Mary", "Lane", "Poly"));
        people.add(new Teacher("Shelly", "Love", "Poly"));
        people.add(new Teacher("Isaiah", "Mccall", "Poly"));
        people.add(new Teacher("Alana", "Hinton", "Poly"));
        people.add(new Teacher("Sigourney", "Rosa", "Poly"));
        people.add(new Teacher("Rogan", "Briggs", "Poly"));
        people.add(new Teacher("Medge", "Trevino", "Poly"));
        people.add(new Teacher("Nevada", "Vazquez", "Poly"));
        people.add(new Teacher("Dane", "Slater", "Poly"));
        people.add(new Teacher("Craig", "Obrien", "Poly"));
        people.add(new Teacher("Piper", "Moran", "Poly"));
        people.add(new Teacher("Barclay", "Suarez", "Poly"));
        people.add(new Teacher("Yoko", "Perez", "Poly"));
        people.add(new Teacher("Colorado", "Dixon", "Poly"));
        people.add(new Teacher("Laith", "Macdonald", "Poly"));
        people.add(new Teacher("Isabella", "Fry", "Poly"));
        people.add(new Teacher("Kane", "Conrad", "Poly"));
        people.add(new Teacher("Kasper", "Mcdonald", "Media"));
        people.add(new Teacher("Ifeoma", "Austin", "Media"));
        people.add(new Teacher("Deanna", "Baird", "Media"));
        people.add(new Teacher("Erasmus", "Middleton", "Media"));
        people.add(new Teacher("Zane", "Mcleod", "Media"));
        people.add(new Student("Inga", "Flowers", "Media"));
        people.add(new Student("Wesley", "Gallagher", "Media"));
        people.add(new Student("Linus", "Goodwin", "Media"));
        people.add(new Student("Elton", "Drake", "Media"));
        people.add(new Student("Justine", "Whitfield", "Media"));
        people.add(new Student("Kaseem", "Chambers", "Media"));
        people.add(new Student("Melinda", "Fitzpatrick", "Media"));
        people.add(new Student("Thaddeus", "Cherry", "Media"));
        people.add(new Student("Sarah", "Hunt", "Media"));
        people.add(new Student("Holly", "Ratliff", "Media"));
        people.add(new Student("Xanthus", "Watson", "Media"));
        people.add(new Student("Jarrod", "Thomas", "Info"));
        people.add(new Student("Sybil", "Paul", "Info"));
        people.add(new Student("Brenna", "Hale", "Info"));
        people.add(new Student("Lee", "Sanders", "Info"));
        people.add(new Student("Irma", "Gardner", "Info"));
        people.add(new Student("Tiger", "Butler", "Info"));
        people.add(new Student("Kyle", "Reid", "Info"));
        people.add(new Student("Yoko", "Perry", "Info"));
        people.add(new Student("Alden", "Brennan", "Info"));
        people.add(new Student("Tana", "Whitney", "Info"));
        people.add(new Student("Vivien", "Allison", "Info"));
        people.add(new Student("Arsenio", "Pugh", "Info"));
        people.add(new Student("Nissim", "Chan", "Info"));
        people.add(new Student("Kasimir", "Eaton", "Info"));
        people.add(new Student("Nicholas", "Stone", "Info"));
        people.add(new Student("Jada", "Underwood", "Info"));
        people.add(new Student("Honorato", "Lyons", "Info"));
        people.add(new Student("Montana", "Benjamin", "Info"));
        people.add(new Student("Winifred", "Keith", "Info"));
        people.add(new Student("Xander", "Mckinney", "Info"));
        people.add(new Student("Benedict", "Ferrell", "Info"));
        people.add(new Student("Kylan", "Noble", "Info"));
        people.add(new Student("Wilma", "Warren", "Info"));
        people.add(new Student("Paloma", "Stokes", "Info"));
        people.add(new Student("Jacob", "Phillips", "Info"));
        people.add(new Student("Raya", "Whitaker", "Info"));
        people.add(new Student("Constance", "Fleming", "Poly"));
        people.add(new Student("Wilma", "Fitzpatrick", "Poly"));
        people.add(new Student("Charissa", "Vincent", "Poly"));
        people.add(new Student("Lisandra", "Burch", "Poly"));
        people.add(new Student("Rae", "George", "Poly"));
        people.add(new Student("Vladimir", "Hurst", "Poly"));
        people.add(new Student("Beatrice", "Mercer", "Poly"));
        people.add(new Student("Ferdinand", "Mccoy", "Poly"));
        people.add(new Student("Ulric", "Joyner", "Poly"));
        people.add(new Student("Marshall", "Leon", "Poly"));
        people.add(new Student("Whitney", "Patton", "Poly"));
        people.add(new Student("Ryder", "Serrano", "Poly"));
        people.add(new Student("Lani", "Oliver", "Poly"));
        people.add(new Student("Jena", "Logan", "Poly"));
        people.add(new Student("Wallace", "Stafford", "Poly"));
        people.add(new Student("Isaac", "Winters", "Poly"));
        people.add(new Student("Elaine", "Combs", "Poly"));
        people.add(new Student("Francis", "Hansen", "Poly"));
        people.add(new Student("Oliver", "Acevedo", "Poly"));
        people.add(new Student("Cooper", "Walters", "Media"));
        people.add(new Student("Venus", "Molina", "Media"));
        people.add(new Student("Ivan", "Rich", "Media"));
        people.add(new Student("Noble", "Walsh", "Media"));
        people.add(new Student("Grady", "Rowe", "Media"));
        people.add(new Student("Eugenia", "Vega", "Media"));

        // list of pseudos
        String[] pseudos = {
                "Toronto",
                "Barnstaple",
                "Aalst",
                "San Giovanni Lipioni",
                "Castelluccio Superiore",
                "Liberchies",
                "Wagga Wagga",
                "Santa Luzia",
                "Timkur",
                "Harderwijk",
                "Lampernisse",
                "Glimes",
                "Bargagli",
                "Brussel",
                "Drumheller",
                "Edmundston",
                "Greifswald",
                "Satna",
                "Vliermaalroot",
                "Maintal",
                "Yungay",
                "Quilleco",
                "Guben",
                "Grouville",
                "Padre las Casas",
                "Saint-Georges",
                "San Martino in Pensilis",
                "Salisbury",
                "New Haven",
                "Worksop",
                "Bersillies-l'Abbaye",
                "Bayeux",
                "Fulda",
                "Diano Arentino",
                "Haridwar",
                "Wrigley",
                "Piła",
                "Pemberton",
                "Wetzlar",
                "Montebello",
                "Herstappe",
                "Igboho",
                "Tufo",
                "Sombreffe",
                "Seilles",
                "La Magdeleine",
                "Saint-Denis-Bovesse",
                "Stalhille",
                "Bargagli",
                "Independencia",
                "Miami",
                "Araban",
                "Tobermory",
                "Vellore",
                "San Rafael",
                "Dallas",
                "Warwick",
                "Kapolei",
                "Birmingham",
                "Unnao",
                "Aalst",
                "Panguipulli",
                "Villers-la-Bonne-Eau",
                "Zwijnaarde",
                "Fort Simpson",
                "Newport",
                "Piancastagnaio",
                "Brechin",
                "San Pedro",
                "Baunatal",
                "Blieskastel",
                "High Level",
                "Quinte West",
                "Marke",
                "New Sarepta",
                "Pinto",
                "Würzburg",
                "Bundaberg",
                "Martello/Martell",
                "Inverurie",
                "Wambeek",
                "Callander",
                "Xhoris",
                "Beauvais",
                "Traralgon",
                "Halifax",
                "Moose Jaw",
                "Portici",
                "Ziano di Fiemme",
                "Purmerend",
                "Flin Flon",
                "Ferlach",
                "Broken Hill",
                "Shimla",
                "Kortessem",
                "Santa Marina",
                "Leffinge",
                "Heusden",
                "Beaumont",
                "Chailly",
                "Wergen",
                "Patrok",
                "Castor",
                "Pollux",
                "Genesis",
                "Pink",
                "Floyd",
                "Flintstones",
                "Burtons",
                "Oakley",
                "Rampage",
                "Canyons",
                "Missisipi",
                "Volken",
                "Stary night",
                "Stray cats",
                "Holy Cow",
                "Holy Molly",
                "Verdammt",
                "Petzi",
                "Captain Cook",
                "Mozilla",
                "Mozzarella",
                "Vongoles",
                "Stray dogs",
                "Dingos"
        };

        // Initialise pseudos
        Iterator<String> pseudo = Arrays.asList(pseudos).iterator();
        for (Person p : people) p.setPseudo(pseudo.next());

        // Teacher teams
        teams = new ArrayList<Team>();
        for (int nt = 0; nt < nbTeams; nt++) {
            Team aTeam = new Team(pseudo.next(), people.get(alea.nextInt(people.size())));
            int tsize = alea.nextInt(3) + 2; // pick a team size between 2 and 4
            Person newTPlayer;
            for (int i = 0; i < tsize; i++) {
                newTPlayer = people.get(alea.nextInt(people.size()));
                aTeam.newPlayer(newTPlayer);
                people.remove(newTPlayer); // avoid having one person in two teams
            }
            teams.add(aTeam);
        }

        // List of games
        games = new ArrayList<Game>();
        for (int p = 0; p < 2; p++) {
            for (int i = p * 8; i < (p + 1) * 8 - 1; i++) {
                for (int j = i + 1; j < (p + 1) * 8; j++) {
                    Game g = new Game(teams.get(i), teams.get(j));
                    Integer s1 = alea.nextInt(20) + 5;
                    Integer s2 = alea.nextInt(20) + 5;
                    g.setScore(s1, s2);
                    games.add(g);
                }
            }
        }
    }

}
