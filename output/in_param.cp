
class Main {
    int u[2];
    int v[2];
    int t[2];
    int a = 5;
    int r = 10;

    int mystery(int w, int x[], int y[], int z, int c) {
	t = x;
	x = y;
	y = t;
	y[0] = x[0] + u[0];
	z = v[1];
	w = y[1];
	x[1] = w + z;
	t[0] = y[0] + x[0];
	a = t[0] + c;
	return a + z;
    }

    void main() {
	u[0] = 5; u[1] = 6; v[0] = 3; v[1] = 8;
	r = mystery(a, u, v, u[1], 13);
	print(u[0], u[1], v[0], v[1], t[0], t[1], a, r);
    }
}
