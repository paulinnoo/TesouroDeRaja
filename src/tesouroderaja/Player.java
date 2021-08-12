package tesouroderaja;
import java.util.ArrayList;

public class Player
{
    private Room currentRoom;
    private ArrayList<Item> backpack;
    private int life = 100;
    private int peso = 0;
    private int capacidadeMax=10;
    private Quests quest;
    private boolean quit = false;

    public Player(Room currentRoom)
    {
        quest = new Quests();
        backpack = new ArrayList<Item>();
        this.currentRoom = currentRoom;

    }

    public Room getCurrentRoom()
    {
        return currentRoom;        
    }

    public void setCurrentRoom(Room nextRoom)
    {
        currentRoom = nextRoom;        
    }

    public void addItemToBackpack(String nome)
    {
        Item newItem = currentRoom.getItem(nome);
        if(newItem == null){
            System.out.println("Não existe tal item");        
        }
        else{      
            if(newItem.getPeso()+peso>capacidadeMax){
                System.out.println("Capacidade da mochila excedida ");
                System.out.println("Dica: Vá ao Bar do zezin ou drop um item ;)"); 
            }
            else if(newItem.getName() == "tesouro"){
                if(haveTheMap()==true){
                    if(haveTheShovel()==true){
                        System.out.println("Vc conseguiu");
                        System.out.println("o tesouro de RAJA é seu");
                        System.out.println("Não gaste tudo com a Rita Cadillac !!");                        
                        quit = true;
                    }
                    else{
                        System.out.println("Vc não está com a pá");
                        System.out.println("Vai cavar com as maõs ????");                                                    
                    }
                }
                else{
                    System.out.println("Vc não está com o mapa");
                    System.out.println("Voce sabe que o tesouro de RAJA está aqui na quadra");
                    System.out.println("Mas não sabe onde na quadra");
                }

            }

            else if(newItem.getHaveQuest()==true){
                boolean a  = quest.getQuest(newItem);
                if(a==true){
                    currentRoom.getItem(newItem.getName()).setHaveQuest();                    
                }
                else{
                    quit = true;
                }

            }
            else{
                backpack.add(newItem);
                currentRoom.removeItem(newItem);
                peso+=newItem.getPeso();
                System.out.println("Item guardado");
                System.out.println("Mochila ("+peso+"/"+capacidadeMax+")");
                if(newItem.getName()=="mapa"){
                    System.out.println("Vc abre o mapa e vê que o tesouro está na quadra");
                }
            }
        }
    }

    public void dropItem(String name){
        for(Item item : backpack){
            if(item.getName().equals(name)==true){
                backpack.remove(item);
                peso-=item.getPeso();
                currentRoom.addItem(item);
                System.out.println("Item dropado");
                System.out.println("Mochila ("+peso+"/"+capacidadeMax+")");
                return;
            }                               
        }
        System.out.println("Vc não possui tal item");
    }

    public void openBackpack()
    {
        for(Item item : backpack){
            System.out.println(item.getName()+" = ("+item.getPeso()+")");
        }
        System.out.println("Mochila ("+peso+"/"+capacidadeMax+")");
    }

    public void eat(String food)
    {
        for(Item item : backpack){
            if(item.getName().equals(food)==true){
                backpack.remove(item);
                peso-=item.getPeso();
                capacidadeMax=20;
                System.out.println(item.getName()+" drinked");
                System.out.println("capacidade aumentada");
                System.out.println("Mochila ("+peso+"/"+capacidadeMax+")");
                return;
            }
        }
        System.out.println("Vc não possui tal item");
    }

    public boolean haveKey()
    {
        for(Item item : backpack){
            if(item.getName() == "chave"){
                backpack.remove(item);
                peso-=item.getPeso();                           
                System.out.println("Mochila ("+peso+"/"+capacidadeMax+")");
                return true;
            }
        }
        return false;
    }

    public boolean haveTheMap()
    {
        for(Item item : backpack){
            if(item.getName() == "mapa"){
                return true;
            }
        }
        return false;
    }

    public boolean haveTheShovel()
    {
        for(Item item : backpack){
            if(item.getName() == "pá"){
                return true;
            }
        }
        return false;
    }

    public boolean play()
    {
        return quit;
    }
}
