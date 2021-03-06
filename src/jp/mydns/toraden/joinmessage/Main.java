package jp.mydns.toraden.joinmessage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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
			e.setJoinMessage(null);
		}else {
			e.setJoinMessage(null);
		}
		
	}
	@EventHandler
	public void onPlayerJoin(PlayerQuitEvent e) {
		Player p = e.getPlayer();
			e.setQuitMessage(null);
		
	}

	@EventHandler
	public void onEnderDragonDeath(EntityDeathEvent e) {
		if (e.getEntity() instanceof EnderDragon) {
			// Bukkit.broadcastMessage("エンダードラゴンが死にました");
            Player p = e.getEntity().getKiller();

            // DiscordSRVの仕様上おそらくPlayerの発言に見せかけないとDiscordに表示しない
            p.chat(e.getEntity().getWorld().getName() + "のエンダードラゴンが死にました");
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("2020vote")) {
			sender.sendMessage("投票が行われました。");
		} else if (label.equalsIgnoreCase("vote")) {
			sender.sendMessage("https://minecraft.jp/servers/mc.toraden.com/vote");
		}

		return true;
	}
}