package io.github.solclient.client.mod.impl.hud.ping;

import io.github.solclient.client.DetectedServer;
import net.minecraft.client.resource.language.I18n;

public enum PingSource {
	AUTO, MULTIPLAYER_SCREEN, TAB_LIST;

	public PingSource resolve() {
		if (this != AUTO)
			return this;

		if (DetectedServer.current() == DetectedServer.HYPIXEL)
			return MULTIPLAYER_SCREEN;

		return TAB_LIST;
	}

	@Override
	public String toString() {
		return I18n.translate("sol_client.mod.ping.option.source." + name().toLowerCase());
	}

}
