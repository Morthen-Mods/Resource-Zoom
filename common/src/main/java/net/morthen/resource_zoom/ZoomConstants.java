package net.morthen.resource_zoom;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZoomConstants {
    public static final String MOD_ID = "resource_zoom";
    public static final String MOD_NAME = "Resource Zoom";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final KeyMapping.Category CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(MOD_ID, "category"));
    public static final KeyMapping ZOOM = new KeyMapping("key.zoom", GLFW.GLFW_KEY_Z, CATEGORY);

    private static final Minecraft client = Minecraft.getInstance();

    private static final Double defaultZoom = 3.0;
    private static Double currentLevel = defaultZoom;
    private static Double defaultSens;

    public static float changeFov(float fov) {
        OptionInstance<Double> mouseSens = client.options.sensitivity();

        if (!ZOOM.isDown()) {
            if (defaultSens != null) {
                mouseSens.set(defaultSens);
                defaultSens = null;
            }

            return fov;
        }

        if (defaultSens == null) {
            defaultSens = mouseSens.get();
        }

        double fovSense = (defaultSens * (1.0 / currentLevel));
        mouseSens.set(fovSense);

        return (float) (fov / currentLevel);
    }

    public static void onMouseScroll(double amount) {
        if (!ZOOM.isDown()) return;

        if (currentLevel == null) currentLevel = defaultZoom;

        if (amount > 0) currentLevel *= 1.1;
        else if (amount < 0) currentLevel *= 0.9;

        currentLevel = Mth.clamp(currentLevel, 1, 50);
    }
}
