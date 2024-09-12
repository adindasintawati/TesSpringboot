package eventOrganizer;

import org.springframework.stereotype.Service;

@Service
public class PesertaService {

    private final PesertaRepository pesertaRepository;

    public PesertaService(PesertaRepository pesertaRepository) {
        this.pesertaRepository = pesertaRepository;
    }
}
