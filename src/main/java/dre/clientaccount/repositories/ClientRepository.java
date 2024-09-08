package dre.clientaccount;

import java.util.List;

import ch.qos.logback.core.net.server.Client;

public class ClientRepository extends JpaRepository<Client,Long> {

    public List<Client> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
