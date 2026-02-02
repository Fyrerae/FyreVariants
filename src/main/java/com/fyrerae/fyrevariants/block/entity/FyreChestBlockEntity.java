package com.fyrerae.fyrevariants.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FyreChestBlockEntity extends ChestBlockEntity {
    public FyreChestBlockEntity(BlockPos pos, BlockState state) {
        super(FyreBlockEntities.CHEST.get(), pos, state);
    }
}