package tesouroderaja;
/**
 * Escreva a descrição da classe Item aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Item
{
    private String nome;
    private int peso;
    private String description;
    private boolean canBeSeen;
    private boolean haveQuest;
    /**
     * COnstrutor para objetos da classe Item
     */
    public Item(String nome,int peso,String description,boolean canBeSeen,boolean haveQuest)
    {
        this.nome = nome;
        this.peso = peso;
        this.description = description;
        this.canBeSeen = canBeSeen;
        this.haveQuest = haveQuest;        
    }
    
    public String getName()
    {
        return nome;
    }
    
    public int getPeso()
    {
        return peso;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public boolean getCanBeSeen()
    {
        return canBeSeen;
    }
    
    public boolean getHaveQuest()
    {
        return haveQuest;
    }
    
    public void setHaveQuest()
    {
        haveQuest = false;
    }
    
    public void setCanBeSeen()
    {
        canBeSeen = true;
    }
    

}
