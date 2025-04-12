/*package com.example.examplemod.mixin;

import xyz.bedly_nerfed_sleeping.bedly_nerfed_sleeping;


import net.minecraft.world.phys.AABB;
//mixins
import net.minecraft.server.level.ServerPlayer;
	//startSleepInBed
	import net.minecraft.core.BlockPos;
	import com.mojang.datafixers.util.Either;

	//getEntitiesOfClass
	import java.lang.Class;
	//import net.minecraft.world.phys.AABB;
	import java.util.function.Predicate;
	import java.util.List;




import org.slf4j.Logger;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
	
    @ModifyArg( method="startSleepInBed(Lnet/minecraft/core/BlockPos)Lcom/mojang/datafixers/util/Either;", at = @At(value = "INVOKE", target = "getEntitiesOfClass(Ljava/lang/Class,Lnet/minecraft/world/phys/AABB,Ljava/util/function/Predicate)Ljava/util/List"), index = 1)
    private AABB bigger_monster_range(AABB old_range)
	{
		Vec3 bottom_center=old_range.getCenter();

		return new AABB(
			bottom_center.x()-64, bottom_center.y()-64, bottom_center.z()-64,
			bottom_center.x()+64, bottom_center.y()+64, bottom_center.z()+64
		);
    }

}*/