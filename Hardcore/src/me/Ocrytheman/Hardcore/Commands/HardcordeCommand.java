package me.Ocrytheman.Hardcore.Commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.Ocrytheman.Hardcore.MyListener;
public class HardcordeCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args) 
	{
		
		File file = new File(sender.getName() + ".PlaceFile.txt");
		File materialFile = new File(sender.getName() + ".MaterialFile.txt");
		File breakFile = new File(sender.getName() + ".BreakFile.txt");
		
		BufferedReader br = null;
		BufferedReader breakBuffer = null;
		BufferedReader materialBuffer = null;
		 
		try {
			br = new BufferedReader(new FileReader(file));
			breakBuffer = new BufferedReader(new FileReader(breakFile));
			materialBuffer = new BufferedReader(new FileReader(materialFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 String st;
		 String stB;
		 String stM;
		Player player = (Player) sender;
		
		if(sender instanceof Player)
		{
			player.getWorld().getBlockAt(new Location(player.getWorld(), -240, 63,50)).setType(Material.GRASS);
			
			 try {
					while ((st = br.readLine()) != null) 
					 {
						
						 String[] locString = st.split(",");
						 Location loc = new Location(Bukkit.getWorld(locString[0]),0,0,0);
						 loc.setX(Double.parseDouble(locString[1].substring(2, locString[1].length())));
					     loc.setY(Double.parseDouble(locString[2].substring(2, locString[2].length())));
					     loc.setZ(Double.parseDouble(locString[3].substring(2, locString[3].length())));
					     player.getWorld().getBlockAt(loc).setType(Material.AIR);
					}
				 while ((stB = breakBuffer.readLine()) != null)
					{
						String[] locString = stB.split(",");
						System.out.println(locString[6]);
						Location loc = new Location(Bukkit.getWorld(locString[0]),0,0,0);
						loc.setX(Double.parseDouble(locString[1].substring(2, locString[1].length())));
						loc.setY(Double.parseDouble(locString[2].substring(2, locString[2].length())));
						loc.setZ(Double.parseDouble(locString[3].substring(2, locString[3].length())));
						player.getWorld().getBlockAt(loc).setType(Material.getMaterial(locString[6]));
						
					}
				 
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	 	   
		}
		else
		{
			sender.sendMessage("This dosnt work");
		}
		return true;
	}
}
