


import java.util.*;
import node.*;
import analysis.*;

public class SymTabTester extends DepthFirstAdapter
{
    static SymbolTable symtab = new SymbolTable();

    public void outAClassCommand(AClassCommand node)
    {
        if(node.getIdent() != null) {
            String id = node.getIdent().getText();
	    ClassEntry ce = new ClassEntry(id);
	    if (symtab.insertBinding(ce)) {
		System.out.println("Successful command "
				   + node.getIdent().getLine()
				   + ": " + node);
	    } else if (symtab.lookup(id) != null) {
		// This error message is only approximately accurate
		// To be completely accurate, we would have look only in 
		// the current scope!
		System.out.println("Unsuccessful command "
				   + node.getIdent().getLine()
				   + ": " + node
				   + " -- redeclaration of identifier "
				   + id);
	    } else {
		System.out.println("Unsuccessful command "
				   + node.getIdent().getLine()
				   + ": " + node
				   + " -- class declarations are not "
				   + "allowed in this scope");
	    }
        }
    }

    public void outAProcDeclCommand(AProcDeclCommand node)
    {
	Object id = getOut(node.getMethodHdr());
	AMethodHdr phdr = (AMethodHdr) node.getMethodHdr();
	if (id instanceof String) {
	    if (symtab.lookup((String)id) != null) {
		// This error message is only approximately accurate
		// To be completely accurate, we would have look only in 
		// the current scope!
		System.out.println("Unsuccessful command "
				   + phdr.getIdent().getLine()
				   + ": " + node
				   + " -- redeclaration of identifier "
				   + id);
	    } else {
		System.out.println("Unsuccessful command "
				   + phdr.getIdent().getLine()
				   + ": " + node
				   + " -- method declarations are not "
				   + "allowed in this scope");
	    }
	} else {
	    System.out.println("Successful command "
			       + phdr.getIdent().getLine()
			       + ": " + node + ";");
	}
	symtab.leaveScope();
    }

    public void outAMethodHdr(AMethodHdr node)
    {
	String id = node.getIdent().getText();
	Type type = (Type)getOut(node.getType());
	Type methodType = type.makeValueType();
	MethodEntry me = new MethodEntry(id, methodType);
	if (! symtab.insertBinding(me)) {
	    setOut(node, id);
	}
	symtab.enterScope(me);
    }

    public void outAVariableCommand(AVariableCommand node)
    {
	Type type;
        if(node.getType() != null) {
            type = (Type)getOut(node.getType());
	    if (type != null && node.getIdent() != null) {
		if (!type.isVariableKind()) {  // void type is not allowed
		    System.out.println("Unsuccessful command "
				       + node.getIdent().getLine()
				       + ": " + node
				       + " -- invalid type");
		} else {
		    String id = node.getIdent().getText();
		    VariableEntry ve = new VariableEntry(id, type);
		    if (symtab.insertBinding(ve)) {
			System.out.println("Successful command "
					   + node.getIdent().getLine()
					   + ": " + node);
		    } else {
			System.out.println("Unsuccessful command "
					   + node.getIdent().getLine()
					   + ": " + node
					   + " -- redeclaration of identifier "
					   + id);
		    }
		}
	    } else {
		// should not happen unless type is not an attribute 
		// of this node (i.e., bug in this program)
		System.out.println("Unsuccessful command "
				   + node.getIdent().getLine()
				   + ": " + node
				   + " -- invalid command");
	    }
	}
    }

    public void outALookup1Command(ALookup1Command node)
    {
        if(node.getIdent() != null) {
            String id = node.getIdent().getText();
	    Entry e = symtab.lookup(id);
	    if (e != null) {
		System.out.println("Successful command "
				   + node.getIdent().getLine()
				   + ": " + node);
		System.out.println(e);
	    } else {
		System.out.println("Unsuccessful command "
				   + node.getIdent().getLine()
				   + ": " + node
				   + " -- unknown identifier");
	    }
        }
    }

    public void outALookup2Command(ALookup2Command node)
    {
	String id1;
	String id2;
        if(node.getId1() != null) {
            id1 = node.getId1().getText();
	    if(node.getId2() != null) {
		id2 = node.getId2().getText();
		Entry e = symtab.lookup(id1, id2);
		if (e != null) {
		    System.out.println("Successful command "
				       + node.getLookup2().getLine()
				       + ": " + node);
		    System.out.println(e);
		} else if (symtab.lookup(id1) == null) {
		    System.out.println("Unsuccessful command "
				       + node.getId1().getLine()
				       + ": " + node
				       + " -- unknown identifier " + id1);
		} else {
		    System.out.println("Unsuccessful command "
				       + node.getId1().getLine()
				       + ": " + node
				       + " -- unknown identifier " + id2);
		}
	    }
        }
    }

    public void outANewScopeCommand(ANewScopeCommand node)
    {
        if(node.getIdent() != null) {
            String id = node.getIdent().getText();
	    Entry ce = symtab.lookup(id);
	    if (ce instanceof ScopeEntry) {
		symtab.enterScope((ScopeEntry)ce);
		System.out.println("Successful command "
				   + node.getIdent().getLine()
				   + ": " + node);
		System.out.println("The new scope is ");
		System.out.println(symtab.currentScope());
	    } else {
		System.out.println("Unsuccessful command "
				   + node.getIdent().getLine()
				   + ": " + node
				   + " -- not a ScopeEntry: ");
	    }
        }
    }

    public void outAEndScopeCommand(AEndScopeCommand node)
    {
	String previous = symtab.currentScope();
	if (symtab.leaveScope() != null) {
	    System.out.println("Successful command "
			       + node.getEndScope().getLine()
			       + ": " + node);
	    System.out.println("Leaving scope ");
	    System.out.println(previous);
	    System.out.println("The new scope is ");
	    System.out.println(symtab.currentScope());
	} else {
	    System.out.println("Unsuccessful command "
			       + node.getEndScope().getLine()
			       + ": " + node
			       + " -- cannot leave Global Scope");
	}
    }

    public void outAMethodScopeCommand(AMethodScopeCommand node)
    {
	MethodEntry me = symtab.enclosingMethod();
	if (me != null) {
	    System.out.println("Successful command "
			       + node.getEnclosingMethod().getLine()
			       + ": " + node);
	    System.out.println(me);
	} else {
	    System.out.println("Unsuccessful command "
			       + node.getEnclosingMethod().getLine()
			       + ": " + node);
	}
    }

    public void outANewBlockCommand(ANewBlockCommand node)
    {
	if (symtab.enterNewBlock()) {
	    System.out.println("Successful command "
			       + node.getNewBlock().getLine()
			       + ": " + node);
	} else {
	    // should always be successful, but just in case
	    System.out.println("Unsuccessful command "
			       + node.getNewBlock().getLine()
			       + ": " + node);
	}
    }

    public void outAPrintSymtabCommand(APrintSymtabCommand node)
    {
	System.out.println("Successful command "
			   + node.getPrintSymtab().getLine()
			   + ": print_symtab ");
	System.out.println(symtab);
    }

    public void outABooleanType(ABooleanType node)
    {
	setOut(node, Type.boolVar);
    }

    public void outACharType(ACharType node)
    {
	setOut(node, Type.charVar);
    }

    public void outAIntType(AIntType node)
    {
	setOut(node, Type.intVar);
    }

    public void outAFloatType(AFloatType node)
    {
	setOut(node, Type.floatVar);
    }

    public void outAStringType(AStringType node)
    {
	setOut(node, Type.stringVar);
    }

    public void outAVoidType(AVoidType node)
    {
	setOut(node, Type.voidValue);
    }

    public void outAFormal(AFormal node)
    {
        if(node.getType() != null) {
            Type type = (Type)getOut(node.getType());
	    if (type != null && node.getIdent() != null) {
		String id = node.getIdent().getText();
		VariableEntry ve = new VariableEntry(id, type);
		if (! symtab.insertBinding(ve)) {
		    System.out.println(
				  "Redeclaration of formal parameter at line "
				  + node.getIdent().getLine()
				  + ": " + node);
		}
	    } else {
		System.out.println("Invalid formal parameter at line "
				   + node.getIdent().getLine()
				   + ": " + node);
	    }
	} else {
	    System.out.println("Invalid formal parameter at line "
			       + node.getIdent().getLine()
			       + ": " + node);
	}
    }

    public void outAArrayFormal(AArrayFormal node)
    {
        if(node.getType() != null) {
            Type varType = (Type)getOut(node.getType());
	    if (varType != null && node.getIdent() != null) {
		String id = node.getIdent().getText();
		varType = varType.makeArrayType(0);
		VariableEntry ve = new VariableEntry(id, varType);
		if (! symtab.insertBinding(ve)) {
		    System.out.println(
				  "Redeclaration of formal parameter at line "
				  + node.getIdent().getLine()
				  + ": " + node);
		}
	    } else {
		System.out.println("Invalid formal parameter at line "
				   + node.getIdent().getLine()
				   + ": " + node);
	    }
	} else {
	    System.out.println("Invalid formal parameter at line "
			       + node.getIdent().getLine()
			       + ": " + node);
	}
    }

}
