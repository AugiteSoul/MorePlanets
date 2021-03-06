package stevekung.mods.moreplanets.module.planets.nibiru.blocks;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.module.planets.nibiru.tileentity.TileEntityNibiruAncientChest;
import stevekung.mods.moreplanets.util.blocks.BlockAncientChestMP;

public class BlockNibiruAncientChest extends BlockAncientChestMP
{
    public BlockNibiruAncientChest(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        super.onNeighborBlockChange(world, pos, state, neighborBlock);
        TileEntity tileentity = world.getTileEntity(pos);

        if (tileentity instanceof TileEntityNibiruAncientChest)
        {
            tileentity.updateContainingBlockInfo();
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            ILockableContainer lock = this.getLockableContainer(world, pos);

            if (lock != null)
            {
                player.displayGUIChest(lock);
            }
        }
        return true;
    }

    public ILockableContainer getLockableContainer(World world, BlockPos pos)
    {
        TileEntity tileentity = world.getTileEntity(pos);

        if (!(tileentity instanceof TileEntityNibiruAncientChest))
        {
            return null;
        }
        else
        {
            Object object = tileentity;

            if (this.isBlocked(world, pos))
            {
                return null;
            }
            else
            {
                Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

                while (iterator.hasNext())
                {
                    EnumFacing enumfacing = (EnumFacing)iterator.next();
                    BlockPos blockpos1 = pos.offset(enumfacing);
                    Block block = world.getBlockState(blockpos1).getBlock();

                    if (block == this)
                    {
                        if (this.isBlocked(world, blockpos1))
                        {
                            return null;
                        }

                        TileEntity tileentity1 = world.getTileEntity(blockpos1);

                        if (tileentity1 instanceof TileEntityNibiruAncientChest)
                        {
                            if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
                            {
                                object = new InventoryLargeChest(StatCollector.translateToLocal("container.nibiru.ancientchest.name"), (ILockableContainer)object, (TileEntityNibiruAncientChest)tileentity1);
                            }
                            else
                            {
                                object = new InventoryLargeChest(StatCollector.translateToLocal("container.nibiru.ancientchest.name"), (TileEntityNibiruAncientChest)tileentity1, (ILockableContainer)object);
                            }
                        }
                    }
                }
                return (ILockableContainer)object;
            }
        }
    }

    @Override
    public TileEntity getChestTile()
    {
        return new TileEntityNibiruAncientChest();
    }

    @Override
    public int getComparatorInputOverride(World world, BlockPos pos)
    {
        return Container.calcRedstoneFromInventory(this.getLockableContainer(world, pos));
    }

    @Override
    public String getName()
    {
        return "nibiru_ancient_chest";
    }
}