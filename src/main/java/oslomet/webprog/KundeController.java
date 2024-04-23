package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class KundeController {

    @Autowired
    KundeRepository rep;

    @GetMapping("/lagre")
    public void lagreKunde(Kunde innKunde, HttpServletResponse response) throws IOException {
        if(!rep.lagreKunde(innKunde)){
            try {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
            } catch (Exception e) {}
        }
    }

    @GetMapping("/hentAlle")
    public List<Kunde> hentAlle(){
        return rep.hentAlleKunder();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlleKunder();
    }
}

