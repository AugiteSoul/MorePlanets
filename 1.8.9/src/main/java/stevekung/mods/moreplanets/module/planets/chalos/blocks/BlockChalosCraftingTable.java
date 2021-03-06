package stevekung.mods.moreplanets.module.planets.chalos.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.util.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.util.blocks.EnumSortCategoryBlock;
import stevekung.mods.moreplanets.util.inventory.ContainerWorkbenchMP;

public class BlockChalosCraftingTable extends BlockBaseMP
{
    protected BlockChalosCraftingTable(String name)
    {
        super(Material.wood);
        this.setHardness(2.5F);
        this.setStepSound(soundTypeWood);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            player.displayGui(new InterfaceCraftingTable(world, pos));
            return true;
        }
        return true;
    }

    @Override
    public EnumSortCategoryBlock getBlockCategory(int meta)
    {
        return EnumSortCategoryBlock.DECORATION_BLOCK;
    }

    @Override
    public String getName()
    {
        return "chalos_crafting_table";
    }

    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private World world;
        private BlockPos position;

        public InterfaceCraftingTable(World world, BlockPos pos)
        {
            this.world = world;
            this.position = pos;
        }

        @Override
        public String getName()
        {
            return null;
        }

        @Override
        public boolean hasCustomName()
        {
            return false;
        }

        @Override
        public IChatComponent getDisplayName()
        {
            return new ChatComponentTranslation(ChalosBlocks.CHALOS_CRAFTING_TABLE.getUnlocalizedName() + ".name", new Object[0]);
        }

        @Override
        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer player)
        {
            return new ContainerWorkbenchMP(playerInventory, this.world, this.position, ChalosBlocks.CHALOS_CRAFTING_TABLE);
        }

        @Override
        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }
}