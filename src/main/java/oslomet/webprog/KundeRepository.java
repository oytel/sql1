package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KundeRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreKunde(Kunde kunde) {
        String sql = "insert into kunde (navn, adresse) values(?,?)";
        db.update(sql, kunde.getNavn(), kunde.getAdresse());
    }

    public List<Kunde> hentAlleKunder() {
        String sql = "select * from kunde";
        List<Kunde> alleKunder = db.query(sql, new BeanPropertyRowMapper<>(Kunde.class));
        return alleKunder;
    }

    public void slettAlleKunder() {
        String sql = "delete from kunde";
        db.update(sql);
    }
}
