
public class VariableEntry extends Entry {
	public VariableEntry(String name, Type t) {
		super(name, t);
	}

	/**
	 * Returns a String representation of the variable. e.g., int var
	 */
	public String toString() {
		// Do not put a semicolon after the variable because sometimes
		// a variable declaration is followed by a comma, e.g.,
		// method parameters. Only include the type and identifier name.
		
		String str = this.type().toString() + " " + this.name();
		if (this.type().isArrayKind()) {
			int size = this.type().getArraySize();
			str += "[";
			if (size > 0) str += size;
			str += "]";
		}
		return str;
	}
} // End of class VariableEntry
