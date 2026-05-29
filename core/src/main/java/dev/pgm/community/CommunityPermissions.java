package dev.pgm.community;

public interface CommunityPermissions {

  // TODO: Copy PGM format and style, register groups of permission nodes like moderator/admin/dev
  // etc

  // Root permission node
  String ROOT = "uranus";

  // Admin - Reserved for restricted features
  String ADMIN = ROOT + ".admin";

  // Staff
  String RELOAD = ROOT + ".reload";
  String RESTRICTED = ROOT + ".restricted"; // Access to restricted info (e.g IP addresses)

  // Nicknames
  String NICKNAME = ROOT + ".nick"; // Access to /nick (random)
  String NICKNAME_SET = NICKNAME + ".set"; // Access to /nick set
  String NICKNAME_OTHER = NICKNAME_SET + ".other"; // Access to /nick setother
  String NICKNAME_CLEAR = NICKNAME_SET + ".clear"; // Access to /nick clear <username>
  String NICKNAME_VIEW = NICKNAME + ".view-skins"; // Access to view normal skins

  // General Staff
  String STAFF =
      ROOT + ".staff"; // Receive staff broadcasts and see disguised players (maybe add a different
  // node later)

  // Match History
  String MATCH_HISTORY = ROOT + ".match-history";

  // Mutations
  String MUTATION = ROOT + ".mutation"; // Access to /mutate

  // Requests
  String REQUEST = ROOT + ".request"; // Access to /request
  String REQUEST_SPONSOR = REQUEST + ".sponsor"; // Access to /sponsor
  String REQUEST_STAFF = REQUEST + ".staff"; // Access to /requests
  String REQUEST_REFUND = REQUEST + ".refund"; // Receive token refunds when applicable

  String TOKEN = ROOT + ".token"; // Access to view /token
  String TOKEN_DAILY = TOKEN + ".daily"; // Receives token refresh daily
  String TOKEN_WEEKLY = TOKEN + ".weekly"; // Receives token refresh weekly
  String TOKEN_BALANCE = TOKEN + ".view-others"; // Access to view other token balances

  String SPONSOR_COOLDOWN_CUSTOM = "sponsor.cooldown.";

  String VIEW_MAP_COOLDOWNS = ROOT + ".view-map-cooldown";

  // Super Votes
  String SUPER_VOTE = REQUEST + ".super-vote";
  String SUPER_VOTE_BALANCE = SUPER_VOTE + ".balance";

  // Translations
  String TRANSLATE = ROOT + ".translate"; // Access to /translate

  // Polls
  String POLL = ROOT + ".poll";

  // General Commands
  String FLIGHT = ROOT + ".fly";
  String FLIGHT_SPEED = FLIGHT + ".speed";
  String GAMEMODE = ROOT + ".gamemode";
  String BROADCAST = ROOT + ".broadcast";
  String CONTAINER = ROOT + ".container";
  String MOB_SPAWN = ROOT + ".mob-spawn";

  // Player Selectors
  String SELECTOR = ROOT + ".selector"; // Allow access to targeting more than 1 player
  String ALL_SELECTOR = SELECTOR + ".all"; // * - select everyone
  String RANDOM_SELECTOR = SELECTOR + ".random"; // ? - select a random player
  String TEAM_SELECTOR = SELECTOR + ".team"; // team='Name' - select a match's team

  String VIEW_VANISHED = ROOT + ".vanish.view";

  String OVERRIDE = "pgm.admin"; // Access to override
  // TODO Setup different groups like moderation

}
