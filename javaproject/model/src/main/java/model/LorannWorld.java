package model;
	public class LorannWorld extends Entity {

	
		private int			id;

	
		private String	key;

		
		private String	maptxt;

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
		public LorannWorld(final int id, final String key, final String maptxt) {
			this.setId(id);
			this.setKey(key);
			this.setMaptxt(maptxt);
			
		}

		/**
		 * Instantiates a new hello world.
		 */
		public LorannWorld() {
			this(0, "", "");
		}

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public int getId() {
			return this.id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id
		 *          the new id
		 */
		public void setId(final int id) {
			this.id = id;
		}

		/**
		 * Gets the key.
		 *
		 * @return the key
		 */
		public String getKey() {
			return this.key;
		}

		/**
		 * Sets the key.
		 *
		 * @param key
		 *          the new key
		 */
		public void setKey(final String key) {
			this.key = key;
		}

		/**
		 * Gets the message.
		 *
		 * @return the message
		 */
		public String getMaptxt() {
			return this.maptxt;
		}

		/**
		 * Sets the message.
		 *
		 * @param message
		 *          the new message
		 */
		public void setMaptxt(final String maptxt) {
			this.maptxt = maptxt;
		}

	}


