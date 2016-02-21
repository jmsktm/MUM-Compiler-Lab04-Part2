import analysis.DepthFirstAdapter;
import node.AArrayField;
import node.AArrayTypeFormal;
import node.ABoolType;
import node.ACharType;
import node.AClassDecl;
import node.AClassHdr;
import node.AEmptyClassDecl;
import node.AField;
import node.AFieldMember;
import node.AFloatType;
import node.AFormal;
import node.AInitializedField;
import node.AIntType;
import node.AMethodHdr;
import node.AMethodMember;
import node.ANoReturnMethodHdr;
import node.AStringType;
import node.Node;

public class SymTabBuilder extends DepthFirstAdapter {

	private SymbolTable symtab;

	public SymTabBuilder() {
		super();
	
		symtab = new SymbolTable();
	}

	public SymbolTable getSymtab() {
		return symtab;
	}
	
	public void printError(Node node) {
		System.out.print("Unsuccessful command : " + node);
	}

	// Entering class scope
	@Override
	public void outAClassHdr(AClassHdr node) {
		String identifier = node.getIdentifier().getText();
		ClassEntry classEntry = new ClassEntry(identifier);
		
		boolean bound = symtab.insertBinding(classEntry);
		if (bound) {
			symtab.enterScope(classEntry);
		} else {
			printError(node);
		}
	}
	
	// Exiting class scope
	@Override
	public void outAEmptyClassDecl(AEmptyClassDecl node) {
		symtab.leaveScope();
	}

	@Override
	public void outAClassDecl(AClassDecl node) {
		symtab.leaveScope();
	}

	@Override
	public void outABoolType(ABoolType node) {
		setOut(node, Type.boolVar);
	}

	@Override
	public void outACharType(ACharType node) {
		setOut(node, Type.charVar);
	}

	@Override
	public void outAFloatType(AFloatType node) {
		setOut(node, Type.floatVar);
	}

	@Override
	public void outAIntType(AIntType node) {
		setOut(node, Type.intVar);
	}

	@Override
	public void outAStringType(AStringType node) {
		setOut(node, Type.stringVar);
	}

	@Override
	public void outAField(AField node) {
		String id = node.getIdentifier().getText();
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		symtab.insertBinding(entry);
	}

	@Override
	public void outAInitializedField(AInitializedField node) {
		String id = node.getIdentifier().getText();
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		symtab.insertBinding(entry);
	}

	@Override
	public void outAArrayField(AArrayField node) {
		String id = node.getIdentifier().getText();
		Type t = (Type)getOut(node.getType());
		String size = node.getIntegerValue().toString().trim();
		VariableEntry entry = new VariableEntry(id, t.makeArrayType(Integer.valueOf(size)));
		symtab.insertBinding(entry);
	}

	@Override
	public void outANoReturnMethodHdr(ANoReturnMethodHdr node) {
		String methodName = node.getIdentifier().getText();
		MethodEntry methodEntry = new MethodEntry(methodName, Type.voidValue);
		
		if (symtab.insertBinding(methodEntry)) {
			symtab.enterScope(methodEntry);
		} else {
			printError(node);
		}
	}

	@Override
	public void outAMethodHdr(AMethodHdr node) {
		String methodName = node.getIdentifier().getText();
		Type type = (Type)getOut(node.getType());
		MethodEntry methodEntry = new MethodEntry(methodName, type);
		
		if (symtab.insertBinding(methodEntry)) {
			symtab.enterScope(methodEntry);
		} else {
			printError(node);
		}
	}

	@Override
	public void outAMethodMember(AMethodMember node) {
		symtab.leaveScope();
	}

	@Override
	public void outAFormal(AFormal node) {
		String formalName = node.getIdentifier().getText();
		Type type = (Type)getOut(node.getType());
		VariableEntry variableEntry = new VariableEntry(formalName, type);
		
		symtab.insertBinding(variableEntry);
	}

	@Override
	public void outAArrayTypeFormal(AArrayTypeFormal node) {
		String formalName = node.getIdentifier().getText();
		Type type = (Type)getOut(node.getType());
		int size = type.getArraySize();
		VariableEntry variableEntry = new VariableEntry(formalName, type.makeArrayType(size));
		
		symtab.insertBinding(variableEntry);
	}

	/*@Override
	public void outAClassHdr(AClassHdr node) {
		String id = node.getId().getText();
		ClassEntry entry = new ClassEntry(id);
		if (symtab.insertBinding(entry)) {
			// success
			symtab.enterScope(entry);
		} else
		{
			//error message
			System.out.print("Unsuccessful command at line " + node.getId().getLine() + ": " + node);
		}
	}

	@Override
	public void outAEmptyClassDecl(AEmptyClassDecl node) {
		symtab.leaveScope();
	}

	@Override
	public void outAClassDecl(AClassDecl node) {
		symtab.leaveScope();
	}

	@Override
	public void outAVoidMethodHdr(AVoidMethodHdr node) {
		String id = node.getId().getText();
		MethodEntry entry = new MethodEntry(id, Type.voidValue);
		if (symtab.insertBinding(entry)) {
			//success
			symtab.enterScope(entry);
		} else
		{
			//error message
		}
	}

	@Override
	public void outATypeMethodHdr(ATypeMethodHdr node) {
		String id = node.getId().getText();
		Type t = (Type)getOut(node.getType());
		MethodEntry entry = new MethodEntry(id, t);
		if (symtab.insertBinding(entry)) {
			//success
			symtab.enterScope(entry);
		} else
		{
			//error message
		}
	}
	
	@Override
	public void outAMethod(AMethod node) { symtab.leaveScope(); }

	@Override
	public void outAEmptyMethod(AEmptyMethod node) { symtab.leaveScope(); }

	
	@Override
	public void outAField(AField node) {
		String id = node.getId().getText();
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		
		if (symtab.insertBinding(entry)){
			//success
		} else
		{
			//error message
		}
	}
	
	@Override
	public void outAInitField(AInitField node) {
		String id = node.getId().getText();
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		
		if (symtab.insertBinding(entry)){
			//success
		} else
		{
			//error message
		}
	}

	@Override
	public void outAArrayField(AArrayField node) {
		String id = node.getId().getText();
		int arraySize = Integer.parseInt(node.getIntLit().getText());
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t.makeArrayType(arraySize));
		
		if (symtab.insertBinding(entry)){
			//success
		} else
		{
			//error message
		}
	}
	
	@Override
	public void outAFormal(AFormal node) {
		String id = node.getId().getText();
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		
		if (symtab.insertBinding(entry)){
			//success
		} else
		{
			//error message
		}
	}

	@Override
	public void outAArrayFormal(AArrayFormal node) {
		String id = node.getId().getText();
		Type t = (Type)getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t.makeArrayType(0));
		
		if (symtab.insertBinding(entry)){
			//success
		} else
		{
			//error message
		}
	}

	
	@Override
	public void outAIntType(AIntType node) { setOut(node, Type.intVar); 	}
	
	@Override
	public void outACharType(ACharType node) { setOut(node, Type.charVar); }

	@Override
	public void outABoolType(ABoolType node) { setOut(node, Type.boolVar); }

	@Override
	public void outAStringType(AStringType node) { setOut(node, Type.stringVar); 	}

	@Override
	public void outAFloatType(AFloatType node) { setOut(node, Type.floatVar); }*/

	
}
