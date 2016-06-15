package model;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class LorannWorld extends Entity {

	/** The id. */
	private int			id_carte;
	private int			x;
	private int			y;


	/**
	 * Instantiates a new hello world.
	 *
	 * @param id
	 *          the id
	 * @param key
	 *          the key
	 * @param message
	 *          the message
	 */
	public LorannWorld(final int id_carte) {
		this.setIdCarte(id_carte);

	}

	/**
	 * Instantiates a new hello world.
	 */
	public LorannWorld() {
		this(0);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getIdCarte() {
		return this.id_carte;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setIdCarte(final int id_carte) {
		this.id_carte = id_carte;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(final int x) {
		this.x = x;
	}
	
	public void setY(final int y) {
		this.y = y;
	}



}
