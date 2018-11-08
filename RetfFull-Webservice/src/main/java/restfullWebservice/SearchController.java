package restfullWebservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {


    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/search")
    public SearchCloud greeting(@RequestParam(value="query", defaultValue="World") String searhQuery) {
        return new SearchCloud(counter.incrementAndGet(),searhQuery);
    }




}
