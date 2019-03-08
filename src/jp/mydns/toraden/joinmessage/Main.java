package jp.mydns.toraden.joinmessage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		System.out.println("プラグインが有効になりました");
	}
	
	@Override
	public void onDisable() {
		System.out.println("プラグインが無効になりました");
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.hasPlayedBefore()) {
			e.setJoinMessage("プレイヤーがログインしました: " + e.getPlayer().getName());
		}else {
			e.setJoinMessage("プレイヤーが初めてログインしました: " + e.getPlayer().getName());
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("2019vote")) {
			sender.sendMessage("投票が行われました。");
		}
		
		return true;
	}
}