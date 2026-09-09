package net.morthen.resource_zoom;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ZoomConstants.MOD_ID)
public class ZoomClient {
    public ZoomClient() {
        RegisterKeyMappingsEvent.BUS.addListener(this::registerKeybinds);
    }

    private void registerKeybinds(RegisterKeyMappingsEvent event) {
        event.register(ZoomConstants.ZOOM);
    }
}
