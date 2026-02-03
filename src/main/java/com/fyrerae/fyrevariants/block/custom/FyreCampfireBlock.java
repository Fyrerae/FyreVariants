package com.fyrerae.fyrevariants.block.custom;

import com.fyrerae.fyrevariants.block.entity.FyreBlockEntities;
import com.fyrerae.fyrevariants.block.entity.FyreCampfireBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FyreCampfireBlock extends CampfireBlock {
    public FyreCampfireBlock(boolean spawnParticles, int fireDamage, Properties properties) {
        super(spawnParticles, fireDamage, properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FyreCampfireBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, FyreBlockEntities.CAMPFIRE.get(), CampfireBlockEntity::particleTick) : null;
        } else {
            return state.getValue(LIT) ? createTickerHelper(blockEntityType, FyreBlockEntities.CAMPFIRE.get(), CampfireBlockEntity::cookTick) : createTickerHelper(blockEntityType, FyreBlockEntities.CAMPFIRE.get(), CampfireBlockEntity::cooldownTick);
        }
    }
}