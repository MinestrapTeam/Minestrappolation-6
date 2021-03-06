package minestrapp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockColdSand extends FallingBlock {
    private final int dustColor;

    public BlockColdSand(int dustColorIn, Block.Properties properties) {
        super(properties);
        this.dustColor = dustColorIn;
    }

    @OnlyIn(Dist.CLIENT)
    public int getDustColor(BlockState state) {
        return this.dustColor;
    }
}
