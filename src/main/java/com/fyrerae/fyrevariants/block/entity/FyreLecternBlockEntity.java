package com.fyrerae.fyrevariants.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FyreLecternBlockEntity extends LecternBlockEntity {
    public FyreLecternBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FyreBlockEntities.LECTERN.get();
    }
}
