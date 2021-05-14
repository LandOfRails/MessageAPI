package net.landofrails.MessageAPI.api;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.landofrails.MessageAPI.plugin.MessageAPIPlugin;

public final class MessageAPI<E extends Enum<E> & IMessageAPI> {

	public static final ELanguage DEFAULT_LANGUAGE = ELanguage.AMERICAN_ENGLISH;

	private Map<ELanguage, FileConfiguration> configuration = new EnumMap<>(ELanguage.class);
	private Map<ELanguage, File> configurationFiles = new EnumMap<>(ELanguage.class);

	private MessageAPI(JavaPlugin plugin, Class<E> enumClass) {

		checkConfigs(plugin, enumClass);

	}

	/**
	 * 
	 * Factory for MessageAPI Instances. Needs your plugin and an enum class
	 * that implements {@link IMessageAPI
	 * net.landofrails.MessageAPI.IMessageAPI}.
	 * 
	 * @param plugin
	 * @param enumClass
	 * @return MessageAPI
	 */
	public static <E extends Enum<E> & IMessageAPI> MessageAPI<E> register(JavaPlugin plugin, Class<E> enumClass) {
		return new MessageAPI<>(plugin, enumClass);
	}

	/**
	 * 
	 * Returns the players language, if that fails it will return the value from
	 * {@link MessageAPI#defaultLanguage()}.
	 * 
	 * @param player
	 * @return ELanguage
	 */
	public static ELanguage getLanguage(Player player) {
		return ELanguage.getFromLocale(player.getLocale().toLowerCase()).orElse(defaultLanguage());
	}

	/**
	 * 
	 * Returns the server language, if that fails it will return the value from
	 * {@link MessageAPI#DEFAULT_LANGUAGE}.
	 * 
	 * @return ELanguage
	 */
	private static ELanguage defaultLanguage() {
		try {
			return MessageAPIPlugin.getInstance().getServerLanguage();
		} catch (Exception e) {
			return DEFAULT_LANGUAGE;
		}
	}

	public void sendToConsole(IMessageAPI message, Object... arguments) {
		String text = getTranslatedText(message, defaultLanguage(), true, arguments);
		Bukkit.getConsoleSender().sendMessage(text);
	}

	public void sendTo(Player player, IMessageAPI message, Object... arguments) {
		String text = getTranslatedText(message, getLanguage(player), true, arguments);
		player.sendMessage(text);
	}

	public void sendTo(List<Player> players, IMessageAPI message, Object... arguments) {
		players.forEach(p -> sendTo(p, message, true, arguments));
	}

	public String getTranslatedText(IMessageAPI message, ELanguage language, boolean returnPathIfMissing, Object... arguments) {
		if (configuration.containsKey(language)) {
			FileConfiguration config = configuration.get(language);
			if (config.contains(message.getPath())) {
				return MessageFormat.format(config.getString(message.getPath()), arguments);
			}
		}
		return returnPathIfMissing ? message.getPath() : null;
	}

	private void checkConfigs(JavaPlugin plugin, Class<E> enumClass) {
		
		// For existing constant languages
		for (E enumConstant : enumClass.getEnumConstants()) {
			for (TranslatedText text : enumConstant.getText()) {
				if (!configuration.containsKey(text.getLanguage())) {
					// Create config
					FileConfiguration config = new YamlConfiguration();
					try {
						File folder = new File(plugin.getDataFolder(), "messages");
						folder.mkdirs();
						File configFile = new File(folder, text.getLanguage().getLocale() + ".yml");
						configFile.createNewFile();
						configurationFiles.put(text.getLanguage(), configFile);
						config.load(configFile);
					} catch (IOException | InvalidConfigurationException e) {
						e.printStackTrace();
					}
					configuration.put(text.getLanguage(), config);
				}
				
				FileConfiguration config = configuration.get(text.getLanguage());
				if (!config.contains(enumConstant.getPath())) {
					config.set(enumConstant.getPath(), text.getText());
				}

			}
		}
		
		// Save changes made
		for (ELanguage lang : configuration.keySet()) {
			try {
				configuration.get(lang).save(configurationFiles.get(lang));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// check if there are other lang files
		for (ELanguage lang : ELanguage.values()) {
			if (!configuration.containsKey(lang)) {
				// Create config
				FileConfiguration config = new YamlConfiguration();
				try {
					File folder = new File(plugin.getDataFolder(), "messages");
					folder.mkdirs();
					File configFile = new File(folder, lang.getLocale() + ".yml");
					if (configFile.exists()) {
						configurationFiles.put(lang, configFile);
						config.load(configFile);
						configuration.put(lang, config);
					}
				} catch (IOException | InvalidConfigurationException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
