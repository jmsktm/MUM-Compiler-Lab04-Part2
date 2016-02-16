import analysis.DepthFirstAdapter;
import node.AAddArithExpr;
import node.AAndExpr;
import node.AArgs;
import node.AArrayField;
import node.AArrayFieldAccess;
import node.AArrayLocalDecl;
import node.AArrayTypeFormal;
import node.AAssignmentStmt;
import node.ABlock;
import node.ABlockStmt;
import node.ABoolType;
import node.ACharLiteralPrimary;
import node.ACharType;
import node.AClassDecl;
import node.AClassHdr;
import node.ACondition;
import node.ADivideFactExpr;
import node.ADoWhileLoopStmt;
import node.AEmptyBlock;
import node.AEmptyClassDecl;
import node.AEmptyMember;
import node.AEmptyStmt;
import node.AEqualsEqualityExpr;
import node.AExprPrimary;
import node.AFalseLiteralPrimary;
import node.AField;
import node.AFieldAccess;
import node.AFieldMember;
import node.AFieldPrimary;
import node.AFloatLiteralPrimary;
import node.AFloatType;
import node.AFormal;
import node.AFormals;
import node.AGreaterThanComparisonExpr;
import node.AGreaterThanOrEqComparisonExpr;
import node.AIdentifierIntegerValue;
import node.AIfElseMatched;
import node.AIfElseUnmatched;
import node.AIfUnmatched;
import node.AInitializedField;
import node.AInitializedLocalDecl;
import node.AIntLiteralPrimary;
import node.AIntType;
import node.ALessThanComparisonExpr;
import node.ALessThanOrEqComparisonExpr;
import node.ALocalDecl;
import node.ALocalDeclStmt;
import node.AMatchedGenericStmt;
import node.AMemberDecls;
import node.AMethod;
import node.AMethodCall;
import node.AMethodCallPrimary;
import node.AMethodCallStmt;
import node.AMethodHdr;
import node.AMethodMember;
import node.AMinusUnaryExpr;
import node.AModuloFactExpr;
import node.AMultArgs;
import node.AMultStmts;
import node.AMultiplyFactExpr;
import node.ANoArgMethodCall;
import node.ANoParamMethod;
import node.ANoReturnMethodHdr;
import node.ANotAComparisonExpr;
import node.ANotAFactExpr;
import node.ANotAUnaryExpr;
import node.ANotAnAndExpr;
import node.ANotAnArithExpr;
import node.ANotAnEqualityExpr;
import node.ANotAnOrExpr;
import node.ANotEqualsEqualityExpr;
import node.ANotUnaryExpr;
import node.ANumericIntegerValue;
import node.AOrExpr;
import node.AParameterizedArrayFieldAccess;
import node.APlusUnaryExpr;
import node.AQualifiedFieldAccess;
import node.AReturnExprStmt;
import node.AReturnVoidStmt;
import node.ASingleClassDecls;
import node.ASingleFormals;
import node.ASingleMemberDecls;
import node.ASizedArrayFieldAccess;
import node.AStmtMatched;
import node.AStmts;
import node.AStrLiteralPrimary;
import node.AStringType;
import node.ASubArithExpr;
import node.ATrueLiteralPrimary;
import node.AUnmatchedGenericStmt;
import node.AWhileLoopStmt;
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

	/*@Override
	public void outStart(Start node) {
		// TODO Auto-generated method stub
		super.outStart(node);
	}*/

	/*@Override
	public void outAProgram(AProgram node) {
		// TODO Auto-generated method stub
		super.outAProgram(node);
	}*/

	/*@Override
	public void outAClassDecls(AClassDecls node) {
		// TODO Auto-generated method stub
		super.outAClassDecls(node);
	}*/

	/*@Override
	public void outASingleClassDecls(ASingleClassDecls node) {
		// TODO Auto-generated method stub
		super.outASingleClassDecls(node);
	}

	@Override
	public void outAEmptyClassDecl(AEmptyClassDecl node) {
		// TODO Auto-generated method stub
		super.outAEmptyClassDecl(node);
	}

	@Override
	public void outAClassDecl(AClassDecl node) {
		// TODO Auto-generated method stub
		super.outAClassDecl(node);
	}*/

	@Override
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
		
		String identifier = node.getIdentifier().getText();
		ClassEntry classEntry = new ClassEntry(identifier);
		
		boolean bound = symtab.insertBinding(classEntry);
		if (bound) {
			symtab.enterScope(classEntry);
		} else {
			
		}
	}

	@Override
	public void outAMemberDecls(AMemberDecls node) {
		// TODO Auto-generated method stub
		super.outAMemberDecls(node);
	}

	@Override
	public void outASingleMemberDecls(ASingleMemberDecls node) {
		// TODO Auto-generated method stub
		super.outASingleMemberDecls(node);
	}

	@Override
	public void outAFieldMember(AFieldMember node) {
		// TODO Auto-generated method stub
		super.outAFieldMember(node);
	}

	@Override
	public void outAMethodMember(AMethodMember node) {
		// TODO Auto-generated method stub
		super.outAMethodMember(node);
	}

	@Override
	public void outAEmptyMember(AEmptyMember node) {
		// TODO Auto-generated method stub
		super.outAEmptyMember(node);
	}

	@Override
	public void outAField(AField node) {
		// TODO Auto-generated method stub
		super.outAField(node);
	}

	@Override
	public void outAInitializedField(AInitializedField node) {
		// TODO Auto-generated method stub
		super.outAInitializedField(node);
	}

	@Override
	public void outAArrayField(AArrayField node) {
		// TODO Auto-generated method stub
		super.outAArrayField(node);
	}

	@Override
	public void outABoolType(ABoolType node) {
		// TODO Auto-generated method stub
		super.outABoolType(node);
	}

	@Override
	public void outACharType(ACharType node) {
		// TODO Auto-generated method stub
		super.outACharType(node);
	}

	@Override
	public void outAFloatType(AFloatType node) {
		// TODO Auto-generated method stub
		super.outAFloatType(node);
	}

	@Override
	public void outAIntType(AIntType node) {
		// TODO Auto-generated method stub
		super.outAIntType(node);
	}

	@Override
	public void outAStringType(AStringType node) {
		// TODO Auto-generated method stub
		super.outAStringType(node);
	}

	@Override
	public void outAMethod(AMethod node) {
		// TODO Auto-generated method stub
		super.outAMethod(node);
	}

	@Override
	public void outANoParamMethod(ANoParamMethod node) {
		// TODO Auto-generated method stub
		super.outANoParamMethod(node);
	}

	@Override
	public void outANoReturnMethodHdr(ANoReturnMethodHdr node) {
		// TODO Auto-generated method stub
		super.outANoReturnMethodHdr(node);
	}

	@Override
	public void outAMethodHdr(AMethodHdr node) {
		// TODO Auto-generated method stub
		super.outAMethodHdr(node);
	}

	@Override
	public void outAFormals(AFormals node) {
		// TODO Auto-generated method stub
		super.outAFormals(node);
	}

	@Override
	public void outASingleFormals(ASingleFormals node) {
		// TODO Auto-generated method stub
		super.outASingleFormals(node);
	}

	@Override
	public void outAFormal(AFormal node) {
		// TODO Auto-generated method stub
		super.outAFormal(node);
	}

	@Override
	public void outAArrayTypeFormal(AArrayTypeFormal node) {
		// TODO Auto-generated method stub
		super.outAArrayTypeFormal(node);
	}

	@Override
	public void outABlock(ABlock node) {
		// TODO Auto-generated method stub
		super.outABlock(node);
	}

	@Override
	public void outAEmptyBlock(AEmptyBlock node) {
		// TODO Auto-generated method stub
		super.outAEmptyBlock(node);
	}

	@Override
	public void outAMultStmts(AMultStmts node) {
		// TODO Auto-generated method stub
		super.outAMultStmts(node);
	}

	@Override
	public void outAStmts(AStmts node) {
		// TODO Auto-generated method stub
		super.outAStmts(node);
	}

	@Override
	public void outACondition(ACondition node) {
		// TODO Auto-generated method stub
		super.outACondition(node);
	}

	@Override
	public void outALocalDeclStmt(ALocalDeclStmt node) {
		// TODO Auto-generated method stub
		super.outALocalDeclStmt(node);
	}

	@Override
	public void outAAssignmentStmt(AAssignmentStmt node) {
		// TODO Auto-generated method stub
		super.outAAssignmentStmt(node);
	}

	@Override
	public void outAMethodCallStmt(AMethodCallStmt node) {
		// TODO Auto-generated method stub
		super.outAMethodCallStmt(node);
	}

	@Override
	public void outAReturnVoidStmt(AReturnVoidStmt node) {
		// TODO Auto-generated method stub
		super.outAReturnVoidStmt(node);
	}

	@Override
	public void outAReturnExprStmt(AReturnExprStmt node) {
		// TODO Auto-generated method stub
		super.outAReturnExprStmt(node);
	}

	@Override
	public void outABlockStmt(ABlockStmt node) {
		// TODO Auto-generated method stub
		super.outABlockStmt(node);
	}

	@Override
	public void outAWhileLoopStmt(AWhileLoopStmt node) {
		// TODO Auto-generated method stub
		super.outAWhileLoopStmt(node);
	}

	@Override
	public void outADoWhileLoopStmt(ADoWhileLoopStmt node) {
		// TODO Auto-generated method stub
		super.outADoWhileLoopStmt(node);
	}

	@Override
	public void outAEmptyStmt(AEmptyStmt node) {
		// TODO Auto-generated method stub
		super.outAEmptyStmt(node);
	}

	@Override
	public void outAMatchedGenericStmt(AMatchedGenericStmt node) {
		// TODO Auto-generated method stub
		super.outAMatchedGenericStmt(node);
	}

	@Override
	public void outAUnmatchedGenericStmt(AUnmatchedGenericStmt node) {
		// TODO Auto-generated method stub
		super.outAUnmatchedGenericStmt(node);
	}

	@Override
	public void outAIfElseMatched(AIfElseMatched node) {
		// TODO Auto-generated method stub
		super.outAIfElseMatched(node);
	}

	@Override
	public void outAStmtMatched(AStmtMatched node) {
		// TODO Auto-generated method stub
		super.outAStmtMatched(node);
	}

	@Override
	public void outAIfUnmatched(AIfUnmatched node) {
		// TODO Auto-generated method stub
		super.outAIfUnmatched(node);
	}

	@Override
	public void outAIfElseUnmatched(AIfElseUnmatched node) {
		// TODO Auto-generated method stub
		super.outAIfElseUnmatched(node);
	}

	@Override
	public void outALocalDecl(ALocalDecl node) {
		// TODO Auto-generated method stub
		super.outALocalDecl(node);
	}

	@Override
	public void outAInitializedLocalDecl(AInitializedLocalDecl node) {
		// TODO Auto-generated method stub
		super.outAInitializedLocalDecl(node);
	}

	@Override
	public void outAArrayLocalDecl(AArrayLocalDecl node) {
		// TODO Auto-generated method stub
		super.outAArrayLocalDecl(node);
	}

	@Override
	public void outAFieldAccess(AFieldAccess node) {
		// TODO Auto-generated method stub
		super.outAFieldAccess(node);
	}

	@Override
	public void outASizedArrayFieldAccess(ASizedArrayFieldAccess node) {
		// TODO Auto-generated method stub
		super.outASizedArrayFieldAccess(node);
	}

	@Override
	public void outAArrayFieldAccess(AArrayFieldAccess node) {
		// TODO Auto-generated method stub
		super.outAArrayFieldAccess(node);
	}

	@Override
	public void outAParameterizedArrayFieldAccess(AParameterizedArrayFieldAccess node) {
		// TODO Auto-generated method stub
		super.outAParameterizedArrayFieldAccess(node);
	}

	@Override
	public void outAQualifiedFieldAccess(AQualifiedFieldAccess node) {
		// TODO Auto-generated method stub
		super.outAQualifiedFieldAccess(node);
	}

	@Override
	public void outANoArgMethodCall(ANoArgMethodCall node) {
		// TODO Auto-generated method stub
		super.outANoArgMethodCall(node);
	}

	@Override
	public void outAMethodCall(AMethodCall node) {
		// TODO Auto-generated method stub
		super.outAMethodCall(node);
	}

	@Override
	public void outAMultArgs(AMultArgs node) {
		// TODO Auto-generated method stub
		super.outAMultArgs(node);
	}

	@Override
	public void outAArgs(AArgs node) {
		// TODO Auto-generated method stub
		super.outAArgs(node);
	}

	@Override
	public void outAOrExpr(AOrExpr node) {
		// TODO Auto-generated method stub
		super.outAOrExpr(node);
	}

	@Override
	public void outANotAnOrExpr(ANotAnOrExpr node) {
		// TODO Auto-generated method stub
		super.outANotAnOrExpr(node);
	}

	@Override
	public void outAAndExpr(AAndExpr node) {
		// TODO Auto-generated method stub
		super.outAAndExpr(node);
	}

	@Override
	public void outANotAnAndExpr(ANotAnAndExpr node) {
		// TODO Auto-generated method stub
		super.outANotAnAndExpr(node);
	}

	@Override
	public void outAEqualsEqualityExpr(AEqualsEqualityExpr node) {
		// TODO Auto-generated method stub
		super.outAEqualsEqualityExpr(node);
	}

	@Override
	public void outANotEqualsEqualityExpr(ANotEqualsEqualityExpr node) {
		// TODO Auto-generated method stub
		super.outANotEqualsEqualityExpr(node);
	}

	@Override
	public void outANotAnEqualityExpr(ANotAnEqualityExpr node) {
		// TODO Auto-generated method stub
		super.outANotAnEqualityExpr(node);
	}

	@Override
	public void outALessThanComparisonExpr(ALessThanComparisonExpr node) {
		// TODO Auto-generated method stub
		super.outALessThanComparisonExpr(node);
	}

	@Override
	public void outAGreaterThanComparisonExpr(AGreaterThanComparisonExpr node) {
		// TODO Auto-generated method stub
		super.outAGreaterThanComparisonExpr(node);
	}

	@Override
	public void outALessThanOrEqComparisonExpr(ALessThanOrEqComparisonExpr node) {
		// TODO Auto-generated method stub
		super.outALessThanOrEqComparisonExpr(node);
	}

	@Override
	public void outAGreaterThanOrEqComparisonExpr(AGreaterThanOrEqComparisonExpr node) {
		// TODO Auto-generated method stub
		super.outAGreaterThanOrEqComparisonExpr(node);
	}

	@Override
	public void outANotAComparisonExpr(ANotAComparisonExpr node) {
		// TODO Auto-generated method stub
		super.outANotAComparisonExpr(node);
	}

	@Override
	public void outAAddArithExpr(AAddArithExpr node) {
		// TODO Auto-generated method stub
		super.outAAddArithExpr(node);
	}

	@Override
	public void outASubArithExpr(ASubArithExpr node) {
		// TODO Auto-generated method stub
		super.outASubArithExpr(node);
	}

	@Override
	public void outANotAnArithExpr(ANotAnArithExpr node) {
		// TODO Auto-generated method stub
		super.outANotAnArithExpr(node);
	}

	@Override
	public void outAMultiplyFactExpr(AMultiplyFactExpr node) {
		// TODO Auto-generated method stub
		super.outAMultiplyFactExpr(node);
	}

	@Override
	public void outADivideFactExpr(ADivideFactExpr node) {
		// TODO Auto-generated method stub
		super.outADivideFactExpr(node);
	}

	@Override
	public void outAModuloFactExpr(AModuloFactExpr node) {
		// TODO Auto-generated method stub
		super.outAModuloFactExpr(node);
	}

	@Override
	public void outANotAFactExpr(ANotAFactExpr node) {
		// TODO Auto-generated method stub
		super.outANotAFactExpr(node);
	}

	@Override
	public void outANotUnaryExpr(ANotUnaryExpr node) {
		// TODO Auto-generated method stub
		super.outANotUnaryExpr(node);
	}

	@Override
	public void outAPlusUnaryExpr(APlusUnaryExpr node) {
		// TODO Auto-generated method stub
		super.outAPlusUnaryExpr(node);
	}

	@Override
	public void outAMinusUnaryExpr(AMinusUnaryExpr node) {
		// TODO Auto-generated method stub
		super.outAMinusUnaryExpr(node);
	}

	@Override
	public void outANotAUnaryExpr(ANotAUnaryExpr node) {
		// TODO Auto-generated method stub
		super.outANotAUnaryExpr(node);
	}

	@Override
	public void outAFieldPrimary(AFieldPrimary node) {
		// TODO Auto-generated method stub
		super.outAFieldPrimary(node);
	}

	@Override
	public void outAMethodCallPrimary(AMethodCallPrimary node) {
		// TODO Auto-generated method stub
		super.outAMethodCallPrimary(node);
	}

	@Override
	public void outAIntLiteralPrimary(AIntLiteralPrimary node) {
		// TODO Auto-generated method stub
		super.outAIntLiteralPrimary(node);
	}

	@Override
	public void outACharLiteralPrimary(ACharLiteralPrimary node) {
		// TODO Auto-generated method stub
		super.outACharLiteralPrimary(node);
	}

	@Override
	public void outAStrLiteralPrimary(AStrLiteralPrimary node) {
		// TODO Auto-generated method stub
		super.outAStrLiteralPrimary(node);
	}

	@Override
	public void outAFloatLiteralPrimary(AFloatLiteralPrimary node) {
		// TODO Auto-generated method stub
		super.outAFloatLiteralPrimary(node);
	}

	@Override
	public void outATrueLiteralPrimary(ATrueLiteralPrimary node) {
		// TODO Auto-generated method stub
		super.outATrueLiteralPrimary(node);
	}

	@Override
	public void outAFalseLiteralPrimary(AFalseLiteralPrimary node) {
		// TODO Auto-generated method stub
		super.outAFalseLiteralPrimary(node);
	}

	@Override
	public void outAExprPrimary(AExprPrimary node) {
		// TODO Auto-generated method stub
		super.outAExprPrimary(node);
	}

	@Override
	public void outANumericIntegerValue(ANumericIntegerValue node) {
		// TODO Auto-generated method stub
		super.outANumericIntegerValue(node);
	}

	@Override
	public void outAIdentifierIntegerValue(AIdentifierIntegerValue node) {
		// TODO Auto-generated method stub
		super.outAIdentifierIntegerValue(node);
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
