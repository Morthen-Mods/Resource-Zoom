package net.morthen.resource_zoom.mixins;

import net.minecraft.world.entity.player.Inventory;
import net.morthen.resource_zoom.ZoomConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Inventory.class)
public class InventoryMixin {
    @Inject(at = @At("HEAD"), method = "setSelectedSlot(I)V", cancellable = true)
    public void zoom$setSelectedSlot(int selected, CallbackInfo ci) {
        if (ZoomConstants.ZOOM.isDown()) ci.cancel();
    }
}
