package practica1ej9;

public class Princi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ejemplo1 = "({[]})"; 
        String ejemplo2 = "((())";   
        String ejemplo3 = "[{()}]"; 

        System.out.println(TestBalanceo.estaBalanced(ejemplo1)); 
        System.out.println(TestBalanceo.estaBalanced(ejemplo2)); 
        System.out.println(TestBalanceo.estaBalanced(ejemplo3)); 
	}

}
