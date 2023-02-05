package dev.tr7zw.itemswapper.manager.shortcuts;

import dev.tr7zw.itemswapper.manager.itemgroups.Icon;
import dev.tr7zw.itemswapper.manager.itemgroups.Icon.ItemIcon;
import dev.tr7zw.itemswapper.manager.itemgroups.Shortcut;
import dev.tr7zw.itemswapper.overlay.SwitchItemOverlay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;

public class BackShortcut implements Shortcut {

    private final Icon icon = new ItemIcon(Items.HOPPER.getDefaultInstance(), Component.literal("Back"));
    private final SwitchItemOverlay overlay;

    public BackShortcut(SwitchItemOverlay overlay) {
        this.overlay = overlay;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public void invoke(ActionType action) {
        // remove the current page
        overlay.getPageHistory().remove(overlay.getPageHistory().size() - 1);
        overlay.openPage(overlay.getPageHistory().remove(overlay.getPageHistory().size() - 1));
    }

    @Override
    public boolean acceptClose() {
        return false;
    }

    @Override
    public boolean acceptClick() {
        return true;
    }

    @Override
    public boolean isVisible() {
        // one entry is the current page!
        return overlay.getPageHistory().size() > 1;
    }

}
