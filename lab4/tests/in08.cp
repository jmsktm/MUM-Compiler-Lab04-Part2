class in08 {

    void t1() {
	return ;
    }

    int five() {
	return 5;
    }

    int square(int i) {
	return i*i;
    }

    string concat(string a, string b) {
	return a+b;
    }

    string concatN(string s, string a, int copies) {
	if (copies <= 0) {
	    return s;
	}
	while (0 < copies) {
	    s = s + a;
	    copies = copies - 1;
	}
	return s;
    }

    void vectorAdd(int a[], int b[], int c[], int size) {
	int i = 0;
	while (i < size) {
	    c[i] = a[i] + b[i];
	    i = i + 1;
	}
    }
}

class Main {

    void main() {
	int i;
	int j;
	string a;
	string b;

	int i;
	int j[2];
	float a = 1.5 ;
	float b = .5 ;
	float c = 1. ;
	float d = 1.e05 ;
	float e = .5E+1 ;
	float f = 1.77E-03 ;

	i = 4;
	j = 7;
	a = "aaa";
	b = "bb";
	in08.t1();
	print(in08.five());
	print(in08.square(i));
	print(in08.concat(a, b));
	print(in08.concatN(a, b, 3));
	print(in08.concatN(a, "cd", 7));
	print(in08.concatN("xyz", b, i));

	{
		int A[14];
		int B[14];
		int C[14];

		i = 0;
		while (i < 14) {
			A[i] = 3*i;
			B[i] = i*i;
			i = i + 1;
        	}
		i = 0;
		while (i < 14) {
			print(A[i], " ");
			i = i + 1;
		}
		print("\n");
		i = 0;
		while (i < 14) {
			print(B[i], " ");
			i = i + 1;
		}
		print("\n");
		in08.vectorAdd(A, B, C, 14);
		i = 0;
		while (i < 14) {
			print(C[i], " ");
			i = i + 1;
		}
		print("\n");
		in08.vectorAdd(C, B, A, 14);
		i = 0;
		while (i < 14) {
			print(A[i], " ");
			i = i + 1;
		}
		print("\n");
	}
   }

    void main() {
    }
}

class Main {
    int m() {
    }
    char m(int x, 
	     float x) {
    }
}

