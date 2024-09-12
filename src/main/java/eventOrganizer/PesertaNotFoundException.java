package eventOrganizer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PesertaNotFoundException extends RuntimeException {
    public PesertaNotFoundException(Integer id) { super("Peserta not found");
    }
}
