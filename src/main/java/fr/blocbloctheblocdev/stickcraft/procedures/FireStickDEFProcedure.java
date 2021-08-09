package fr.blocbloctheblocdev.stickcraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import fr.blocbloctheblocdev.stickcraft.StickcraftModElements;
import fr.blocbloctheblocdev.stickcraft.StickcraftMod;

@StickcraftModElements.ModElement.Tag
public class FireStickDEFProcedure extends StickcraftModElements.ModElement {
	public FireStickDEFProcedure(StickcraftModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				StickcraftMod.LOGGER.warn("Failed to load dependency entity for procedure FireStickDEF!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				StickcraftMod.LOGGER.warn("Failed to load dependency itemstack for procedure FireStickDEF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 200, (int) 1));
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 20);
	}
}
