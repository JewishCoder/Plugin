package MainPackage;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class Handler implements Listener 
{	
	public int PlayerSpleepCount = 0;
	
	public Handler() 
	{
	}
	
	
	@EventHandler
	public void Sleeping(PlayerBedEnterEvent e) 
	{
		Player player = e.getPlayer();
		Server server = player.getServer();
		int coutPlayers = server.getOnlinePlayers().size();
		
		PlayerSpleepCount++;
		float percent = PlayerSpleepCount / coutPlayers * 100;
		player.sendMessage("Сейчас спят: " + PlayerSpleepCount + " "+ "from" + " "+ coutPlayers);
		if(percent >= 50) 
		{
			player.sendMessage("Да прибудет свет!");
			server.dispatchCommand(server.getConsoleSender(),"time set 0");
		}
	}
	
	@EventHandler
	public void NotSpleeping(PlayerBedLeaveEvent e) 
	{
		if(PlayerSpleepCount == 0) return;
		PlayerSpleepCount--;
	}
	
	
}
