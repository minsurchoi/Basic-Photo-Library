package part03;

public enum BookType {
	FICTION("Stories from the imagination"),
	NON_FICTION("Factual, real-life experiences"),
	REFERENCE("Theories, Philosophies and common knowledge");
	

private String type;

BookType(String type){
	this.type = type;
}

public String toString() {
	return type;
}

} 
