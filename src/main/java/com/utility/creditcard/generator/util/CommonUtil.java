package com.utility.creditcard.generator.util;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A utility class with static methods used to generate
 * a credit card number
 */
public class CommonUtil {

    public static final String DEFAULT_CARD_TYPE = "Visa";
    public static final boolean DEFAULT_EXP = false;
    public static final boolean DEFAULT_CVV = false;
    public static final Long DEFAULT_QUANTITY = 1L;
    public static List<String> CCList;
    private static List<String> userNamesList;

    /**
     * A static utility method for validating Lunh Algorithm
     * @param number Credit card number to validate Luhn Algorithm
     * @return boolean true/false
     */
    public static boolean luhnCheck(final String number) {
        return (LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(number));
    }

    /**
     * A static utility method to generate a random expiry date
     * @return String expiry date Ex. 2018/12
     */
    public static String generateExpDate() {
        return Calendar.getInstance().get(Calendar.YEAR)+ ThreadLocalRandom.current().nextInt(2,6)
                + "/" + String.format("%02d",ThreadLocalRandom.current().nextInt(1,12));
    }

    /**
     * A static utility method to generate a random CVV
     * @return int CVV number
     */
    public static String generateCvv(boolean digit4) {
        int cvv = 0;
        String formattedCvv = "101";
        if(digit4){
            cvv = ThreadLocalRandom.current().nextInt(1,998);
            cvv = (cvv * 10)  + ThreadLocalRandom.current().nextInt(0,9);
            formattedCvv = String.format("%04d",cvv);
        } else {
            cvv = ThreadLocalRandom.current().nextInt(1,998);
            formattedCvv = String.format("%03d",cvv);
        }
        return formattedCvv;
    }

    public static String generateUserName() {
      return userNamesList.get(ThreadLocalRandom.current().nextInt(0,498));
    }

    /**
     * A list of various types of Credit Cards
     */
    static {
        CCList = Collections.unmodifiableList(
                Arrays.asList(
                        "5404 36xx xxxx xxxx MasterCard - Lloyds Tsb Bank Plc., UK",
                        "5404 37xx xxxx xxxx MasterCard - Lloyds Tsb Bank Plc., UK",
                        "5177 43xx xxxx xxxx MasterCard - Credit Suisse, Switzerland",
                        "5218 41xx xxxx xxxx MasterCard - Ubs Ag, Switzerland",
                        "5288 77xx xxxx xxxx MasterCard - Banco Nacional De Mexico, S.A.",
                        "5289 00xx xxxx xxxx MasterCard - Bank Of America, USA",
                        "5314 50xx xxxx xxxx MasterCard - Bank Of America, USA",
                        "5315 7xxx xxxx xxxx MasterCard - First Usa Bank, USA.",
                        "5323 5xxx xxxx xxxx MasterCard - Chase Manhattan Bank USA, USA",
                        "5369 90xx xxxx xxxx MasterCard - Chase Manhattan Bank USA, USA",
                        "5405 10xx xxxx xxxx MasterCard - Wells Fargo Bank, USA",
                        "5121 64xx xxxx xxxx MasterCard - HSBC Bank Canada, Canada",
                        "5221 22xx xxxx xxxx MasterCard - Bank Of Montreal, Canada",
                        "5122 17xx xxxx xxxx MasterCard - Commonwealth Bank Of Australia, Australia",
                        "5324 20xx xxxx xxxx MasterCard - China Construction Bank, China",
                        "5592 09xx xxxx xxxx MasterCard - Banco Nacional De Mexico, S.A., Mexico",
                        "5137 4xxx xxxx xxxx MasterCard - Europay France Sas, France",
                        "5520 71xx xxxx xxxx MasterCard - Banco Bilbao Vizcaya Argentaria S.A., Spain",
                        "5522 00xx xxxx xxxx MasterCard - HSBC Bank Malta P.L.C., Malta",
                        "5127 17xx xxxx xxxx MasterCard - National Bank Of Dubai Ltd., United Arab Emirates",
                        "5xxx xxxx xxxx xxxx MasterCard",
                        "4003 91xx xxxx xxxx Visa - First United Bank, USA (Debit, Classic)",
                        "4003 93xx xxxx xxxx Visa - Capital One Bank, USA (Classic)",
                        "4223 99xx xxxx xxxx Visa - Chase Manhattan Bank USA, USA (Debit, Classic)",
                        "4030 73xx xxxx xxxx Visa - Chase Manhattan Bank USA, USA (Platinum)",
                        "4113 55xx xxxx xxxx Visa - Chase Manhattan Bank USA, USA (Platinum)",
                        "4343 51xx xxxx xxxx Visa - HSBC Bank Nevada, USA (Classic)",
                        "4343 85xx xxxx xxxx Visa - HSBC Bank Nevada, USA (Gold)",
                        "4000 52xx xxxx xxxx Visa - The Connecticut Bank And Trust Company, USA (Debit, Classic)",
                        "4265 10xx xxxx xxxx Visa - Barclays Bank Plc, UK (Classic)",
                        "4265 03xx xxxx xxxx Visa - Barclays Bank Plc, UK (Gold)",
                        "4265 04xx xxxx xxxx Visa - Barclays Bank Plc, UK (Platinum)",
                        "4112 98xx xxxx xxxx Visa - Lloyds Tsb Bank Plc, UK (Classic)",
                        "4479 65xx xxxx xxxx Visa - Citibank International Plc, UK (Business)",
                        "4067 42xx xxxx xxxx Visa - Bank Of Valletta Plc, Malta (Debit, Classic)",
                        "4233 85xx xxxx xxxx Visa - First International Bank Ltd., Malta (Gold)",
                        "4188 75xx xxxx xxxx Visa - Bank Of Valletta Plc, Malta (Platinum)",
                        "4137 73xx xxxx xxxx Visa - Topcard Service S.A., Switzerland (Classic)",
                        "4133 91xx xxxx xxxx Visa - Ubs Ag (Union Bank Of Switzerland), Switzerland (Gold)",
                        "4133 92xx xxxx xxxx Visa - Ubs Ag (Union Bank Of Switzerland), Switzerland (Business)",
                        "4001 31xx xxxx xxxx Visa - Barclays Bank Plc, Portugal (Debit, Electron)",
                        "4001 02xx xxxx xxxx Visa - Banco Do Brasil S.A., Brazil (Debit, Electron)",
                        "4001 36xx xxxx xxxx Visa - Banco Do Brasil S.A., Brazil (Debit, Electron)",
                        "4009 58xx xxxx xxxx Visa - Caixa Economica Federal, Brazil (Classic)",
                        "4009 59xx xxxx xxxx Visa - Caixa Economica Federal, Brazil (Gold)",
                        "4009 60xx xxxx xxxx Visa - Caixa Economica Federal, Brazil (Business)",
                        "4002 13xx xxxx xxxx Visa - The Hongkong And Shanghai Banking Corporation Ltd., Brunei (Classic)",
                        "4002 14xx xxxx xxxx Visa - The Hongkong And Shanghai Banking Corporation Ltd., Brunei (Gold)",
                        "4002 59xx xxxx xxxx Visa - Banco Sudameris Argentina S.A., Argentina (Classic)",
                        "4357 31xx xxxx xxxx Visa - HSBC Bank Argentina S.A., Argentina (Classic)",
                        "4357 52xx xxxx xxxx Visa - Banco Velox S.A., Argentina (Classic)",
                        "4357 53xx xxxx xxxx Visa - Banco Velox S.A., Argentina (Gold)",
                        "4002 62xx xxxx xxxx Visa - Coop Bank Ab, Sweden (Classic)",
                        "4003 31xx xxxx xxxx Visa - Sanpaolo Imi S.P.A., Italy (Debit, Electron)",
                        "4003 15xx xxxx xxxx Visa - Banca Monte Dei Paschi Di Siena S.P.A., Italy (Electron)",
                        "4003 29xx xxxx xxxx Visa - Banca Nazionale Del Lavoro, Italy (Classic)",
                        "4003 59xx xxxx xxxx Visa - Taiwan Shin Kong Commercial Bank, Taiwan (Infinite)",
                        "4003 61xx xxxx xxxx Visa - Chinatrust Commercial Bank, Taiwan (Infinite)",
                        "4003 63xx xxxx xxxx Visa - Banco Nacional Ultramarino, S.A., Macau (Platinum)",
                        "4017 80xx xxxx xxxx Visa - Banco Cooperativo Espanol S.A., Spain (Debit, Electron)",
                        "4020 40xx xxxx xxxx Visa - Caja De Ahorros Y Pensiones De Barcelona (La Caixa), Spain (Debit, Electron)",
                        "4035 69xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Debit, Electron)",
                        "4035 67xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Classic)",
                        "4035 68xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Classic)",
                        "4036 42xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Platinum)",
                        "4343 87xx xxxx xxxx Visa - Iberia Cards, Spain (Business)",
                        "4539 71xx xxxx xxxx Visa - Citibank, Philippines (Classic)",
                        "4539 72xx xxxx xxxx Visa - Citibank, Philippines (Gold)",
                        "4036 49xx xxxx xxxx Visa - Deutscher Sparkassen- Und Giroverband, Germany (Debit, Classic)",
                        "4036 50xx xxxx xxxx Visa - Deutscher Sparkassen- Und Giroverband, Germany (Debit, Gold)",
                        "4035 79xx xxxx xxxx Visa - HSBC France, France (Debit, Classic)",
                        "4561 22xx xxxx xxxx Visa - HSBC France, France (Gold)",
                        "4150 56xx xxxx xxxx Visa - Societe Generale, France (Classic)",
                        "4971 19xx xxxx xxxx Visa - BNP Paribas, France (Classic)",
                        "4561 23xx xxxx xxxx Visa - BNP Paribas, France (Gold)",
                        "4101 01xx xxxx xxxx Visa - Barclays Bank Egypt Sae, Egypt (Debit, Electron)",
                        "4214 02xx xxxx xxxx Visa - Citizens Bank Of Canada, Canada (Debit, Classic)",
                        "4257 02xx xxxx xxxx Visa - Banque Laurentienne Du Canada, Canada (Corporate)",
                        "4257 03xx xxxx xxxx Visa - Absa Group Ltd., South Africa (Corporate)",
                        "4101 00xx xxxx xxxx Visa - Wells Fargo Bank, USA (Classic)",
                        "4113 40xx xxxx xxxx Visa - Wells Fargo Bank, USA (Debit, Classic)",
                        "4023 80xx xxxx xxxx Visa - Barclays Bank Plc, Gibraltar (Debit, Electron)",
                        "4050 68xx xxxx xxxx Visa - Barclays Bank Plc, Switzerland (Classic)",
                        "4010 00xx xxxx xxxx Visa - Bayerische Landesbank Girozentrale, Germany (Gold)",
                        "4018 49xx xxxx xxxx Visa - Commerzbank Ag, Germany (Debit, Classic)",
                        "4667 04xx xxxx xxxx Visa - Icici Bank Ltd, India (Debit, Classic)",
                        "4259 83xx xxxx xxxx Visa - Ixe Banco, S.A., Mexico (Debit, Classic)",
                        "4259 84xx xxxx xxxx Visa - Ixe Banco, S.A., Mexico (Debit, Gold)",
                        "4265 14xx xxxx xxxx Visa - HSBC Mexico S.A., Mexico (Electron)",
                        "4265 13xx xxxx xxxx Visa - HSBC Mexico S.A., Mexico (Business)",
                        "6011 xxxx xxxx xxxx Discover Card - prefix(6011)",
                        "65xx xxxx xxxx xxxx Discover Card - prefix(65)",
                        "644x xxxx xxxx xxxx Discover Card - prefix(644)",
                        "645x xxxx xxxx xxxx Discover Card - prefix(645)",
                        "646x xxxx xxxx xxxx Discover Card - prefix(646)",
                        "647x xxxx xxxx xxxx Discover Card - prefix(647)",
                        "648x xxxx xxxx xxxx Discover Card - prefix(648)",
                        "649x xxxx xxxx xxxx Discover Card - prefix(649)",
                        "6221 26xx xxxx xxxx Discover Card - prefix(622126)",
                        "6229 25xx xxxx xxxx Discover Card - prefix(622925)",
                        "3714 xxxx xxxx xxx  American Express Company, USA (Green)",
                        "3712 xxxx xxxx xxx  American Express Company, USA (Green)",
                        "3728 xxxx xxxx xxx  American Express Company, USA (Gold)",
                        "3703 70xx xxxx xxx  American Express Company, USA (Platinum)",
                        "3703 71xx xxxx xxx  American Express Company, USA (Platinum)",
                        "3738 xxxx xxxx xxx  American Express Company, USA (Corporate Card)",
                        "3702 46xx xxxx xxx  American Express - Industrial And Commercial Bank Of China, China",
                        "3702 47xx xxxx xxx  American Express - Industrial And Commercial Bank Of China, China",
                        "50xx xxxx xxxx xxxx Maestro Prefix(50)",
                        "56xx xxxx xxxx xxxx Maestro Prefix(56)",
                        "57xx xxxx xxxx xxxx Maestro Prfix(57)",
                        "58xx xxxx xxxx xxxx Maestro Prfix(58)",
                        "61xx xxxx xxxx xxxx Maestro Prfix(61)",
                        "68xx xxxx xxxx xxxx Maestro Prfix(68)",
                        "69xx xxxx xxxx xxxx Maestro Prfix(69)"
                ));

        userNamesList = Collections.unmodifiableList(
                Arrays.asList(
                        "James Butt",
                        "Josephine Darakjy",
                        "Art Venere",
                        "Lenna Paprocki",
                        "Donette Foller",
                        "Simona Morasca",
                        "Mitsue Tollner",
                        "Leota Dilliard",
                        "Sage Wieser",
                        "Kris Marrier",
                        "Minna Amigon",
                        "Abel Maclead",
                        "Kiley Caldarera",
                        "Graciela Ruta",
                        "Cammy Albares",
                        "Mattie Poquette",
                        "Meaghan Garufi",
                        "Gladys Rim",
                        "Yuki Whobrey",
                        "Fletcher Flosi",
                        "Bette Nicka",
                        "Veronika Inouye",
                        "Willard Kolmetz",
                        "Maryann Royster",
                        "Alisha Slusarski",
                        "Allene Iturbide",
                        "Chanel Caudy",
                        "Ezekiel Chui",
                        "Willow Kusko",
                        "Bernardo Figeroa",
                        "Ammie Corrio",
                        "Francine Vocelka",
                        "Ernie Stenseth",
                        "Albina Glick",
                        "Alishia Sergi",
                        "Solange Shinko",
                        "Jose Stockham",
                        "Rozella Ostrosky",
                        "Valentine Gillian",
                        "Kati Rulapaugh",
                        "Youlanda Schemmer",
                        "Dyan Oldroyd",
                        "Roxane Campain",
                        "Lavera Perin",
                        "Erick Ferencz",
                        "Fatima Saylors",
                        "Jina Briddick",
                        "Kanisha Waycott",
                        "Emerson Bowley",
                        "Blair Malet",
                        "Brock Bolognia",
                        "Lorrie Nestle",
                        "Sabra Uyetake",
                        "Marjory Mastella",
                        "Karl Klonowski",
                        "Tonette Wenner",
                        "Amber Monarrez",
                        "Shenika Seewald",
                        "Delmy Ahle",
                        "Deeanna Juhas",
                        "Blondell Pugh",
                        "Jamal Vanausdal",
                        "Cecily Hollack",
                        "Carmelina Lindall",
                        "Maurine Yglesias",
                        "Tawna Buvens",
                        "Penney Weight",
                        "Elly Morocco",
                        "Ilene Eroman",
                        "Vallie Mondella",
                        "Kallie Blackwood",
                        "Johnetta Abdallah",
                        "Bobbye Rhym",
                        "Micaela Rhymes",
                        "Tamar Hoogland",
                        "Moon Parlato",
                        "Laurel Reitler",
                        "Delisa Crupi",
                        "Viva Toelkes",
                        "Elza Lipke",
                        "Devorah Chickering",
                        "Timothy Mulqueen",
                        "Arlette Honeywell",
                        "Dominque Dickerson",
                        "Lettie Isenhower",
                        "Myra Munns",
                        "Stephaine Barfield",
                        "Lai Gato",
                        "Stephen Emigh",
                        "Tyra Shields",
                        "Tammara Wardrip",
                        "Cory Gibes",
                        "Danica Bruschke",
                        "Wilda Giguere",
                        "Elvera Benimadho",
                        "Carma Vanheusen",
                        "Malinda Hochard",
                        "Natalie Fern",
                        "Lisha Centini",
                        "Arlene Klusman",
                        "Alease Buemi",
                        "Louisa Cronauer",
                        "Angella Cetta",
                        "Cyndy Goldammer",
                        "Rosio Cork",
                        "Celeste Korando",
                        "Twana Felger",
                        "Estrella Samu",
                        "Donte Kines",
                        "Tiffiny Steffensmeier",
                        "Edna Miceli",
                        "Sue Kownacki",
                        "Jesusa Shin",
                        "Rolland Francescon",
                        "Pamella Schmierer",
                        "Glory Kulzer",
                        "Shawna Palaspas",
                        "Brandon Callaro",
                        "Scarlet Cartan",
                        "Oretha Menter",
                        "Ty Smith",
                        "Xuan Rochin",
                        "Lindsey Dilello",
                        "Devora Perez",
                        "Herman Demesa",
                        "Rory Papasergi",
                        "Talia Riopelle",
                        "Van Shire",
                        "Lucina Lary",
                        "Bok Isaacs",
                        "Rolande Spickerman",
                        "Howard Paulas",
                        "Kimbery Madarang",
                        "Thurman Manno",
                        "Becky Mirafuentes",
                        "Beatriz Corrington",
                        "Marti Maybury",
                        "Nieves Gotter",
                        "Leatha Hagele",
                        "Valentin Klimek",
                        "Melissa Wiklund",
                        "Sheridan Zane",
                        "Bulah Padilla",
                        "Audra Kohnert",
                        "Daren Weirather",
                        "Fernanda Jillson",
                        "Gearldine Gellinger",
                        "Chau Kitzman",
                        "Theola Frey",
                        "Cheryl Haroldson",
                        "Laticia Merced",
                        "Carissa Batman",
                        "Lezlie Craghead",
                        "Ozell Shealy",
                        "Arminda Parvis",
                        "Reita Leto",
                        "Yolando Luczki",
                        "Lizette Stem",
                        "Gregoria Pawlowicz",
                        "Carin Deleo",
                        "Chantell Maynerich",
                        "Dierdre Yum",
                        "Larae Gudroe",
                        "Latrice Tolfree",
                        "Kerry Theodorov",
                        "Dorthy Hidvegi",
                        "Fannie Lungren",
                        "Evangelina Radde",
                        "Novella Degroot",
                        "Clay Hoa",
                        "Jennifer Fallick",
                        "Irma Wolfgramm",
                        "Eun Coody",
                        "Sylvia Cousey",
                        "Nana Wrinkles",
                        "Layla Springe",
                        "Joesph Degonia",
                        "Annabelle Boord",
                        "Stephaine Vinning",
                        "Nelida Sawchuk",
                        "Marguerita Hiatt",
                        "Carmela Cookey",
                        "Junita Brideau",
                        "Claribel Varriano",
                        "Benton Skursky",
                        "Hillary Skulski",
                        "Merilyn Bayless",
                        "Teri Ennaco",
                        "Merlyn Lawler",
                        "Georgene Montezuma",
                        "Jettie Mconnell",
                        "Lemuel Latzke",
                        "Melodie Knipp",
                        "Candida Corbley",
                        "Karan Karpin",
                        "Andra Scheyer",
                        "Felicidad Poullion",
                        "Belen Strassner",
                        "Gracia Melnyk",
                        "Jolanda Hanafan",
                        "Barrett Toyama",
                        "Helga Fredicks",
                        "Ashlyn Pinilla",
                        "Fausto Agramonte",
                        "Ronny Caiafa",
                        "Marge Limmel",
                        "Norah Waymire",
                        "Aliza Baltimore",
                        "Mozell Pelkowski",
                        "Viola Bitsuie",
                        "Franklyn Emard",
                        "Willodean Konopacki",
                        "Beckie Silvestrini",
                        "Rebecka Gesick",
                        "Frederica Blunk",
                        "Glen Bartolet",
                        "Freeman Gochal",
                        "Vincent Meinerding",
                        "Rima Bevelacqua",
                        "Glendora Sarbacher",
                        "Avery Steier",
                        "Cristy Lother",
                        "Nicolette Brossart",
                        "Tracey Modzelewski",
                        "Virgina Tegarden",
                        "Tiera Frankel",
                        "Alaine Bergesen",
                        "Earleen Mai",
                        "Leonida Gobern",
                        "Ressie Auffrey",
                        "Justine Mugnolo",
                        "Eladia Saulter",
                        "Chaya Malvin",
                        "Gwenn Suffield",
                        "Salena Karpel",
                        "Yoko Fishburne",
                        "Taryn Moyd",
                        "Katina Polidori",
                        "Rickie Plumer",
                        "Alex Loader",
                        "Lashon Vizarro",
                        "Lauran Burnard",
                        "Ceola Setter",
                        "My Rantanen",
                        "Lorrine Worlds",
                        "Peggie Sturiale",
                        "Marvel Raymo",
                        "Daron Dinos",
                        "An Fritz",
                        "Portia Stimmel",
                        "Rhea Aredondo",
                        "Benedict Sama",
                        "Alyce Arias",
                        "Heike Berganza",
                        "Carey Dopico",
                        "Dottie Hellickson",
                        "Deandrea Hughey",
                        "Kimberlie Duenas",
                        "Martina Staback",
                        "Skye Fillingim",
                        "Jade Farrar",
                        "Charlene Hamilton",
                        "Geoffrey Acey",
                        "Stevie Westerbeck",
                        "Pamella Fortino",
                        "Harrison Haufler",
                        "Johnna Engelberg",
                        "Buddy Cloney",
                        "Dalene Riden",
                        "Jerry Zurcher",
                        "Haydee Denooyer",
                        "Joseph Cryer",
                        "Deonna Kippley",
                        "Raymon Calvaresi",
                        "Alecia Bubash",
                        "Ma Layous",
                        "Detra Coyier",
                        "Terrilyn Rodeigues",
                        "Salome Lacovara",
                        "Garry Keetch",
                        "Matthew Neither",
                        "Theodora Restrepo",
                        "Noah Kalafatis",
                        "Carmen Sweigard",
                        "Lavonda Hengel",
                        "Junita Stoltzman",
                        "Herminia Nicolozakes",
                        "Casie Good",
                        "Reena Maisto",
                        "Mirta Mallett",
                        "Cathrine Pontoriero",
                        "Filiberto Tawil",
                        "Raul Upthegrove",
                        "Sarah Candlish",
                        "Lucy Treston",
                        "Judy Aquas",
                        "Yvonne Tjepkema",
                        "Kayleigh Lace",
                        "Felix Hirpara",
                        "Tresa Sweely",
                        "Kristeen Turinetti",
                        "Jenelle Regusters",
                        "Renea Monterrubio",
                        "Olive Matuszak",
                        "Ligia Reiber",
                        "Christiane Eschberger",
                        "Goldie Schirpke",
                        "Loreta Timenez",
                        "Fabiola Hauenstein",
                        "Amie Perigo",
                        "Raina Brachle",
                        "Erinn Canlas",
                        "Cherry Lietz",
                        "Kattie Vonasek",
                        "Lilli Scriven",
                        "Whitley Tomasulo",
                        "Barbra Adkin",
                        "Hermila Thyberg",
                        "Jesusita Flister",
                        "Caitlin Julia",
                        "Roosevelt Hoffis",
                        "Helaine Halter",
                        "Lorean Martabano",
                        "France Buzick",
                        "Justine Ferrario",
                        "Adelina Nabours",
                        "Derick Dhamer",
                        "Jerry Dallen",
                        "Leota Ragel",
                        "Jutta Amyot",
                        "Aja Gehrett",
                        "Kirk Herritt",
                        "Leonora Mauson",
                        "Winfred Brucato",
                        "Tarra Nachor",
                        "Corinne Loder",
                        "Dulce Labreche",
                        "Kate Keneipp",
                        "Kaitlyn Ogg",
                        "Sherita Saras",
                        "Lashawnda Stuer",
                        "Ernest Syrop",
                        "Nobuko Halsey",
                        "Lavonna Wolny",
                        "Lashaunda Lizama",
                        "Mariann Bilden",
                        "Helene Rodenberger",
                        "Roselle Estell",
                        "Samira Heintzman",
                        "Margart Meisel",
                        "Kristofer Bennick",
                        "Weldon Acuff",
                        "Shalon Shadrick",
                        "Denise Patak",
                        "Louvenia Beech",
                        "Audry Yaw",
                        "Kristel Ehmann",
                        "Vincenza Zepp",
                        "Elouise Gwalthney",
                        "Venita Maillard",
                        "Kasandra Semidey",
                        "Xochitl Discipio",
                        "Maile Linahan",
                        "Krissy Rauser",
                        "Pete Dubaldi",
                        "Linn Paa",
                        "Paris Wide",
                        "Wynell Dorshorst",
                        "Quentin Birkner",
                        "Regenia Kannady",
                        "Sheron Louissant",
                        "Izetta Funnell",
                        "Rodolfo Butzen",
                        "Zona Colla",
                        "Serina Zagen",
                        "Paz Sahagun",
                        "Markus Lukasik",
                        "Jaclyn Bachman",
                        "Cyril Daufeldt",
                        "Gayla Schnitzler",
                        "Erick Nievas",
                        "Jennie Drymon",
                        "Mitsue Scipione",
                        "Ciara Ventura",
                        "Galen Cantres",
                        "Truman Feichtner",
                        "Gail Kitty",
                        "Dalene Schoeneck",
                        "Gertude Witten",
                        "Lizbeth Kohl",
                        "Glenn Berray",
                        "Lashandra Klang",
                        "Lenna Newville",
                        "Laurel Pagliuca",
                        "Mireya Frerking",
                        "Annelle Tagala",
                        "Dean Ketelsen",
                        "Levi Munis",
                        "Sylvie Ryser",
                        "Sharee Maile",
                        "Cordelia Storment",
                        "Mollie Mcdoniel",
                        "Brett Mccullan",
                        "Teddy Pedrozo",
                        "Tasia Andreason",
                        "Hubert Walthall",
                        "Arthur Farrow",
                        "Vilma Berlanga",
                        "Billye Miro",
                        "Glenna Slayton",
                        "Mitzie Hudnall",
                        "Bernardine Rodefer",
                        "Staci Schmaltz",
                        "Nichelle Meteer",
                        "Janine Rhoden",
                        "Ettie Hoopengardner",
                        "Eden Jayson",
                        "Lynelle Auber",
                        "Merissa Tomblin",
                        "Golda Kaniecki",
                        "Catarina Gleich",
                        "Virgie Kiel",
                        "Jolene Ostolaza",
                        "Keneth Borgman",
                        "Rikki Nayar",
                        "Elke Sengbusch",
                        "Hoa Sarao",
                        "Trinidad Mcrae",
                        "Mari Lueckenbach",
                        "Selma Husser",
                        "Antione Onofrio",
                        "Luisa Jurney",
                        "Clorinda Heimann",
                        "Dick Wenzinger",
                        "Ahmed Angalich",
                        "Iluminada Ohms",
                        "Joanna Leinenbach",
                        "Caprice Suell",
                        "Stephane Myricks",
                        "Quentin Swayze",
                        "Annmarie Castros",
                        "Shonda Greenbush",
                        "Cecil Lapage",
                        "Jeanice Claucherty",
                        "Josphine Villanueva",
                        "Daniel Perruzza",
                        "Cassi Wildfong",
                        "Britt Galam",
                        "Adell Lipkin",
                        "Jacqueline Rowling",
                        "Lonny Weglarz",
                        "Lonna Diestel",
                        "Cristal Samara",
                        "Kenneth Grenet",
                        "Elli Mclaird",
                        "Alline Jeanty",
                        "Sharika Eanes",
                        "Nu Mcnease",
                        "Daniela Comnick",
                        "Cecilia Colaizzo",
                        "Leslie Threets",
                        "Nan Koppinger",
                        "Izetta Dewar",
                        "Tegan Arceo",
                        "Ruthann Keener",
                        "Joni Breland",
                        "Vi Rentfro",
                        "Colette Kardas",
                        "Malcolm Tromblay",
                        "Ryan Harnos",
                        "Jess Chaffins",
                        "Sharen Bourbon",
                        "Nickolas Juvera",
                        "Gary Nunlee",
                        "Diane Devreese",
                        "Roslyn Chavous",
                        "Glory Schieler",
                        "Rasheeda Sayaphon",
                        "Alpha Palaia",
                        "Refugia Jacobos",
                        "Shawnda Yori",
                        "Mona Delasancha",
                        "Gilma Liukko",
                        "Janey Gabisi",
                        "Lili Paskin",
                        "Loren Asar",
                        "Dorothy Chesterfield",
                        "Gail Similton",
                        "Catalina Tillotson",
                        "Lawrence Lorens",
                        "Carlee Boulter",
                        "Thaddeus Ankeny",
                        "Jovita Oles",
                        "Alesia Hixenbaugh",
                        "Lai Harabedian",
                        "Brittni Gillaspie",
                        "Raylene Kampa",
                        "Flo Bookamer",
                        "Jani Bookamer",
                        "Chauncey Motley"

                )
        );

    }

    /**
     * A static utility function used in the process of generating credit card number
     */
    public static String generateRandomNumber(String cardSequence, String placeHolder, String numberSequence) {
        String randomNumber = "";
        numberSequence += "";

        for(int i = 1; i <= cardSequence.trim().length(); i++) {
            String cardSubString = cardSequence.trim().substring(i-1, i);
            int tempIndex = placeHolder.indexOf(cardSubString);

            if( tempIndex == -1) {
                randomNumber += cardSubString;
            } else {
                randomNumber += midSubString(numberSequence, (int)Math.floor(Math.random() * (numberSequence.length() - 1)) + 1, 1);
            }
        }

        return randomNumber;
    }


    /**
     * A static utility function used in the process of generating credit card number
     */
    public static String midSubString(String numberSequence, int tempRandomNumber, int tempPlaceHolder) {
        String midSubString = "";
        numberSequence += "";

        if(tempPlaceHolder == 0) {
            tempPlaceHolder = numberSequence.length();
        }

        tempRandomNumber *= 1;
        tempPlaceHolder *= 1;

        if(tempRandomNumber < 0) {
            tempRandomNumber++;
        }
        midSubString = numberSequence.substring(tempRandomNumber - 1, tempRandomNumber - 1 + tempPlaceHolder);

        return midSubString;
    }

}
