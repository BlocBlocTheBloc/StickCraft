package fr.blocbloctheblocdev.stickcraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import fr.blocbloctheblocdev.stickcraft.StickcraftModElements;
import fr.blocbloctheblocdev.stickcraft.StickcraftMod;

@StickcraftModElements.ModElement.Tag
public class FireStickAttackProcedure extends StickcraftModElements.ModElement {
	public FireStickAttackProcedure(StickcraftModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StickcraftMod.LOGGER.warn("Failed to load dependency entity for procedure FireStickAttack!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				StickcraftMod.LOGGER.warn("Failed to load dependency itemstack for procedure FireStickAttack!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		entity.setFire((int) 5);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 20);
	}
}
