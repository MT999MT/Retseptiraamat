import java.util.Random;
import java.util.ArrayList;

public class RetseptiRaamat {

    private ArrayList<Retsept> retseptid;

    private Random rand = new Random();

    private String[] tudengiretseptid;

    public RetseptiRaamat() {
        retseptid = new ArrayList<Retsept>();

        tudengiretseptid = new String[8];
        tudengiretseptid[0] = "Makaronid ketšupiga";
        tudengiretseptid[1] = "Leib võiga";
        tudengiretseptid[2] = "Munaputru soola ja pipraga";
        tudengiretseptid[3] = "Keedetud riis sojakastmega";
        tudengiretseptid[4] = "Nuudlid kuubikupuljongi ja munaga";
        tudengiretseptid[5] = "Jogurt müslitükkidega";
        tudengiretseptid[6] = "Võileib juustu ja sinepiga";
        tudengiretseptid[7] = "Külm pitsa (eelmisest õhtust)";

        lisaVaikimisiRetseptid();
    }

    private void lisaVaikimisiRetseptid() {

        Retsept bolognese = new Retsept("Spagetibolognese", 40);
        bolognese.lisaKoostisosa("spagetid");
        bolognese.lisaKoostisosa("hakkliha");
        bolognese.lisaKoostisosa("tomatipasta");
        bolognese.lisaKoostisosa("sibul");
        bolognese.lisaKoostisosa("küüslauk");
        retseptid.add(bolognese);

        Retsept omlett = new Retsept("Klassikaline omlett", 15);
        omlett.lisaKoostisosa("munad");
        omlett.lisaKoostisosa("piim");
        omlett.lisaKoostisosa("või");
        omlett.lisaKoostisosa("sool");
        retseptid.add(omlett);

        Retsept kanasupp = new Retsept("Kanasupp köögiviljadega", 60);
        kanasupp.lisaKoostisosa("kana");
        kanasupp.lisaKoostisosa("porgand");
        kanasupp.lisaKoostisosa("kartul");
        kanasupp.lisaKoostisosa("sibul");
        kanasupp.lisaKoostisosa("petersell");
        retseptid.add(kanasupp);

        Retsept praetudRiis = new Retsept("Praetud riis munaga", 25);
        praetudRiis.lisaKoostisosa("riis");
        praetudRiis.lisaKoostisosa("munad");
        praetudRiis.lisaKoostisosa("sojakaste");
        praetudRiis.lisaKoostisosa("küüslauk");
        praetudRiis.lisaKoostisosa("sibul");
        retseptid.add(praetudRiis);

        Retsept pannkoogid = new Retsept("Eesti pannkoogid", 30);
        pannkoogid.lisaKoostisosa("jahu");
        pannkoogid.lisaKoostisosa("munad");
        pannkoogid.lisaKoostisosa("piim");
        pannkoogid.lisaKoostisosa("suhkur");
        pannkoogid.lisaKoostisosa("sool");
        pannkoogid.lisaKoostisosa("või");
        retseptid.add(pannkoogid);

        Retsept kuuslaugu = new Retsept("Küüslauguleib ahjust", 20);
        kuuslaugu.lisaKoostisosa("leib");
        kuuslaugu.lisaKoostisosa("või");
        kuuslaugu.lisaKoostisosa("küüslauk");
        kuuslaugu.lisaKoostisosa("petersell");
        retseptid.add(kuuslaugu);

        Retsept pastaJuust = new Retsept("Pasta juustukastmega", 25);
        pastaJuust.lisaKoostisosa("makaronid");
        pastaJuust.lisaKoostisosa("juust");
        pastaJuust.lisaKoostisosa("koor");
        pastaJuust.lisaKoostisosa("või");
        retseptid.add(pastaJuust);

        Retsept kartulipuder = new Retsept("Kartulipuder vorstiga", 35);
        kartulipuder.lisaKoostisosa("kartul");
        kartulipuder.lisaKoostisosa("piim");
        kartulipuder.lisaKoostisosa("või");
        kartulipuder.lisaKoostisosa("vorst");
        kartulipuder.lisaKoostisosa("sool");
        retseptid.add(kartulipuder);

        Retsept kanaCurry = new Retsept("Kana curry riisiga", 50);
        kanaCurry.lisaKoostisosa("kana");
        kanaCurry.lisaKoostisosa("curry pasta");
        kanaCurry.lisaKoostisosa("piimakoor");
        kanaCurry.lisaKoostisosa("porgand");
        kanaCurry.lisaKoostisosa("sibul");
        retseptid.add(kanaCurry);

        Retsept kreemjasPasta = new Retsept("Kreemjas pasta seentega", 30);
        kreemjasPasta.lisaKoostisosa("pasta");
        kreemjasPasta.lisaKoostisosa("seened");
        kreemjasPasta.lisaKoostisosa("koor");
        kreemjasPasta.lisaKoostisosa("sibul");
        kreemjasPasta.lisaKoostisosa("küüslauk");
        retseptid.add(kreemjasPasta);

        Retsept suppTomat = new Retsept("Tomatisupp basiilikuga", 25);
        suppTomat.lisaKoostisosa("tomatid");
        suppTomat.lisaKoostisosa("sibul");
        suppTomat.lisaKoostisosa("küüslauk");
        suppTomat.lisaKoostisosa("petersell");
        suppTomat.lisaKoostisosa("basiilik");
        retseptid.add(suppTomat);

        Retsept salatKanasalat = new Retsept("Kanasalat jogurti kastmega", 20);
        salatKanasalat.lisaKoostisosa("kana");
        salatKanasalat.lisaKoostisosa("salatilehed");
        salatKanasalat.lisaKoostisosa("tomat");
        salatKanasalat.lisaKoostisosa("kurk");
        salatKanasalat.lisaKoostisosa("jogurt");
        retseptid.add(salatKanasalat);

        Retsept köögiviljapirukas = new Retsept("Köögiviljapirukas", 60);
        köögiviljapirukas.lisaKoostisosa("pärmitaigen");
        köögiviljapirukas.lisaKoostisosa("porgand");
        köögiviljapirukas.lisaKoostisosa("brokoli");
        köögiviljapirukas.lisaKoostisosa("paprika");
        köögiviljapirukas.lisaKoostisosa("juust");
        retseptid.add(köögiviljapirukas);

        Retsept omlettKartul = new Retsept("Omlett kartulitega", 20);
        omlettKartul.lisaKoostisosa("munad");
        omlettKartul.lisaKoostisosa("kartul");
        omlettKartul.lisaKoostisosa("piim");
        omlettKartul.lisaKoostisosa("sool");
        omlettKartul.lisaKoostisosa("pipar");
        retseptid.add(omlettKartul);

        Retsept pannkoogidMarjad = new Retsept("Pannkoogid marjadega", 35);
        pannkoogidMarjad.lisaKoostisosa("jahu");
        pannkoogidMarjad.lisaKoostisosa("munad");
        pannkoogidMarjad.lisaKoostisosa("piim");
        pannkoogidMarjad.lisaKoostisosa("marjad");
        pannkoogidMarjad.lisaKoostisosa("suhkur");
        retseptid.add(pannkoogidMarjad);

        Retsept magusKreem = new Retsept("Magus kreem šokolaadiga", 25);
        magusKreem.lisaKoostisosa("piim");
        magusKreem.lisaKoostisosa("suhkur");
        magusKreem.lisaKoostisosa("šokolaad");
        magusKreem.lisaKoostisosa("jahu");
        magusKreem.lisaKoostisosa("munad");
        retseptid.add(magusKreem);

        Retsept sushiKodune = new Retsept("Kodune sushi", 45);
        sushiKodune.lisaKoostisosa("riis");
        sushiKodune.lisaKoostisosa("vetikad");
        sushiKodune.lisaKoostisosa("kurgi");
        sushiKodune.lisaKoostisosa("avokaado");
        sushiKodune.lisaKoostisosa("sojakaste");
        retseptid.add(sushiKodune);

        Retsept wrapsKana = new Retsept("Wrap kanaga", 20);
        wrapsKana.lisaKoostisosa("tortilla");
        wrapsKana.lisaKoostisosa("kana");
        wrapsKana.lisaKoostisosa("salatilehed");
        wrapsKana.lisaKoostisosa("tomat");
        wrapsKana.lisaKoostisosa("juust");
        retseptid.add(wrapsKana);
    }

    public void lisaRetsept(Retsept r) {
        retseptid.add(r);
    }

    public int kuvasobivadRetseptid(ArrayList<String> olemasolevad) {
        int leitud = 0;

        for (int i = 0; i < retseptid.size(); i++) {
            if (retseptid.get(i).onTaielikultKaetud(olemasolevad)) {
                leitud = leitud + 1;
                System.out.println("  " + leitud + ". " + retseptid.get(i).getNimi()
                        + " (valmistusaeg: " + retseptid.get(i).getValmistusaeg() + " min)");
            }
        }

        return leitud;
    }

    public int kuvaOstunimekiri(ArrayList<String> olemasolevad) {
        int leitud = 0;

        for (int i = 0; i < retseptid.size(); i++) {
            int puuduvaid = retseptid.get(i).puuduvateArv(olemasolevad);

            if (puuduvaid >= 1 && puuduvaid <= 2) {
                leitud = leitud + 1;
                System.out.println("  " + retseptid.get(i).getNimi()
                        + " (" + retseptid.get(i).getValmistusaeg() + " min)");
                System.out.println("  Poest:");

                ArrayList<String> puuduvad = retseptid.get(i).puuduvadKoostisosad(olemasolevad);
                for (int j = 0; j < puuduvad.size(); j++) {
                    System.out.println("    -> " + puuduvad.get(j));
                }
                System.out.println();
            }
        }

        return leitud;
    }

    public String juhuslikTudengiretsept() {
        int indeks = (int) (System.currentTimeMillis() % tudengiretseptid.length);
        return tudengiretseptid[indeks];
    }

    public void kuvaKoikRetseptid() {
        for (int i = 0; i < retseptid.size(); i++) {
            System.out.println("  - " + retseptid.get(i).getNimi());
        }
    }

    public int getRetseptideArv() {
        return retseptid.size();
    }

    // ✅ SINU UUS FUNKTSIOON
    public Retsept juhuslikRetsept() {
        if (retseptid.isEmpty()) {
            return null;
        }

        int indeks = rand.nextInt(retseptid.size());
        return retseptid.get(indeks);
    }
}