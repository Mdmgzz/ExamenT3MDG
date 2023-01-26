package fraccion;
/**
 * Clase que define una fracción
 * @author mdominguezg
 * @version 1.0
 */
public class Fraccion {
	/**
	 * Numerador de la fraccion
	 */
	
	private int num;

	/**
	 * Denominador de la fraccion
	 */
	private int den;

	/**
	 * Constructor por defecto
	 * debe generar el valor neutro que es 0/1
	 */
	public Fraccion() {
		num = 0;
		den = 1;

	}

	/**
	 * Constructor con parámetros
	 * @param num Numerador de la fracción
	 * @param den Denominador de la fracción
	 * @return devuelvo la fraccion simplificada
	 */
	public Fraccion(int num, int den) {
		/**
		 * debo evitar crear fracciones con 0 en el divisor
		 */
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		simplificar();
	}

	/**
	 * Constructor copia
	 * @param f como parametro entra el objeto de tipo fraccion
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * setea la constante num con el valor de la variable num
	 * @param num entra el numerador como parametro 
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * coje el valor de la constante num para devolverlo
	 * @return num devuelve el valor del numerador
	 */
	public int getNum() {
		return num;

	}
	/**
	 * Setea el valor de den a la constante den
	 * @param den el valor del denomidador en la variable local (den) entra como parametro
	 */
	public void setDen(int den) {
		this.den = den;
	}
	/**
	 * obtiene el valor de la constante den 
	 * @return den devuelve el valor de den 
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * @return u devuelve l valor absoluto del numerador
	 */
	private int mcd() {
		/*
		 * u= valor absoluto del numerador
		 * v= valor absoluto del denominador
		 * si el valor de v es = a 0 devuelve el valor de u
		 */
		int u = (Math.abs(num)); 
		int v = (Math.abs(den)); 
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * método para simplificar fracciones, llamando a la funcion mcd y seteando el resultado a la variable n
	 * apartir de ahí, realiza operaciones para simplificar
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * Método toString
	 * @return mensaje devuelve la fracion para verla en pantalla
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * suma de fracciones
	 * @param f entra la propia fracion como parametro para sumarla
	 * @return devuelve el resultado de la suma simplificado
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Restar fracciones
	 * @param f entra la propia fracion como parametro para restarla
	 * @return devuelve el resultado de la resta simplificado
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Multiplicar fracciones
	 * @param f entra la propia fracion como parametro para multiplicarla
	 * @return devuelve el resultado de la multiplicación simplificado
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Dividir fracciones
	 * @param f entra la propia fracion como parametro para dividirla
	 * @return devuelve el resultado de la división simplificado
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
