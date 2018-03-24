package MainPackage;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class Handler implements Listener 
{	
	public double PlayerSpleepCount = 0;
	
	public Handler() 
	{
	}
	
	
	@EventHandler
	public void Sleeping(PlayerBedEnterEvent e) 
	{
		Player player = e.getPlayer();
		Server server = player.getServer();
		int coutPlayers = server.getOnlinePlayers().size();
		
		PlayerSpleepCount+=1;
		double percent = (PlayerSpleepCount / coutPlayers) * 100;
		
		player.sendMessage("������ ����: " + (int)PlayerSpleepCount + " "+ "��" + " "+ coutPlayers);
		if(percent >= 50) 
		{
			player.sendMessage("�� �������� ����!");
			server.dispatchCommand(server.getConsoleSender(),"time set 0");
		}
	}
	
	@EventHandler
	public void NotSpleeping(PlayerBedLeaveEvent e) 
	{
		if(PlayerSpleepCount == 0) return;
		PlayerSpleepCount-=1;
	}
	
	
}
