
import node.*;
import analysis.*;

public class SymTabBuilder extends DepthFirstAdapter
{ 
    static private SymbolTable symtab = new SymbolTable();

    public SymbolTable symtab() {
	return symtab;
    }
        //  your evaluation rules (i.e., method overrides) go here.

}              /*        end of SymTabBuilder       */
