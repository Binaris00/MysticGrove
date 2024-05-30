package binaris.mystic_grove;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysticGrove implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("mystic_grove");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		LOGGER.info("This mod was made to be just a test for Premier Studios!");
		LOGGER.info("I hope you enjoy it!");
	}
}