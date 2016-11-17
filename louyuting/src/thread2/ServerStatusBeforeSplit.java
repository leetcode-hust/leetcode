package thread2;

import java.util.*;


/**
 * ServerStatusBeforeSplit
 * <p/>
 * Candidate for lock splitting
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ServerStatusBeforeSplit {
   public final Set<String> users;
    public final Set<String> queries;

    public ServerStatusBeforeSplit() {
        users = new HashSet<String>();
        queries = new HashSet<String>();
    }

    public synchronized void addUser(String u) {
        users.add(u);
    }

    public synchronized void addQuery(String q) {
        queries.add(q);
    }

    public synchronized void removeUser(String u) {
        users.remove(u);
    }

    public synchronized void removeQuery(String q) {
        queries.remove(q);
    }
}
