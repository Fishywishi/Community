package dev.pgm.community.moderation.tools;

import dev.pgm.community.moderation.ModerationConfig;
import dev.pgm.community.moderation.tools.types.LookupSign;
import dev.pgm.community.moderation.tools.types.ModerationMenuTool;
import org.bukkit.entity.Player;
import tc.oc.pgm.api.player.event.ObserverInteractEvent;

public class ModerationTools {

  private final ModerationMenuTool menu;
  private final LookupSign sign;

  public ModerationTools(ModerationConfig config) {
    // TODO: allow reloads to enable/disable tools
    this.menu = new ModerationMenuTool(config.getModMenuSlot(), config.isModMenuEnabled());
    this.sign = new LookupSign(config.getLookupSignSlot(), config.isLookupSignEnabled());
  }

  public ModerationMenuTool getMenu() {
    return menu;
  }

  public LookupSign getLookupSign() {
    return sign;
  }

  public void onInteract(ObserverInteractEvent event) {
    menu.onInteract(event);
    sign.onInteract(event);
  }

  public void giveTools(Player player) {
    getMenu().give(player);
    getLookupSign().give(player);
  }
}
