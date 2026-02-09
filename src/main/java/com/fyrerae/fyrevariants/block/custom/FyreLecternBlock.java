package com.fyrerae.fyrevariants.block.custom;

import com.fyrerae.fyrevariants.block.entity.FyreLecternBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FyreLecternBlock extends LecternBlock {
    public FyreLecternBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FyreLecternBlockEntity(pos, state);
    }
}