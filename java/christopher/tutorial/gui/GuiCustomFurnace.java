package christopher.tutorial.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import christopher.tutorial.Reference;
import christopher.tutorial.container.ContainerCustomFurnace;
import christopher.tutorial.tileentity.TileEntityCustomFurnace;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCustomFurnace extends GuiContainer
{
	private static final ResourceLocation background = new ResourceLocation(Reference.MODID + ":textures/gui/furnace_gui.png");
	private final InventoryPlayer playerInv;
	public TileEntityCustomFurnace tileFurnace;
	private Object TileEntityCustomFurnace;
	
	public GuiCustomFurnace(InventoryPlayer playerInventory, TileEntityCustomFurnace furnaceInventory) 
	{
		super(new ContainerCustomFurnace(playerInventory, furnaceInventory));
		playerInv = playerInventory;
		TileEntityCustomFurnace = furnaceInventory;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
	protected void drawGuiContainerBackgroundLayer(int mouseX, int mouseY) 
	{
		String name = ((TileEntityLockable) TileEntityCustomFurnace).getDisplayName().getUnformattedText();
		fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 117, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        
        if(((christopher.tutorial.tileentity.TileEntityCustomFurnace) TileEntityCustomFurnace).isBurning())
        {
        	int k = this.getBurnLeftScaled(42);
        	int m = 40 - k;
        	drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - m, 10);
        }
        
        int l = this.getCookProgressScaled(24);
        drawTexturedModalRect(i + 79, j + 38, 176, 14, l + 1, 17);
    }
    
    private int getCookProgressScaled(int pixels)
    {
        int i = ((TileEntityCustomFurnace) this.TileEntityCustomFurnace).getField(2);
        int j = ((TileEntityCustomFurnace) this.TileEntityCustomFurnace).getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = ((TileEntityCustomFurnace) this.TileEntityCustomFurnace).getField(1);

        if (i == 0)
        {
            i = 200;
        }

        return ((TileEntityCustomFurnace) this.TileEntityCustomFurnace).getField(0) * pixels / i;
    }
}
