package net.landofrails.MessageAPI.plugin;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.landofrails.MessageAPI.api.ELanguage;
import net.landofrails.MessageAPI.api.MessageAPI;

public class MessageAPIPlugin extends JavaPlugin {

	private static MessageAPIPlugin plugin = null;

	public static MessageAPIPlugin getInstance() {
		return plugin;
	}

	//

	private MessageAPI<MessageAPIMessages> messageAPI;

	@Override
	public void onLoad() {
		// Pre MessageAPI
		plugin = this;
		checkConfig();
		// Init MessageAPI
		messageAPI = MessageAPI.register(plugin, MessageAPIMessages.class);
		//
		messageAPI.sendToConsole(MessageAPIMessages.LOADING_START);

		messageAPI.sendToConsole(MessageAPIMessages.LOADING_END);
	}

	@Override
	public void onEnable() {
		try {
			final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

			bukkitCommandMap.setAccessible(true);
			CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

			commandMap.register("lang", new BukkitCommand("lang") {
				@Override
				public boolean execute(CommandSender sender, String commandLabel, String[] args) {
					if (sender instanceof Player) {
						sender.sendMessage("PlayerLang: " + MessageAPI.getLanguage((Player) sender));
						sender.sendMessage("ServerLang: " + getServerLanguage().getName());
					} else {
						System.out.println("Du bist kein Spieler!");
					}
					return true;
				}
			});


		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {

	}

	private void checkConfig() {
		this.reloadConfig();
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	public ELanguage getServerLanguage() {
		return ELanguage.getFromLocale(getConfig().getString("serverLanguage")).orElse(MessageAPI.DEFAULT_LANGUAGE);
	}

}
