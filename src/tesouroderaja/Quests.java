package tesouroderaja;
import java.util.Scanner;
/**
 * Escreva a descrição da classe Quests aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Quests
{
    private Scanner scan;
    /**
     * COnstrutor para objetos da classe Quests
     */
    public Quests()
    {
        scan = new Scanner(System.in);
    }

    public boolean getQuest(Item item){
        if(item.getName().equals("chave")==true){
            return getChaveMission();                    
        }
        else if(item.getName().equals("pá")==true){
            return getPaMission();                    
        }
        else if(item.getName().equals("mapa")==true){
            return getMapaMission();                    
        }
        else if(item.getName().equals("drinky")==true){
            return getDrinkyMission();                    
        }
        else{
            return false;
        }
    }

    public boolean getDrinkyMission()
    {
        System.out.println("Mas ... um fantasma aparece antes");
        System.out.println("e diz:");
        System.out.println("Meu nome é Contabil, um dos protetores do tesouro RAJA Casablanca");
        System.out.println("Voce deve provar seu valor para chegar ao tesouro");        
        System.out.println("Portanto responda a seguinte pergunta para pegar a bebida:");
        System.out.println("Voce pode errar apenas uma vez");
        System.out.println("ou então...");
        System.out.println();
        System.out.println("Agora me responda:");
        System.out.println("Em que ano Michael Jackson morreu?");        
        int answer = scan.nextInt();
        if(answer == 2009){
            System.out.println("Resposta correta");
            System.out.println("Agora sim vc pode pegar o drinky");
            return true;
        }
        else{
            System.out.println("Errrou"); 
            System.out.println("Tente de novo");        
            answer = scan.nextInt();
            if(answer == 2009){
                System.out.println("Resposta correta");
                System.out.println("Agora sim vc pode pegar o drinky");
                return true;
            }
        }
        System.out.println("VOCE NÃO É DIGNO DESSE TESOURO");
        System.out.println("SOFRA AGORA A FÚRIA DO CONTABIL...");
        System.out.println(".....");
        System.out.println("Contabil então lhe tira a vida");
        return false;
    }

    public boolean getPaMission()
    {
        return true;
    }

    public boolean getMapaMission()
    {
        return true;
    }

    public boolean getChaveMission(){
        System.out.println("Mas ... um fantasma aparece antes");
        System.out.println("e diz:");
        System.out.println("Meu nome é Tobias sou um dos protetores do tesouro de RAJA Casablanca");
        System.out.println("Voce deve provar seu valor para chegar ao tesouro");
        System.out.println("Portanto responda a seguinte pergunta para pegar a chave:");
        System.out.println("Voce pode errar apenas uma vez");
        System.out.println("ou então...");
        System.out.println();
        System.out.println("Agora me responda:");
        System.out.println("Quantos filhos tem Jair Bolsonaro?");
        int answer = scan.nextInt();
        if(answer ==5){
            System.out.println("Resposta correta");
            System.out.println("Agora sim vc pode pegar a chave");
            return true;
        }
        else{
            System.out.println("Não foi dessa vez ...");
            System.out.println("Vc só tem mais uma chance :)");
            answer = scan.nextInt();
            if(answer==5){
                System.out.println("Resposta correta");
                System.out.println("Agora sim vc pode pegar a chave");
                return true;
            }
            else{
                System.out.println("VOCE NÃO É DIGNO DESSE TESOURO");
                System.out.println("SOFRA AGORA A FÚRIA DE TOBIAS...");
                System.out.println(".....");
                System.out.println("Voce morreu");
                return false;
            }
        }

    }

}
