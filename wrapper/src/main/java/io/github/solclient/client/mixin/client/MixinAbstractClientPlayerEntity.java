package io.github.solclient.client.mixin.client;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.authlib.GameProfile;

import io.github.solclient.client.mod.impl.cosmetica.CosmeticaMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class MixinAbstractClientPlayerEntity extends PlayerEntity {

	public MixinAbstractClientPlayerEntity(World world, GameProfile profile) {
		super(world, profile);
	}

	@Inject(method = "getCapeId", at = @At("HEAD"), cancellable = true)
	public void overrideCapeLocation(CallbackInfoReturnable<Identifier> callback) {
		if (!CosmeticaMod.enabled)
			return;

		CosmeticaMod.instance.getCapeTexture(this).ifPresent(callback::setReturnValue);
	}

}
