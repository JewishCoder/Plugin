package MainPackage;

import java.util.ArrayList;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;

public class Handler implements Listener 
{	
	public int PlayerSpleepCount = 0;
	public int CountPlayers = 0;
	public ArrayList<Player> Plaeyrs;
	
	public Handler() 
	{
		Plaeyrs = new ArrayList<Player>();
	}
	
	@EventHandler
	public void Join(PlayerJoinEvent e) 
	{	
		Plaeyrs.add(e.getPlayer());
		CountPlayers = Plaeyrs.size();
	}
	
	@EventHandler
	public void Leave(PlayerKickEvent e) 
	{
		Player player = e.getPlayer();
		
		if(Plaeyrs.size() > 0) 
		{
			if(Plaeyrs.contains(player)) 
			{
				Plaeyrs.remove(player);
				CountPlayers--;
			}
		}
	}
	
	@EventHandler
	public void Sleeping(PlayerBedEnterEvent e) 
	{
		Player player = e.getPlayer();
		Server server = player.getServer();
		
		PlayerSpleepCount++;
		float percent = PlayerSpleepCount / CountPlayers * 100;
		player.sendMessage("Sleep " + PlayerSpleepCount + " "+ "from" + " "+ CountPlayers);
		if(percent > 50) 
		{
			player.sendMessage("Let there be light!");
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
