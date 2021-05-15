package net.landofrails.MessageAPI.api;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.landofrails.MessageAPI.plugin.MessageAPIPlugin;

public final class MessageAPI<E extends Enum<E> & IMessageAPI> {

	public static final ELanguage DEFAULT_LANGUAGE = ELanguage.AMERICAN_ENGLISH;

	private Map<ELanguage, Entry<FileConfiguration, File>> configs = new EnumMap<>(ELanguage.class);

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
	 * {@link MessageAPI#serverLanguage()}.
	 * 
	 * @param player
	 * @return ELanguage
	 */
	public static ELanguage getLanguage(Player player) {
		return ELanguage.getFromLocale(player.getLocale().toLowerCase()).orElse(serverLanguage());
	}

	/**
	 * 
	 * Returns the server language, if that fails it will return the value from
	 * {@link MessageAPI#DEFAULT_LANGUAGE}.
	 * 
	 * @return ELanguage
	 */
	public static ELanguage serverLanguage() {
		try {
			return MessageAPIPlugin.getInstance().getServerLanguage();
		} catch (Exception e) {
			return DEFAULT_LANGUAGE;
		}
	}

	/**
	 * 
	 * Sends a message to the console. Calls {@link MessageAPI#serverLanguage()}
	 * for the wanted language.
	 * 
	 * @param message
	 * @param arguments
	 */
	public void sendToConsole(IMessageAPI message, Object... arguments) {
		String text = getTranslatedText(message, serverLanguage(), true, arguments);
		Bukkit.getConsoleSender().sendMessage(text);
	}

	/**
	 * 
	 * Sends a message to a player. Calls {@link MessageAPI#getLanguage(Player)}
	 * for the players language.
	 * 
	 * @param player
	 * @param message
	 * @param arguments
	 */
	public void sendTo(Player player, IMessageAPI message, Object... arguments) {
		String text = getTranslatedText(message, getLanguage(player), true, arguments);
		player.sendMessage(text);
	}

	public void sendTo(CommandSender sender, IMessageAPI message, Object... arguments) {
		ELanguage lang = sender instanceof Player ? getLanguage((Player) sender) : serverLanguage();
		String text = getTranslatedText(message, lang, true, arguments);
		sender.sendMessage(text);
	}

	/**
	 * 
	 * Calls {@link MessageAPI#sendTo(Player, IMessageAPI, Object...)} for every
	 * player.
	 * 
	 * @param players
	 * @param message
	 * @param arguments
	 */
	public void sendTo(List<Player> players, IMessageAPI message, Object... arguments) {
		players.forEach(p -> sendTo(p, message, true, arguments));
	}

	/**
	 * 
	 * Translates the text in the given language. Arguments are inserted via
	 * {@link MessageFormat#format(String, Object...)}.
	 * 
	 * @param message
	 * @param language
	 * @param returnPathIfMissing
	 * @param arguments
	 * @return
	 */
	public String getTranslatedText(IMessageAPI message, ELanguage language, boolean returnPathIfMissing, Object... arguments) {
		if (configs.containsKey(language)) {
			FileConfiguration config = configs.get(language).getKey();
			if (config.contains(message.getPath())) {
				return MessageFormat.format(config.getString(message.getPath()), arguments);
			}
		}
		return returnPathIfMissing ? message.getPath() : null;
	}

	/**
	 * 
	 * Creates lang files for the enum constants. Loads all lang files.
	 * 
	 * @param plugin
	 * @param enumClass
	 */
	private void checkConfigs(JavaPlugin plugin, Class<E> enumClass) {
		
		// For existing constant languages
		for (E enumConstant : enumClass.getEnumConstants()) {
			for (TranslatedText text : enumConstant.getText()) {
				if (!configs.containsKey(text.getLanguage())) {
					// Create config
					FileConfiguration config = new YamlConfiguration();
					try {
						File folder = new File(plugin.getDataFolder(), "messages");
						folder.mkdirs();
						File configFile = new File(folder, text.getLanguage().getLocale() + ".yml");
						configFile.createNewFile();
						config.load(configFile);

						configs.put(text.getLanguage(), new SimpleEntry<FileConfiguration, File>(config, configFile));
					} catch (IOException | InvalidConfigurationException e) {
						e.printStackTrace();
					}
				}
				
				FileConfiguration config = configs.get(text.getLanguage()).getKey();
				if (!config.contains(enumConstant.getPath())) {
					config.set(enumConstant.getPath(), text.getText());
				}

			}
		}
		
		// Save changes made
		for (ELanguage lang : configs.keySet()) {
			try {
				configs.get(lang).getKey().save(configs.get(lang).getValue());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// check if there are other lang files
		for (ELanguage lang : ELanguage.values()) {
			if (!configs.containsKey(lang)) {
				// Create config
				FileConfiguration config = new YamlConfiguration();
				try {
					File folder = new File(plugin.getDataFolder(), "messages");
					folder.mkdirs();
					File configFile = new File(folder, lang.getLocale() + ".yml");
					if (configFile.exists()) {
						config.load(configFile);
						configs.put(lang, new SimpleEntry<FileConfiguration, File>(config, configFile));
					}
				} catch (IOException | InvalidConfigurationException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
