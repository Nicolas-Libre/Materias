package ar.edu.unlp.oo1.ejercicio1;


/**
 * Completar esta clase de acuerdo a lo especificado
 */
public class WallPost {
	private String texto = "Undefined post";
	private int cant_likes = 0;
	private boolean destacado = false;
	
	/**
	 * Retorna el texto descriptivo de la publicación
	 * 
	 * 
	 * @return
	 */
	public WallPost () {
		
	}
	public String getText() {
		return texto;
	};

	/**
	 * Setea el texto descriptivo de la publicación
	 * @param text
	 */
	public void setText(String text) {
		texto = text;
	};

	/**
	 * Retorna la cantidad de “me gusta”
	 * 
	 * @return
	 */
	public int getLikes() {
		return cant_likes;
	};

	/**
	 * Incrementa la cantidad de likes en uno
	 */
	public void like() {
		cant_likes++;
	};

	/**
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
	 */
	public void dislike() {
		if (cant_likes != 0) {
			cant_likes--;
		}
		
	};

	/**
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 * 
	 * @return
	 */
	public boolean isFeatured() {
		return destacado;
	};

	/**
	 * Cambia el post del estado destacado a no destacado y viceversa
	 */
	public void toggleFeatured() {
		destacado = !destacado;
	};

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" +
			"text: " + getText() +
			", likes: '" + getLikes() + "'" +
			", featured: '" + isFeatured() + "'" +
			"}";
	}

}