package me.Ocrytheman.Hardcore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Ocrytheman.Hardcore.Commands.HardcordeCommand;

public class Main extends JavaPlugin{

	public void onEnable()
	{
		System.out.println("Plugin started");
		
		PluginManager pm = getServer().getPluginManager();
		MyListener listeners = new MyListener(this);
		
		this.getCommand("hardcore").setExecutor((CommandExecutor) new HardcordeCommand());
		pm.registerEvents(listeners,this);
		
		
		
	}
	public void onDisable()
	{
		System.out.println("Plugin shutting down");

	}
	
}
