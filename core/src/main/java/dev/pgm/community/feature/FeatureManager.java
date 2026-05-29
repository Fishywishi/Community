package dev.pgm.community.feature;

import dev.pgm.community.broadcast.BroadcastFeature;
import dev.pgm.community.history.MatchHistoryFeature;
import dev.pgm.community.info.InfoCommandsFeature;
import dev.pgm.community.mobs.MobFeature;
import dev.pgm.community.motd.MotdFeature;
import dev.pgm.community.mutations.feature.MutationFeature;
import dev.pgm.community.network.feature.NetworkFeature;
import dev.pgm.community.network.types.RedisNetworkFeature;
import dev.pgm.community.nick.feature.NickFeature;
import dev.pgm.community.nick.feature.types.NickFeatureCore;
import dev.pgm.community.polls.feature.PollFeature;
import dev.pgm.community.requests.feature.RequestFeature;
import dev.pgm.community.requests.feature.types.RequestFeatureCore;
import dev.pgm.community.sessions.feature.SessionFeature;
import dev.pgm.community.sessions.feature.types.SessionFeatureCore;
import dev.pgm.community.store.StoreFactory;
import dev.pgm.community.store.Stores;
import dev.pgm.community.users.feature.UsersFeature;
import dev.pgm.community.users.feature.types.UsersFeatureCore;
import fr.minuskube.inv.InventoryManager;
import java.util.logging.Logger;
import org.bukkit.configuration.Configuration;

/** Manages all {@link Feature}s of the plugin */
public class FeatureManager {

  private final UsersFeature users;
  private final NetworkFeature network;
  private final NickFeature nick;
  private final RequestFeature requests;
  private final SessionFeature sessions;

  private final InfoCommandsFeature infoCommands;
  private final MotdFeature motd;
  private final MutationFeature mutation;
  private final BroadcastFeature broadcast;
  private final MobFeature mob;
  private final PollFeature polls;
  private final MatchHistoryFeature history;

  public FeatureManager(Configuration config, Logger logger, InventoryManager inventory) {
    // Networking
    this.network = new RedisNetworkFeature(config, logger);
    Stores stores = StoreFactory.create(config, logger);

    // DB Features
    this.users = new UsersFeatureCore(config, logger, stores.users());
    this.sessions = new SessionFeatureCore(users, logger, stores.sessions());
    this.nick = new NickFeatureCore(config, logger, users, stores.nicks());
    this.requests = new RequestFeatureCore(config, logger, users, stores.requests());

    // TODO: 1. Support non-sql databases?
    // Ex. FileReportFeature, MongoReportFeature, RedisReportFeature...
    // Not a priority

    // Non-DB Features
    this.infoCommands = new InfoCommandsFeature(config, logger);
    this.motd = new MotdFeature(config, logger);
    this.mutation = new MutationFeature(config, logger, inventory);
    this.broadcast = new BroadcastFeature(config, logger);
    this.mob = new MobFeature(config, logger);
    this.polls = new PollFeature(config, logger);
    this.history = new MatchHistoryFeature(config, logger);
  }

  public UsersFeature getUsers() {
    return users;
  }

  public SessionFeature getSessions() {
    return sessions;
  }

  public InfoCommandsFeature getInfoCommands() {
    return infoCommands;
  }

  public MotdFeature getMotd() {
    return motd;
  }

  public MutationFeature getMutations() {
    return mutation;
  }

  public NickFeature getNick() {
    return nick;
  }

  public BroadcastFeature getBroadcast() {
    return broadcast;
  }

  public RequestFeature getRequests() {
    return requests;
  }

  public MobFeature getMobs() {
    return mob;
  }

  public PollFeature getPolls() {
    return polls;
  }

  public MatchHistoryFeature getHistory() {
    return history;
  }

  public void reloadConfig(Configuration config) {
    // Reload all config values here
    getUsers().getConfig().reload(config);
    getSessions().getConfig().reload(config);
    getInfoCommands().getConfig().reload(config);
    getMotd().getConfig().reload(config);
    getMutations().getConfig().reload(config);
    getBroadcast().getConfig().reload(config);
    getNick().getConfig().reload(config);
    getRequests().getConfig().reload(config);
    getMobs().getConfig().reload(config);
    getPolls().getConfig().reload(config);
    getHistory().getConfig().reload(config);

    // TODO: Look into maybe unregister commands for features that have been disabled
    // commands#unregisterCommand
    // Will need to check isEnabled
  }

  public void disable() {
    if (getUsers().isEnabled()) getUsers().disable();
    if (getSessions().isEnabled()) getSessions().disable();
    if (getInfoCommands().isEnabled()) getInfoCommands().disable();
    if (getMotd().isEnabled()) getMotd().disable();
    if (getMutations().isEnabled()) getMutations().disable();
    if (getBroadcast().isEnabled()) getBroadcast().disable();
    if (getNick().isEnabled()) getNick().disable();
    if (getRequests().isEnabled()) getRequests().disable();
    if (getMobs().isEnabled()) getMobs().disable();
    if (getPolls().isEnabled()) getPolls().disable();
    if (getHistory().isEnabled()) getHistory().disable();
  }
}
