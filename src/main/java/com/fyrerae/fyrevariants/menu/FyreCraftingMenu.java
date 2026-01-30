package com.fyrerae.fyrevariants.menu;

import com.fyrerae.fyrevariants.block.custom.FyreCraftingTableBlock;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;

public class FyreCraftingMenu extends CraftingMenu {
    private final ContainerLevelAccess access;

    public FyreCraftingMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(containerId, playerInventory, access);
        this.access = access;
    }

    @Override
    public boolean stillValid(net.minecraft.world.entity.player.Player player) {
        return this.access.evaluate((level, pos) -> level.getBlockState(pos).getBlock() instanceof FyreCraftingTableBlock
                && player.distanceToSqr((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D) <= 64.0D, true);
    }
}