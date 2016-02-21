import analysis.DepthFirstAdapter;
import node.AArrayField;
import node.AArrayTypeFormal;
import node.ABoolType;
import node.ACharType;
import node.AClassDecl;
import node.AClassHdr;
import node.AEmptyClassDecl;
import node.AField;
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

	@Override
	public void outAClassHdr(AClassHdr node) {
		String identifier = node.getIdentifier().getText();
		ClassEntry classEntry = new ClassEntry(identifier);

		boolean binding = symtab.insertBinding(classEntry);
		symtab.enterScope(classEntry);

		if (!binding) {
			printDupError(node.getIdentifier().getLine(), identifier);
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
		Type t = (Type) getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		
		boolean binding = symtab.insertBinding(entry);
		if (!binding) {
			printDupError(node.getIdentifier().getLine(), id);
		}
	}

	@Override
	public void outAInitializedField(AInitializedField node) {
		String id = node.getIdentifier().getText();
		Type t = (Type) getOut(node.getType());
		VariableEntry entry = new VariableEntry(id, t);
		symtab.insertBinding(entry);
	}

	@Override
	public void outAArrayField(AArrayField node) {
		String id = node.getIdentifier().getText();
		Type t = (Type) getOut(node.getType());
		String size = node.getIntegerValue().toString().trim();
		VariableEntry entry = new VariableEntry(id, t.makeArrayType(Integer.valueOf(size)));
		symtab.insertBinding(entry);
	}

	@Override
	public void outANoReturnMethodHdr(ANoReturnMethodHdr node) {
		String methodName = node.getIdentifier().getText();
		MethodEntry methodEntry = new MethodEntry(methodName, Type.voidValue);

		boolean binding = symtab.insertBinding(methodEntry);
		symtab.enterScope(methodEntry);

		if (!binding) {
			printDupError(node.getIdentifier().getLine(), methodName);
		}
	}

	@Override
	public void outAMethodHdr(AMethodHdr node) {
		String methodName = node.getIdentifier().getText();
		Type type = (Type) getOut(node.getType());
		MethodEntry methodEntry = new MethodEntry(methodName, type);

		boolean binding = symtab.insertBinding(methodEntry);
		symtab.enterScope(methodEntry);

		if (!binding) {
			printDupError(node.getIdentifier().getLine(), methodName);
		}
	}

	@Override
	public void outAMethodMember(AMethodMember node) {
		symtab.leaveScope();
	}

	@Override
	public void outAFormal(AFormal node) {
		String formalName = node.getIdentifier().getText();
		Type type = (Type) getOut(node.getType());
		VariableEntry variableEntry = new VariableEntry(formalName, type);

		boolean binding = symtab.insertBinding(variableEntry);
		if (!binding) {
			printDupError(node.getIdentifier().getLine(), formalName);
		}
	}

	@Override
	public void outAArrayTypeFormal(AArrayTypeFormal node) {
		String formalName = node.getIdentifier().getText();
		Type type = (Type) getOut(node.getType());
		int size = type.getArraySize();
		VariableEntry variableEntry = new VariableEntry(formalName, type.makeArrayType(size));

		boolean binding = symtab.insertBinding(variableEntry);

		if (!binding) {
			printDupError(node.getIdentifier().getLine(), formalName);
		}
	}
	
	public void printDupError(int line, String identifier) {
		System.out.println("line " + line + ": Redeclaration of identifier `" +identifier + "'");
	}
}
