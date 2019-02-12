package cashbackDomain.objects.identity;

public final class Id<T> implements Comparable<Id<T>>{
	private final int id;
	
	public Id(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Id<T> otherId) {
		if(this.id == otherId.id) {
			return 0;
		} else if (this.id < otherId.id) {
			return -1;
		} else {
			return 1;
		}
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object that) {
		if (that instanceof Id<?>){
	        if ( ((Id<?>)that).id == id ){
	            return true;
	        } 
	    }
	    return false;
	}
	
}
