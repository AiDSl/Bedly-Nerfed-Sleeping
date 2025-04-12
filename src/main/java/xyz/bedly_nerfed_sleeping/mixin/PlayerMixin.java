package xyz.bedly_nerfed_sleeping.mixin;


import xyz.bedly_nerfed_sleeping.bedly_nerfed_sleeping;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Player.class)
public abstract class PlayerMixin {
	
    @Inject( method="drop(Lnet/minecraft/world/item/ItemStack;ZZ)Lnet/minecraft/world/entity/item/ItemEntity;",at=@At("HEAD"),cancellable=true)
    private void dropping(ItemStack s,boolean isThrowRandomly,boolean isRetainOwnerShip,CallbackInfoReturnable<ItemEntity> cir)
	{
		Player player=(Player)(Object)this;
		bedly_nerfed_sleeping.LOGGER.info(player.getName().getString());
		bedly_nerfed_sleeping.LOGGER.info("A");
    }

}