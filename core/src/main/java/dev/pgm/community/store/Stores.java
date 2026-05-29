package dev.pgm.community.store;

import dev.pgm.community.nick.store.NickStore;
import dev.pgm.community.requests.store.RequestStore;
import dev.pgm.community.sessions.store.SessionStore;
import dev.pgm.community.users.store.UserStore;

public interface Stores {

  UserStore users();

  SessionStore sessions();

  RequestStore requests();

  NickStore nicks();
}
