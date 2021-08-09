
package fr.blocbloctheblocdev.stickcraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import fr.blocbloctheblocdev.stickcraft.item.FireStickItem;
import fr.blocbloctheblocdev.stickcraft.StickcraftModElements;

@StickcraftModElements.ModElement.Tag
public class StickCraftItemGroup extends StickcraftModElements.ModElement {
	public StickCraftItemGroup(StickcraftModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabstick_craft") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FireStickItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
