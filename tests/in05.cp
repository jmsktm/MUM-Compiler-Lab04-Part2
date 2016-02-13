/*
  Tests of class and method declarations, qualified variable accesses and 
  if and while statements.
*/
class A {
    int A(int A) {
	B.A = A;
	;
    }
    bool B(int A, bool B) {
	B.A = A;
	B.B = B;
	while (i < 10) {
	    if (B) 
	        if (B.B[i]) i = i + 1;  else  {
		    B.B[i] = B; A.A[i] = A.A[i] + A; i = i + 1;
	        }
	    else i = i + 1;
      }
    }
    char C(int A[], bool B, char C) {
	int i = 0;
	B.A = A;
	B.B = B;
	B.C = C;
	while (i < 10) {
	    if (B.B[i]) i = i + 1;  else  {
		 B.B[i] = B; A.A[i] = A.A[i] + A; i = i + 1;
	    }
      }
    }
    string S(int A, bool B, char C, string S) { 
	B.A = A;
	if (B) B.B[A] = B;  else  B.C = C;
	B.S = S;
    }
}
class B {
    int A[10];
    bool B[10];
    char C;
    string S;
}
 
