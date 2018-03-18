package MainPackage;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Sleep extends JavaPlugin {

	Logger _log=Logger.getLogger("Minecraft");
	
	public void onEnable() 
	{
		Bukkit.getPluginManager().registerEvents(new Handler(), this);
		_log.info("Sleep plugin enable");
	}
	
	public void onDisable() 
	{
		_log.info("Sleep plugin disable");
	}
}
