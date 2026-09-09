package net.morthen.resource_zoom.mixins;

import net.minecraft.client.MouseHandler;
import net.morthen.resource_zoom.ZoomConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseMixin {
    @Inject(at = @At("RETURN"), method = "onScroll(JDD)V")
    private void zoom$onMouseScroll(long handle, double xOffset, double yOffset, CallbackInfo ci) {
        ZoomConstants.onMouseScroll(yOffset);
    }
}
