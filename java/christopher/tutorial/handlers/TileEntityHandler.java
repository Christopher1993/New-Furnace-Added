package christopher.tutorial.handlers;

import christopher.tutorial.tileentity.TileEntityCustomFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
		public static void register()
		{
			GameRegistry.registerTileEntity(TileEntityCustomFurnace.class, "custom_furnace_idle");
		}
}
