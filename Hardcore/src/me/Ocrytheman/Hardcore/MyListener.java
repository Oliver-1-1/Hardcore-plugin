package me.Ocrytheman.Hardcore;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.block.Block;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class MyListener implements Listener {
	  
	public List<Block> blocks = new ArrayList<Block>();
	public List<Block> blocksBreak = new ArrayList<Block>();
	public List<Material> mat = new ArrayList<Material>();
	char [] a = new char[5];
	public MyListener(Main plugin)
	{
		
	}
	
	@EventHandler
	public void blockplace(BlockPlaceEvent event) throws IOException{
		File placeFile = new File(event.getPlayer().getDisplayName() + ".PlaceFile.txt");
		
		File materialFile = new File(event.getPlayer().getDisplayName() + ".MaterialFile.txt");
		if(placeFile.exists())
		{
		
		blocks.add(event.getBlock());

	    }
		
			FileWriter writer = new FileWriter(placeFile, true); 
			
			FileWriter writerc = new FileWriter(materialFile, true);
			
			for(int i = 0; i < blocks.size(); i++)
			{
					
					Block block = blocks.get(i);
					writer.write(block.getLocation() + "\n");
					blocks.remove(block);
					i = 0;
			}
			for(int j = 0; j < blocksBreak.size(); j++)
			{
				
				
				//writerc.write(mat.get(j) + System.lineSeparator());
				//loc.getBlock().setType(blocksBreak.get(j).getBlockData().getMaterial());
				
			}
			
			blocks.clear();
			mat.clear();
			writer.close();
			writerc.close();
			

		
		}
		
		
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) throws IOException
	{
		File breakFile = new File(event.getPlayer().getDisplayName() + ".BreakFile.txt");
		if(breakFile.exists())
		{
		blocksBreak.add(event.getBlock());
		}
		mat.add(event.getBlock().getType());
		FileWriter writerb = new FileWriter(breakFile, true);
		for(int j = 0; j < blocksBreak.size(); j++)
		{
			Block blockss = blocksBreak.get(j);
			Material localmat = mat.get(j);
			writerb.write(blockss.getLocation() + ","+ mat.get(j ) + System.lineSeparator());
			blocksBreak.remove(blockss);
			mat.remove(localmat);
			j = 0;
		}
		writerb.close();
		blocksBreak.clear();
		}
	
	}




