package File;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class manageFile {
	public void write(Location[] loc) throws IOException {
		DataOutputStream writer = new DataOutputStream(new FileOutputStream("./plugins/game/data.ump45"));
		writer.writeInt(loc.length);
		for(int i =0; i<loc.length; i++) {
			writer.writeDouble(loc[i].getX());
			writer.writeDouble(loc[i].getY());
			writer.writeDouble(loc[i].getZ());
			writer.writeChars(loc[i].getWorld().getName());
		}
	}
	
	public Location[] read() throws IOException{
		DataInputStream reader = new DataInputStream(new FileInputStream("./plugins/game/data.ump45"));
		int length = reader.readInt();
		Location array[] = new Location[length];
		for(int i = 0; i<length; i++) {
			array[i].setX(reader.readDouble());
			array[i].setY(reader.readDouble());
			array[i].setZ(reader.readDouble());
			array[i].setWorld(Bukkit.getWorld(reader.readLine()));
		}
		return array;
	}
}
