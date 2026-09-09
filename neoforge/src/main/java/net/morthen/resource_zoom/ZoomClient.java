package net.morthen.resource_zoom;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod(ZoomConstants.MOD_ID)
public class ZoomClient {
    public ZoomClient(IEventBus eventBus) {
        eventBus.addListener(this::registerKeybinds);
    }

    private void registerKeybinds(RegisterKeyMappingsEvent event) {
        event.register(ZoomConstants.ZOOM);
    }
}
