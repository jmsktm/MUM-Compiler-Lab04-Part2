class in06 {

  void main() {

    int i;
    int j;
    int k;
    bool p;
    bool q;

	i = 0;
	j = 0;
	while (i < 10) {
	    if (i % 2 == 0)
		j = j+i;
	    else j = j+i+1;
	    i = i + 1;
	}
	print(j, "\n");
	i = 0;
	k = 0;
	while (i > 0) {
	    k = k+i;
	    i = i - 1;
	}
	print(k, "\n");
  }

}
