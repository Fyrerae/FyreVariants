package com.fyrerae.fyrevariants.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FyreCampfireBlockEntity extends CampfireBlockEntity {
    public FyreCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FyreBlockEntities.CAMPFIRE.get();
    }
}