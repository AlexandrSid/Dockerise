package com.alexsid.lesson17;

import com.alexsid.lesson17.pets.DuplicatedPetException;
import com.alexsid.lesson17.pets.Pet;
import com.alexsid.lesson17.pets.PetFactory;

import java.util.Scanner;

public class Main {
    PetFactory factory;
    PetCatalogFacade defaultCatalogFacade;


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        boolean contin = true;
        Scanner scanner = new Scanner(System.in);

        while (contin) {

            main.setUp();

            System.out.println(
                    "==========================\n" +
                            "Enter option: \n" +
                            "1 - show all pets \n" +
                            "2 - show addDuplicatedPetToCatalog \n" +
                            "3 - show findPetByName \n" +
                            "4 - show changePetNameByID \n" +
                            "5 - show changePetOwnerByID \n" +
                            "6 - show changePetWeightByID \n" +
                            "-------------------------------------"
            );
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    main.showAllPetsFromCatalog();
                    break;
                case 2:
                    main.addDuplicatedPetToCatalog();
                    break;
                case 3:
                    main.findPetByName();
                    break;
                case 4:
                    main.changePetNameByID();
                    break;
                case 5:
                    main.changePetOwnerByID();
                    break;
                case 6:
                    main.changePetWeightByID();
                    break;
                default:
                    contin = false;

            }
            main.tearDown();

        }
    }

//    @Before
    public void setUp() throws Exception {
        factory = PetFactory.getInstance();
        defaultCatalogFacade = new PetCatalogFacade(PetCatalog.getInstance());
        Person jean = new Person("Jean", 19, Person.Sex.FEMALE);
        Person crism = new Person("Cris", 22, Person.Sex.MALE);
        Person mike = new Person("Mike", 20, Person.Sex.MALE);
        Person helen = new Person("Helen", 22, Person.Sex.FEMALE);
        Person sam = new Person("Sam", 21, Person.Sex.MALE);
        Person july = new Person("July", 18, Person.Sex.FEMALE);
        Person crisf = new Person("Cris", 19, Person.Sex.FEMALE);

        defaultCatalogFacade.addPetToCatalog(factory.createPet("cat", jean, "Flare", 3.4));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("cat", jean, "Fluffy", 4.3));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("cat", jean, "Foxy", 2.9));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("cat", jean, "Fred", 4.9));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("parrot", crism, "Twetty", 0.2));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("dog", crism, "Lucky", 9.2));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Snake", mike, "Serpenty", 5.0));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("dOg", helen, "Bolt", 17.7));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("doG", sam, "Bolt", 14.7));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("doG", sam, "Buffy", 13.2));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Racccooon", sam, "Bandit", 6.6));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Owl", july, "Khrias", 0.6));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Owl", july, "Khrum", 0.5));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Owl", july, "Willow", 0.4));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Owl", july, "Fred", 3.4));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Cat", july, "Murk", 4.4));
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Lizard", crisf, "Pancake", 1.4));

    }

//    @After
    public void tearDown() throws Exception {
        defaultCatalogFacade.clearCatalog();
        factory = null;
        defaultCatalogFacade = null;
    }

//    @Test
    public void addDuplicatedPetToCatalog() {
        Person crisf = new Person("Cris", 20, Person.Sex.FEMALE);//?????????????? ???? ???????????????? ???? ??????????????????
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Lizard", crisf, "Pancake", 1.4));
        defaultCatalogFacade.setExceptionHandler(new DuplicatedPetExceptionHandler() {
            @Override
            public void process(DuplicatedPetException e) {
                System.out.println("still cannot be added, ");
            }
        });
        defaultCatalogFacade.addPetToCatalog(factory.createPet("Lizard", crisf, "Pancake", 1.4));


    }

//    @Test
    public void findPetByName() {
        Pet fred = defaultCatalogFacade.findPetByName("Fred");//2 Freds in catalog
        System.out.println(fred);
    }

//    @Test
    public void changePetNameByID() {
        Pet murk = defaultCatalogFacade.findPetByName("Murk");
        System.out.println(murk);
        defaultCatalogFacade.changePetNameByID(murk.getId(), "Barsik");
        Pet barsik = defaultCatalogFacade.findPetByName("Barsik");
        System.out.println(barsik);
    }

//    @Test
    public void changePetOwnerByID() {
        Pet willow = defaultCatalogFacade.findPetByName("Willow");
        System.out.println(willow);
        Person newOwner = new Person("Craig", 25, Person.Sex.MALE);
        defaultCatalogFacade.changePetOwnerByID(willow.getId(), newOwner);
        System.out.println(willow);
    }

//    @Test
    public void changePetWeightByID() {
        defaultCatalogFacade.changePetWeightByID(70, 20.2);
        Pet bolt = defaultCatalogFacade.findPetByName("Bolt");
        System.out.println(bolt);
        defaultCatalogFacade.changePetWeightByID(bolt.getId(), bolt.getWeight()+0.5);
        System.out.println(bolt);
    }

//    @Test
    public void showAllPetsFromCatalog() {
        defaultCatalogFacade.showAllPetsFromCatalog();
    }
}