package net.landofrails.MessageAPI.plugin;

import static net.landofrails.MessageAPI.api.ELanguage.AMERICAN_ENGLISH;
import static net.landofrails.MessageAPI.api.ELanguage.AUSTRALIAN_ENGLISH;
import static net.landofrails.MessageAPI.api.ELanguage.AUSTRIAN_GERMAN;
import static net.landofrails.MessageAPI.api.ELanguage.BRITISH_ENGLISH;
import static net.landofrails.MessageAPI.api.ELanguage.CANADIAN_ENGLISH;
import static net.landofrails.MessageAPI.api.ELanguage.GERMAN;
import static net.landofrails.MessageAPI.api.ELanguage.NEW_ZEALAND_ENGLISH;
import static net.landofrails.MessageAPI.api.ELanguage.SWISS_GERMAN;

import net.landofrails.MessageAPI.api.IMessageAPI;
import net.landofrails.MessageAPI.api.TranslatedText;

public enum MessageAPIMessages implements IMessageAPI {

	// @formatter:off
	LOADING_START(
			"loading.start", 
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Loading phase started.."),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] Loading phase started.."),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] Loading phase started.."),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] Loading phase started.."),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] Loading phase started.."),
			
			new TranslatedText(GERMAN, "[MessageAPI] Lade-Phase begonnen.."),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] Lade-Phase begonnen.."),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] Lade-Phase begonnen..")
	),
	LOADING_END(
			"loading.end",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Loading phase finished."),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] Loading phase finished."),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] Loading phase finished."),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] Loading phase finished."),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] Loading phase finished."),
			
			new TranslatedText(GERMAN, "[MessageAPI] Lade-Phase beendet."),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] Lade-Phase beendet."),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] Lade-Phase beendet.")
	),
	
	REGISTER_COMMAND_START(
			"register_command.start",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Starting command registration.."),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] Starting command registration.."),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] Starting command registration.."),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] Starting command registration.."),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] Starting command registration.."),
			
			new TranslatedText(GERMAN, "[MessageAPI] Registriere Befehl.."),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] Registriere Befehl.."),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] Registriere Befehl..")
	),
	REGISTER_COMMAND_END(
			"register_command.end",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Command registrated."),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] Command registrated."),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] Command registrated."),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] Command registrated."),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] Command registrated."),
			
			new TranslatedText(GERMAN, "[MessageAPI] Befehl registriert."),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] Befehl registriert."),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] Befehl registriert.")
	),
	
	DISABLING_PLUGIN(
			"disabling_plugin",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Disabling plugin."),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] Disabling plugin."),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] Disabling plugin."),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] Disabling plugin."),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] Disabling plugin."),
			
			new TranslatedText(GERMAN, "[MessageAPI] Plugin wird gestoppt."),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] Plugin wird gestoppt."),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] Plugin wird gestoppt.")
	),
	
	LANGUAGE_SERVER(
			"language.server",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] Server language: {0}, {1}"),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] Server language: {0}, {1}"),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] Server language: {0}, {1}"),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] Server language: {0}, {1}"),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] Server language: {0}, {1}"),
			
			new TranslatedText(GERMAN, "[MessageAPI] Server Sprache: {0}, {1}"),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] Server Sprache: {0}, {1}"),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] Server Sprache: {0}, {1}")
	),
	LANGUAGE_PLAYER(
			"language.player",
			new TranslatedText(AMERICAN_ENGLISH, "[MessageAPI] {0}s language: {1}, {2}"),
			new TranslatedText(AUSTRALIAN_ENGLISH, "[MessageAPI] {0}s language: {1}, {2}"),
			new TranslatedText(CANADIAN_ENGLISH, "[MessageAPI] {0}s language: {1}, {2}"),
			new TranslatedText(BRITISH_ENGLISH, "[MessageAPI] {0}s language: {1}, {2}"),
			new TranslatedText(NEW_ZEALAND_ENGLISH, "[MessageAPI] {0}s language: {1}, {2}"),
			
			new TranslatedText(GERMAN, "[MessageAPI] {0}s Sprache: {1}, {2}"),
			new TranslatedText(SWISS_GERMAN, "[MessageAPI] {0}s Sprache: {1}, {2}"),
			new TranslatedText(AUSTRIAN_GERMAN, "[MessageAPI] {0}s Sprache: {1}, {2}")
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
