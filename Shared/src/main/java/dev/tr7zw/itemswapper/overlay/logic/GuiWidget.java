package dev.tr7zw.itemswapper.overlay.logic;

import java.util.List;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.GuiComponent;

public interface GuiWidget {

    public List<GuiSlot> getSlots();
    
    public int getX();
    
    public int getY();
    
    public int getMouseBoundsX();

    public int getMouseBoundsY();
    
    public void render(GuiComponent parent, PoseStack poseStack, int originX, int originY, boolean overwrideAvailable);
    
    public void renderSelectedSlotName(GuiSlot selected, int yOffset, boolean overwrideAvailable);
    
    /**
     * A click is done via the middle mouse key
     * 
     * @param slot
     */
    public void onClick(GuiSlot slot);
    
    /**
     * Close is called when letting go from the key/re-pressing it in toggle mode/left click
     * 
     * @param slot
     */
    public void onClose(GuiSlot slot);
    
    public default int titleYOffset() {
        return 0;
    }

    
}
