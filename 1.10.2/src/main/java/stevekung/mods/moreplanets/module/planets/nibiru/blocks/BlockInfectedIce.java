package stevekung.mods.moreplanets.module.planets.nibiru.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import stevekung.mods.moreplanets.util.blocks.BlockIceMP;
import stevekung.mods.moreplanets.util.helper.ColorHelper;

public class BlockInfectedIce extends BlockIceMP
{
    public BlockInfectedIce(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    @Nullable
    public float[] getBeaconColorMultiplier(IBlockState state, World world, BlockPos pos, BlockPos beaconPos)
    {
        return ColorHelper.rgbToFloatArray(138, 57, 36);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile, ItemStack heldStack)
    {
        player.addExhaustion(0.025F);

        if (this.canSilkHarvest(world, pos, world.getBlockState(pos), player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldStack) > 0)
        {
            List<ItemStack> items = new ArrayList<>();
            ItemStack itemstack = this.createStackedBlock(state);

            if (itemstack != null)
            {
                items.add(itemstack);
            }

            ForgeEventFactory.fireBlockHarvesting(items, world, pos, world.getBlockState(pos), 0, 1.0f, true, player);

            for (ItemStack is : items)
            {
                Block.spawnAsEntity(world, pos, is);
            }
        }
        else
        {
            if (world.provider.doesWaterVaporize())
            {
                world.setBlockToAir(pos);
                return;
            }

            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, heldStack);
            this.harvesters.set(player);
            this.dropBlockAsItem(world, pos, state, i);
            this.harvesters.set(null);
            Material material = world.getBlockState(pos.down()).getMaterial();

            if (material.blocksMovement() || material.isLiquid())
            {
                world.setBlockState(pos, NibiruBlocks.INFECTED_WATER_FLUID_BLOCK.getDefaultState());
            }
        }
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (world.getLightFor(EnumSkyBlock.BLOCK, pos) > 11 - state.getLightOpacity(world, pos))
        {
            if (world.provider.doesWaterVaporize())
            {
                world.setBlockToAir(pos);
            }
            else
            {
                this.dropBlockAsItem(world, pos, world.getBlockState(pos), 0);
                world.setBlockState(pos, NibiruBlocks.INFECTED_WATER_FLUID_BLOCK.getDefaultState());
            }
        }
    }

    @Override
    public String getName()
    {
        return "infected_ice";
    }
}