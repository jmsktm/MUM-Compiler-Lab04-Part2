/*
  Tests of class and method declarations, qualified variable accesses and 
  qualified method calls.
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
	{
	    int A = B.A;
	    bool B = B.B;
	    char C = B.C;
	    string S = B.S;
	}
    }
    string S(int A, bool B, char C[], string S) { 
	read(C[B.A], B, A, S);
	B.A = A;
	B.B = B;
	B.C = C[B.A];
	B.S = S;
	print(C[B.A], B, A, S);
	return B.S;
    }
}
class B {
    int A;
    bool B;
    char C;
    string S;
    void M() {
	A = A.A(A);
	B = A.B(A, B);
	C = A.C(A, B, C);
	S = A.S(A, B, C, S);
    }
}
