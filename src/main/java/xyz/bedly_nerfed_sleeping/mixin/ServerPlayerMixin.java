package xyz.bedly_nerfed_sleeping.mixin;

import xyz.bedly_nerfed_sleeping.bedly_nerfed_sleeping;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Monster;
//mixin org
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
//mixins
import net.minecraft.server.level.ServerPlayer;
	//startSleepInBed
	import net.minecraft.core.BlockPos;
	import com.mojang.datafixers.util.Either;

	//getEntitiesOfClass
	import net.minecraft.world.level.Level;
	import java.lang.Class;
	import net.minecraft.world.phys.AABB;
	import java.util.function.Predicate;
	import java.util.List;
		
	//return
	import net.minecraft.world.entity.player.Player.BedSleepingProblem;
	import net.minecraft.util.Unit;




@Mixin(ServerPlayer.class)
public class ServerPlayerMixin{
	
	@ModifyArg(
		method="startSleepInBed(Lnet/minecraft/core/BlockPos;)Lcom/mojang/datafixers/util/Either;",
		at=@At(value="INVOKE",target="Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;")
	)
    private AABB bigger_monster_range(AABB old_range)
	{
		Vec3 bottom_center=old_range.getCenter();
		double r=32;
		return new AABB(
			bottom_center.x()-r, bottom_center.y()-r, bottom_center.z()-r,
			bottom_center.x()+r, bottom_center.y()+r, bottom_center.z()+r
		);
		
    };

	@ModifyVariable(
		method="startSleepInBed(Lnet/minecraft/core/BlockPos;)Lcom/mojang/datafixers/util/Either;",
		at=@At(value="STORE",target="Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;")
	)
    private List<Monster> glow_the_clowns(List<Monster> list)
	{
		for(Monster m:list)
		{m.addEffect(new MobEffectInstance(MobEffects.GLOWING,20*3));};
		
		return list;
    };


}