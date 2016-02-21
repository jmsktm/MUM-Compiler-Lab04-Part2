/*
  Tests of class and method declarations, qualified variable accesses and 
  if statements.
*/
class A {
    int A(int A) {
	B.A = A;
	;
    }
    bool B(int A, bool B) {
	B.A = A;
	B.B = B;
    }
    char C(int A, bool B, char C) {
	B.A = A;
	B.B = B;
	B.C = C;
    }
    string S(int A, bool B, char C, string S) { 
	B.A = A;
	if (B) B.B = B;  else  B.C = C;
	B.S = S;
    }
}
class B {
    int A;
    bool B;
    char C;
    string S;
}
