package practica1ej9;
import java.util.Stack;




public class TestBalanceo {
	public static boolean estaBalanced (String T) {
		Stack<Character> pila = new Stack<Character>();

		for (int i=0; i < T.length(); i++) {
			char c = T.charAt(i);
			System.out.println(c);
			if ((c == '(') || (c=='{') || (c=='[')) {
				pila.push(c);
			}
			else if ((c == ')') || (c=='}') || (c==']')) {
				if (pila.isEmpty()) {
					return false;
				}
				char ap = pila.pop();
				if (((c == ')') && (ap != '('))  || ((c=='}') && (ap != '{')) || ((c==']') && (ap != '['))){
					return false;
				}

			}
	}
		return pila.isEmpty();
}
}
