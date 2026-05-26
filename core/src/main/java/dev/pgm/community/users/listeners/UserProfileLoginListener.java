package dev.pgm.community.users.listeners;

import dev.pgm.community.events.UserProfileLoadEvent;
import dev.pgm.community.users.UsersConfig;
import dev.pgm.community.users.feature.UsersFeature;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UserProfileLoginListener implements Listener {

  private final UsersFeature users;

  public UserProfileLoginListener(UsersFeature users) {
    this.users = users;
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onLoginEvent(final PlayerJoinEvent event) {
    users.onLogin(event);
  }

  @EventHandler
  public void onPostLoginEvent(UserProfileLoadEvent event) {
    UsersConfig config = (UsersConfig) users.getConfig();
    Player player = Bukkit.getPlayer(event.getUser().getId());
    if (player == null) return;
  }
}
