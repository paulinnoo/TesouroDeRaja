package tesouroderaja;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {"ir", "sair", "help","olhar","voltar","pegar","drop","itens","usar","beber" };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Um exemplo de método - substitua este comentário pelo seu próprio
     *
     * @param  y   um parâmetro de exemplo
     * @return     a soma de x com y
     */
    public String showCommands()
    {
        String a = " ";
        for(String words : validCommands){
            a +="|"+words+"|  ";        
        }
        return a;
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}
