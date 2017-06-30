package stevekung.mods.moreplanets.integration.jei.rockett5;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import micdoodle8.mods.galacticraft.api.recipe.INasaWorkbenchRecipe;
import net.minecraft.item.ItemStack;

public class Tier5RocketRecipeWrapper extends BlankRecipeWrapper implements ICraftingRecipeWrapper
{
    private INasaWorkbenchRecipe recipe;

    public Tier5RocketRecipeWrapper(INasaWorkbenchRecipe recipe)
    {
        this.recipe = recipe;
    }

    @Override
    public List getInputs()
    {
        List<ItemStack> list = Lists.newArrayList();
        list.addAll(this.recipe.getRecipeInput().values());
        return list;
    }

    @Override
    public List<ItemStack> getOutputs()
    {
        return Collections.singletonList(this.recipe.getRecipeOutput());
    }

    @Override
    public void getIngredients(IIngredients ingredients) {}
}