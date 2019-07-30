package tss;



/**
 * Template for tss.Artist. You must implement the constructor and methods
 * shown. You may add fields, constructors, and methods, but do not change
 * the signatures of those provided.
 */
public class Artist {

	private String _name;


	/**
	 * Create an artist object with the provide name.
	 * @param name The name of the artist.
	 */
	public Artist(String name) {
		System.out.println("@Artist object created with name " + name);
		_name = name;


	}




	@Override
	public String toString() {
		return _name;
	}
	/**
	 * Check whether the new artist match with the reigstered artist list.
	 */
	@Override
	public boolean equals(Object obj) {
		if (_name == obj){
			return true;
		}

		return false;
	}


}

