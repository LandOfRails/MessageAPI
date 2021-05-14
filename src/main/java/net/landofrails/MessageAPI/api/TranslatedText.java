package net.landofrails.MessageAPI.api;

public final class TranslatedText {

	private ELanguage lang;
	private String text;

	public TranslatedText(ELanguage lang, String text) {
		this.lang = lang;
		this.text = text;
	}

	public ELanguage getLanguage() {
		return lang;
	}

	public String getText() {
		return text;
	}

}
