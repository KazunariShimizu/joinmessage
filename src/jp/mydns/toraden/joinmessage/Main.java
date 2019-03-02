package jp.mydns.toraden.joinmessage;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("プラグインが有効になりました");
	}
	
	@Override
	public void onDisable() {
		System.out.println("プラグインが無効になりました");
	}
}