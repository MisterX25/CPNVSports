package activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import Entities.Game;
import Entities.Participant;
import Entities.Person;
import Entities.Student;
import Entities.Teacher;
import Entities.Team;
import ch.cpnv.cpnvsports.R;


public class cpnvSportsHome extends Activity
    implements View.OnClickListener {

    // Constants
    private final int nbGames = 50;
    private final int nbTeams = 10;

    // infrasctructure
    private Button btn; // Handle on button
    private TextView output; // handle on output zone
    private EditText input; // handle on input text box
    private Context context; // For toasts

    // application
    private ArrayList<Team> teacherTeams;
    private ArrayList<Team> studentTeams;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Participant> participants;
    private ArrayList<Participant> participants;
    private ArrayList<Game> teamGames;
    private ArrayList<Game> individualGames;

    private Random alea = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpnv_sports_home);

        // Application data
        initializeAppData();

        // Initialize handles
        output = (TextView)findViewById(R.id.txtOutput);
        input = (EditText)findViewById(R.id.txtInputText);
        context = getApplicationContext(); // This can go in the constructor because it does not depend on the view content

        // define event handlers
        btn=(Button)findViewById(R.id.cmdButton1);
        btn.setOnClickListener(this);
        btn=(Button)findViewById(R.id.cmdButton2);
        btn.setOnClickListener(this);
        btn=(Button)findViewById(R.id.cmdButton3);
        btn.setOnClickListener(this);
        btn=(Button)findViewById(R.id.cmdButton4);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View btn)
    {

        Button clicked = (Button)btn;
        switch (clicked.getId())
        {

            case R.id.cmdButton1:
                output.setText("Participants:");
                for (Participant p:participants)
                    output.setText(output.getText()+"\n"+p.dump());
                break;
            case R.id.cmdButton2:
                output.setText("Matches entre équipes:");
                for (Game g:teamGames)
                    output.setText(output.getText()+"\n"+g.dump());
                output.setText(output.getText()+"\n\nMatches entre individus:");
                for (Game g:individualGames)
                    output.setText(output.getText()+"\n"+g.dump());
                break;
            case R.id.cmdButton3:
                break;
            case R.id.cmdButton4:
                break;

        }
    }

    //=========================================== Private methods ==================================

    private void initializeAppData()
    {
        teachers = new ArrayList<Teacher>();
        students = new ArrayList<Student>();

        // from generatedata.com
        teachers.add(new Teacher("Adria","Holt","Info"));
        teachers.add(new Teacher("Kasper","Booth","Info"));
        teachers.add(new Teacher("Samuel","Leach","Info"));
        teachers.add(new Teacher("Colton","Camacho","Info"));
        teachers.add(new Teacher("Chiquita","Armstrong","Info"));
        teachers.add(new Teacher("Travis","Carver","Info"));
        teachers.add(new Teacher("Brendan","Shannon","Info"));
        teachers.add(new Teacher("Irene","Hayden","Info"));
        teachers.add(new Teacher("Kadeem","Travis","Info"));
        teachers.add(new Teacher("Raya","Burgess","Info"));
        teachers.add(new Teacher("Marvin","Patterson","Info"));
        teachers.add(new Teacher("Barbara","Williams","Info"));
        teachers.add(new Teacher("Jada","Joyce","Info"));
        teachers.add(new Teacher("Anastasia","Bean","Poly"));
        teachers.add(new Teacher("Branden","Ware","Poly"));
        teachers.add(new Teacher("Mary","Lane","Poly"));
        teachers.add(new Teacher("Shelly","Love","Poly"));
        teachers.add(new Teacher("Isaiah","Mccall","Poly"));
        teachers.add(new Teacher("Alana","Hinton","Poly"));
        teachers.add(new Teacher("Sigourney","Rosa","Poly"));
        teachers.add(new Teacher("Rogan","Briggs","Poly"));
        teachers.add(new Teacher("Medge","Trevino","Poly"));
        teachers.add(new Teacher("Nevada","Vazquez","Poly"));
        teachers.add(new Teacher("Dane","Slater","Poly"));
        teachers.add(new Teacher("Craig","Obrien","Poly"));
        teachers.add(new Teacher("Piper","Moran","Poly"));
        teachers.add(new Teacher("Barclay","Suarez","Poly"));
        teachers.add(new Teacher("Yoko","Perez","Poly"));
        teachers.add(new Teacher("Colorado","Dixon","Poly"));
        teachers.add(new Teacher("Laith","Macdonald","Poly"));
        teachers.add(new Teacher("Isabella","Fry","Poly"));
        teachers.add(new Teacher("Kane","Conrad","Poly"));
        teachers.add(new Teacher("Kasper","Mcdonald","Media"));
        teachers.add(new Teacher("Ifeoma","Austin","Media"));
        teachers.add(new Teacher("Deanna","Baird","Media"));
        teachers.add(new Teacher("Erasmus","Middleton","Media"));
        teachers.add(new Teacher("Zane","Mcleod","Media"));
        students.add(new Student("Inga","Flowers","Media"));
        students.add(new Student("Wesley","Gallagher","Media"));
        students.add(new Student("Linus","Goodwin","Media"));
        students.add(new Student("Elton","Drake","Media"));
        students.add(new Student("Justine","Whitfield","Media"));
        students.add(new Student("Kaseem","Chambers","Media"));
        students.add(new Student("Melinda","Fitzpatrick","Media"));
        students.add(new Student("Thaddeus","Cherry","Media"));
        students.add(new Student("Sarah","Hunt","Media"));
        students.add(new Student("Holly","Ratliff","Media"));
        students.add(new Student("Xanthus","Watson","Media"));
        students.add(new Student("Jarrod","Thomas","Info"));
        students.add(new Student("Sybil","Paul","Info"));
        students.add(new Student("Brenna","Hale","Info"));
        students.add(new Student("Lee","Sanders","Info"));
        students.add(new Student("Irma","Gardner","Info"));
        students.add(new Student("Tiger","Butler","Info"));
        students.add(new Student("Kyle","Reid","Info"));
        students.add(new Student("Yoko","Perry","Info"));
        students.add(new Student("Alden","Brennan","Info"));
        students.add(new Student("Tana","Whitney","Info"));
        students.add(new Student("Vivien","Allison","Info"));
        students.add(new Student("Arsenio","Pugh","Info"));
        students.add(new Student("Nissim","Chan","Info"));
        students.add(new Student("Kasimir","Eaton","Info"));
        students.add(new Student("Nicholas","Stone","Info"));
        students.add(new Student("Jada","Underwood","Info"));
        students.add(new Student("Honorato","Lyons","Info"));
        students.add(new Student("Montana","Benjamin","Info"));
        students.add(new Student("Winifred","Keith","Info"));
        students.add(new Student("Xander","Mckinney","Info"));
        students.add(new Student("Benedict","Ferrell","Info"));
        students.add(new Student("Kylan","Noble","Info"));
        students.add(new Student("Wilma","Warren","Info"));
        students.add(new Student("Paloma","Stokes","Info"));
        students.add(new Student("Jacob","Phillips","Info"));
        students.add(new Student("Raya","Whitaker","Info"));
        students.add(new Student("Constance","Fleming","Poly"));
        students.add(new Student("Wilma","Fitzpatrick","Poly"));
        students.add(new Student("Charissa","Vincent","Poly"));
        students.add(new Student("Lisandra","Burch","Poly"));
        students.add(new Student("Rae","George","Poly"));
        students.add(new Student("Vladimir","Hurst","Poly"));
        students.add(new Student("Beatrice","Mercer","Poly"));
        students.add(new Student("Ferdinand","Mccoy","Poly"));
        students.add(new Student("Ulric","Joyner","Poly"));
        students.add(new Student("Marshall","Leon","Poly"));
        students.add(new Student("Whitney","Patton","Poly"));
        students.add(new Student("Ryder","Serrano","Poly"));
        students.add(new Student("Lani","Oliver","Poly"));
        students.add(new Student("Jena","Logan","Poly"));
        students.add(new Student("Wallace","Stafford","Poly"));
        students.add(new Student("Isaac","Winters","Poly"));
        students.add(new Student("Elaine","Combs","Poly"));
        students.add(new Student("Francis","Hansen","Poly"));
        students.add(new Student("Oliver","Acevedo","Poly"));
        students.add(new Student("Cooper","Walters","Media"));
        students.add(new Student("Venus","Molina","Media"));
        students.add(new Student("Ivan","Rich","Media"));
        students.add(new Student("Noble","Walsh","Media"));
        students.add(new Student("Grady","Rowe","Media"));
        students.add(new Student("Eugenia","Vega","Media"));

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
                "Pollux"
        };

        // Initialise pseudos
        Iterator<String> pseudo = Arrays.asList(pseudos).iterator();
        for (Teacher t:teachers) t.setPseudo(pseudo.next());
        for (Student s:students) s.setPseudo(pseudo.next());

        // Some teams
        teacherTeams = new ArrayList<Team>();
        for (int nt=0; nt<nbTeams; nt++)
        {
            Team aTeam = new Team("Temp",teachers.get(alea.nextInt(teachers.size())));
            aTeam.setPseudo(aTeam.getCaptain().getLastname()); // Team's pseudo is the last name of the captain
            int tsize = alea.nextInt(3)+2; // pick a team size between 2 and 4
            Teacher newTPlayer;
            for (int i=0; i< tsize; i++)
            {
                newTPlayer=teachers.get(alea.nextInt(teachers.size()));
                aTeam.newPlayer(newTPlayer);
                teachers.remove(newTPlayer); // avoid having one teacher in two teams
            }
            teacherTeams.add(aTeam);
        }

        studentTeams = new ArrayList<Team>();
        for (int nt=0; nt<nbTeams; nt++)
        {
            Team aTeam = new Team("Temp", students.get(alea.nextInt(students.size())));
            aTeam.setPseudo(aTeam.getCaptain().getLastname()); // Team's pseudo is the last name of the captain
            int tsize = alea.nextInt(3) + 2; // pick a team size between 2 and 4
            Student newSPlayer;
            for (int i = 0; i < tsize; i++)
            {
                newSPlayer = students.get(alea.nextInt(students.size()));
                aTeam.newPlayer(newSPlayer);
                students.remove(newSPlayer);
            }
            studentTeams.add(aTeam);
        }

        // Build list of all participants. We make a single list because the end goal is to find the best participant, team or individual
        teams = new ArrayList<Participant>();
        participants.addAll(teacherTeams);
        participants.addAll(studentTeams);
        participants.addAll(teachers);
        participants.addAll(students);


        Integer nbTeamParticipants = teacherTeams.size()+studentTeams.size();
        Integer nbIndividualParticipants = teachers.size()+students.size();

        // List of team games
        teamGames = new ArrayList<Game>();
        for (int i=0; i<nbGames; i++)
        {
            Integer p1=alea.nextInt(nbTeamParticipants);
            Integer p2=alea.nextInt(nbTeamParticipants);
            Game g=new Game(participants.get(p1),participants.get(p2));
            Integer s1=alea.nextInt(20)+5;
            Integer s2=alea.nextInt(20)+5;;
            g.setScore(s1,s2);
            teamGames.add(g);
        }
        // List of individual games
        individualGames = new ArrayList<Game>();
        for (int i=0; i<nbGames; i++)
        {
            Integer p1=alea.nextInt(nbIndividualParticipants);
            Integer p2=alea.nextInt(nbIndividualParticipants);
            Game g=new Game(participants.get(nbTeamParticipants+p1),participants.get(nbTeamParticipants+p2));
            Integer s1=alea.nextInt(20)+5;
            Integer s2=alea.nextInt(20)+5;;
            g.setScore(s1,s2);
            individualGames.add(g);
        }
    }
}
