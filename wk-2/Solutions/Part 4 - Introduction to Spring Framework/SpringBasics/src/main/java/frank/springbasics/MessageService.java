package frank.springbasics;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage() {
        return "Hello From Frank - Spring Basic";
    }
}
