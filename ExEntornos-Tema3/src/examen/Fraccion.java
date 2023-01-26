package examen;

// Clase que define una fracción
public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		}else {
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
		}
	}

	// Constructor copia
	public Fraccion(final Fraccion valorFraccionf) {
		num = valorFraccionf.num;
		den = valorFraccionf.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maxComunDivisor() {
		int valornum = Math.abs(num); // valor absoluto del numerador
		int valorden = Math.abs(den); // valor absoluto del denominador
		int resultado;
		while (valorden != 0) {
			resultado = valornum % valorden;
			valornum = valorden;
			valorden = resultado;
		}
		return valornum;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int maxComDiv = maxComunDivisor();
		num = num / maxComDiv;
		den = den / maxComDiv;
	}

	// Método toString

	public String toString() {
		return num + "/" + den;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion valorFraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * valorFraccion.den;
		int cruce2 = den * valorFraccion.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * valorFraccion.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion valorFraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * valorFraccion.den;
		int cruce2 = den * valorFraccion.num;
		aux.num = cruce1 - cruce2;
		aux.den = den * valorFraccion.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
	

	public Fraccion multiplicar(Fraccion valorFraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * valorFraccion.num;
		aux.den = den * valorFraccion.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion valorFraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * valorFraccion.den;
		aux.den = den * valorFraccion.num;
		aux.simplificar();
		return aux;

	}

}
