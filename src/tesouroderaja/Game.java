package tesouroderaja;
import java.util.Stack;
import java.util.Scanner;

public class Game 
{
    private Parser parser;    
    private Stack<Room> pilha; 
    private Player player;
    private Scanner scan;   

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        pilha = new Stack<Room>();
        scan = new Scanner(System.in);
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, entrada, pub, solange,rca,banheiro1,banheiro2,corredor1,corredor2;
        Room lab1,lab2,sala1,sala2,quadra;
        Item farolete,chave,chave2,biscoito,shovel,tesouro,mapa;        

        // create the rooms
        outside = new Room("na estrada em frente ao IF",false,"");
        entrada = new Room(" campus do IF",false,"Tem um cachorro enorme, mas muito manso ");
        pub = new Room("no bar do Zezin",false,"Há alguns largados aki no bar escutando uma sofrencia");
        solange = new Room("na famosa sala redonda da Solange",true,"É uma sala realmente a frente de deu tempo, não sei nem descrevê-la");
        rca = new Room("no RCA",false,"");
        banheiro1 = new Room("no banheiro",false,"Apenas um sabonete nem um pouco cheiroso");
        banheiro2 = new Room("no banheiro",false,"Vc pensa em usar o banheiro mas vê q não tem papel");        
        corredor1 = new Room("no corredor do terreo",false,"Varías salas para procurar");
        corredor2 = new Room("no corredor do 1 andar",false,"Varías para entrar ");
        quadra = new Room("na quadra do IF",true,"");
        lab1 = new Room("em um laboratorio de Informatica",false,"");
        lab2 = new Room("em um laboratorio de Informatica",false,"");
        sala1 = new Room("em uma sala de aula",false,"");
        sala2 = new Room("em uma sala de aula",false,"");

        //create items
        farolete = new Item("farolete",5,"- Há um farolete, vulgo lanterna, na sua frente ",true,false);
        chave = new Item("chave",5,"- Há uma chave debaixo do seu pé ",true,true);
        chave2 = new Item("chave",5,"- Há uma chave perto de um dos computadores ",true,false);
        biscoito = new Item("drinky",6,"- Tem um drinky suspeito no balcão ",true,true);
        shovel = new Item("pá",6,"- uma pá",true,true);
        tesouro = new Item("tesouro",6,"",false,false);
        mapa = new Item("mapa",6,"- Tem Fantasma segurando um mapa",true,true);

        // initialise room exits
        outside.setExit("portaria",entrada);
        outside.setExit("BarDoZezin",pub);        
        pub.setExit("MG666",outside);
        entrada.setExit("terreo",corredor1);
        entrada.setExit("quadra",quadra);
        entrada.setExit("MG666",outside);
        quadra.setExit("terreo",corredor1);
        quadra.setExit("1Andar",corredor2);
        quadra.setExit("portaria",entrada);
        corredor1.setExit("1Andar",corredor2);
        corredor1.setExit("banheiro",banheiro1);
        corredor1.setExit("RCA",rca);
        corredor1.setExit("sala",sala1);
        corredor1.setExit("lab",lab1);        
        banheiro1.setExit("terreo",corredor1);
        corredor1.setExit("portaria",entrada);
        rca.setExit("terreo",corredor1);
        sala1.setExit("terreo",corredor1);
        lab1.setExit("terreo",corredor1);      
        corredor2.setExit("terreo",corredor1);
        corredor2.setExit("banheiro",banheiro2);
        corredor2.setExit("salaRedonda",solange);
        corredor2.setExit("sala",sala2);
        corredor2.setExit("lab",lab2);        
        banheiro2.setExit("banheiro",corredor2);
        solange.setExit("salaRedonda",corredor2);
        sala2.setExit("sala",corredor2);
        lab2.setExit("lab",corredor2);

        //put items in the rooms
        rca.addItem(chave);
        pub.addItem(biscoito);
        quadra.addItem(tesouro);
        solange.addItem(mapa);
        banheiro2.addItem(shovel);
        lab2.addItem(chave2);
        entrada.addItem(farolete);
        

        // start game outside
        player = new Player(outside);  
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();        

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            finished = player.play();
            System.out.println();
        }
        scan.nextLine();
        System.out.println("Obrigado por jogar!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
             
        System.out.println("Há muitas lendas presentes na cidade Sábara");
        System.out.println("O povo sabaraense é um povo muito criativo");
        System.out.println("Algumas dessas lendas são apenas mitos");
        System.out.println("Mas uma lhe chama atenção");
        System.out.println("a de um tesouro enterrado em algum lugar do IFMG");
        System.out.println();
        System.out.println("Não um tesouro qualquer,mas o tesouro de Raja, que é, na verdade um contrato");
        System.out.println("Esse contrato te dá direito ao emprego que você quiser");
        System.out.println("Somente o(a) aluno(a) escolhido(a), que trará equilíbrio ao mercado de trabalho pode obtê-lo");
        System.out.println();
        System.out.println();        
        System.out.println("No entanto, não é simples conseguí-lo");
        System.out.println("Existem fantasmas e zumbis guardando-o ");
        System.out.println("Só aquele(a) que conseguir responder todas as perguntas de tais seres conseguirão a recompensa");
        System.out.println("só aparecem com esse tesouro uma vez a cada 100 semestres (ou quando vão dançar Thriller)");
        System.out.println();        
        System.out.println("Será que você é o escolhido?"); 
        System.out.println("Você pode tentar, mas caso não seja você, os zumbis e fantasmas te levarão para junto deles");
        System.out.println("Digite 'help' para ver os comandos");
        printLocationInfo();
    }

    private void printLocationInfo()
    {
        System.out.println();
        System.out.println("Voce está " + player.getCurrentRoom().getDescription());       
        System.out.println(player.getCurrentRoom().getExitString());      
        
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Não entendi");
            return false;
        }

        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("ir"))
            goRoom(command);
        else if (commandWord.equals("sair"))
            wantToQuit = quit(command);
        else if (commandWord.equals("olhar"))
            player.getCurrentRoom().getALook();
        else if (commandWord.equals("voltar"))
            goBack();
        else if (commandWord.equals("pegar"))
            player.addItemToBackpack(secondWord);
        else if (commandWord.equals("drop"))
            player.dropItem(secondWord);
        else if (commandWord.equals("itens"))
            player.openBackpack();
        else if (commandWord.equals("beber"))
            player.eat(secondWord);

        return wantToQuit;
    }

    // implementations of user commands:

    private void goBack()
    {
        if(pilha.empty()==false){
            player.setCurrentRoom(pilha.pop());
            printLocationInfo();
        }
        else{
            System.out.println("sem volta");                                
        }
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println();
        System.out.println("Seus comandos são:");
        System.out.println(parser.showCommands());
    } 

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Ir onde?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = null;
        nextRoom = player.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("Não há essa saída");
        }
        else if(nextRoom.getIsLocked() == true){
            System.out.println("Porta trancada");
            System.out.println("Vc quer abrir a porta?");            
            String answer = scan.nextLine();
            if(answer.equals("sim")==true){
                if(player.haveKey()==true){
                    nextRoom.openDoor();
                    System.out.println("Porta aberta, tente entrar novamente ");
                } 
                else{
                    System.out.println("Vc não tem a chave");
                }  
            }
            else{
                System.out.println("okay");            
            }
        }
        else {
            pilha.push(player.getCurrentRoom());
            player.setCurrentRoom(nextRoom);                
            printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Sair oque?");
            return false;
        }
        else {
            return true;  
        }
    }

}
