package Hello;

public class textEditor {
	private spellChecker sp = new spellChecker();
	
	public void setspellChecker(spellChecker checker) {
		System.out.println("set spellchecker");
		this.sp = checker;
	}
	
	public spellChecker getspellChecker() {
		return sp;
	}
	
	public void checkSpelling() {
		sp.checkspell();
	}
}
