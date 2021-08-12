package tesouroderaja;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/**
 * @author  
 * @version 2
 */
public class Room 
{
    private String description;
    private String longDescription;   
    private Map<String,Room> exits; 
    private ArrayList<Item> items;
    private boolean isLocked;

    public Room(String description, boolean isLocked,String longDescription) 
    {
        this.description = description;
        this.isLocked = isLocked;
        this.longDescription = longDescription;
        exits = new HashMap<String,Room>();
        items = new ArrayList<Item>();
    } 
    
    public boolean getIsLocked() 
    {
        return isLocked;            
    }
    
    public void openDoor(){
        isLocked = false;
    }
    
    public Room getExit(String description) 
    {
        return exits.get(description);            
    }

    public String getExitString()
    {
        String saidas="Saídas :";
        for(String key:exits.keySet()){            
                saidas+=" |"+key+"| ";                        
        }
        return saidas;   
    }

    public void setExit(String direction, Room vizinha)
    {
        exits.put(direction,vizinha);
    }

    public String getDescription()
    {
        return description;
    }

    public void getALook()
    {
        System.out.println(longDescription);
        if(items.isEmpty()==true){
            System.out.println("Nenhum item interessante aqui");        
        }
        else{
            System.out.println("Itens na sala:"); 
            for(Item item : items){
                if(item.getCanBeSeen() == true){
                    System.out.println(item.getDescription()); 
            }                               
            }       
        }       
    }

    public void addItem(Item item)
    {
        items.add(item);
    }    

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    public Item getItem(String name)
    {
        for(Item item : items){
            if(item.getName().equals(name)==true){
                return item;
            }                               
        }      
        return null;
    }      

}
