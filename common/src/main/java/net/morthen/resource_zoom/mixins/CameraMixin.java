package net.morthen.resource_zoom.mixins;

import net.minecraft.client.Camera;
import net.morthen.resource_zoom.ZoomConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Inject(at = @At("RETURN"), method = "calculateFov(F)F", cancellable = true)
    public void zoom$calculateFov(float partialTicks, CallbackInfoReturnable<Float> cir) {
        if (ZoomConstants.ZOOM.isDown()) {
            float fov = ZoomConstants.changeFov(partialTicks);
            cir.setReturnValue(fov);
        }
    }

    @Inject(at = @At("RETURN"), method = "calculateHudFov(F)F", cancellable = true)
    public void zoom$calculateHudFov(float partialTicks, CallbackInfoReturnable<Float> cir) {
        if (ZoomConstants.ZOOM.isDown()) {
            float fov = ZoomConstants.changeFov(partialTicks);
            cir.setReturnValue(fov);
        }
    }
}
