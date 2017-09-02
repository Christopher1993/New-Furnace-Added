package christopher.tutorial.handlers;

import christopher.tutorial.Reference;
import christopher.tutorial.Tutorial;
import christopher.tutorial.container.ContainerCustomFurnace;
import christopher.tutorial.gui.GuiCustomFurnace;
import christopher.tutorial.tileentity.TileEntityCustomFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler
{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(new BlockPos(x,y,z));
		
		if(entity != null)
		{
			switch(ID)
			{
			case Reference.GUI_CUSTOMFURNACE:
				if(entity instanceof TileEntityCustomFurnace) 
				{
					return new ContainerCustomFurnace(player.inventory, (TileEntityCustomFurnace)entity);
				}
			}
		}
		
		return null;
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(new BlockPos(x,y,z));
		
		if(entity != null)
		{
			switch(ID)
			{
			case Reference.GUI_CUSTOMFURNACE:
				if(entity instanceof TileEntityCustomFurnace) 
				{
					return new GuiCustomFurnace(player.inventory, (TileEntityCustomFurnace)entity);
				}
				
				return null;
			}
		}
		
		return null;
	}
	
	public static void register()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Tutorial.INSTANCE, new GUIHandler());
	}	
}
