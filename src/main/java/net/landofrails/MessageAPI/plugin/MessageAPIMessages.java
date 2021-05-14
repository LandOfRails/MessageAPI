package net.landofrails.MessageAPI.plugin;

import static net.landofrails.MessageAPI.api.ELanguage.AMERICAN_ENGLISH;
import static net.landofrails.MessageAPI.api.ELanguage.GERMAN;

import net.landofrails.MessageAPI.api.IMessageAPI;
import net.landofrails.MessageAPI.api.TranslatedText;

public enum MessageAPIMessages implements IMessageAPI {

	// @formatter:off
	LOADING_START(
			"loading.start", 
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Loading phase started.."),
			new TranslatedText(GERMAN, "[MessageAPI] Lade-Phase begonnen..")
	),
	LOADING_END(
			"loading.end",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Loading phase finished."),
			new TranslatedText(GERMAN, "[MessageAPI] Lade-Phase beendet.")
	);
	// @formatter:on

	private String path;
	private TranslatedText[] translatedText = new TranslatedText[0];

	private MessageAPIMessages(String path, TranslatedText... translatedText) {
		this.path = path;
		this.translatedText = translatedText;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public TranslatedText[] getText() {
		return translatedText;
	}

}
