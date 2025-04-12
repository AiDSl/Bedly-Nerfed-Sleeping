package com.example.examplemod.mixin;




import xyz.bedly_nerfed_sleeping.bedly_nerfed_sleeping;
import net.minecraft.world.phys.Vec3;

//mixin org
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//mixins
import net.minecraft.server.level.ServerPlayer;
	//startSleepInBed
	import net.minecraft.core.BlockPos;
	import com.mojang.datafixers.util.Either;

	//getEntitiesOfClass
	import net.minecraft.world.level.EntityGetter;
	import java.lang.Class;
	import net.minecraft.world.phys.AABB;
	import java.util.function.Predicate;
	import java.util.List;
		






@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
	
    @ModifyArg(
		method="startSleepInBed(Lnet/minecraft/core/BlockPos;)Lcom/mojang/datafixers/util/Either;",
		at=@At(value="INVOKE",target="Lnet/minecraft/world/level/EntityGetter;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"),
		index = 1
	)
    private AABB bigger_monster_range(AABB old_range)
	{
		Vec3 bottom_center=old_range.getCenter();
		double r=0;//range

		bedly_nerfed_sleeping.LOGGER.info("("+bottom_center.x+","+bottom_center.y+","+bottom_center.z+")");

		return new AABB(
			bottom_center.x()-r, bottom_center.y()-r, bottom_center.z()-r,
			bottom_center.x()+r, bottom_center.y()+r, bottom_center.z()+r
		);
    }

}