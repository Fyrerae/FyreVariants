package com.fyrerae.fyrevariants.block.custom;

import com.fyrerae.fyrevariants.block.entity.FyreBlockEntities;
import com.fyrerae.fyrevariants.block.entity.FyreChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FyreChestBlock extends ChestBlock {
    public FyreChestBlock(Properties properties) {
        super(properties, () -> FyreBlockEntities.CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FyreChestBlockEntity(pos, state);
    }
}