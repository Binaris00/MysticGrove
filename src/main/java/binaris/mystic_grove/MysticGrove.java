package binaris.mystic_grove;

import binaris.mystic_grove.world.biome.MysticGroveRegion;
import binaris.mystic_grove.world.biome.MysticGroveRules;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class MysticGrove implements ModInitializer {
	public static final String MODID = "mystic_grove";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	/**
	 * This is a boolean that is true if the mod is in development environment.
	 * Used only for debug purposes.
	 */
	public static final boolean isDev = FabricLoader.getInstance().isDevelopmentEnvironment();

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		LOGGER.info("This mod was made to be just a test for Premier Studios!");
		LOGGER.info("I hope you enjoy it!");
	}

	/**
	 * Logs a message with the [DEBUG] prefix if the mod is in the development environment.
	 * @param message The message to be logged.
	 */
	public static void debug(String message) {
		if (isDev) {
			LOGGER.warn("[DEBUG] ");
			LOGGER.info(message + "\n");
		}
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}

}