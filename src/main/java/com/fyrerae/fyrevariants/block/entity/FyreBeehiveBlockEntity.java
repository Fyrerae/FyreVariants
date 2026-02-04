package com.fyrerae.fyrevariants.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FyreBeehiveBlockEntity extends BeehiveBlockEntity {
    public FyreBeehiveBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FyreBlockEntities.BEEHIVE.get();
    }
}
